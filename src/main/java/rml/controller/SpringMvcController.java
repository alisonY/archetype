package rml.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SpringMvcController { 
    
    
    
    @RequestMapping(value="/welcome",method={RequestMethod.GET})
    public ModelAndView getFirstPage(HttpServletRequest request) {  
        ModelAndView mv = new ModelAndView();  
        mv.addObject("name", "蛤蛤");  
        mv.setViewName("welcom");
        return mv;  
    }
    
} 
