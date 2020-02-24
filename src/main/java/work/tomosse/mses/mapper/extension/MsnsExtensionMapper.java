package work.tomosse.mses.mapper.extension;

import org.apache.ibatis.annotations.Mapper;

import work.tomosse.mses.model.db.Msns;

@Mapper
public interface MsnsExtensionMapper {

    /**
     * 指定したhostを持つmsnsを取得する
     *
     * @param host
     * @return
     */
    public Msns selectByHost(String host);
}
