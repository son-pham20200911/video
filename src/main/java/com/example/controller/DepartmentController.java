package com.example.controller;

import com.example.entity.department;
import com.example.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {
    private com.example.service.departmentService departmentService;

    @Autowired
    public DepartmentController(com.example.service.departmentService departmentService) {
        this.departmentService = departmentService;
    }

    //Lấy danh sách Department
    @GetMapping("department_list")
    public String getAllDepartment(Model model){
        List<department> departments=departmentService.getAll();
        if(departments.isEmpty()||departments==null){
            departments=new ArrayList<>();
        }
        model.addAttribute("departments",departments);
        return "department-list";
    }

    // Thêm Department
    @GetMapping("/add_department")
    public String addDepartment(Model model){
        department de=new department();
        model.addAttribute("department",de);
        return "department-add";
    }
    @PostMapping("add")
    public String add(@ModelAttribute("department")department de){
    departmentService.addDepartment(de);
    return "redirect:/department_list";
    }

    //Xóa Department
    @GetMapping("/delete_department")
    public String deleteDepartment(@ModelAttribute("id")Integer id){
    departmentService.deleteDepartment(id);
    return "redirect:/department_list";
    }

    //Cập nhật Department
    @GetMapping("/update_department/{id}")
    public String updateDepartment(@PathVariable("id") Integer id, Model model) {
        department de = departmentService.getById(id)
                .orElse(new department());
        model.addAttribute("department", de);
        return "department-update";
    }
    @PostMapping("/up")
    public String update(@ModelAttribute("department") department department) {
        if (department.getId() == null) {
            // Xử lý lỗi nếu cần
            return "redirect:/department_list";
        }
        departmentService.updateDepartment(department);
        return "redirect:/department_list";
    }
}
