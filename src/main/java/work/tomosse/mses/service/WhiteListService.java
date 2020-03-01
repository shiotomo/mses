package work.tomosse.mses.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.enums.Role;
import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.exception.MsesForbiddenException;
import work.tomosse.mses.model.msns.WhiteList;
import work.tomosse.mses.repository.AccountMsnsRepository;
import work.tomosse.mses.repository.AccountRepository;
import work.tomosse.mses.repository.MsnsRepository;
import work.tomosse.mses.util.HttpClientUtils;
import work.tomosse.mses.util.UrlUtils;

@Service
public class WhiteListService {

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    UrlUtils urlUtils;

    @Autowired
    MsnsRepository msnsRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMsnsRepository accountMsnsRepository;

    /**
     * whitelist.jsonを取得する
     * 権限がない場合403エラー
     *
     * @param id
     * @return
     */
    public List<WhiteList> getWhiteList(final String accountName, final Long id) {
        final var account = accountRepository.selectByName(accountName);
        // accountがADMINの場合whitelistが表示できるため、whitelistを返却
        if (Role.ADMIN.getRole().equals(account.getRole())) {
            return getWhiteList(id);
        }
        final var msnsList = accountMsnsRepository.getMsnsWhereAccountId(account.getId());
        final var isPermission = msnsList.stream().anyMatch(msns -> msns.getId() == id);
        if (isPermission == false) {
            throw new MsesForbiddenException(ErrorCode.WhitelistPermissionError);
        }
        return getWhiteList(id);
    }

    /**
     * whitelist.jsonを取得する
     *
     * @param id
     * @return
     */
    public List<WhiteList> getWhiteList(final Long id) {
        try {
            final var msns = msnsRepository.selectById(id);
            final var msnsUrl = urlUtils.getMsnsUrl(msns, "/api/v1/whitelist");
            final var resultJson = httpClientUtils.getRequest(msnsUrl);
            final var objectMapper = new ObjectMapper();
            final var whiteList = objectMapper.readValue(resultJson, new TypeReference<List<WhiteList>>() {});
            return whiteList;
        } catch (final IllegalArgumentException e) {
            // msnsからデータが取得できない場合のExceptionのため、空のWhiteListのListを返却する
            return new ArrayList<WhiteList>();
        } catch (final JsonProcessingException e) {
            throw new MsesBadRequestException(ErrorCode.CannotReadWhiteList);
        }
    }

    /**
     * whitelist.jsonにユーザを追加する
     *
     * @param msnsId
     * @param whiteList
     */
    public void putUserToWhiteList(final Long msnsId, final WhiteList whiteList) {
        try {
            final var msns = msnsRepository.selectById(msnsId);
            final var url = urlUtils.getMsnsUrl(msns) + "/api/v1/whitelist/add";
            final var objectMapper = new ObjectMapper();
            final var requestBody = objectMapper.writeValueAsString(whiteList);
            httpClientUtils.postRequest(url, requestBody);
        } catch (final JsonProcessingException e) {
            throw new MsesBadRequestException(ErrorCode.CannotReadWhiteList);
        }
    }
}
