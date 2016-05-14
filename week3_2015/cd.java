import java.util.*;

class Main {
	static class Comb{
		int tot;
		ArrayList<Integer> ar;
		
		public Comb(int tot, ArrayList<Integer> ar){
			this.tot = tot;
			this.ar = ar;
		}
	}
	public static void main(String args[])  {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			int t = cin.nextInt();
			ArrayList<Comb> sum = new ArrayList<Comb>();
			
			for (int a=0;a<t;a++){
				int curr = cin.nextInt();
				if (curr<=n){
					int szt = sum.size();
					for (int b=0;b<szt;b++){
						Comb th = sum.get(b);
						int test = th.tot+curr;
						if (test<=n){
							ArrayList<Integer> toAdd2 = new ArrayList<Integer>();
							for (int item : th.ar){
								toAdd2.add(item);
							}
							toAdd2.add(curr);
							sum.add(new Comb(test,toAdd2));
						}
					}
					ArrayList<Integer> toAdd = new ArrayList<Integer>();
					toAdd.add(curr);
					sum.add(new Comb(curr,toAdd));
				}
				
			}
			int maxIdx = 0;
			int maxtot = 0;
			int ml = 0;
			int sz = sum.size();
			for (int c=0;c<sz;c++){
				Comb ti = sum.get(c);
				int tti = ti.tot;
				if (tti>maxtot){
					maxtot = tti;
					maxIdx = c;
					ml = ti.ar.size();
				}
				if (tti==maxtot){
					int tsz = ti.ar.size();
					if (tsz>ml){
						maxtot = tti;
						maxIdx = c;
						ml = tsz;
					}
				}
			}
			String out = "";
			ArrayList<Integer> max = sum.get(maxIdx).ar;
			int szm = max.size();
			for (int d=0;d<szm;d++){
				out += max.get(d);
				out += " ";
			}
			out += "sum:";
			out += maxtot;
			System.out.println(out);
		}
	}
}