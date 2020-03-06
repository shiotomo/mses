package work.tomosse.mses.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import work.tomosse.mses.mapper.AccountMsnsMapper;
import work.tomosse.mses.mapper.extension.AccountMsnsExtensionMapper;
import work.tomosse.mses.model.db.AccountMsns;
import work.tomosse.mses.model.db.Msns;

@Repository
public class AccountMsnsRepository {

    @Autowired
    AccountMsnsMapper accountMsnsMapper;

    @Autowired
    AccountMsnsExtensionMapper accountMsnsExtensionMapper;

    public List<AccountMsns> selectWhereAccountId(final Long accountId) {
        return accountMsnsExtensionMapper.selectWhereAccountId(accountId);
    }
    /**
     * 指定したaccount_idを持つaccount_msnsに紐付たmsnsの一覧を取得する
     *
     * @param accountId
     * @return
     */
    public List<Msns> selectMsnsWhereAccountId(final Long accountId) {
        return accountMsnsExtensionMapper.selectMsnsWhereAccountId(accountId);
    }

    /**
     * account_msnsを作成する
     *
     * @param accountMsns
     * @return
     */
    public int insert(final AccountMsns accountMsns) {
        return accountMsnsMapper.insert(accountMsns);
    }

    /**
     * account_msnsを削除する
     *
     * @param id
     * @return
     */
    public int delete(final Long id) {
        return accountMsnsMapper.deleteByPrimaryKey(id);
    }
}
