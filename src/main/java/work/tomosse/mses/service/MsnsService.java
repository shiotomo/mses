package work.tomosse.mses.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import work.tomosse.mses.enums.Role;
import work.tomosse.mses.model.db.Msns;
import work.tomosse.mses.model.msns.MinecraftServer;
import work.tomosse.mses.repository.AccountMsnsRepository;
import work.tomosse.mses.repository.AccountRepository;
import work.tomosse.mses.repository.MsnsRepository;
import work.tomosse.mses.util.HttpClientUtils;
import work.tomosse.mses.util.UrlUtils;

@Service
public class MsnsService {

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    UrlUtils urlUtils;

    @Autowired
    MsnsRepository msnsRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMsnsRepository accountMsnsRepository;

    /**
     * 指定したROLEに適したmsns(MinecraftServer)の一覧を返却する
     * ADMIN: 全msnsを返却する
     * USER: account_msnsが存在するmsnsのみ返却する
     *
     * @param name
     * @return
     */
    public List<MinecraftServer> getListByRole(final String name) {
        final var account = accountRepository.selectByName(name);
        if (account.getRole().equals(Role.ADMIN.getRole())) {
            final var msnsList = msnsRepository.select();
            return getMinecraftServerList(msnsList);
        }
        final var msnsList = accountMsnsRepository.getMsnsWhereAccountId(account.getId());
        return getMinecraftServerList(msnsList);
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

    /**
     * msnsの一覧をMinecraftServerの一覧に変換して返却する
     *
     * @param msnsList
     * @return
     */
    private List<MinecraftServer> getMinecraftServerList(final List<Msns> msnsList) {
        final var minecraftServerList = new ArrayList<MinecraftServer>();
        final var path = "/api/v1/status";
        final var objectMapper = new ObjectMapper();
        msnsList.forEach(msns -> {
            try {
                final var url = urlUtils.getMsnsUrl(msns, path);
                final var resultJson = httpClientUtils.getRequest(url);
                final var minecraftServer = objectMapper.readValue(resultJson, MinecraftServer.class);
                minecraftServer.setId(msns.getId());
                minecraftServer.setHost(urlUtils.getMsnsUrl(msns));
                minecraftServerList.add(minecraftServer);
            } catch (final IllegalArgumentException | JsonProcessingException e) {
                // Exceptionが発生した場合は全てのstatusが存在しないMinecraftServerをListに格納
                minecraftServerList.add(getInactiveMinecraftServer(msns));
            }
        });
        return minecraftServerList;
    }

    /**
     * statusが空のMinecraftServerを返却する
     *
     * @param msns
     * @return
     */
    private MinecraftServer getInactiveMinecraftServer(final Msns msns) {
        final var status = new HashMap<String, String>();
        final var minecraftServer = new MinecraftServer();
        minecraftServer.setId(msns.getId());
        minecraftServer.setHost(urlUtils.getMsnsUrl(msns));
        minecraftServer.setVersion(msns.getVersion());
        minecraftServer.setStatus(status);
        return minecraftServer;
    }
}
