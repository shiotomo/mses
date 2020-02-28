package work.tomosse.mses.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

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
        } catch (final Exception e) {
            // Excptionが発生した場合nullを返却する
            return null;
        }
    }
}
