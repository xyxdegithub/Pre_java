package mappers;

import entity.Employee;

import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/25 19:52
 * @description:TODO
 * @
 */
public interface employeeMapper {
    List<Employee> findAllEmployees();
}

