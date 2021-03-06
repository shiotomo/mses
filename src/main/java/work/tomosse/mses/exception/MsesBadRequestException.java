package work.tomosse.mses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import work.tomosse.mses.enums.ErrorCode;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MsesBadRequestException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String[] args;

    public MsesBadRequestException(final ErrorCode errorCode, final String... args) {
        this.errorCode = errorCode;
        this.args = args;
    }
}
