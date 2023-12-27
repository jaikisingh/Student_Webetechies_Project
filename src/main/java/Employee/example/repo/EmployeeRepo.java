package Employee.example.repo;

import Employee.example.model.EmployeeModel;
import Employee.example.model.empDto.EmpDto;
import Employee.example.model.enums.DepartmentEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeModel,Long> {
        // fetch employee by department
    List<EmployeeModel> findByDepartment(DepartmentEnums department);

        // finding minimum salary from All employee
    @Query("SELECT MIN(e.salary) FROM EmployeeModel e")
    Long findMinimumSalary();

        // finding maximum salary from All employee
    @Query("SELECT MAX(e.salary) FROM EmployeeModel e")
    Long findMaximumSalary();

        // finding sum of top5 employee salary
    @Query(value = "SELECT SUM(salary) AS totalSalary FROM (SELECT salary FROM employee_model ORDER BY salary DESC LIMIT 5) AS topSalaries", nativeQuery = true)
    Long findSumOfTop5Salaries();

        // finding total number of employee
    @Query(value = "SELECT COUNT(*) FROM employee_model", nativeQuery = true)
    Integer findTotalNumberOfEmployees();

        // finding total salary average
    @Query(value = "SELECT AVG(salary) FROM employee_model", nativeQuery = true)
    Double findAverageSalary();


        // finding All employee with their name and age
        @Query(value = "SELECT id,name, age FROM empdto.employee_model", nativeQuery = true)
        List<EmpDto> findIdNameAndAge();

        // finding sum of total salary
        @Query(value = "SELECT SUM(salary) FROM employee_model", nativeQuery = true)
        Long findSumOfSalaries();


}
