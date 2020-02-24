package work.tomosse.mses.model.response;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MsnsResponse {
    @JsonProperty("version")
    @NotBlank
    private String version;

    @JsonProperty("host")
    @NotBlank
    private String host;

    @JsonProperty("port")
    private int port;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
