import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int n = cin.nextInt();
		
		for (int a=1;a<n+1;a++){
			int r = cin.nextInt();
			int[] arr = new int[r+1];
			int max = 0;
			
			for (int b=1;b<=r;b++){
				arr[b] = cin.nextInt();
				int diff = arr[b] - arr[b-1];
				
				if (diff>max){
					max = diff;
				}
			}
			
			int out = max;
			for (int c=1;c<=r;c++){
	            int diff2 = arr[c]-arr[c-1];
	            if (diff2 == max){
	            	max--;
	            }
	            else if (diff2>max) { 
	            	out++; 
	            	break;
	            } 
	        }
			System.out.println("Case "+a+": "+out);
		}
	}
}