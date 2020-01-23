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
    JsonParseError(103, MessageProperty.JsonParseError),
    CannotReadWhiteList(104, MessageProperty.CannotReadWhiteList),
    CannotReadOps(104, MessageProperty.CannotReadOps),
    CannotDeleteAccount(104, MessageProperty.CannotDeleteAccount),
    ;

    private int minorCode;
    private MessageProperty messageProperty;
}