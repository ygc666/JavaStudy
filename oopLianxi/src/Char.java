public class Char {
    public static void main(String[] args) {
        char[] arr = { '我','好','渴','谁','来','整','救','我' ,'帮','我','止','渴'};
        System.out.println("数组中'渴'的数量是："+ count(arr, '渴') );
        change(arr,'我','你');
        //System.out.println(arr[0]);
        transform(arr);

    }
    //计数
    public static int count(char[] arr,char str){
        int c = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==str){
                c++;
            }
        }
        return c;
    }
    //改变
    public static void change(char[] arr,char a,char b){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == a){
                arr[i] = b;
            }
        }
    }
    //
    public static void transform(char[] arr){
        String str = new String(arr);
        //System.out.println(str);
        int[] indexs = new int[arr.length];
        int index = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='你'){
                indexs[index++] = i;
            }
        }
        System.out.println("数组中第二个'你'的位置是："+ indexs[1] );

        changeStr(str);

    }
    public static void changeStr(String str){
        str = str.replace('你','他');
        //System.out.println(str.charAt(0));
        System.out.println("--------------------------");
        System.out.println(str);
        int index1 = str.indexOf('他')+1;
        int index2 = str.indexOf('他',index1)+1;
        int index3 = str.indexOf('他',index2);
        System.out.println("第一个他和第三个他之间的字符串是："+str.substring(index1,index3));

    }
}
