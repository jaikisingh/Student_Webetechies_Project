package Employee.example.model.empDto;

import Employee.example.model.enums.DepartmentEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDetailDto {
    private Long id;
    private String name;
    private int age;
    private DepartmentEnums department;
    private long salary;
}
