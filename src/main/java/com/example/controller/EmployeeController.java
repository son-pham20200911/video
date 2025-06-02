package com.example.controller;

import com.example.entity.employee;
import com.example.repository.employeeRepository;
import com.example.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller // Phải là Controller vì khi hiển thị kiểu view (HTML)
public class EmployeeController {
    private employeeService employeeService;
    private employeeRepository employeeRepo;
    @Autowired
    public EmployeeController(com.example.service.employeeService employeeService,employeeRepository employeeRepo) {
        this.employeeService = employeeService;
        this.employeeRepo=employeeRepo;
    }


    //Lấy danh sách Employee
    @GetMapping("employee_list")
    public String getAll(Model model){
        //Lấy list employye in ra ở đây
        List<employee> employees=employeeService.getAll();
        if(employees==null){
            employees = new ArrayList<employee>();
        }
        //trả về view
        model.addAttribute("employees",employees);
        model.addAttribute("name","Sơn");
        return "employee-list"; // return về "tên file.html" (file phải tồn tại ở folder "templates" thì mới return được)
    }


    //Xóa Employee theo ID
    @GetMapping("/employee_delete")
    public String deleteEmployee(@RequestParam("id") Integer id){
    employeeRepo.deleteById(id);
    return "redirect:/employee_list"; // redirect: Có nghĩa là sau khi xóa xong nó sẽ không trả về tên VIEW mà là yêu cầu đến URL được chỉ định
                                      // Hiểu đơn giản là: Sau khi xóa hãy cho tôi quay lại URl "employee_list"
    }


    //Thêm Employee mới
    @GetMapping("/employee_add")
    public String addEmployee(Model model){
        employee em=new employee();
        model.addAttribute("employee",em);
        return "employee-add" ;
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute("employee") employee em){
        employeeRepo.save(em);
        return "redirect:/employee_list";
    }

    //Cập nhật Employee theo ID
    @GetMapping("/employee_update")
    public String updateEmployee(@ModelAttribute("id") Integer id,Model model){
        Optional<employee> em=employeeRepo.findById(id);
        model.addAttribute("employee",em);
        return "employee-update" ;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("employee") employee em){
        employeeRepo.saveAndFlush(em);
        return "redirect:/employee_list";
    }
}
