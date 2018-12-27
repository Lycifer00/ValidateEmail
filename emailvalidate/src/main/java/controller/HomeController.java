package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9.]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public HomeController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView home(Locale locale) {
        return new ModelAndView("home");

    }



    @RequestMapping(value = "/validate", method = RequestMethod.POST)

    public ModelAndView user(@RequestParam("email") String email) {

        boolean isvalid = this.validate(email);
        ModelAndView modelAndView1 = new ModelAndView("home");

        if (!isvalid) {

            modelAndView1.addObject("message", "Email is invalid");

            return modelAndView1;

        }


        ModelAndView modelAndView2 = new ModelAndView("success");
        modelAndView2.addObject("email", email);

        return modelAndView2;

    }

    private boolean validate(String regex) {

        matcher = pattern.matcher(regex);

        return matcher.matches();

    }

}




