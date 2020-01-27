package work.tomosse.mses.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import work.tomosse.mses.enums.Role;

@Data
public class UpdateAccountRequest {
    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("password")
    @NotBlank
    private String password;

    @JsonProperty("newPassword")
    @NotBlank
    private String newPassword;

    @JsonProperty("minecraftName")
    private String minecraftName;

    @JsonProperty("minecraftUuid")
    private String minecraftUuid;

    @JsonProperty("role")
    @NotBlank
    private Role role;

}
