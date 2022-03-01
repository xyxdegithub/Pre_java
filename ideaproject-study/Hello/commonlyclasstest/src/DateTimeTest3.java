import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :xyx
 * @date :2021/2/2 13:37
 * @description:练习:将字符串2021-2-2转化成java.sql.date
 * @
 */
public class DateTimeTest3 {
    public static void main(String[] args) throws ParseException {
        String birth = "2021-2-2";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = simpleDateFormat.parse(birth);//util包下的date
        //util转化成sql下的date
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);//输出sql下的date，2021-02-02
    }
}
