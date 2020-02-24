package work.tomosse.mses.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.tomosse.mses.model.db.Msns;
import work.tomosse.mses.model.request.MsnsRequest;
import work.tomosse.mses.model.response.MsnsResponse;
import work.tomosse.mses.repository.MsnsRepository;

@Service
public class MsnsService {

    @Autowired
    MsnsRepository msnsRepository;

    /**
     * msnsを登録する
     * アクセスする度にupdated_atを更新する
     *
     * @param msnsRequest
     * @return
     */
    public MsnsResponse create(final MsnsRequest msnsRequest) {
        final var host = msnsRequest.getHost();
        final var existMsns = msnsRepository.selectByHost(host);
        // hostが登録されていなければ登録する
        if (existMsns == null) {
            final var newMsns = new Msns();
            newMsns.setHost(msnsRequest.getHost());
            newMsns.setVersion(msnsRequest.getVersion());
            newMsns.setPort(msnsRequest.getPort());
            newMsns.setCreatedAt(new Date());
            newMsns.setUpdatedAt(new Date());
            msnsRepository.insert(newMsns);
        }
        final var msns = msnsRepository.selectByHost(host);
        update(msns);
        final var msnsResponse = new MsnsResponse();
        msnsResponse.setHost(msns.getHost());
        msnsResponse.setPort(msns.getPort());
        msnsResponse.setVersion(msns.getVersion());
        msnsResponse.setCreatedAt(msns.getCreatedAt());
        msnsResponse.setUpdatedAt(msns.getUpdatedAt());
        return msnsResponse;
    }

    /**
     * msnsを作成する
     *
     * @param msns
     */
    public void create(final Msns msns) {
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
    private void update(final Msns msns) {
        msns.setUpdatedAt(new Date());
        msnsRepository.update(msns);
    }
}
