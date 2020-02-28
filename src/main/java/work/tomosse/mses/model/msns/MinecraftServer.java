package work.tomosse.mses.model.msns;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MinecraftServer {
    @JsonProperty("id")
    @NotBlank
    private Long id;

    @JsonProperty("version")
    @NotBlank
    private String version;

    @JsonProperty("host")
    @NotBlank
    private String host;

    @JsonProperty("status")
    @NotBlank
    private Map<String, String> status;
}
