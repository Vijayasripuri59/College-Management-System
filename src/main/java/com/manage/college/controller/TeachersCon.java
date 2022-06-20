package com.manage.college.controller;

import com.manage.college.models.Parents;
import com.manage.college.models.Student;
import com.manage.college.models.Subjects;
import com.manage.college.models.Teachers;
import com.manage.college.services.SubjectsSer;
import com.manage.college.services.TeachersSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeachersCon {
	@Autowired
    private TeachersSer teachersSer;

    @Autowired
    private SubjectsSer subjectsSer;



    @PostMapping("addTeacher")
    public String addVTypes(@ModelAttribute Teachers teachers,@ModelAttribute Subjects subjects, Model model){
//

        teachers.setSubjects(subjects);
        teachersSer.addTeacher(teachers);

        model.addAttribute("Subjects", subjectsSer.getAllSubjects());
        model.addAttribute("newTeacher", new Teachers());
        model.addAttribute("newSubject", new Subjects());


        return "TeachersAdd";

    }

    @GetMapping("Teachers")
    public String Teacher(Model model){

        model.addAttribute("Subjects", subjectsSer.getAllSubjects());
        model.addAttribute("newTeacher", new Teachers());
        model.addAttribute("newSubject", new Subjects());

        return "TeachersAdd";

    }


    @GetMapping("Teachersshow")
    public String Teachersshow(Model model){
        List<Teachers> Teacher =teachersSer.getTeachers();
        model.addAttribute("Teacher",  Teacher);
        return "Teachersshow";
    }

    @GetMapping("/Teachersshow/edit/{ID}")
    public String edit(@PathVariable("ID") long ID, Model m){

        Teachers teacher = teachersSer.getteaByID(ID);

        m.addAttribute("Teacher", teacher);

        return "TeacherEdit";
    }

    @PostMapping("Teachersshow/edit/UpdateTeacher")
    public String UpdateTeacher(@ModelAttribute Teachers teachers, Model model, HttpSession session){

        teachersSer.addTeacher(teachers);

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());     
       
        return "redirect:/Teachersshow";
    }
    @GetMapping("/Teachersshow/delete/{ID}")
    public String deleteTeachers(@PathVariable("ID") Long ID) {
        teachersSer.deleteById(ID);       
        return "redirect:/Teachersshow";
}

}