import java.util.*;

public class Main {
	static class pair{
		int comb;
		int lvl;
		
		public pair(int comb, int lvl){
			this.comb = comb;
			this.lvl = lvl;
		}
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		int c = 1;
		while (cin.hasNextInt()){
			int l = cin.nextInt();
			int u = cin.nextInt();
			int r = cin.nextInt();
//			System.out.println(l+","+u+","+r);
			
			if ((l==0)&&(u==0)&&(r==0)){
				break;
			}

			Deque<pair> q = new ArrayDeque<pair>();
			HashSet<Integer> t = new HashSet<Integer>();
			q.offer(new pair(l,0));
			int[] buttons = new int[11];
			int out = -1;
			
			for (int i=1;i<r+1;i++){
				buttons[i] = cin.nextInt();
			}
			
			while (!q.isEmpty()){
				if (q.peek().lvl<10000){
					pair curr = q.poll();
					for (int j=1;j<r+1;j++){
						int added = curr.comb + buttons[j];
//						System.out.println(added);
						if (added>9999){
							added -= 10000;
						}
						if (u==added){
							out = curr.lvl+1;
							break;
						} else {
							if (!t.contains(added)){
								q.offer(new pair(added,curr.lvl+1));
								t.add(added);
							}
						}
					}
					if (out!=-1) break;
				} else {
					break;
				}
			}
			if (out!=-1){
				System.out.println("Case "+c+": "+out);
			} else {
				System.out.println("Case "+c+": Permanently Locked");
			}
			c++;
		}
	}
}