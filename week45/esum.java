import java.util.*;

class Main {
	public static void main(String args[])  {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			cin.nextLine();
			String[] line = cin.nextLine().split(" ");
			int t = cin.nextInt();
			
			int[] arr = new int[n];
			int e = 0;
			int md = 1000001; 
			
			for (int a=0;a<n;a++){
				int curr = Integer.parseInt(line[a]);
				if (curr!=t){
				    arr[a] = curr;
    				for (int b=0;b<a;b++){
    					int added = curr+arr[b];
    					if (added == t){
    					    int diff = Math.abs(curr-arr[b]);
    					    if (diff<md){
    					        e = curr;
    					        md = diff;
    					    }
    					}
    				}
				}
			}
			int f = t-e;
			if (e<f){
			    System.out.println("Peter should buy books whose prices are "+e+" and "+f+".");
			} else {
			    System.out.println("Peter should buy books whose prices are "+f+" and "+e+".");
			}
			System.out.println();
		}    
	}
}