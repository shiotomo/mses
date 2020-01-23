package work.tomosse.mses.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtils {

    @Autowired
    MessageSource messageSource;

    /**
     * messageSourceからデータを取得する
     *
     * @param code
     * @param args
     * @return
     */
    public String getMessage(final String code, final String... args) {
        final var message = messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
        return message;
    }
}