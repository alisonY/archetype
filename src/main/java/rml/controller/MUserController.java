package rml.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rml.model.MUser;
import rml.service.MUserServiceI;

@Controller
@RequestMapping("/muser")
public class MUserController {

	private MUserServiceI muserService;

	public MUserServiceI getMuserService() {
		return muserService;
	}

	@Autowired
	public void setMuserService(MUserServiceI muserService) {
		this.muserService = muserService;
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
