package cumt.tj.learn.offer.alibaba;

import java.util.Scanner;

/**
 * Created by sky on 17-8-25.
 */
public class MinBoxes {

    public static class BoxTemplate{
        int price;
        int length;
        int width;
        int height;
    }

    public static class Model{
        int price;
        int length;
        int width;
        int height;
    }

    private static BoxTemplate boxTemplate=new BoxTemplate();
    private static Model[] items;
    private static int boxMinNum;
    private static final int CUSTOMS_LIMIT_MONEY_PER_BOX=1;

    /** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int process()
    {

        //假设最少需要x个箱子
        int x=0;

        //那么x*2000大于等于商品价值总和
        //另外箱子的体积大于所有商品的体积
        //箱子所能装的价值总和
        int maxPrice=0;
        //箱子的体积总和
        int maxVolume=0;
        //商品价值总和
        int priceSum=0;
        //商品的体积总和
        int volumeSum=0;
        for(Model m:items){
            priceSum+=m.price;
            volumeSum+=(m.height*m.width*m.length);
        }

        //因为用户最多买10个商品，最多需要10个箱子
        int preBoxVolume=boxTemplate.length*boxTemplate.height*boxTemplate.width;
        for(int i=1;i<=10;i++){

            maxPrice=i*2000;
            maxVolume=i*preBoxVolume;

            if(maxPrice>priceSum && maxVolume>volumeSum){
                //当体积和价格都满足需求的时候，认为是最小箱子数
                x=i;
                break;
            }

        }

        return x;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());

        }
    }
}
