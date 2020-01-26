package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.exception.MsesNotFoundException;
import work.tomosse.mses.util.MessageSourceUtils;

@ControllerAdvice
public class MsesControllerAdvice {

    @Autowired
    MessageSourceUtils messageSource;

    /**
     * MsesBadRequestException用のエラーハンドラー
     *
     * @param mav
     * @param e
     * @return
     */
    @ExceptionHandler(MsesBadRequestException.class)
    public String handler(final MsesBadRequestException e, final Model model) {
        final var args = e.getArgs();
        final var message = e.getErrorCode().getMessageProperty().getMessage();
        final var errorMessage = messageSource.getMessage(message, args);
        final var errorCode = e.getErrorCode().getMinorCode();
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("errorCode", errorCode);
        return "error";
    }

    /**
     * MsesNotFoundException用のエラーハンドラー
     *
     * @param mav
     * @param e
     * @return
     */
    @ExceptionHandler(MsesNotFoundException.class)
    public String handler(final MsesNotFoundException e, final Model model) {
        final var args = e.getArgs();
        final var message = e.getErrorCode().getMessageProperty().getMessage();
        final var errorMessage = messageSource.getMessage(message, args);
        final var errorCode = e.getErrorCode().getMinorCode();
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("errorCode", errorCode);
        return "error";
    }
}
