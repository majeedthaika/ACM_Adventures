import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextLine()){
			int n = cin.nextInt();
			int m = cin.nextInt();
			
			if ((n==0)&&(m==0)){
				break;
			}
			
			boolean conf = false;
			BitSet range = new BitSet(1000000);
			
			for (int a=0;a<n;a++){
				int start = cin.nextInt();
				int end = cin.nextInt();
				if (conf==false){
					for (int c=start;c<end;c++){
						boolean curr = range.get(c);
						if (curr==false){
							range.set(c);
						} else {
							conf = true;
							break;
						}
					}
				}
			}
			
			for (int b=0;b<m;b++){
				int x = cin.nextInt();
				int y = cin.nextInt();
				int z = cin.nextInt();
				if (conf==false){
					while (y<1000001){
						for (int d=x;d<y;d++){
							boolean curr = range.get(d);
							if (curr==false){
								range.set(d);
							} else {
								conf = true;
								break;
							}
						}
						if (conf==true){
							break;
						}
						x+=z;
						y+=z;
					}
				}
			}
			if (conf==true){
				System.out.println("CONFLICT");
			} else {
				System.out.println("NO CONFLICT");
			}
		}
	}
}