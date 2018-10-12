package Games;

abstract class StandAloneGame extends Game {

    @Override
    void openGame() {
        System.out.println("单机游戏打开");
    }

    @Override
    void closeGame() {
        System.out.println("单机游戏关闭");
    }

    public void handleOperateGame(){
        System.out.println("使用手柄操作单机游戏");
    }

}
