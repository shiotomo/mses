package work.tomosse.mses.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesBadRequestException;

@Component
public class HttpClientUtils {

    /**
     * 指定したAPIからデータを取得する。 取得できなかった場合は400エラー
     *
     * @param uri
     * @return
     */
    public String getRequest(final String uri) {
        try {
            final var httpRequest = HttpRequest.newBuilder(URI.create(uri)).build();
            final var bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
            final var httpResponse = HttpClient.newBuilder().build().send(httpRequest, bodyHandler);
            return httpResponse.body();
        } catch (IOException | InterruptedException e) {
            throw new MsesBadRequestException(ErrorCode.AccessFailed);
        }
    }
}
