package cumt.tj.learn.algorithms;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by sky on 17-5-11.
 */
public class Traversal {

    /**
     * 先序遍历《数据结构与算法分析——java语言描述版》第四章
     * 打印目录结构
     * @param filePath 根目录
     * @param filenameFilter 目录过滤器，如过滤掉隐藏文件
     */
    public void printFilePath(String filePath, FilenameFilter filenameFilter){
        //树的深度，根深度为0
        int depth=0;
        System.out.println(filePath+"/");
        File path=new File(filePath);
        printFilePath(path,depth,filenameFilter);
    }


    /**
     * 先序遍历具体实现
     * 打印目录结构
     * @param filePath 父节点目录
     * @param depth 节点的深度
     * @param filenameFilter 目录过滤器，如过滤掉隐藏文件
     */
    public void printFilePath(File filePath, int depth, FilenameFilter filenameFilter){
        //每递归调用一次，遍历到的节点深度+1
        depth++;

        //获得满足过滤器的所有子目录
        File[] childFiles=filePath.listFiles(filenameFilter);
        String space;

        //对子目录进行那个遍历
        for (File f:childFiles){
            //生成空格，方便查看有层次感的目录结构
            space=generateSpace(depth);
            if (f.isDirectory()){
                //如果是目录，那么先打印目录名，然后递归遍历
                System.out.println(space+f.getName()+"/");
                printFilePath(f,depth,filenameFilter);
            }else {
                //如果是文件，直接打印文件名
                System.out.println(space+f.getName());
            }
        }
    }

    /**
     * 后序遍历，返回目录filePath的空间
     * @param filePath 目录名
     * @return 目录所在空间
     */
    public long size(String filePath){
        long totalSize;
        File rootFile=new File(filePath);

        if(rootFile.isDirectory()){
            //如果是目录，那么递归求空间大小
            totalSize=size(rootFile);
        }else {
            //如果是文件，直接返回
            totalSize=rootFile.length();
        }

        return totalSize;
    }

    /**
     * 后序遍历求占用空间大小具体实现
     * @param parentFile 父目录
     * @return 父目录所占空间大小
     */
    public long size(File parentFile){
        long totalSize=0;
        File[] childFiles=parentFile.listFiles();

        //对子目录进行那个遍历
        for (File f:childFiles){
            if (f.isDirectory()){
                //如果是目录，然后递归遍历，大小等于子目录大小相加
                //暂时忽略目录本身说占用的大小
                totalSize+=size(f);
            }else {
                //如果是文件，大小等于加上文件大小的值
                totalSize+=f.length();
            }
        }
        return totalSize;
    }

    /**
     * 产生空格
     * @param spaceNum 产生的空格数量
     * @return 空格字符串
     */
    public String generateSpace(int spaceNum){
        StringBuilder sb=new StringBuilder(" ");
        while (spaceNum>0){
            sb.append(' ');
            spaceNum--;
        }
        return sb.toString();
    }
}
