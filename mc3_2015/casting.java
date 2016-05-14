import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		
		for (int a=1;a<=t;a++){
			cin.nextInt();
			int n = cin.nextInt();
			String num = cin.nextLine();
			int len = num.length();
			int val = 0;
			for (int b=1;b<len;b++){
				int curr = Integer.parseInt(num.substring(b, b+1));
				val = (val+curr)%(n-1);
			}
			System.out.println(a+" "+val%(n-1));
		}
	}
}