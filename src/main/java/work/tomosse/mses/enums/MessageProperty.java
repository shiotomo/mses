package work.tomosse.mses.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageProperty {
    // Success系
    SuccessDelete("api.message.success.successDelete"),

    // Error系
    ResourceNotFound("api.message.error.resourceNotFound"),
    ConflictAccount("api.message.error.conflictAccount"),
    AccessFailed("api.message.error.accessFailed"),
    JsonParseError("api.message.error.jsonParseError"),
    CannotReadWhiteList("api.message.error.cannotReadWhiteList"),
    CannotReadOps("api.message.error.cannotReadOps"),
    CannotDeleteAccount("api.message.error.cannotDeleteAccount"),
    NotFoundMinecraftAccount("api.message.error.notFoundMinecraftAccount"),
    InvalidPassword("api.message.error.InvalidPassword"),
    ;

    private String message;
}