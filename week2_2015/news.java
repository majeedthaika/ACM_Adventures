import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(cin.readLine());
		for (int a=0;a<n;a++){
			HashMap<Character,Integer> val = new HashMap<Character,Integer>();
			HashMap<Character,Integer> total = new HashMap<Character,Integer>();
			int k = Integer.parseInt(cin.readLine());
			for (int b=0;b<k;b++){
				String cline = cin.readLine();
				char c = cline.charAt(0);
				int y = Integer.parseInt(cline.substring(2));
				total.put(c, y);
				val.put(c, 0);
			}
			int m = Integer.parseInt(cin.readLine());
			for (int d=0;d<m;d++){
				String line = cin.readLine();
				for (int e=0;e<line.length();e++){
					char f = line.charAt(e);
					if (val.containsKey(f)){
						int count = val.get(f);
						val.put(f, count + 1);
					}
				}
			}
			Double tot = 0.0;
			for (Map.Entry<Character, Integer> entry : total.entrySet()) {
			    Character key = entry.getKey();
			    tot += (entry.getValue()*val.get(key));
			}
			tot = tot/100;
			System.out.println(String.format("%.2f", tot)+"$");
		}
	}
}