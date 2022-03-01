package bean;

import lombok.*;

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
public class Address {
    private String address;

    public String toString() {
        return "Address(address=" + this.getAddress() + ")";
    }
}
