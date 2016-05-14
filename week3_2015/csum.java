import java.util.*;

class Main {
	public static void main(String args[])  {
		Scanner cin = new Scanner(System.in);
		int count = 1;
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			if (n==0){
				break;
			}
			int[] arr = new int[n];
			TreeSet<Integer> sum = new TreeSet<Integer>();
			
			for (int a=0;a<n;a++){
				int curr = cin.nextInt();
				arr[a] = curr;
				
				for (int b=0;b<a;b++){
					if (b!=curr){
						int added = curr+arr[b];
						sum.add(added);
					}
				}
			}
			
			int m = cin.nextInt();
			System.out.println("Case "+count+":");
			for (int c=0;c<m;c++){
				int z = cin.nextInt();
				if (sum.contains(z)){
					System.out.println("Closest sum to "+z+" is "+z+".");
				} else {
					Integer above = sum.higher(z);
					Integer below = sum.lower(z);
					int da, db;
					if (above!=null) {
						da = Math.abs(z-above);
					} else {
						da = Integer.MAX_VALUE;
					}
					if (below!=null) {
						db = Math.abs(z-below);
					} else {
						db = Integer.MAX_VALUE;
					}
					
					if (da>db) {
						System.out.println("Closest sum to "+z+" is "+below+".");
					} else {
						System.out.println("Closest sum to "+z+" is "+above+".");
					}
				}
			}
			count++;
		}
	}
}