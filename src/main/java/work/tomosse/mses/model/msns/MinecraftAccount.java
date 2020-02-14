package work.tomosse.mses.model.msns;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MinecraftAccount {
    @JsonProperty("uuid")
    @NotBlank
    private String uuid;

    @JsonProperty("name")
    @NotBlank
    private String name;
}
