package com.univrouen.socialmedia.Controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodOrderingController handles web requests related to the home and menu pages of the food ordering application.
 */
@RestController
public class KeycloackController {
    @GetMapping("/")
    public String Home(){
        return "Hello! this is a public page!";
    }

    @GetMapping("/private")
    public String secured(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User oauthUser = (OAuth2User) auth.getPrincipal();
        System.out.println("Nom de l'utilisateur : " + oauthUser.getAttribute("name"));
        return "Hello ! this is a private page !";
    }
}