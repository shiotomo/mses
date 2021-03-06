package work.tomosse.mses.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.service.AccountService;
import work.tomosse.mses.service.LoginLogService;
import work.tomosse.mses.service.MinecraftServerService;
import work.tomosse.mses.service.MsnsService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    AccountService accountService;

    @Autowired
    LoginLogService loginLogService;

    @Autowired
    MinecraftServerService minecraftServerService;

    @Autowired
    MsnsService msnsService;

    /**
     * Dashboardを表示する
     * TODO: principalから直接アカウント情報を取得するようにする
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(final ModelAndView mav, @AuthenticationPrincipal final Principal principal) {
        mav.addObject("account", accountService.getAccountByName(principal.getName()));
        mav.addObject("msnsList", msnsService.getListByRole(principal.getName()));
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
        final var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        loginLogService.loginMses(principal);
        return "redirect:/dashboard";
    }
}
