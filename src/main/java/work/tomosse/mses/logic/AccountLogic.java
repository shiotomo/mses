package work.tomosse.mses.logic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesConflictException;
import work.tomosse.mses.exception.MsesNotFoundException;
import work.tomosse.mses.model.db.Account;
import work.tomosse.mses.repository.AccountRepository;

@Component
public class AccountLogic {

    @Autowired
    AccountRepository accountRepository;

    private final static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * accountを作成する
     *
     * @param name
     * @param password
     * @param role
     * @return
     */
    public int createAccount(final String name, final String password, final String role) {
        final var encordPassword = passwordEncoder.encode(password);
        final var account = new Account();
        account.setName(name);
        account.setPassword(encordPassword);
        account.setRole(role);
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        return accountRepository.insert(account);
    }

    /**
     * accountの存在確認を行う 存在すれば409エラー
     *
     * @param account
     */
    public void ensureExistAccount(final Account account) {
        if (account != null) {
            throw new MsesConflictException(ErrorCode.ConflictAccount, account.getName());
        }
    }

    /**
     * accountの存在確認を行う 存在しなければ404エラー
     *
     * @param account
     */
    public void ensureNotExistAccount(final Account account) {
        if (account == null) {
            throw new MsesNotFoundException(ErrorCode.ResourceNotFound);
        }
    }
}
