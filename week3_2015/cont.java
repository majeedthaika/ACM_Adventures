import java.util.*;

public class Main {
	public static boolean can(int[] arr, int n, int max) {
        int curr = max;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                return false;
            if (arr[i] <= curr)
                curr -= arr[i];
            else {
                curr = max - arr[i];
                count++;
            }
        }
        if (count > n)
            return false;
        return true;
    }
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			int c = cin.nextInt();
			
			int[] arr = new int[n];
			for (int a=0;a<n;a++){
				int b = cin.nextInt();
				arr[a] = b;
			}

			int h = 100000001;
			int l = 1;
			int m = 0;
			int out = 0;
			boolean b;
			while (l<=h) {
                m = (l+h) / 2;
                b = can(arr, c, m);
                if (b) {
                    h = (m-1);
                    out = m;
                } else {
                    l = (m+1);
                }
            }
			System.out.println(out);
		}
	}
}