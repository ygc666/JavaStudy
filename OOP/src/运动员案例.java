public class 运动员案例 {
    public static void main(String[] args) {
        篮球教练 xm = new 篮球教练();

    }
}

class Person{
    String name;
    int age;
    String sex;
    public void eat(){
        System.out.println("吃饭...");
    }
    public void sleep(){
        System.out.println("睡觉...");
    }
}

abstract class Sportsman extends Person{
    abstract void study();
}

abstract class Instructor{
    abstract void instruct();
}

interface StudyEnglish{
    void studyE();
}

class 乒乓球运动员 extends Sportsman{

    @Override
    void study() {
        System.out.println("学习打乒乓球...");
    }

}

class 篮球运动员 extends Sportsman implements StudyEnglish{

    @Override
    void study() {
        System.out.println("学习打蓝球...");
    }

    @Override
    public void studyE() {
        System.out.println("学习英语...");
    }
}

class 乒乓球教练 extends Instructor{

    @Override
    void instruct() {
        System.out.println("教打乒乓球...");
    }

}

class 篮球教练 extends Instructor implements StudyEnglish{

    @Override
    void instruct() {
        System.out.println("教打篮球...");
    }

    public void studyE() {
        System.out.println("学习英语...");
    }

}

