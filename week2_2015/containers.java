import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int cs = 1;
		while (cin.hasNextLine()){
			String line = cin.nextLine();
			if (line.contains("end")){
				break;
			}
			
			char[] stk = new char[27];
			
			int size = line.length();
			
			for (int a=0;a<size;a++){
				char curr = line.charAt(a);
				
				for (int b=0;b<26;b++){
					if ((stk[b]>'Z')||(stk[b]<'A')){
						stk[b] = curr;
						break;
					}
					if ((curr < stk[b])&&(curr>='A')){
						stk[b] = curr;
						break;
					}
					if (curr == stk[b]){
						break;
					}
				}
			}
			
			int n = 0;
			for (int c=0;c<27;c++){
				if ((stk[c]>'Z')||(stk[c]<'A')){
					n = c;
					break;
				}
			}
			
			System.out.println("Case " + cs + ": " + n);
			cs++;
		}
	}
}