package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.db.Account;
import work.tomosse.mses.service.AccountMsnsService;
import work.tomosse.mses.service.AccountService;
import work.tomosse.mses.service.LoginLogService;

@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMsnsService accountMsnsService;

    @Autowired
    LoginLogService loginLogService;

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

    /**
     * accountの詳細を表示する
     *
     * @param mav
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView show(final ModelAndView mav, @PathVariable("id") final Long id) {
        mav.addObject("account", accountService.getAccountById(id));
        mav.addObject("loginLogList", loginLogService.selectWhrereAccountId(id));
        mav.addObject("msnsList", accountMsnsService.getMsnsWhereAccountId(id));
        mav.addObject("accountMsnsList", accountMsnsService.getWhrereAccountId(id));
        mav.setViewName("account/show");
        return mav;
    }

    /**
     * account作成ページを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping("/new")
    public ModelAndView newPage(final ModelAndView mav) {
        mav.setViewName("account/new");
        return mav;
    }

    /**
     * account更新ページを表示する
     *
     * @param mav
     * @param userId
     * @return
     */
    @GetMapping("/{id}/edit")
    public ModelAndView edit(final ModelAndView mav, @PathVariable("id") final Long id) {
        mav.addObject("account", accountService.getAccountById(id));
        mav.setViewName("account/edit");
        return mav;
    }

    /**
     * accountを作成する
     *
     * @param account
     * @return
     */
    @PostMapping("/create")
    public String create(@ModelAttribute final Account account) {
        accountService.createAccount(account);
        return "redirect:/account";
    }

    /**
     * accountを更新する
     *
     * @param id
     * @param account
     * @return
     */
    @PutMapping("/{id}/update")
    public String putUpdate(@PathVariable("id") final Long id, @ModelAttribute final Account account) {
        accountService.updateAccount(id, account);
        return "redirect:/account";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable final Long id) {
        accountService.deleteAccount(id);
        return "redirect:/account";
    }
}
