import java.math.*;
import java.util.*;

public class Main {
	static HashMap<String,String> hm;
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		hm = new HashMap<String,String>();
		
		hm.put("2", "2");
		hm.put("3", "3");
		hm.put("4", "322");
		hm.put("5", "5");
		hm.put("6", "53");
		hm.put("7", "7");
		hm.put("8", "7222");
		hm.put("9", "7332");

		int n = cin.nextInt();
		cin.nextLine();
		String x = cin.nextLine();
		
		BigInteger f = BigInteger.ONE;
		int[] arr = new int[10];
		Arrays.fill(arr, 0);
		for (int i=0;i<n;i++){
			if (!x.substring(i,i+1).equals("1")){
				if (!x.substring(i,i+1).equals("0")){
					String s = hm.get(x.substring(i,i+1));
					for (int a=0;a<s.length();a++){
						int z = Integer.parseInt(s.substring(a, a+1));
						if (z>1){
							arr[z] += 1;
						}
					}
				}
			}
		}

		String out = "";
		for (int b=9;b>1;b--){
			for (int c=0;c<arr[b];c++){
				out += String.valueOf(b);
			}
		}
		System.out.println(out);
    }
}