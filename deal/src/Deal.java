import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deal {
    public static void main(String[] args) {

        //定义花色和牌
        String[] arr = {"黑桃","红桃","方块","梅花"};
        String[] arr2 = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        //存牌
        ArrayList<String> array = new ArrayList<>();

        //把花色和牌拼接起来
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr2.length;j++){
                array.add(arr[i] + arr2[j]);
            }
        }
        array.add("大王");
        array.add("小王");

        //洗牌 并 标记一张（斗地主中的翻牌）
        Collections.shuffle(array);
        Random r = new Random();
        int num = r.nextInt(54);
        String s = array.get(num);
        array.set(num,s+"-");
        //System.out.println(array);

        //发牌
        ArrayList<String> 周润发 = new ArrayList<>();
        ArrayList<String> 今晚打老虎 = new ArrayList<>();
        ArrayList<String> 孙先生 = new ArrayList<>();

        // array.size() - 3 留三张底牌给地主
        for(int i=0;i < array.size()-3;i++){
            //用取模来做
            if(i%3 == 0){
                周润发.add(array.get(i));
            }else if(i%3 == 1){
                今晚打老虎.add(array.get(i));
            }else if(i%3 == 2){
                孙先生.add(array.get(i));
            }
        }

        //判断谁拿到了那一张带标记的牌,并给他加入底牌
        if(!estimate(周润发)){
            addTh(array,周润发);
        }else if(!estimate(今晚打老虎)){
            addTh(array,今晚打老虎);
        }else {
            addTh(array,孙先生);
        }

        System.out.println(周润发);
        System.out.println(今晚打老虎);
        System.out.println(孙先生);

    }

    public static boolean estimate(ArrayList<String> arr){

        for(int i=0;i<arr.size();i++){
            String s = arr.get(i);
            String c = s.substring(s.length()-1);

            if(c.equals("-")){
                //arr.set(i,s.substring(0,s.length()-1));
                return false;
            }

        }

        return true;
    }

    //前面是所有牌，后面是玩家
    public static void addTh(ArrayList<String> array,ArrayList<String> o){
        int len = array.size();
        for(int i = len - 3;i < len;i++){
            o.add(array.get(i));
        }
        //System.out.println("底牌是：");
    }

}
