package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.db.Account;
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
    public ModelAndView edit(final ModelAndView mav, @PathVariable final Long id) {
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
     * @param accountId
     * @param account
     * @return
     */
    @PatchMapping("/{id}/update")
    public String putUpdate(@PathVariable final Long id, @ModelAttribute final Account account) {
        accountService.updateAccount(id, account);
        return "redirect:/account";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable final Long id) {
        accountService.deleteAccount(id);
        return "redirect:/account";
    }
}
