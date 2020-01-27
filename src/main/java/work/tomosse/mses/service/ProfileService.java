package work.tomosse.mses.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.logic.AccountLogic;
import work.tomosse.mses.model.request.ProfileUpdateRequest;
import work.tomosse.mses.repository.AccountRepository;

@Service
public class ProfileService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountLogic accountLogic;

    private final static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * パスワード情報を更新する
     *
     * @param principal
     * @param profileUpdateRequest
     */
    public void updatePassword(final Principal principal, final ProfileUpdateRequest profileUpdateRequest) {
        final var account = accountRepository.selectByName(principal.getName());
        final var newPassword = profileUpdateRequest.getNewPassword();
        final var confirmPassword = profileUpdateRequest.getConfirmPassword();

        if (!newPassword.equals(confirmPassword)) {
            throw new MsesBadRequestException(ErrorCode.InvalidPassowrd);
        }

        final var password = passwordEncoder.encode(newPassword);

        accountLogic.updateAccount(account, account.getName(), password, account.getRole());
    }

}
