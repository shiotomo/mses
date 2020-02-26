package work.tomosse.mses.mapper.extension;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import work.tomosse.mses.model.db.Msns;

@Mapper
public interface AccountMsnsExtensionMapper {

    /**
     * 指定したaccountIdを持つaccount_msnsに紐付いたmsnsを取得する
     *
     * @param id
     * @return
     */
    public List<Msns> selectWhereAccountId(Long accountId);
}
