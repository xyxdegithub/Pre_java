package bean;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author :xyx
 * @date :2021/3/29 9:46
 * @description:TODO
 * @
 */
@Getter
public class Person {
  @Autowired
  private Cat cat;
  @Autowired
  private Dog dog;

}
