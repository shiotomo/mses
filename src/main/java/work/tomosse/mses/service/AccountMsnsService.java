package work.tomosse.mses.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.tomosse.mses.model.db.AccountMsns;
import work.tomosse.mses.model.db.Msns;
import work.tomosse.mses.repository.AccountMsnsRepository;

@Service
public class AccountMsnsService {

    @Autowired
    AccountMsnsRepository accountMsnsRepository;

    /**
     * 指定したaccountIdを持つaccount_msnsに紐付いたmsnsを取得する
     *
     * @param accountId
     * @return
     */
    public List<Msns> getMsnsWhereAccountId(final Long accountId) {
        return accountMsnsRepository.selectMsnsWhereAccountId(accountId);
    }

    /**
     * AccountMsnsを作成する
     *
     * @param accountMsns
     */
    public void create(final AccountMsns accountMsns) {
        accountMsns.setCreatedAt(new Date());
        accountMsns.setUpdatedAt(new Date());
        accountMsnsRepository.insert(accountMsns);
    }

    /**
     * AccountMsnsを作成する
     *
     * @param accountId
     * @param accountMsns
     */
    public void create(final Long accountId, final AccountMsns accountMsns) {
        accountMsns.setCreatedAt(new Date());
        accountMsns.setUpdatedAt(new Date());
        accountMsns.setAccountId(accountId);
        accountMsnsRepository.insert(accountMsns);
    }

    /**
     * 指定したIDのaccoutMsnsを削除する
     *
     * @param id
     */
    public void delete(final Long id) {
        accountMsnsRepository.delete(id);
    }

}
