package work.tomosse.mses.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import work.tomosse.mses.config.MsesProperty;
import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.model.msns.OpsList;
import work.tomosse.mses.util.HttpClientUtils;

@Service
public class OpsService {

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    MsesProperty msesProperty;

    /**
     * ops.jsonを取得する
     *
     * @return
     */
    public List<OpsList> getOpsList() {
        try {
            final var msnsUrl = msesProperty.getMsnsUrl() + "/api/v1/ops";
            final var resultJson = httpClientUtils.getRequest(msnsUrl);
            final var objectMapper = new ObjectMapper();
            final var opsList = objectMapper.readValue(resultJson, new TypeReference<List<OpsList>>() {});
            return opsList;
        } catch (final IllegalArgumentException e) {
            // msnsからデータが取得できない場合のExceptionのため、空のOpsListのListを返却する
            return new ArrayList<OpsList>();
        } catch (final JsonProcessingException e) {
            throw new MsesBadRequestException(ErrorCode.CannotReadOps);
        }
    }

}
