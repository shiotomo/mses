package work.tomosse.mses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import work.tomosse.mses.config.MsesProperty;
import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.model.msns.MinecraftServer;
import work.tomosse.mses.util.HttpClientUtils;

@Service
public class MinecraftServerService {

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    MsesProperty msesProperty;

    public MinecraftServer getStatus() {
        try {
            final var msnsUrl = msesProperty.getMsnsUrl() + "/api/v1/status";
            final var resultJson = httpClientUtils.getRequest(msnsUrl);
            final var objectMapper = new ObjectMapper();
            final var minecraftServer = objectMapper.readValue(resultJson, MinecraftServer.class);
            return minecraftServer;
        } catch (final IllegalArgumentException e) {
            // msnsからデータが取得できない場合のExceptionのため、空のMinecraftServerを返却する
            return new MinecraftServer();
        } catch (final JsonProcessingException e) {
            throw new MsesBadRequestException(ErrorCode.CannotReadMinecraftServer);
        }
    }

}
