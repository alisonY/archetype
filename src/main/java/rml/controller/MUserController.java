package rml.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rml.model.MUser;
import rml.service.MUserService;
import rml.utils.JacksonMapper;
import rml.utils.JacksonUtils;

@Controller
@RequestMapping("/muser")
public class MUserController {

	@Autowired
	private MUserService muserService;
	
	
    private static final Logger LOGGER     = LoggerFactory.getLogger(MUserController.class);
	
	
    @RequestMapping(value="/getJson",method={RequestMethod.GET})
    @ResponseBody
    public String getFirstPage(HttpServletRequest request) {  
    	List <MUser> list = muserService.getAll();
    	String json = JacksonUtils.getInstance().obj2Json(list);
    	String json2 = JacksonMapper.listToJson(list);
    	LOGGER.info("info");
    	LOGGER.debug("debug");
    	LOGGER.warn("warn");
    	LOGGER.trace("trace");
    	LOGGER.error("error");
        return json+"/"+json2;  
    }

	@RequestMapping(value="/listUser")
	public ModelAndView listUser(HttpServletRequest request,ModelMap modelMap) {
	    ModelAndView mav = new ModelAndView();
		List <MUser> list = muserService.getAll();
		modelMap.put("MUser", list);
		mav.addAllObjects(modelMap);
		mav.setViewName("listUser");
		return mav;
	}

	
    @RequestMapping(value="/addUserPage")
    public ModelAndView addUserPage(MUser muser) {
        return new ModelAndView("addUser");
    }
	
	
	@RequestMapping(value="/addUserAction")
	public ModelAndView addUserAction(MUser muser) {
		String id = UUID.randomUUID().toString();
		muser.setId(id);
		muserService.insert(muser);
		return new ModelAndView("redirect:/muser/listUser.do");
	}
	
	
	@RequestMapping(value="/updateUserPage")
	public ModelAndView updateUserUI(String id, HttpServletRequest request,ModelMap modelMap) {
		MUser muser = muserService.selectByPrimaryKey(id);
		modelMap.put("user", muser);
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(modelMap);
		mav.setViewName("updateUser");
		return mav;
	}

	@RequestMapping(value="/updateUserAction")
	public String updateUser(MUser muser) {
		muserService.update(muser);
		return "redirect:/muser/listUser.do";
	}
	
	
   @RequestMapping(value="/deleteUser")
    public ModelAndView deleteUser(String id) {
        muserService.delete(id);
        return new ModelAndView("redirect:/muser/listUser.do");
    }

}
