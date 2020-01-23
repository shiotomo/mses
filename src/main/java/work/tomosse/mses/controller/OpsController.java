package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.service.OpsService;

@Controller
@RequestMapping("/ops")
public class OpsController {

    @Autowired
    OpsService opsService;

    /**
     * whitelistを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(final ModelAndView mav) {
        mav.addObject("opsList", opsService.getOpsList());
        mav.setViewName("ops/index");
        return mav;
    }

}
