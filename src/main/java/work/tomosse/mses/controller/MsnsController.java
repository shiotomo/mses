package work.tomosse.mses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.db.Msns;

@Controller
@RequestMapping("/msns")
public class MsnsController {

    /**
     * msnsを登録するページ
     *
     * @param mav
     * @return
     */
    @GetMapping("/new")
    public ModelAndView newPage(final ModelAndView mav) {
        mav.setViewName("msns/new");
        return mav;
    }

    /**
     * msnsを保存する
     *
     * @param msns
     * @return
     */
    @PostMapping("/create")
    public String create(@ModelAttribute final Msns msns) {
        return "redirect:/dashboards";
    }

    /**
     * msnsを削除する
     *
     * @return
     */
    @DeleteMapping("/{id}/delete")
    public String delete() {
        return "redirect:/dashboards";
    }
}
