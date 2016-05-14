import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		
		for (int a=1;a<=t;a++){
			
			boolean[] arr = new boolean[10];
			cin.nextInt();
			cin.nextInt();
			int prev = 0;
			int total = 0;
			for (int b=0;b<14;b++){
				int curr = cin.nextInt();
				if (curr!=prev){
//					System.out.println(curr+1+" "+arr[curr+1]);
					if (arr[curr+1]){
						arr[curr+1] = false;
						total++;
					} else {
						arr[curr] = true;
					}
					prev = curr;
				}
			}
			System.out.println(a+" "+total);
		}
	}
}