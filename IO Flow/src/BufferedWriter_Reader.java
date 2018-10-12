import java.io.*;

public class BufferedWriter_Reader {

    /*
     * BufferedWriter:将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
     * BufferedReader:从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
     */

    public static void main(String[] args) throws IOException {
        //创建输出缓存流：构造参数传入的是 FileWriter
        BufferedWriter bw = new BufferedWriter(new FileWriter("111.txt"));
        bw.write("hello");
        bw.close();

        //创建输入缓存流：
        BufferedReader br = new BufferedReader(new FileReader("1.txt"));
        br.close();

        //缓冲流特有方法使用

        //写一个换行符，这个换行符由系统决定,不同的操作系统newLine()方法使用的换行符不同
        bw.newLine();

        //一次读取一行数据，但是不读取换行符
        br.readLine();
    }

}
