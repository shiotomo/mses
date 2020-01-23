package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.service.AccountService;

@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * account listを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping
    public ModelAndView index(final ModelAndView mav) {
        mav.addObject("accountList", accountService.getAccountList());
        mav.setViewName("account/index");
        return mav;
    }

}
