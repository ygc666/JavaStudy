package ArrayListToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 键盘录入3个学生信息 (学号，姓名，年龄，居住地) 存入集合
* 然后遍历集合把每一个学生存入文本文件（ 每一个学生信息为一行数据 ）
* */
public class ArrayListToFile {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();

        //写方法实现键盘录入学生信息，并把学生对象作为元素添加到集合
        addStudent(array);
        addStudent(array);
        addStudent(array);

        //创建缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("array.txt"));

        //遍历集合，得到每一个学生信息，并把学生信息按照一定的格式写入文本文件
        for (int i =0;i<array.size();i++){
            Student s = array.get(i);

            // StringBuilder
            StringBuilder sb = new StringBuilder();

            sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
    }
    public static void  addStudent(ArrayList<Student> array){
        //键盘录入对象
        Scanner sc = new Scanner(System.in);

        //为了让 id 能被访问到 把 id 定义在循环的外面
        String id;

        while (true){
            System.out.println("请输入学生学号：");
            id = sc.nextLine();
            //判断学号是否被占用
            //定义标记
            boolean onOff = false;
            //遍历集合，得到每一个学生
            for(int i = 0;i<array.size();i++){
                Student s = array.get(i);
                //获取该学生的学号和键盘录入的学号进行比较
                if(s.getId().equals(id)){
                    onOff = true;
                    break;
                }
            }

            if(onOff){
                System.out.println("你输入的学号已经被占用，请重新输入：");
            }else {
                break;//结束循环,也就是结束 while 循环
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);

        //给出提示
        System.out.println("添加学生成功！");

    }
}
