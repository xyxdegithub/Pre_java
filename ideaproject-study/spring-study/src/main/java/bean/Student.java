package bean;

import lombok.*;

import java.util.*;

/**
 * @author :xyx
 * @date :2021/3/28 20:58
 * @description:TODO
 * @
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;
    public String toString() {
        return "Student(name=" + this.getName() +"\n"+
                " address=" + this.getAddress()  +"\n"+
                " books=" + Arrays.deepToString(this.getBooks()) + "\n" +
                " hobbys=" + this.getHobbys() + "\n" +
                " card=" + this.getCard() + "\n" +
                " games=" + this.getGames() + "\n" +
                " wife=" + this.getWife() + "\n" +
                " info=" + this.getInfo() + ")";
    }
}
