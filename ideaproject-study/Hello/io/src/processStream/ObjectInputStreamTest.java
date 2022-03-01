package processStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author :xyx
 * @date :2021/5/25 10:23
 * @description:TODO
 * @
 */
public class ObjectInputStreamTest {

    @Test
    public void test() {
        String path = "object.dat";
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readDouble());
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
