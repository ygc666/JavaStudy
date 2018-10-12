package Games;

public class PcGame extends StandAloneGame implements Keyboard{

    @Override
    public void KeyboardOperateGame() {
        System.out.println("使用键盘操作PC游戏");
    }
    //录制视频
    public void recordedVideo(){
        System.out.println("录制游戏视频");
    }

}
