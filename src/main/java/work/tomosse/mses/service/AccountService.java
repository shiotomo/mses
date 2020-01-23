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
     * accountの一覧を返却する
     */
    public List<Account> getAccountList() {
        return accountRepository.selectAll();
    }

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
        final var account = accountRepository.selectByName(name);
        accountLogic.ensureExistAccount(account);
        accountLogic.createAccount(name, password, role);
        return accountRepository.selectByName(name);
    }
}
