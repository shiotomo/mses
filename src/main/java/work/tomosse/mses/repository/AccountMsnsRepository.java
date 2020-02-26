package work.tomosse.mses.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import work.tomosse.mses.mapper.extension.AccountMsnsExtensionMapper;
import work.tomosse.mses.model.db.Msns;

@Repository
public class AccountMsnsRepository {

    @Autowired
    AccountMsnsExtensionMapper accountMsnsExtensionMapper;

    /**
     * 指定したaccount_idを持つaccount_msnsに紐付たmsnsの一覧を取得する
     *
     * @param accountId
     * @return
     */
    public List<Msns> getMsnsWhereAccountId(final Long accountId) {
        return accountMsnsExtensionMapper.selectWhereAccountId(accountId);
    }

}
