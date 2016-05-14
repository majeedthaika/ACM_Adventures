import java.util.*;

public class Main {
	static class Edge{
		int u;
		int v;
		int w;
		
		Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int t = cin.nextInt();
		for (int a=0;a<t;a++){
			int n = cin.nextInt();
			int m = cin.nextInt();
			
			int[] d = new int[n];
			Arrays.fill(d, 1000000000);
			d[0] = 0;
			
			int[] p = new int[n];
			Arrays.fill(p, -1);

			Edge[] e = new Edge[m];
			
			for (int i=0;i<m;i++){
				int u = cin.nextInt();
				int v = cin.nextInt();
				int w = cin.nextInt();
				e[i] = new Edge(u,v,w);
			}
			
			for(int i=0;i<n-1;i++){ 
				for(int j=0;j < e.length;j++){
					int u = e[j].u;
					int v = e[j].v;
					int w = e[j].w;

					if(d[u] + w < d[v]){
						d[v] = d[u] + w;
						p[v] = u;
					}
				}
			}
			boolean negcycle = false;
			for(int i=0;i < e.length;i++){
				int u = e[i].u;
				int v = e[i].v;
				int w = e[i].w;

				if(d[u] + w < d[v])
					negcycle = true;
			}
			
			if (negcycle){
				System.out.println("possible");
			} else {
				System.out.println("not possible");
			}
		}
	}
}