package work.tomosse.mses.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import work.tomosse.mses.model.db.LoginLog;
import work.tomosse.mses.repository.AccountRepository;
import work.tomosse.mses.repository.LoginLogRepository;

@Service
public class LoginLogService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    LoginLogRepository loginLogReposiory;

    /**
     * msesにログインした情報を記録する
     *
     * @param principal
     */
    public void loginMses(final Object principal) {
        final var accountName = principal instanceof UserDetails ?
                ((UserDetails)principal).getUsername() : principal.toString();
        final var account = accountRepository.selectByName(accountName);
        final var loginLog = new LoginLog();
        loginLog.setAccountId(account.getId());
        loginLog.setLoginTime(new Date());
        loginLog.setCreatedAt(new Date());
        loginLog.setUpdatedAt(new Date());
        loginLogReposiory.insertByAccountId(loginLog);
    }

    /**
     * accountに紐付いたlogin_logを取得する
     *
     * @param principal
     * @return
     */
    public List<LoginLog> selectWhrereAccountId(final Long accountId) {
        return loginLogReposiory.selectWhereAccountId(accountId);
    }
}
