package cumt.tj.learn.offer;

/**
 * Created by sky on 17-10-9.
 */
public class LongestSubstring {
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        int maxLen=0;
        int tmpLen=0;
        int tmpI;
        int tmpJ;

        // write code here
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.charAt(i)==B.charAt(j)){
                    tmpLen=1;
                    tmpI=i;
                    tmpJ=j;
                    while (true){

                        if(tmpI>=n-1 || tmpJ>=m-1){
                            break;
                        }

                        if(A.charAt(++tmpI)==B.charAt(++tmpJ)) {
                            tmpLen++;
                        }else{
                            break;
                        }

                    }
                    if(tmpLen>maxLen) maxLen=tmpLen;
                }
            }
        }

        return maxLen;
    }
}
