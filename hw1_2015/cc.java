import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		for (int i=1;i<=n;i++){
			int a = cin.nextInt();
			int b = cin.nextInt();
			int c = cin.nextInt();
			
			int out;
			if (((a-b)*(c-a))>=0) out = a;
			else if (((b-a)*(c-b))>=0) out = b;
			else out = c;
			
			System.out.println("Case "+i+": " + out);
		}
	}
}