import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        long[] arr = new long[(10*10*10*10*10)+1];
        long[] out = new long[(10*10*10*10*10)+1];

        int last = 0;
        for (int i=0;i<n;i++){
        	int curr = cin.nextInt();
        	if (curr>last){
        		last = curr;
        	}
        	arr[curr]++;
        }

        out[0] = 0;
        out[1] = arr[1];
        for (int j=2;j<=last;j++){
        	out[j] = Math.max(out[j-2]+(arr[j]*j), out[j-1]);
        }
        System.out.println(out[last]);
    }
}