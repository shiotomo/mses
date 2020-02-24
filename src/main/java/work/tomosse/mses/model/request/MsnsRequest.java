package work.tomosse.mses.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MsnsRequest {
    @JsonProperty("version")
    @NotBlank
    private String version;

    @JsonProperty("host")
    @NotBlank
    private String host;

    @JsonProperty("port")
    private int port;
}
