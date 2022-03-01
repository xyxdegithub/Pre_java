package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/3/24 16:29
 * @description:TODO
 * @
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    private Integer id;
    private String name;
    List<Employee> employees;
}
