package Employee.example.controller;

import Employee.example.model.EmployeeModel;
import Employee.example.model.empDto.EmpDetailDto;
import Employee.example.model.empDto.EmpDto;
import Employee.example.model.enums.DepartmentEnums;
import Employee.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    // add a post
        @PostMapping("/employee")
        public String addEmployee(@RequestBody EmployeeModel employeeModel){
            return employeeService.addEmployee(employeeModel);
        }
        // get All

    @GetMapping("/employee")
    public List<EmployeeModel> getAllEmployee(){
            return employeeService.getAllEmployee();
    }
    //find out All emp and age

    @GetMapping("/employee/name/age")
    public List<EmpDto> findAllEmpAge(){
            return employeeService.findAllEmpAge();
    }

    // find sum of All emp. Salary
    @GetMapping("/allSalary")
    public Long allSalary(){
            return employeeService.allSalary();
    }
    // get All employee detail with their id,name,age,salary,department
    @GetMapping("/employeeDetail")
    public List<EmpDetailDto> getAllEmployeeDetail() {
        return employeeService.getAllEmployeeDetail();
    }
    // delete All api from employee table
    @DeleteMapping("/Employee")
    public String deleteEmployee(){
            return employeeService.deleteEmployee();
    }

    //delete by id
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
            return employeeService.deleteById(id);
    }

    // put or update employee detail
    @PutMapping("/Employee/id")
    public  String updateEmployee(@RequestBody EmployeeModel employeeModel){
            return employeeService.updateEmployee(employeeModel);
    }

    //get maximum salary

    @GetMapping("/employee/maxSalary")
    public long getMaxSalary(){
            return employeeService.getMaxSalary();
    }


    // get minimum salary
    @GetMapping("/employee/min/salary")
    public long getMinSalary(){
            return employeeService.getMinSalary();
    }

    @GetMapping("/employee/average/salary")
    public double getAvgSalary(){
            return employeeService.getAvgSalary();
    }
    // for finding total number of employee
    @GetMapping("/employee/counting")
    public int getEmployeeCounting(){
            return employeeService.getEmployeeCounting();
        }
        // for finding by department
        @GetMapping("/employee/{department}")
    public List<EmployeeModel> getByDepartment(@PathVariable DepartmentEnums department){
            return employeeService.getByDepartment(department);
        }

        // top 5 salary sum
        @GetMapping("/employee/top5/salary")

    public long getFiveHighestSalary(){
            return employeeService.getFiveHighestSalary();
        }

    }

