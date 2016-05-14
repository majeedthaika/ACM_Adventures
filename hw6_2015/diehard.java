import java.util.*;

public class Main {
    static HashMap<int[], Integer> hm;

    public static int dp(int[] dArr, int h, int a, int last){
        if (hm.containsKey(dArr)){
            return hm.get(dArr);
        }
        int res = 0;
        if (last!=0){
            dArr[0]++;
            res = Math.max(dp(dArr,h+3,a+2,0)+1, res);
            dArr[0]--;
        }
        if (last!=1){
            if (((h-5)>0)&&((a-10)>0)){
                dArr[1]++;
                res = Math.max(dp(dArr,h-5,a-10,1)+1, res);
                dArr[1]--;
            }
        }
        if (last!=2){
            if ((h-20)>0){
                dArr[2]++;
                res = Math.max(dp(dArr,h-20,a+5,2)+1, res);
                dArr[2]--;
            }
        }
//        System.out.println(dArr[0]+","+dArr[1]+","+dArr[2]+","+h+","+a);
        hm.put(dArr,res);
        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int t = cin.nextInt();
        cin.nextLine();

        for (int b=0;b<t;b++) {
            int h = cin.nextInt();
            int a = cin.nextInt();

            int out = 0;
            hm = new HashMap<int[], Integer>();

            int[] arr = new int[3];

            arr[0] = 1;
            arr[1] = 0;
            out = Math.max(dp(arr,h+3,a+2,0)+1, out);

            arr[0] = 0;
            arr[1] = 1;
            if (((h-5)>0)&&((a-10)>0)){
                out = Math.max(dp(arr,h-5,a-10,1)+1, out);
            }

            arr[1] = 0;
            arr[2] = 1;
            if ((h-20)>0){
                out = Math.max(dp(arr,h-20,a+5,2)+1, out);
            }

            System.out.println(out);
        }
    }
}