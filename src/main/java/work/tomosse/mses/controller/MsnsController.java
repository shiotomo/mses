package work.tomosse.mses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.db.Msns;

@Controller
@RequestMapping("/msns")
public class MsnsController {

    /**
     * msns情報を登録するページ
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
     * msns情報を更新するページ
     *
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/{id}/edit")
    public ModelAndView newPage(@PathVariable final Long id, final ModelAndView mav) {
        mav.setViewName("msns/edit");
        return mav;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute final Msns msns) {
        return "redirect:/dashboards";
    }

    @PutMapping("/{id}/update")
    public String update() {
        return "redirect:/dashboards";
    }
}
