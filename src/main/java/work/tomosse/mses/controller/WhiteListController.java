package work.tomosse.mses.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.msns.WhiteList;
import work.tomosse.mses.service.WhiteListService;

@Controller
@RequestMapping("/whitelist")
public class WhiteListController {

    @Autowired
    WhiteListService whiteListService;

    /**
     * whitelistを表示する
     *
     * @param principal
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView show(
            @AuthenticationPrincipal final Principal principal,
            @PathVariable final Long id,
            final ModelAndView mav) {
        mav.addObject("whiteList", whiteListService.getWhiteList(principal.getName(), id));
        mav.setViewName("whitelist/show");
        return mav;
    }

    /**
     * whitelistを追加するフォームを表示する
     *
     * @param mav
     * @return
     */
    @GetMapping("/{id}/new")
    public ModelAndView newPage(@PathVariable final Long id, final ModelAndView mav) {
        mav.setViewName("whitelist/new");
        return mav;
    }

    /**
     * whitelistにユーザを追加する
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/put")
    public String put(@PathVariable final Long id, @ModelAttribute final WhiteList whiteList) {
        whiteListService.putUserToWhiteList(id, whiteList);
        return "redirect:/whitelist/" + id;
    }
}
