import java.util.*;

class Main {
	static class cmp implements Comparator<frac>{
		public int compare(frac one, frac two){
			return two.x - one.x;
		}
	}
	static class frac{
		int x;
		int y;
		
		public frac(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[])  {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()){
			
			int n = cin.nextInt();
			cmp fcmp = new cmp();
			PriorityQueue<frac> fracs = new PriorityQueue<frac>(10,fcmp);
			
			for (int i=(n+1);i<=2*n;++i) {
				int t = i*n;
				int r = i-n;
				if ((t%r)==0){
					int x = t/r;
					fracs.add(new frac(x,i));
				}
			}
			
			int sz = fracs.size();
			System.out.println(sz);
			while (sz>0){
				frac curr = fracs.poll();
				System.out.println("1/"+n+" = "+"1/"+curr.x+" + "+"1/"+curr.y);
				sz--;
			}
		}
	}
}