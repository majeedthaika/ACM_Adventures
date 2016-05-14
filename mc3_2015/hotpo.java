import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		
		for (int a=1;a<=t;a++){
			cin.nextInt();
			int n = cin.nextInt();
			int out = n;
			while (n!=1){
				if ((n%2)==0){
					n=n/2;
				}else{
					n*=3;
					n++;
				}
				if (out<n) out = n;
			}
			System.out.println(a+" "+out);
		}
	}
}