import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			int [] alist = new int[n];
			int [] blist = new int[n];
			for (int a=0;a<n;a++){
				alist[a] = 22;
				blist[a] = cin.nextInt();
			}
			String out = "Jolly";
			if (n<=1){
				out = "Jolly";
			} 
			else {
				for (int b=1;b<n;b++){
					int z = Math.abs(blist[b]-blist[b-1]);
					if ((z < n) && (z>0)){
						if(alist[z]!=0){
							alist[z] = 0;
						} else {
							out = "Not jolly";
							break;
						}
					} else{
						out = "Not jolly";
						break;
					}
				}
			}
			System.out.println(out);
		}
	}
}