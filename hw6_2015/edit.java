import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int t = cin.nextInt();
		cin.nextLine();
		
		for (int a=0;a<t;a++){
			String s1 = cin.nextLine();
			String s2 = cin.nextLine();
			
			int[][] arr = new int[s1.length()+1][s2.length()+1];

			for (int b=0;b<=s1.length();b++) arr[b][0] = b;
			for (int b=0;b<=s2.length();b++) arr[0][b] = b;
			
			int  z = 0;
			for (int b=1;b<=s1.length();b++){
				for (int c=1;c<=s2.length();c++){
					if (s1.substring(b-1, b).equals(s2.substring(c-1, c))) z=0;
					else z=1;
					
					arr[b][c] = Math.min((z+arr[b-1][c-1]), Math.min(1+arr[b-1][c],1+arr[b][c-1]));
				}
			}
			
			System.out.println(arr[s1.length()][s2.length()]);
		}
	}
}