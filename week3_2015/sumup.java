import java.util.*;

class Main {
	static class Ccmp implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> one, ArrayList<Integer> two) {
			int s1 = one.size();
			int s2 = two.size();
			
			int idx = 0;
			while ((idx<s1)&&(idx<s2)){
				int a = two.get(idx);
				int b = one.get(idx);
				if (a!=b){
					return a - b;
				}
				idx++;
			}
			return s1-s2;
		}
	}
	static class Comb {
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
			int t = cin.nextInt();
			int n = cin.nextInt();
			if (n==0){
				break;
			}
			ArrayList<Comb> sum = new ArrayList<Comb>();
			TreeSet<ArrayList<Integer>> uni = new TreeSet<ArrayList<Integer>>(new Ccmp());
			System.out.println("Sums of "+t+":");
			boolean none = true;
			for (int a=0;a<n;a++){
				int curr = cin.nextInt();
				if (curr<=t){
					int szt = sum.size();
					for (int b=0;b<szt;b++){
						Comb th = sum.get(b);
						int test = th.tot+curr;
						if (test<=t){
							ArrayList<Integer> toAdd2 = new ArrayList<Integer>();
							for (int item : th.ar){
								toAdd2.add(item);
							}
							toAdd2.add(curr);
							sum.add(new Comb(test,toAdd2));
							if (test==t){
								uni.add(toAdd2);
								none = false;
							}
						}
					}
					ArrayList<Integer> toAdd = new ArrayList<Integer>();
					toAdd.add(curr);
					if (curr==t){
						uni.add(toAdd);
						none = false;
					}
					sum.add(new Comb(curr,toAdd));
				}
			}
			if (none){
				System.out.println("NONE");
			} else {
				int sza = uni.size();
				for (ArrayList<Integer> arrs:uni){
					String out = "";
					boolean first = true;
					for (Integer i: arrs){
						if (!first){
							out += "+";
						} else {
							first = false;
						}
						out += i;
					}
					System.out.println(out);
				}
			}
		}
	}
}