import java.io.File;

public class outputAllJavaFile {
    /*
     * 需求：输出指定目录下所有的java文件名（包含子目录）
     */
    public static void main(String[] args) {
        File f = new File("G:\\JavaFile");
        func(f);
    }

    public static void func(File file){
        //如果是文件夹
        if(file.isDirectory()){
            //获取文件夹下面所有文件文件夹
            File[] files = file.listFiles();
            for (File f : files) {
                //判断是否是文件
                if(f.isFile()){
                    if(f.getName().endsWith(".java")){
                        System.out.println(f.getName());
                    }
                }else {
                    //递归思路再次调用 func
                    func(f);
                }
            }
        }
    }
}
