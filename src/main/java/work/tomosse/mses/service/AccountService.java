package work.tomosse.mses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.tomosse.mses.enums.Role;
import work.tomosse.mses.logic.AccountLogic;
import work.tomosse.mses.model.db.Account;
import work.tomosse.mses.model.request.AccountRequest;
import work.tomosse.mses.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountLogic accountLogic;

    /*
     * accountの一覧を取得する
     */
    public List<Account> getAccountList() {
        return accountRepository.selectAll();
    }

    /**
     * idを指定してaccountを取得する
     *
     * @param name
     * @return
     */
    public Account getAccountById(final Long id) {
        return accountRepository.selectById(id);
    }

    /**
     * nameを指定してaccountを取得する
     *
     * @param name
     * @return
     */
    public Account getAccountByName(final String name) {
        return accountRepository.selectByName(name);
    }

    /**
     * accountが存在しない時ADMINを作成する
     */
    public void createAdmin() {
        final var accountList = accountRepository.selectAll();
        if (accountList.isEmpty()) {
            final var accountRequest = new AccountRequest();
            accountRequest.setName("admin");
            accountRequest.setPassword("admin");
            accountRequest.setRole(Role.ADMIN);
            createAccount(accountRequest);
        }
    }

    public Account createAccount(final Account account) {
        final var name = account.getName();
        final var password = account.getPassword();
        final var minecraftName = account.getMinecraftName();
        final var minecraftUuid = account.getMinecraftUuid();
        final var role = account.getRole();
        accountLogic.ensureNotExistAccount(account);
        accountLogic.createAccount(name, password, role, minecraftName, minecraftUuid);
        return accountRepository.selectByName(name);
    }

    /**
     * accountを作成する
     *
     * @param accountRequest
     * @return
     */
    public Account createAccount(final AccountRequest accountRequest) {
        final var name = accountRequest.getName();
        final var password = accountRequest.getPassword();
        final var role = accountRequest.getRole().getRole();
        final var minecraftName = accountRequest.getMinecraftName();
        final var minecraftUuid = accountRequest.getMinecraftUuid();
        final var account = getAccountByName(name);
        accountLogic.ensureExistAccount(account);
        accountLogic.createAccount(name, password, role, minecraftName, minecraftUuid);
        return accountRepository.selectByName(name);
    }

    /**
     * accountを更新する
     *
     * @param id
     * @param account
     */
    public void updateAccount(final Long id, final Account account) {
        final var name = account.getName();
        final var password = account.getPassword();
        final var minecraftName = account.getMinecraftName();
        final var minecraftUuid = account.getMinecraftUuid();
        final var role = account.getRole();
        final var oldAccount = getAccountById(id);
        accountLogic.ensureNotExistAccount(oldAccount);
        accountLogic.updateAccount(oldAccount, name, password, role, minecraftName, minecraftUuid);
    }

    /**
     * accountを削除する
     *
     * @param id
     */
    public void deleteAccount(final Long id) {
        final var account = getAccountById(id);
        accountLogic.ensureNotExistAccount(account);
        accountLogic.ensureLastAccount();
        accountRepository.deleteById(id);
    }
}
