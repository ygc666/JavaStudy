package StudentManagementSystem;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManageementSystem {
    /*
     * 这是我的学生管理系统的主类
     *
     * 步骤如下：
     * A:定义学生类
     * B:学生管理系统的主界面的代码编写
     * C:学生管理系统的查看所有学生的代码编写
     * D:学生管理系统的添加学生的代码编写
     * E:学生管理系统的删除学生的代码编写
     * F:学生管理系统的修改学生的代码编写
     */

    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();

        //用循环让程序回到选择界面
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            String orderNumber = sc.nextLine();
            // 用switch语句实现选择
            switch (orderNumber) {
                case "1":
                    // 查看所有学生
                    showAllStudent(array);
                    break;
                case "2":
                    // 添加学生
                    addStudent(array);
                    break;
                case "3":
                    // 删除学生
                    deleteStudent(array);
                    break;
                case "4":
                    // 修改学生
                    updateStudent(array);
                    break;
                case "5":
                    // 退出
                    System.out.println("谢谢你的使用");
                    System.exit(0); // JVM退出
                default:
                    //如果没有输入 1-5 的数字就让他从新输入
                    System.out.println("你输入的序号不存在,请从新输入");
                    break;
            }
        }
    }
    //显示所有学生
    public static void showAllStudent(ArrayList<Student> array){
        //先判断是否有数据
        if(array.size() == 0){
            System.out.println("不好意思没有可用学生信息");
            return;
        }

        // title
        System.out.println("学号\t\t姓名\t年龄\t居住地");

        //遍历以便显示所有学生
        for(int i = 0; i < array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getId()+"\t\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
        }
    }
    //添加学生信息
    public static void addStudent(ArrayList<Student> array){
        //创建键盘录入对象

        Scanner sc = new Scanner(System.in);

        //为了让id能够被访问到，我们就把id定义在了循环的外面
        String id;

        //为了让代码能够回到这里，用循环
        while(true) {
            System.out.println("请输入学生学号：");
            id = sc.nextLine();

            //判断学号有没有被人占用
            //定义标记
            boolean flag = false;
            //遍历集合，得到每一个学生
            for(int i=0; i<array.size(); i++) {
                Student s = array.get(i);
                //获取该学生的学号，和键盘录入的学号进行比较
                if(s.getId().equals(id)) {
                    flag = true; //说明学号被占用了
                    break;
                }
            }
            //flag 为 true 表示被占用了
            if(flag) {
                System.out.println("你输入的学号已经被占用,请重新输入");
            }else {
                break; //结束循环
            }
        }

        //提示输入
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

        //给出提示
        System.out.println("添加学生成功");
    }
    //删除学生
    public static void deleteStudent(ArrayList<Student> array) {
        //删除学生的思路：键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就删除该学生
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String id = sc.nextLine();

        //定义一个索引
        int index = -1;

        //遍历集合
        for(int x=0; x<array.size(); x++) {
            //获取到每一个学生对象
            Student s = array.get(x);
            //拿这个学生对象的学号和键盘录入的学号进行比较,如果学号相同就把当前索引赋值给 index 以便以后使用
            if(s.getId().equals(id)) {
                index = x;
                break;
            }
        }

        if(index == -1){
            System.out.println("对不起你输入的学号不存在，请检查后从新输入");
        }else {
            array.remove(index);
            System.out.println("删除学生成功");
        }
    }
    //修改学生
    public static void updateStudent(ArrayList<Student> array){
        //修改学生的思路：键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就修改该学生

        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String id = sc.nextLine();

        //同删除对象的判断方式
        int index = -1;
        for(int x=0; x<array.size(); x++) {
            Student s = array.get(x);
            if(s.getId().equals(id)) {
                index = x;
                break;
            }
        }
        if(index == -1){
            System.out.println("对不起你输入的学号不存在，请检查后从新输入");
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

            //给出提示
            System.out.println("修改学生成功");

        }

    }
}
