import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		
		for (int a=1;a<=t;a++){
			cin.nextInt();
			cin.nextLine();
			String line = cin.nextLine();
			
			int n = cin.nextInt();
			
			int idx = 0;
			int ln = line.length();
			String out = "";
			for (int b=0;b<n;b++){
				int c = cin.nextInt();
				idx += c;
				if (idx>=ln){
					idx = idx%ln;
				}
				if (idx<0){
					idx = ln+idx;
				}
//				System.out.println(idx);
				out += line.substring(idx, idx+1);
//				System.out.println(out);
			}
			System.out.println(a+" "+out);
		}
	}
}