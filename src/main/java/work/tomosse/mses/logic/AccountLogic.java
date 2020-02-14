package work.tomosse.mses.logic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import work.tomosse.mses.enums.ErrorCode;
import work.tomosse.mses.exception.MsesBadRequestException;
import work.tomosse.mses.exception.MsesConflictException;
import work.tomosse.mses.exception.MsesNotFoundException;
import work.tomosse.mses.model.db.Account;
import work.tomosse.mses.repository.AccountRepository;

@Component
public class AccountLogic {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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
     * accountを更新する
     *
     * @param id
     * @param name
     * @param password
     * @param role
     * @param minecraftName
     * @param minecraftUuid
     */
    public void updateAccount(final Account oldAccount, final String name, final String password, final String role) {
        final var account = new Account();
        account.setId(oldAccount.getId());
        account.setName(name);
        account.setPassword(password);
        account.setRole(role);
        account.setCreatedAt(oldAccount.getCreatedAt());
        account.setUpdatedAt(new Date());
        accountRepository.update(account);
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

    /**
     * accountが1つ以下か確認する 1つ以下であれば400エラー
     */
    public void ensureLastAccount() {
        final var accountCount = accountRepository.count();
        if (accountCount <= 1) {
            throw new MsesBadRequestException(ErrorCode.CannotDeleteAccount);
        }
    }
}
