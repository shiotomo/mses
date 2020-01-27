package work.tomosse.mses.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import work.tomosse.mses.mapper.LoginLogMapper;
import work.tomosse.mses.mapper.extension.LoginLogExtensionMapper;
import work.tomosse.mses.model.db.LoginLog;

@Repository
public class LoginLogRepository {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Autowired
    LoginLogExtensionMapper loginLogExtensionMapper;

    /**
     * 指定したaccountのlogin_logを取得する
     *
     * @param accountId
     * @return
     */
    public List<LoginLog> selectWhereAccountId(final Long accountId) {
        return loginLogExtensionMapper.selectWhereAccountId(accountId);
    }

    /**
     * Login情報を保存する
     *
     * @param loginLog
     */
    public void insertByAccountId(final LoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }
}
