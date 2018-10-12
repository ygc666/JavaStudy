import java.sql.SQLOutput;

public class Array_String {
    public static void main(String[] args) {
        /*
         * 把数组拼接成一个字符串
         * 举例：
         * 		int[] arr = {1,2,3};
         * 结果：
         * 		[1, 2, 3]
         */

        int[] arr = {1,2,3};
        System.out.println("数组转换成字符串后的："+arrayToString(arr));
    }
    /*
     * 两个明确：
     * 		返回值类型：String
     * 		参数列表：int[] arr
     */
    public static String arrayToString(int[] arr){

        StringBuilder sb = new StringBuilder();

        //先在字符串前面输出 [
        sb.append('[');
        for(int i = 0;i<arr.length;i++){

            if(i == arr.length-1){
                sb.append(arr[i]);
            }else {
                sb.append(arr[i]).append(',');
            }

        }
        sb.append(']');
        return sb.toString();
    }
}
