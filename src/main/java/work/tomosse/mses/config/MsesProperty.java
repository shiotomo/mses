package work.tomosse.mses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class MsesProperty {
    @Value("${msns.url}")
    private String msnsUrl;
}
