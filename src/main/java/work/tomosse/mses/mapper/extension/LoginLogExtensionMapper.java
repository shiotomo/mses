package work.tomosse.mses.mapper.extension;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import work.tomosse.mses.model.db.LoginLog;

@Mapper
public interface LoginLogExtensionMapper {

    /**
     * 指定したnameを持つaccountを取得する
     * nameはユニークなので1つのAccountが返却される
     *
     * @param name
     * @return
     */
    public List<LoginLog> selectWhereAccountId(Long accountId);
}
