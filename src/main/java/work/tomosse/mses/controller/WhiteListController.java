package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.service.WhiteListService;

@Controller
@RequestMapping("/whitelist")
public class WhiteListController {

    @Autowired
    WhiteListService whiteListService;

    /**
     * whitelistを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(final ModelAndView mav) {
        mav.addObject("whiteList", whiteListService.getWhiteList());
        mav.setViewName("whitelist/index");
        return mav;
    }

}
