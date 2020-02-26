package work.tomosse.mses.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.tomosse.mses.enums.Role;
import work.tomosse.mses.model.db.Msns;
import work.tomosse.mses.repository.AccountMsnsRepository;
import work.tomosse.mses.repository.AccountRepository;
import work.tomosse.mses.repository.MsnsRepository;

@Service
public class MsnsService {

    @Autowired
    MsnsRepository msnsRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMsnsRepository accountMsnsRepository;

    /**
     * 指定したROLEに適したmsnsの一覧を返却する
     * ADMIN: 全msnsを返却する
     * USER: user_msnsが存在するmsnsのみ返却する
     *
     * @param name
     * @return
     */
    public List<Msns> getListByRole(final String name) {
        final var account = accountRepository.selectByName(name);
        if (account.getRole().equals(Role.ADMIN.getRole())) {
            return msnsRepository.select();
        }
        return accountMsnsRepository.getMsnsWhereAccountId(account.getId());
    }

    /**
     * msnsを作成する
     *
     * @param msns
     */
    public void create(final Msns msns) {
        msns.setCreatedAt(new Date());
        msns.setUpdatedAt(new Date());
        msnsRepository.insert(msns);
    }

    /**
     * 指定したIDのmsnsを削除する
     *
     * @param id
     */
    public void deleteMsns(final Long id) {
        msnsRepository.delete(id);
    }

    /**
     * msnsを更新する
     *
     * @param msns
     */
    public void update(final Msns msns) {
        msns.setUpdatedAt(new Date());
        msnsRepository.update(msns);
    }
}
