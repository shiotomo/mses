package work.tomosse.mses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/whitelist")
public class WhiteListController {

    /**
     * whitelistを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(final ModelAndView mav) {
        mav.setViewName("whitelist/index");
        return mav;
    }

}
