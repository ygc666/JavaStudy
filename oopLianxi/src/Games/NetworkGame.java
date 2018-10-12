package Games;

public class NetworkGame extends Game{

    String name = "网络游戏";

    String id;

    String password;

    @Override
    void openGame() {
        System.out.println("打开网络游戏");
        this.landing();
    }

    @Override
    void closeGame() {
        System.out.println("关闭网络游戏");
        this.logout();
    }

    public void landing(){
        System.out.println("登陆...");
    }

    public void logout(){
        System.out.println("登出...");
    }

}
