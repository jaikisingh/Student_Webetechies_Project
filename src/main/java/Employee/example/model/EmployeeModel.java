package Employee.example.model;


import Employee.example.model.enums.DepartmentEnums;
import Employee.example.model.enums.GenderEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dob;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private GenderEnums gender;
    private long phoneNo;
    @Enumerated(value = EnumType.STRING)
    private DepartmentEnums department;
    private long salary;
    private String employeeStatus;

}
