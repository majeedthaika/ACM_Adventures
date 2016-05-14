import java.util.*;
 
class UnionFind {
	private int[] p, rank;
 
	public UnionFind(int n){
		p = new int[n+1];
		rank = new int[n+1];
		for (int i=0;i<n;i++) p[i] = i;
	}
 
	public int find(int i){
		int x = p[i];
		if (x != i) {
			x = find(x);
			p[i] = x; // path compression
		}
		return x;
	}
 
	public void union(int i, int j){
		int x = find(i);
		int y = find(j);
		if (x != y) {
			int rx = rank[x];
			int ry = rank[y];
			//union by rank
			if (rx>ry) p[y] = x;
			else {
				p[x] = y;
				if (rx == ry) rank[y]++;
			}
		}
	}
}
public class Main {
	static class pr implements Comparable<pr>{
		int n1;
		int n2;
		int sd;
 
		public pr(int n1, int n2, int sd){
			this.n1 = n1;
			this.n2 = n2;
			this.sd = sd;
		}
 
		public int compareTo(pr prev){
			return sd - prev.sd;
		}
	}
 
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
 
		while (cin.hasNextInt()){
 
			int m = cin.nextInt();
			int n = cin.nextInt();
 
			if ((n==0)&&(m==0)) break;
 
			int sum = 0;
			int bsum = 0;
			PriorityQueue<pr> pq = new PriorityQueue<pr>();
 
			for (int a=0;a<n;a++){
				int x = cin.nextInt();
				int y = cin.nextInt();
 
				if ((x==0)&&(y==0)) break;
 
				int z = cin.nextInt();
				bsum += z;
 
				pq.add(new pr(x,y,z));
			}
 
			UnionFind uf = new UnionFind(m);
 
			while (!pq.isEmpty()){
				pr curr = pq.poll();
				if (uf.find(curr.n1)!=uf.find(curr.n2)){
					uf.union(curr.n1, curr.n2);
					sum += curr.sd;
				}
			}
			System.out.println(bsum-sum);
		}
	}
}