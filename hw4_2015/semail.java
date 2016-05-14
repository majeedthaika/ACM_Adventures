import java.util.*;

public class Main {
	static List<pr> graph[];
	static int dist[];
	static int n;
	
	static class pr implements Comparable<pr>{
		int num;
		int sd;
		
		public pr(int num, int sd){
			this.num = num;
			this.sd = sd;
		}
		
		public int compareTo(pr prev){
			return sd - prev.sd;
		}
	}
	
	static void dj(int s, List<pr> graph[]){
		PriorityQueue<pr> pq = new PriorityQueue<pr>();
		
		for (int i=0;i<n+1;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[s] = 0;
		pq.offer(new pr(s, 0));
		while (!pq.isEmpty()) {
			pr curr = pq.poll();
			
			if (curr.sd > dist[curr.num])
				continue;
			else {
				dist[curr.num] = curr.sd;
				
				for (pr linkedn : graph[curr.num]) {
					int new_sd = linkedn.sd + dist[curr.num];

					if (new_sd < dist[linkedn.num]) {
						pq.offer(new pr(linkedn.num, new_sd));
						dist[linkedn.num] = new_sd;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int x = cin.nextInt();
		
		for (int a=0;a<x;a++){
			n = cin.nextInt();
			int m = cin.nextInt();
			int s = cin.nextInt();
			int t = cin.nextInt();
//			System.out.println(n+","+m+","+s+","+t);

			graph = new ArrayList[n+1];
			dist = new int[n+1];
			for (int i=0;i<n+1;i++) {
				graph[i] = new ArrayList<pr>();
			}
			
			for (int b=0;b<m;b++){
				int n1 = cin.nextInt();
				int n2 = cin.nextInt();
				int d = cin.nextInt();
//				System.out.println(n1+","+n2);
				graph[n1].add(new pr(n2, d));
				graph[n2].add(new pr(n1, d));
			}
			
			dj(s,graph);
			
			int out = dist[t];
			if (out!=Integer.MAX_VALUE){
				System.out.println("Case #"+(a+1)+": "+out);
			} else {
				System.out.println("Case #"+(a+1)+": unreachable");
			}
		}
	}
}