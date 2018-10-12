package StudentManagementSystem;

public class Student {

    //学号
    private String id;
    //姓名
    private String name;
    //年龄
    private String age;
    //地址
    private String address;

    //方法重载，无参构造
    public Student(){

    }
    //带参构造
    public Student(String id,String name,String age,String address){

    }
    //用软件设置的 getSet 方法
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
