package nodeStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/23 11:32
 * @description:file的一些方法、创建文件和删除文件
 * @getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("E:\\javacode\\ideaproject\\Hello\\io\\file.txt");

        System.out.println("文件名称为:"+file.getName());
        System.out.println("文件大小（字节数）"+file.length());
        System.out.println("文件父级目录"+file.getParent());
        System.out.println("文件路径"+file.getPath());
        System.out.println("文件绝对路径"+file.getAbsolutePath());
        System.out.println("是不是一个文件"+file.isFile());
        System.out.println("是不是一个目录"+file.isDirectory());
        System.out.println("是不是存在"+file.exists());

    }

    @Test
    //创建文件方式一
    public void test01() {
        //方式 2 new File(File parent,String child) //根据父目录文件+子路径构建
        //方式 3 new File(String parent,String child) //根据父目录+子路径构建
        File file2 = new File("E:\\javacode\\ideaproject\\Hello\\io\\file2");
        try {
            boolean newFile = file2.createNewFile();
            if (newFile == true) {
                System.out.println("创建file2成功!");
            } else {
                System.out.println("创建file2失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //删除文件
    public void test02() {

        File file2 = new File("E:\\javacode\\ideaproject\\Hello\\io\\file2.pdf");
        boolean delete = file2.delete();
        if (delete == true) {
            System.out.println("删除file2成功!");
        } else {
            System.out.println("删除file2失败!");
        }
    }

}