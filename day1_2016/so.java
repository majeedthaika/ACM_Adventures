import java.util.*;

public class Main {
    static void nextPermutation(int[] num) {
        int i = 0;
        int j = 0;
        //From right to left, find the first one that is not in ascending order.
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i] >= num[i + 1])
                continue;
            //From right to left, find the first one that is larger than num[i]
            for (j = num.length - 1; j > i; j--) {
                if (num[j] > num[i])
                    break;
            }
            break;
        }
        //If we find i, swap the number on position i and j
        if (i >= 0) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
        //Reverse the numbers which are on the right of i
        int start = i + 1;
        int end = num.length - 1;
        while (start < end) {
            int tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int a=1;a<=t;a++){
        	int n = cin.nextInt();
        	String bin = Integer.toBinaryString(n);
        	int len = bin.length();
        	int res = 0;
        	if (n!=0){
            	int[] digits = new int[len];
            	for (int i=0;i<len;i++){
                    digits[i] = Integer.parseInt(bin.substring(i,i+1));
                }
            	nextPermutation(digits);
            	String out = "";
                for(int num: digits)
                    out += num;
                res = Integer.parseInt(out,2);
            	if(res<=n) {
                	int c = Integer.bitCount(n)-1;
                	String ones = new String(new char[c]).replace("\0", "1");
                	String zeros = new String(new char[len-c]).replace("\0", "0");
                	res = Integer.parseInt("1"+zeros+ones,2);
                }
            }
            System.out.println("Case "+a+": "+res);
        }
    }
}