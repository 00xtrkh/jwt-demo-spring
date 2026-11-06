package ma.enset.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api")
public class UserController {


    @GetMapping("/hello")
    public String hello(){
        return "hello user";
    }


    @GetMapping("/profile")
    public String profile(Authentication authentication){
        return  "Utilisateur connecte: " +  authentication.getName();
    }
}
