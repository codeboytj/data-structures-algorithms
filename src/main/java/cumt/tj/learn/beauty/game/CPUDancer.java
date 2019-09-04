package cumt.tj.learn.beauty.game;

/**
 * Created by sky on 17-6-25.
 * 编程之美第一章，让cpu占用率曲线听你指挥
 */
public class CPUDancer {

    /**
     * 让CPU占用率固定为50%，为一条直线
     * @throws InterruptedException
     */
    public void half() throws InterruptedException {
        usageBySelf(0.5);
    }

    /**
     * 让CPU的占用率为一条直线，具体占用率由命令行参数决定
     * @param usage [0~1]之间的数，表示要实现的cpu占用率
     * @throws InterruptedException
     */
    public void usageBySelf(double usage) throws InterruptedException {
        long busyTime=100;
        long idleTime= (long) (busyTime/usage-busyTime);
        long startTime=0;
        while (true){
            startTime=System.currentTimeMillis();
            while ((System.currentTimeMillis()-startTime)<=busyTime);
            Thread.sleep(idleTime);
        }

    }

    /**
     * 让cpu占用率状态变成一条正弦曲线
     * @throws InterruptedException
     */
    public void danceLikeSine() throws InterruptedException {
        //将2pi分为200个点
        int count=200;
        double spilt=0.01;
        int totalTime=100;
        double radian=0.0;

        long[] busyTime=new long[count];
        long[] idleTime=new long[count];

        int half=totalTime/2;
        for (int i=0;i<count;i++){
            busyTime[i]=(long)(half+half*Math.sin(Math.PI*radian));
            idleTime[i]=totalTime-busyTime[i];
            radian+=spilt;
        }

        long startTime=0;
        int j=0;
        while (true){
            j=j%count;
            startTime=System.currentTimeMillis();
            while ((System.currentTimeMillis()-startTime)<=busyTime[j]);
            Thread.sleep(idleTime[j]);
            j++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CPUDancer cpuDancer=new CPUDancer();
//        cpuDancer.half();
//        cpuDancer.usageBySelf(0.3);
        cpuDancer.danceLikeSine();
    }
}
