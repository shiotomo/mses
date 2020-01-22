package work.tomosse.mses.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import work.tomosse.mses.enums.Role;

@Data
public class AccountRequest {
    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("password")
    @NotBlank
    private String password;

    @JsonProperty("role")
    @NotBlank
    private Role role;
}