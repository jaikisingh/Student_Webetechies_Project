package Employee.example.service;

import Employee.example.model.EmployeeModel;
import Employee.example.model.empDto.EmpDetailDto;
import Employee.example.model.empDto.EmpDto;
import Employee.example.model.enums.DepartmentEnums;
import Employee.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;


    //creating a post
    public String addEmployee(EmployeeModel employeeModel) {
        employeeRepo.save(employeeModel);
        return "Employee Detailed Added..!!";
    }

    // get All employee detail
    public List<EmployeeModel> getAllEmployee() {
        List<EmployeeModel> list = employeeRepo.findAll();
        return list;
    }

    // get sum of all employee salary
    public long allSalary() {
        //    <<-- 1st method-->>
        Long ans=employeeRepo.findSumOfSalaries();
        return ans;

        // <<--2nd method-->>

//        long ans = 0;
//        List<EmployeeModel> list = employeeRepo.findAll();
//        for (EmployeeModel key : list) {
//            ans += key.getSalary();
//        }
//        return ans;
    }

    // get all employee id, name,age
    public List<EmpDto> findAllEmpAge() {
    //    <<-- 1st method-->>

        List<EmpDto> elist = new ArrayList<>();
        List<EmployeeModel> list = employeeRepo.findAll();
        for (EmployeeModel emp : list) {
            EmpDto dto = new EmpDto();
            dto.setId(emp.getId());
            dto.setAge(emp.getAge());
            dto.setName(emp.getName());

            elist.add(dto);
        }
        return elist;


        // <<--2nd method-->>(conversion issue)
//        List<EmpDto> elist = new ArrayList<>();
//        elist=employeeRepo.findIdNameAndAge();
//        return elist;


    }


    // finding All employee name and age salary department

    public List<EmpDetailDto> getAllEmployeeDetail() {
        List<EmpDetailDto> elist = new ArrayList<>();

        List<EmployeeModel> list = employeeRepo.findAll();

        for (EmployeeModel emp : list) {
            EmpDetailDto dto = EmpDetailDto.builder()
                    .id(emp.getId())
                    .age(emp.getAge())
                    .name(emp.getName())
                    .department(emp.getDepartment())
                    .salary(emp.getSalary())
                    .build();

//            dto.setId(emp.getId());
//            dto.setAge(emp.getAge());
//            dto.setName(emp.getName());
            elist.add(dto);
        }
        return elist;
    }

    // delete all employee detail
    public String deleteEmployee() {
        employeeRepo.deleteAll();
        return "[All employee detail was deleted..!!!]";
    }

    // delete by Id
    public String deleteById(Long id) {
        employeeRepo.deleteById(id);
        return id + ":- employee deleted";
    }

    // update employee detail
    public String updateEmployee(EmployeeModel employeeModel) {
        employeeRepo.save(employeeModel);
        return "employee detailed added";
    }

    // get max salary
    public long getMaxSalary() {

//        <<--1st method-->>

//        long ans = 0;
//        List<EmployeeModel> list = employeeRepo.findAll();
//        for (EmployeeModel key : list) {
//            if (ans < key.getSalary()) {
//                ans = key.getSalary();
//            }
//
//        }
//        return ans;

//        <<--2nd method-->>

        long res=employeeRepo.findMaximumSalary();
        return res;
    }

    // get min salary
    public long getMinSalary() {

//        <<--1st method-->>
//
//        long ans=Long.MAX_VALUE;
//        List<EmployeeModel> list=employeeRepo.findAll();
//        for(EmployeeModel key:list){
//            if(ans>key.getSalary()){
//                ans= key.getSalary();
//            }
//        }
//        return ans;

//        <<--2nd method-->>

        long res=employeeRepo.findMinimumSalary();
        return res;
    }


    // get average salary
    public Double getAvgSalary() {
//        <<--1st method-->>

//        List<EmployeeModel> list=employeeRepo.findAll();
//        int n=list.size();
//        double ans=0;
//        for(EmployeeModel key:list){
//            ans+= key.getSalary();
//        }
//        return ans/n;

//        <<--2nd method-->>

        double res=employeeRepo.findAverageSalary();
        return res;
    }
    // finding total number of employee
    public int getEmployeeCounting() {
//        <<--1st method-->>

//        List<EmployeeModel>list=employeeRepo.findAll();
//        return list.size();

//        <<--2nd method-->>
        int res=employeeRepo.findTotalNumberOfEmployees();
        return res;
    }
    // finding by department
    public List<EmployeeModel> getByDepartment(DepartmentEnums department) {
        return employeeRepo.findByDepartment(department);

    }
// top 5 salary sum
    public long getFiveHighestSalary() {
//            <<--1st method -->>
//        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
//        long ans = 0;
//        List<EmployeeModel> list = employeeRepo.findAll();
//        for (EmployeeModel key : list) {
//            long value = key.getSalary();
//            pq.add(value);
//        }
//        for(int i=1;i<=5;i++){
//            ans+=pq.poll();
//        }
//        return ans;


        // <<-- 2nd method -->>

        long res=employeeRepo.findSumOfTop5Salaries();
       return res;
    }
}
