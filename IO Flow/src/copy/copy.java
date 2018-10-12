package copy;

import java.io.*;

public class copy {
    /*
    * 复制文件的三种方式
    * */
    public static void main(String[] args) throws IOException {
        String targetFileName = "2.txt";
        String newFileName = "copy.txt";

        fn1(targetFileName,newFileName);
    }
    //fn1
    public static void fn1(String targetFileName,String newFileName) throws IOException {
        //创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(targetFileName));
        //创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName));

        //一次读写一行字符串 一行
        String line;
        while ((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
        br.close();
    }
    //fn2
    public static void fn2(String targetFileName,String newFileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(targetFileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName));

        //一次读写一个字符数组
        char[] chs = new char[1024];
        int len;
        // = -1 表示文件已经获取不到了
        //len = br.read(chs) 顺便给 len 赋值
        //这里如果不手动给出三个参数 write 方法 默认是 从 0 到 1024 也就是上面 new char[1024]的长度
        while((len=br.read(chs)) != -1){
            bw.write(chs,0,len);
        }
        //释放资源
        bw.close();
        br.close();
    }
    //fn3
    public static void fn3(String targetFileName,String newFileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(targetFileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName));

        //一次读写一个字符
        int ch;
        // = -1 表示文件已经获取不到了
        while((ch=br.read()) != -1){
            bw.write(ch);
        }
        //释放资源
        bw.close();
        br.close();
    }
}
