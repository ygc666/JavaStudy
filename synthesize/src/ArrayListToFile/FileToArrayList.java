package ArrayListToFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileToArrayList {
    /*
    * 把上一题的文本文件中的学生信息读取出来存储到集合中，然后遍历，在控制台输出
    * */
    public static void main(String[] args) throws IOException {
        //创建输入缓冲流
        BufferedReader br = new BufferedReader(new FileReader("array.txt"));

        //创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //读取文件数据，并把数据按照一定的格式进行分割赋值给学生对象，然后把学生对象存储到集合中
        String line;
        // br.readLine() 一次读取一行，没读到数据 是为 null 的
        while ((line=br.readLine())!=null){
            //把字符串 按 , 分割成数组
            String[] strArray = line.split(",");
            //创建学生对象并赋值
            Student s = new Student();
            s.setId(strArray[0]);
            s.setName(strArray[1]);
            s.setAge(strArray[2]);
            s.setAddress(strArray[3]);
            array.add(s);
        }
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println("学号\t\t姓名\t\t年龄\t\t地址");
            System.out.println(s.getId()+"\t\t"+s.getName()+"\t\t"+s.getAge()+"\t\t"+s.getAddress());

        }
    }
}
