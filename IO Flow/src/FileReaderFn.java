import java.io.FileReader;
import java.io.IOException;

public class FileReaderFn {
    public static void main(String[] args) throws IOException {
        /*
        * 读取数据 - 输入流
        * FileReader(String fileName):传递文件名称
        * */

        //输入流对象
        FileReader fr = new FileReader("1.txt");

        //一次读取一个字符 int read(); 未读取到 返回 -1
        int ch = fr.read();
        System.out.println((char)ch);

        //释放资源
        fr.close();
    }
}
