package com.manage.college.controller;

import com.manage.college.models.Parents;
import com.manage.college.models.Student;
import com.manage.college.repository.StudentRepo;
import com.manage.college.services.ParentsSer;
import com.manage.college.services.StudentSer;

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
public class StudentsCon {

	@Autowired
    private StudentSer studentSer;
    @Autowired
    private ParentsSer parentsSer;
    @Autowired
    private StudentRepo studentRepo;



    @PostMapping("addStudent")
    public String addStudent(@ModelAttribute Student student, @ModelAttribute Parents parent, Model model, HttpSession session){
//        System.out.println("type added");
//        StudentSer.addStudent(Student);

        Parents temp = parentsSer.addParents(parent);

        student.setParents(temp);

        studentSer.addStudent(student);

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());
        session.setAttribute("msg","Student Added Sucessfully...");
        return "StudentAdd";
    }

    @PostMapping("AssignSubjectConform")
    public String AssignSubjectConform(@ModelAttribute Student student, Model model){
//        System.out.println("type added");
//        StudentSer.addStudent(Student);
        Student student1=studentRepo.findById(student.getID()).get();
        student1.setSubjects(student.getSubjects());




        studentSer.addStudent(student1);

        List<Student> student2 =studentSer.getStudent();
        model.addAttribute("student",  student2);

        return "Studentshow";
    }


    @GetMapping("Student")
    public String Student(Model model){

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());

        return "StudentAdd";


    }

   

    @GetMapping("Studentshow")
    public String STHome(Model model) throws Exception {
        List<Student> student =studentSer.getStudent();
        model.addAttribute("student",  student);
        return "Studentshow";
    }

    @GetMapping("/Studentshow/edit/{ID}")
    public String edit(@PathVariable("ID") long ID, Model m) throws Exception{

        Student student = studentSer.getStdByID(ID);

        m.addAttribute("student", student);

        return "StudentEdit";
    }

    @PostMapping("Studentshow/edit/UpdateStudent")
    public String UpdateStudent(@ModelAttribute Student student, Model model, HttpSession session) throws Exception{

        studentSer.addStudent(student);

        model.addAttribute("newParent", new Parents());
        model.addAttribute("newStudent", new Student());
        session.setAttribute("msg","Student Added Sucessfully...");
        return "StudentAdd";
    }

    @GetMapping("/Studentshow/delete/{ID}")
    public String deleteStudent(@PathVariable("ID") Long ID, HttpSession session) throws Exception{
        studentSer.deleteByStudentId(ID);        
        return "redirect:/Studentshow";
    }

//    @GetMapping("/Studentshow/delete/{ID}")
//    public String DeleteStd(@PathVariable("ID") long ID){
//
//    }
}