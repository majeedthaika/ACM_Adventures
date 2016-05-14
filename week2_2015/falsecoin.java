import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int m = cin.nextInt();
		
		for (int a=0;a<m;a++){
			int n = cin.nextInt();
			int k = cin.nextInt();

			Deque<Integer> leftq = new ArrayDeque<Integer>();
			Deque<Integer> rightq = new ArrayDeque<Integer>();
			
			int[] ncoins = new int[n+1];
			
			for (int b=0;b<k;b++){
				int p = cin.nextInt();
				for (int c=0;c<p;c++){
					leftq.push(cin.nextInt());
				}
				for (int d=0;d<p;d++){
					rightq.push(cin.nextInt());
				}
				char sym = cin.next().charAt(0);
				
				if (sym == '='){
					while (leftq.isEmpty()!=true){
						ncoins[leftq.pop()] = -999;
					}
					while (rightq.isEmpty()!=true){
						ncoins[rightq.pop()] = -999;
					}
				} else {
					while (leftq.isEmpty()!=true){
						ncoins[leftq.pop()]++;
					}
					while (rightq.isEmpty()!=true){
						ncoins[rightq.pop()]++;
					}
				}
			}
			int maxcount = -1;
			int idx = 0;
			boolean single = false;
			for (int e=1;e<ncoins.length;e++){
				int curr = ncoins[e];
				if (curr>maxcount){
					maxcount = curr;
					idx = e;
					single = true;
				} else if (curr==maxcount){
					single = false;
				}
			}
			if (single == true) {
				System.out.println(idx);
			} else {
				System.out.println(0);
			}
			if (a<(m-1)){
				System.out.println("");
			}
		}
	}
}