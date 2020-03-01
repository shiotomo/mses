package work.tomosse.mses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.service.OpsService;

@Controller
@RequestMapping("/ops")
public class OpsController {

    @Autowired
    OpsService opsService;

    /**
     * whitelistを表示する
     *
     * @param id
     * @param mav
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable final Long id, final ModelAndView mav) {
        mav.addObject("opsList", opsService.getOpsList(id));
        mav.setViewName("ops/show");
        return mav;
    }

}
