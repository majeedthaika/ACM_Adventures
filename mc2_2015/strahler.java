import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int t = cin.nextInt();
		
		for (int a=1;a<=t;a++){
			cin.nextInt();
			int m = cin.nextInt();
			int p = cin.nextInt();

			int[] arr = new int[m+1];
			boolean[] dn = new boolean[m+1];
			Arrays.fill(arr, 1);
			int[] rem = new int[m+1];
			ArrayList<Queue<Integer>> link = new ArrayList<Queue<Integer>>();
			int[][] linkd = new int[m+1][m+1];
			
			for (int b=1;b<=m+1;b++){
				link.add(new LinkedList<Integer>());
			}
			
			for (int b=0;b<p;b++){
				int x = cin.nextInt();
				int y = cin.nextInt();
				
				link.get(x).add(y);
				rem[y]++;
			}
			
			boolean done = false;
			while (!done){
				int curr = 0;
				for (int b=1;b<=m;b++){
					if ((rem[b]==0)&&(!dn[b])){
						curr = b;
						break;
					}
				}
//				System.out.println("y"+curr);
				if (curr==0){
					done = true;
				}
				Queue<Integer> cq = link.get(curr);
				
				while (!cq.isEmpty()){
					int cn = cq.poll();
					
					int c = arr[curr];
					int d = linkd[cn][c];
					int c2;
					if (d>0){
						c2 = c+1;
					} else {
						c2 = c;
					}
					if (c2>arr[cn]){
						arr[cn] = c2;
					}
					linkd[cn][c]++;
					rem[cn]--;
				}
				dn[curr] = true;
			}
//			for (int b=1;b<=m;b++){
//				System.out.println(b+" "+arr[b]);
//			}
			System.out.println(a+" "+arr[m]);
		}
	}
}