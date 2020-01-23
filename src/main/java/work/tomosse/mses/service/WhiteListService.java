package work.tomosse.mses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import work.tomosse.mses.config.MsesProperty;
import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.model.WhiteList;
import work.tomosse.mses.util.HttpClientUtils;

@Service
public class WhiteListService {

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    MsesProperty msesProperty;

    /**
     * whitelist.jsonを取得する
     *
     * @return
     */
    public List<WhiteList> getWhiteList() {
        try {
            final var msnsUrl = msesProperty.getMsnsUrl() + "/api/v1/whitelist";
            final var resultJson = httpClientUtils.getRequest(msnsUrl);
            final var objectMapper = new ObjectMapper();
            final var whiteList = objectMapper.readValue(resultJson, new TypeReference<List<WhiteList>>() {});
            return whiteList;
        } catch (final JsonProcessingException e) {
            throw new MsesBadRequestException(ErrorCode.CannotReadWhiteList);
        }
    }

}
