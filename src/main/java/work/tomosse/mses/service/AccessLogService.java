package work.tomosse.mses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.tomosse.mses.model.db.AccessLog;
import work.tomosse.mses.repository.MsnsRepository;
import work.tomosse.mses.util.HttpClientUtils;
import work.tomosse.mses.util.UrlUtils;

@Service
public class AccessLogService {

    @Autowired
    MsnsRepository msnsRepository;

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    UrlUtils urlUtils;

    /**
     * msnsからaccess_logを取得し、msesのaccess_logを作成する
     * TODO: バルクインサートに変更する
     */
    public void analysis() {
        final var msnsList = msnsRepository.select();
        msnsList.forEach(msns -> {
        });
    }

    public List<AccessLog> getAccessLog(final Long msnsId) {
        return null;
    }

}
