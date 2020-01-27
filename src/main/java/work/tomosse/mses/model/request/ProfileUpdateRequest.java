package work.tomosse.mses.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProfileUpdateRequest {
    @JsonProperty("newPassword")
    @NotBlank
    private String newPassword;

    @JsonProperty("confirmPassword")
    @NotBlank
    private String confirmPassword;
}
