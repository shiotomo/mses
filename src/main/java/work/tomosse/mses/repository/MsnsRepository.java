package work.tomosse.mses.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import work.tomosse.mses.mapper.MsnsMapper;
import work.tomosse.mses.mapper.extension.MsnsExtensionMapper;
import work.tomosse.mses.model.db.Msns;
import work.tomosse.mses.model.db.MsnsExample;

@Repository
public class MsnsRepository {

    @Autowired
    MsnsMapper msnsMapper;

    @Autowired
    MsnsExtensionMapper msnsExtensionMapper;

    /**
     * msnsの一覧を返却する
     *
     * @return
     */
    public List<Msns> select() {
        final var example = new MsnsExample();
        return msnsMapper.selectByExample(example);
    }

    /**
     * 指定したhostのmsnsを返却する
     *
     * @param host
     * @return
     */
    public Msns selectByHost(final String host) {
        return msnsExtensionMapper.selectByHost(host);
    }

    /**
     * 指定したIDのmsnsを返却する
     *
     * @param id
     * @return
     */
    public Msns selectById(final Long id) {
        return msnsMapper.selectByPrimaryKey(id);
    }

    /**
     * msnsを保存する
     *
     * @param msns
     */
    public void insert(final Msns msns) {
        msnsMapper.insert(msns);
    }

    /**
     * msnswを更新する
     *
     * @param msns
     */
    public void update(final Msns msns) {
        msnsMapper.updateByPrimaryKey(msns);
    }

    /**
     * msnsを削除する
     *
     * @param id
     */
    public void delete(final Long id) {
        msnsMapper.deleteByPrimaryKey(id);
    }
}
