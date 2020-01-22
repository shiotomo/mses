package work.tomosse.mses.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 4xx系
    ResourceNotFound(101, MessageProperty.ResourceNotFound),
    ConflictAccount(102, MessageProperty.ConflictAccount),
    ConflictProduct(103, MessageProperty.ConflictProduct),
    ConflictColumnManage(104, MessageProperty.ConflictColumnManage),
    ;

    private int minorCode;
    private MessageProperty messageProperty;
}