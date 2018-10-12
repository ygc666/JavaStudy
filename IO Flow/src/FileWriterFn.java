import java.io.FileWriter;
import java.io.IOException;

public class FileWriterFn {

    public static void main(String[] args) throws IOException, IOException {
        /*
        * FileWriter向文件中写数据
        * 构造方法
        *   FileWriterFn(String file Name);传入文件路径
        * */
        FileWriter fw = new FileWriter("1.txt");

        //向文件中写str
        fw.write("hello");
        //写一个字符串中的一部分数据
        fw.write("abcde",1,3);
        /*写一个字符数据这里写 int 类型的好处是既可以写 char 类型的数据
        也可以写char对应的int类型的值，如: 'a' 97*/
        fw.write(97);
        fw.write('a');
        //写一个字符数组数据
        char[] chs = {'a','b','c','d','e'};
        fw.write(chs);
        //写一个字符数组的一部分数据
        fw.write(chs,1,3);

        //数据没有直接写入文件而是写到了内存缓冲区,将内存中的数据刷新到文件中
        fw.flush();

        //关流释放系统底层资源
        fw.close();

        /*
        * 各个系统如何实现换行
        *
        * windows:\r\n
        * linux:\n
        * mac:\r
         * */

    }
}
