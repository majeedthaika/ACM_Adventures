import java.util.*;

class Main {
	static class Pair {
	    int count;
	    int index;

	    public Pair(int count, int index){
	        this.count = count;
	        this.index = index;
	    }
	}
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		cin.nextInt();
		int rlen = cin.nextInt();

		List<String> rows = new ArrayList<String>();
		List<String> orows = new ArrayList<String>();
		List<Pair> srows = new ArrayList<Pair>();
		
		char c;
		int count;
		int z;
		
		cin.nextLine();
		for (int i = 0; i < rlen; i++) {
			String s = cin.nextLine();
	        rows.add(s);
	        count = 0;
	        for (int d = 0; d < s.length(); d++) {
				c = s.charAt(d);
				if (c == 'C'){
					for (z = d; z < s.length(); z++) {
						if (s.charAt(z) == 'A'){
							count += 1;
						}
					}
				}
				if (c == 'G'){
					for (z = d; z < s.length(); z++) {
						if (s.charAt(z) == 'A'){
							count += 1;
						}
						if (s.charAt(z) == 'C'){
							count += 1;
						}
					}
				}
				if (c == 'T'){
					for (z = d; z < s.length(); z++) {
						if (s.charAt(z) == 'A'){
							count += 1;
						}
						if (s.charAt(z) == 'C'){
							count += 1;
						}
						if (s.charAt(z) == 'G'){
							count += 1;
						}
					}
				}
			}
	        srows.add(new Pair(count, i));
	    }
		
		int prevMin = -1;
		int currMin = 999999;
		int r = -1;
		for (int t = 0; t < rlen; t++) {
			for (int v = 0; v < rlen; v++) {
				Pair cv = srows.get(v);
				int cc = cv.count;
				int ci = cv.index;
				if (cc < currMin) {
					if (cc > prevMin){
						currMin = cc;
						r = ci;
					}
				}
				if (cc==currMin) {
					if (v > r) {
						if (cc > prevMin) {
							orows.add(rows.get(r));
							r = ci;
						}
					}
				}
			}
			orows.add(rows.get(r));
			prevMin = currMin;
			currMin = 999999;
		}
		
		for (int o = 0; o < rlen; o++) {
			System.out.println(orows.get(o));
		}
	}
}