package work.tomosse.mses.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 4xx系
    ResourceNotFound(101, MessageProperty.ResourceNotFound),
    ConflictAccount(102, MessageProperty.ConflictAccount),
    AccessFailed(103, MessageProperty.AccessFailed),
    JsonParseError(104, MessageProperty.JsonParseError),
    CannotReadWhiteList(105, MessageProperty.CannotReadWhiteList),
    CannotReadOps(106, MessageProperty.CannotReadOps),
    CannotDeleteAccount(107, MessageProperty.CannotDeleteAccount),
    NotFoundMinecraftAccount(108, MessageProperty.NotFoundMinecraftAccount),
    InvalidPassowrd(109, MessageProperty.InvalidPassword),
    CannotReadMinecraftServer(108, MessageProperty.CannotReadMinecraftServer),
    WhitelistPermissionError(109, MessageProperty.WhitelistPermissionError),
    ;

    private int minorCode;
    private MessageProperty messageProperty;
}