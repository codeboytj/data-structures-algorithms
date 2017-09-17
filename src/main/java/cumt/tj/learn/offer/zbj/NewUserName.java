package cumt.tj.learn.offer.zbj;

import java.util.*;

/**
 * Created by sky on 17-9-15.
 */
public class NewUserName {

    public static Map<String,Integer> maxNum=new HashMap<String, Integer>();
    public static List<String> originName=new ArrayList<String>();


    public static void getName(){

        Integer max;
        for(String name:originName) {
            max = maxNum.get(name);

            if (max == null) {
                //还没有
//                nameList.add("OK");
                System.out.println("OK");
                max = 0;
            } else {
//                nameList.add(name + (++max));
                System.out.println(name + (++max));
            }

            maxNum.put(name, max);
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n;

        while(sc.hasNextInt()){
            n=Integer.valueOf(sc.nextLine());
            for(int i=0;i<n;i++){
                originName.add(sc.nextLine());
//                getName(sc.nextLine());
            }
        }
        sc.close();

        getName();
//
//        for(String s:nameList){
//            System.out.println(s);
//        }

    }

}
//
//    public static Map<String,Integer> maxNum=new HashMap<String, Integer>();
//    public static List<String> nameList=new ArrayList<String>();
//
//
//    public static void getName(String name){
//
//        Integer max=maxNum.get(name);
//
//        if(max==null){
//            //还没有
//            nameList.add("OK");
//            max=0;
//        }else{
//            nameList.add(name+(++max));
//        }
//
//        maxNum.put(name,max);
//
//    }
//
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//        int n;
//        String[] names;
//
//        while(sc.hasNextInt()){
//            n=Integer.valueOf(sc.nextLine());
////            names=new String[n];
//            for(int i=0;i<n;i++){
//                getName(sc.nextLine());
//            }
//        }
//
//        for(String s:nameList){
//            System.out.println(s);
//        }
//
//    }

