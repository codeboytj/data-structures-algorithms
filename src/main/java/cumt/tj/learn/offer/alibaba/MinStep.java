package cumt.tj.learn.offer.alibaba;

/**
 * Created by sky on 17-7-25.
 * 题目：给定一个数组，里面全是正整数。数字大小表示这一步最多可以向后移动几个节点。总是从数组第一个元素开始移动。问如何移动，可以以最少步数移动到最后一个节点。
 * 例如：[3,4,2,1,3,1]初始状态指向3表示下一步可以移动1格，或者2格，或者3格。
 * 最优的方式是指向3的时候移动一步，第二次选择移动4步，一共只需要两步即可移动到数组尾。
 */
public class MinStep {

    public static int minStep(int[] array){

        int minStepCount=0;

        minStepCount=minStep(array,0,minStepCount);

        return minStepCount;

    }

    public static int minStep(int[] array,int startPos,int stepCount){

        //数组大小
        int length=array.length;

//        if(startPos>=length){
//            return ++stepCount;
//        }

        if(array[startPos]>=length-1-startPos){
            //当前元素就能到达最后一个节点，那么直接返回
            return ++stepCount;
        }else{
            //否则，查找所有能到节点能到达末尾的最小步数
            int minSteps=length;
            int candidate;
            for(int i=startPos+1;i<=startPos+array[startPos];i++){
                candidate=minStep(array,i,0);
                if(minSteps>candidate) minSteps=candidate;
            }
            //然后，2个东西相加就是最小步数
            return ++stepCount+minSteps;
        }

    }

}
