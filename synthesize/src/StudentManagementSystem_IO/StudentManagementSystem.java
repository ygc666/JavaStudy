package StudentManagementSystem_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) throws IOException {

        //定义文件路径
        String fileName = "Students.txt";

        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();

        while (true){
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("其他字符 退出");
            System.out.println("请输入你的选择：");
            //选择编号
            Scanner sc = new Scanner(System.in);
            String activeNumber = sc.nextLine();
            //实现选择
            switch (activeNumber){
                case "1":
                    //查看所有学生
                    findAllStudent(fileName);
                    break;
                case "2":
                    //添加学生
                    addStudent(fileName);
                    break;
                case "3":
                    //删除学生
                    deleteStudent(fileName);
                    break;
                case "4":
                    //修改学生
                    updateStudent(fileName);
                    break;
                default:
                    System.out.println("谢谢你的使用");
                    System.exit(0); //JVM退出
                    break;
            }
        }
    }

    //从文件中读数据到集合
    public static void readData(String fileName,ArrayList<Student> array) throws IOException {
        //创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        //读取一行数据
        String line;

        while ((line = br.readLine()) != null){
            String[] datas = line.split(",");

            Student s = new Student();
            s.setId(datas[0]);
            s.setName(datas[1]);
            s.setAge(datas[2]);
            s.setAddress(datas[3]);
            array.add(s);
        }

        br.close();
    }

    //把集合中的数据写入文件
    public static void writeData(String fileName,ArrayList<Student> array) throws IOException {
        //创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }




    //添加学生
    public static void addStudent(String fileName) throws IOException {

        ArrayList<Student> array = new ArrayList<Student>();

        //从文件中把数据读取到集合中
        readData(fileName,array);

        Scanner sc = new Scanner(System.in);

        //为了让id能够被访问到，我们就把id定义在了循环的外面
        String id;

        while (true) {
            System.out.println("请输入学生学号：");
            id = sc.nextLine();

            boolean onOff = false;

            for (int i = 0; i < array.size(); i++) {

                Student s = array.get(i);

                if (s.getId().equals(id)) {
                    onOff = true;
                    break;
                }

            }
            if(onOff){
                System.out.println("你输入的学号已经被占用,请重新输入");
            }else {
                break;//结束循环 便于添加学生
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

        //把学生对象作为元素添加到集合
        array.add(s);
        //把集合中的数据重新写回到文件
        writeData(fileName, array);

        //给出提示
        System.out.println("添加学生成功");
    }
    //查看所有学生
    public static void findAllStudent(String fileName) throws IOException {

        ArrayList<Student> array = new ArrayList<Student>();

        readData(fileName,array);

        //判断是否有数据
        if(array.size() == 0){
            System.out.println("不好意思,目前没有学生信息可供查询,请回去重新选择你的操作");
            return;
        }

        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getId()+"\t\t"+s.getName()+"\t\t"+s.getAge()+"\t\t"+s.getAddress());
        }
    }
    //删除
    public static void deleteStudent(String fileName) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();
        readData(fileName,array);

        //键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就删除该学生
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String id = sc.nextLine();

        //定义一个索引
        int index = -1;

        for(int i =0;i<array.size();i++){
            Student s = array.get(i);
            //如果找到了就把索引赋值给它用于删除
            if(s.getId().equals(id)){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("不好意思,你要删除的学号对应的学生信息不存在,请回去重新你的选择");
        }else {
            array.remove(index);
            //把集合中的数据重新写回到文件
            writeData(fileName,array);
            System.out.println("删除学生成功");
        }
    }
    //修改学生
    public static void updateStudent(String fileName) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();
        readData(fileName,array);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String id = sc.nextLine();

        //定义索引
        int index = -1;

        //遍历集合
        for(int i=0; i<array.size(); i++) {
            //获取每一个学生对象
            Student s = array.get(i);
            //拿学生对象的学号和键盘录入的学号进行比较
            if(s.getId().equals(id)) {
                index = i;
                break;
            }
        }

        //思路是替换整个学生对象
        if(index == -1) {
            System.out.println("不好意思,你要修改的学号对应的学生信息不存在,请回去重新你的选择");
        }else {
            System.out.println("请输入学生新姓名：");
            String name = sc.nextLine();
            System.out.println("请输入学生新年龄：");
            String age = sc.nextLine();
            System.out.println("请输入学生新居住地：");
            String address = sc.nextLine();

            //创建学生对象
            Student s = new Student();
            s.setId(id);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);

            //修改集合中的学生对象
            array.set(index, s);

            //把集合中的数据重新写回到文件
            writeData(fileName,array);

            //给出提示
            System.out.println("修改学生成功");
        }
    }

}
