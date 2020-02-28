package work.tomosse.mses.util;

import org.springframework.stereotype.Component;

import work.tomosse.mses.model.db.Msns;

@Component
public class UrlUtils {

    /**
     * msnsのURLを返却する
     *
     * @param msns
     * @param path
     * @return
     */
    public String getMsnsUrl(final Msns msns, final String path) {
        if (msns.getPort() == null) {
            return msns.getHost() + path;
        }
        return msns.getHost() + ":" + msns.getPort() + path;
    }

}
