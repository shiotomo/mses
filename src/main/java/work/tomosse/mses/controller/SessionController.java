package work.tomosse.mses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SessionController {

    /**
     * ログインページ用コントローラ
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView login(final ModelAndView mav) {
        mav.setViewName("session/login");
        return mav;
    }
}