package work.tomosse.mses.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WhiteList {
    @JsonProperty("uuid")
    @NotBlank
    private String uuid;

    @JsonProperty("name")
    @NotBlank
    private String name;
}
