import java.util.ArrayList;

public class function {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();

        //添加元素
        array.add("PG one");
        array.add("Gai");
        //获取元素 返回指定索引处的元素
        array.get(0);

        //集合长度
        array.size();

        //删除元素

        //删除指定的元素，返回删除是否成功
        array.remove("PG one");
        //删除指定索引处的元素，返回被删除的元素
        array.remove(0);

        //修改元素
        //修改指定索引处的元素，返回被修改的元素
        String el = array.set(1,"bridge");
    }
}
