import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		
		for (int a=1;a<=t;a++){
			cin.nextInt();
			int m = cin.nextInt();
			
			if(m == 2){
				System.out.println(a+" "+3);
			} else {
				int nSeq = 2;
				int f1 = 1;
				int f2 = 1;
				for(;; nSeq += 2){
					f1 = (f1 + f2) % m;
					f2 = (f2 + f1) % m;
					if(f1 == 1 && f2 == 1){
						break;
					}
				}
				System.out.println(a+" "+nSeq);
			}
		}
	}
}