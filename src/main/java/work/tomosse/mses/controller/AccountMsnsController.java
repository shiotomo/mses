package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.db.AccountMsns;
import work.tomosse.mses.service.AccountMsnsService;
import work.tomosse.mses.service.AccountService;
import work.tomosse.mses.service.MsnsService;

@Controller
@RequestMapping("/account/{accountId}/account_msns")
public class AccountMsnsController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMsnsService accountMsnsService;

    @Autowired
    MsnsService msnsService;

    /**
     * account_msnsの作成ページを表示する
     *
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/new")
    public ModelAndView newPage(
            @PathVariable("accountId") final Long accountId,
            final ModelAndView mav) {
        mav.addObject("account", accountService.getAccountById(accountId));
        mav.addObject("msnsList", msnsService.getMsns());
        mav.setViewName("account_msns/new");
        return mav;
    }

    /**
     * account_msnsを作成する
     *
     * @param accountId
     * @return
     */
    @PostMapping("/create")
    public String create(
            @PathVariable("accountId") final Long accountId,
            @ModelAttribute final AccountMsns accountMsns
            ) {
        accountMsnsService.create(accountMsns);
        return "redirect:/account/" + accountId;
    }

    /**
     * account_msnsを削除する
     *
     * @param accountId
     * @param id
     * @return
     */
    @DeleteMapping("/{id}/delete")
    public String delete(
            @PathVariable("account_id") final Long accountId,
            @PathVariable("id") final Long id
            ) {
        accountMsnsService.delete(id);
        return "redirect:/account/" + accountId;
    }
}
