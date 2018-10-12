import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("1.txt");

        //一次读写一个字符
        char[] chs = new char[1024];
        int len;
        int i = 0;
        while ((len = fr.read(chs)) != -1 ){

        }
        fr.close();
    }
}
