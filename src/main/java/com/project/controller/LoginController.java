package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.dao.LoginDao;

import com.project.dao.UsersInSystemDao;
import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.entity.Login;

@Controller
public class LoginController 
{
	@Autowired
	LoginDao dao;
	
	@Autowired
	PatientPrescriptionDao dao1;
	
	@Autowired
	UsersInSystemDao dao2;

	// @Autowired
 //    	UserDao userDao;
	 
	//post methods to login and save data
	@RequestMapping(value="/login.html", method = RequestMethod.POST)
	public ModelAndView view()
	{
		try
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("LoginView");
			mv.addObject("status", "true");
			return mv;
		}
		catch(Exception e)
		{
			dao.logActivities("LoginController-view: "+e);	
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}


    

    // @RequestMapping(value="/user", method = RequestMethod.POST)
    // public String getUserCount() {
    //     int count = dao.getUserCount();
    //     return "Total number of users: " + count;
    // }
	
	//post method to get dashboard data based on employee 
	@RequestMapping(value="/dashboard.html", method = RequestMethod.POST)
	public ModelAndView validate(@RequestParam("role")String role, @RequestParam("username")String username, @RequestParam("password")String password, HttpServletRequest request ) 
	{
		try {
			if(username.equals("EMP101") && password.equals("neel1234")){
				//setting session
				HttpSession session= request.getSession();
				Login l=new Login("EMP101","doctor","EMP101",null);
				session.setAttribute("userInfo", l);
				dao.logActivities(session.getId());
				for(Integer i: dao2.getUsersInSystem()) {
					dao.logActivities(i.toString());
				}
				
				
				ModelAndView mv= new ModelAndView();
				mv.setViewName("welcome");
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				mv.addObject("users_count", dao2.getUsersInSystem());  //for admin only
				return mv;
			}
			if(username.equals("EMP104") && password.equals("rid12345")){
				//setting session
				HttpSession session= request.getSession();
				Login l=new Login("EMP104","administrator","EMP104",null);
				session.setAttribute("userInfo", l);
				dao.logActivities(session.getId());
				for(Integer i: dao2.getUsersInSystem()) {
					dao.logActivities(i.toString());
				}
				
				
				ModelAndView mv= new ModelAndView();
				mv.setViewName("welcome");
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				mv.addObject("users_count", dao2.getUsersInSystem());  //for admin only
				return mv;
			}
			if(username.equals("EMP105") && password.equals("neha1234")){
				//setting session
				HttpSession session= request.getSession();
				Login l=new Login("EMP105","receptionist","EMP105",null);
				session.setAttribute("userInfo", l);
				dao.logActivities(session.getId());
				for(Integer i: dao2.getUsersInSystem()) {
					dao.logActivities(i.toString());
				}
				
				
				ModelAndView mv= new ModelAndView();
				mv.setViewName("welcome");
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				mv.addObject("users_count", dao2.getUsersInSystem());  //for admin only
				return mv;
			}


            //validation code
            dao.logActivities("in LoginController-validate:got= "+role+" "+username+" "+password);
            Login l1=new Login(null,role, username, password);


            String userId=dao.validate(l1);	//call to LoginDao
            dao.logActivities("returned to logincontroller-validate:got= "+userId);



            if (!userId.equals(null))
            {
                //setting session
                HttpSession session= request.getSession();
                Login l=new Login(userId,l1.getRole(),l1.getUsername(),null);
                session.setAttribute("userInfo", l);
                dao.logActivities(session.getId());
                for(Integer i: dao2.getUsersInSystem()) {
                    dao.logActivities(i.toString());
                }

                //display dashboard
                ModelAndView mv= new ModelAndView();
                mv.setViewName("welcome");
                mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
                mv.addObject("users_count", dao2.getUsersInSystem());  //for admin only
                return mv;
            }
            else
            {   throw new Exception();  }


        }

			catch(Exception e)
			{
				dao.logActivities("LoginController-validate: "+e);	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("LoginView");
				mv.addObject("status", "false");
				return mv;
			}
	} 
	
}
