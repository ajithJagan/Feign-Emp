package com.service.employee.Controller;

import com.service.employee.Dto.EmployeeDto;
import com.service.employee.Model.EmployeeModel;
import com.service.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/check")
    public String check() {
        logger.info("Received request to check employee.");
        return "Working Fine";
    }

    @PostMapping("/insert")
    public String insertEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.insertEmployee(employeeDto);
    }

    @GetMapping("/getAll")
    public List<EmployeeModel> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getById")
    public EmployeeModel getById(@RequestParam long empId){
     return employeeService.getById(empId);
    }

    @GetMapping("/getByIdTotal")
    public long getByIdTotal(@RequestParam long empId){
        return employeeService.getByIdTotal(empId);
    }

}
