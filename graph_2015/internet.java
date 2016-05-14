import java.util.*;

public class Main {
//	static int[][] arr;
//	static int sum;
//	static int t;
//	static int n;
	
//	static void dfs(int u, int min, boolean[] dfs_num){
//		for (int j=u;j<n+1;j++){
//			if (u==j) continue;
//			int v = arr[u][j];
//			if ((v!=0)&&(dfs_num[j]==false)){
//				System.out.println(j);
//				int nmin = min;
//				if (v<nmin){
//					nmin = v;
//				}
//				if (j==t){
////					System.out.println(sum);
//					sum += nmin;
//					return;
//				}
//				dfs_num[j] = true;
//				dfs(j, nmin, dfs_num);
//				dfs_num[j] = false;
//			}
//		}
//	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int cs = 1;
		
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			if (n==0) break;
			int s = cin.nextInt();
			int t = cin.nextInt();
			int c = cin.nextInt();
			int[][] arr = new int[n+1][n+1];
			int[] parent = new int[n+1];
            int[] cost = new int[n+1];
//			boolean[] dfs_num = new boolean[102];
//			Arrays.fill(dfs_num, false);
//			sum = 0;
			
			for (int a=0;a<c;a++){
                int p1 = cin.nextInt();
                int p2 = cin.nextInt();
                int d = cin.nextInt();

                arr[p1][p2] += d;
				arr[p2][p1] += d;
            }
			
//			dfs(s, 1000000, dfs_num);

			cost[s] = Integer.MAX_VALUE;
            parent[s] = s;
            boolean done = false;
            int maxflow = 0;
			while (!done) {
                done = true;
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(s);
                boolean[] vis = new boolean[arr.length];
                vis[s] = true;
                while (!q.isEmpty()) {
                    int z = q.poll();
                    if (z == t) {
                        done = false;
                        break;
                    }
                    for (int i=0;i<arr.length;i++){
                        if (arr[z][i] > 0 && !vis[i]) {
                            parent[i] = z;
                            cost[i] = Math.min(cost[z], arr[z][i]);
                            vis[i] = true;
                            q.add(i);
                        }
                    }
                }
                if (!done) {
                    maxflow += cost[t];
                    int z = t;
                    while (parent[z] != z) {
                        arr[parent[z]][z] -= cost[t];
                        arr[z][parent[z]] += cost[t];
                        z = parent[z];
                    }
                }
            }


			System.out.println("Network "+cs);
			System.out.println("The bandwidth is "+maxflow+".\n");
			cs++;
		}
	}
}