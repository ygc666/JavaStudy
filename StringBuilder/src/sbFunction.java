public class sbFunction {
    public static void main(String[] args) {
        /*
        * 注意：
        *   构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符
        *
        * StringBuilder 的常用方法
        * */

        StringBuilder sb = new StringBuilder();

        //返回当前容量值
        sb.capacity();

        //返回长度(已经存储的字符个数)
        sb.length();

        //添加数据，并返回自身对象(可添加任何类型),并且支持链式编程， 如JQ链式操作一样返回自身对象，在进行操作
        sb.append('1').append('2').append('3');

        //反转功能
        sb.reverse();

        //把StringBuilder转成String
        String s = sb.toString();

        //把String转成StringBuilder
        StringBuilder sb1 = new StringBuilder(s);

    }
}
