package work.tomosse.mses.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.tomosse.mses.model.request.MsnsRequest;
import work.tomosse.mses.model.response.MsnsResponse;
import work.tomosse.mses.service.MsnsService;

@RestController
@RequestMapping("/api/v1/mses")
public class MsesApiController {

    @Autowired
    MsnsService msnsService;

    /**
     * msesにmsnsを登録する
     *
     * @param msnsRequest
     * @return
     */
    @PostMapping("/connect")
    public MsnsResponse connectMsns(@RequestBody final MsnsRequest msnsRequest) {
        return msnsService.create(msnsRequest);
    }

}
