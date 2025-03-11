package com.example.wso2.controller; // Package đã sửa đúng

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LoginController {

    private final OidcClientInitiatedLogoutSuccessHandler logoutSuccessHandler;

    public LoginController(ClientRegistrationRepository clientRegistrationRepository) {
        this.logoutSuccessHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OidcUser user, Model model) {
        Optional.ofNullable(user).ifPresent(u -> {
            model.addAttribute("name", u.getFullName());
            model.addAttribute("email", u.getEmail());
        });
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/oauth2/logout";
    }
}
