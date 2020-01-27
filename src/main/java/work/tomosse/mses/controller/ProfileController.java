package work.tomosse.mses.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.tomosse.mses.model.request.ProfileUpdateRequest;
import work.tomosse.mses.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/edit")
    public ModelAndView edit(final ModelAndView mav, @AuthenticationPrincipal final Principal principal) {
        mav.setViewName("profile/edit");
        return mav;
    }

    @PatchMapping("/update")
    public String edit(@AuthenticationPrincipal final Principal principal, final ProfileUpdateRequest profileUpdateRequest) {
        profileService.updatePassword(principal, profileUpdateRequest);
        return "redirect:/dashboard";
    }
}
