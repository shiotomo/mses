package work.tomosse.mses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSourceConfig {

    @Bean("messageSource")
    public MessageSource messageSource(
            @Value("${spring.messages.basename}") final String basename,
            @Value("${spring.messages.encoding}") final String encoding
    ) {
        final YamlMessageSource yamlMessageSource = new YamlMessageSource();
        yamlMessageSource.setBasename(basename);
        yamlMessageSource.setDefaultEncoding(encoding);
        yamlMessageSource.setAlwaysUseMessageFormat(true);
        yamlMessageSource.setUseCodeAsDefaultMessage(true);
        yamlMessageSource.setFallbackToSystemLocale(true);
        return yamlMessageSource;
    }
}
