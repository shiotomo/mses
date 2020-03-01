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

    /**
     * 指定したAPIにデータを送信する。送信先でエラーがでた場合400エラー
     *
     * @param uri
     * @param requestBody
     * @return
     */
    public String postRequest(final String uri, final String requestBody) {
        try {
            final var httpRequest = HttpRequest.newBuilder(URI.create(uri))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
            final var bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
            final var httpResponse = HttpClient.newBuilder().build().send(httpRequest, bodyHandler);
            return httpResponse.body();
        } catch (final Exception e) {
            // Excptionが発生した場合nullを返却する
            return null;
        }
    }
}
