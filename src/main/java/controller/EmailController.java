package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("email")
public class EmailController {
    private static Pattern pattern;
    private Matcher matcher;

    /* Khai báo Regex */
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    private boolean validate1(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    @GetMapping("")
    public ModelAndView showFormEmail() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @PostMapping("/validate")
    public ModelAndView validate(@RequestParam String email) {
        boolean isvalid = this.validate1(email);
        ModelAndView modelAndView;
        if (!isvalid) {
            modelAndView = new ModelAndView("home", "message", "Email is invalid");
        } else {
            modelAndView = new ModelAndView("success", "email", email);
        }
        return modelAndView;
    }

    @GetMapping("/success")
    public ModelAndView showValidate() {
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }
}
