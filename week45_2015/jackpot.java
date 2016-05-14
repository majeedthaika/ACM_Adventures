import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNextInt()){
			
			int n = cin.nextInt();
			if (n==0){
				break;
			}

			int[] arr = new int[n];
			
			for (int a=0;a<n;a++){
				int curr = cin.nextInt();
				arr[a] = curr;
			}

			int emax = 0;
			int pmax = 0;
			for (int b=0;b<n;b++){
				emax = Math.max(arr[b],(emax+arr[b]));
                pmax = Math.max(pmax, emax);
			}
			if (pmax>0){
				System.out.println("The maximum winning streak is "+pmax+".");
			} else {
				System.out.println("Losing streak.");
			}
		}
	}
}