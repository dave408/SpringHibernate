package com.david.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.david.common.dao.CourseDAO;
import com.david.common.dao.EnrollmentDAO;
import com.david.common.dao.StudentDAO;
import com.david.common.model.Course;
import com.david.common.model.Enrollment;
import com.david.common.model.Student;
import com.david.common.service.EnrollmentService;

@Controller
public class StudentController {
	@Autowired
    private StudentDAO studentDAO;
	
	@Autowired
    private CourseDAO courseDAO;
	
	@Autowired
    private EnrollmentDAO enrollmentDAO;
	
	@Autowired
    private EnrollmentService enrollmentService;
	
	@RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
	public String listStudent(Model model){

		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentDAO.listStudent());
		
		model.addAttribute("course", new Course());
		model.addAttribute("courseList", courseDAO.listCourse());
		
		model.addAttribute("enrollment", new Enrollment());
		model.addAttribute("enrollmentList", enrollmentDAO.listEnrollment());
		return "students";
	}
	
	@RequestMapping(value = "/addStudent", method = {RequestMethod.POST, RequestMethod.GET})
	public String addStudent(Model model, @ModelAttribute("student") Student student, BindingResult result){
	
		studentDAO.insertStudent(student);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/addCourse", method = {RequestMethod.POST, RequestMethod.GET})
	public String addCourse(Model model, @ModelAttribute("course") Course course, BindingResult result){
	
		courseDAO.insertCourse(course);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/addEnrollment/{studentId}/{courseId}", method = {RequestMethod.POST, RequestMethod.GET})
	public String addEnrollment(Model model, @PathVariable(value="studentId") Integer sid, @PathVariable(value="courseId") Integer cid) {
	
		//enrollmentDAO.insertEnrollment(enrollment);
		enrollmentService.registerClass(sid, cid);
		return "redirect:/list";
	}
	
	@RequestMapping(value =  "/deleteStudent/{studentId}", method = {RequestMethod.POST, RequestMethod.GET})
	public String removeStudent(Model model, @PathVariable("studentId") Integer sid) {
	 
		model.addAttribute("student", new Student());
		enrollmentService.removeStudent(sid);
	 
	    return "redirect:/list";
	}
	
	@RequestMapping(value =  "/deleteCourse/{courseId}", method = {RequestMethod.POST, RequestMethod.GET})
	public String removeCourse(Model model, @PathVariable("courseId") Integer cid) {
	 
		model.addAttribute("course", new Course());
		enrollmentService.removeCourse(cid);
	 
	    return "redirect:/list";
	}
	
	@RequestMapping(value =  "/deleteEnrollment/{enrollmentId}", method = {RequestMethod.POST, RequestMethod.GET})
	public String removeEnrollment(Model model, @PathVariable("enrollmentId") Integer eid) {
	 
		model.addAttribute("enrollment", new Enrollment());
		enrollmentDAO.deleteEnrollment(eid);
	 
	    return "redirect:/list";
	}
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping(value = "/loginFail", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "loginFail";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "logout";
    }
}