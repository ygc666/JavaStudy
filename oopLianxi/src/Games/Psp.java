package Games;

public class Psp extends StandAloneGame implements InsertCard {

    @Override
    public void insertCard() {
        System.out.println("插入PSP游戏卡");
    }

    //记录游戏
    public void recordGame(){
        System.out.println("记录游戏...");
    }

}
