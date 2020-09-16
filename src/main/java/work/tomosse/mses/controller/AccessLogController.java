package work.tomosse.mses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/msns/{id}/access_log")
public class AccessLogController {

    @GetMapping
    public ModelAndView index(@PathVariable("id") final Long id, final ModelAndView mav) {
        return mav;
    }

}
