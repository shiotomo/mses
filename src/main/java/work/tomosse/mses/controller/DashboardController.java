package work.tomosse.mses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    /**
     * Dashboardを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(final ModelAndView mav) {
        mav.setViewName("dashboard/index");
        return mav;
    }

    /**
     * ログイン認証成功時処理
     *
     * @param mav
     * @return
     */
    @PostMapping
    public String login() {
        return "redirect:/dashboard";
    }
}
