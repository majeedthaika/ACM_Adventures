import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()){
			int sz = cin.nextInt();
			int p = cin.nextInt();
			
			if ((sz==0)&&(p==0)){
				break;
			}
			
			int x = (sz/2)+1;
			int y = x;
			
			for (int a=1;;a+=2){
				int b = a*a;
				if (p<=b){
					if (p==b){
						break;
					}
					int q = a-1;
					if (p>((b-1)-q)){
						y -= (b-p);
						break;
					}
					if (p>((b-1)-q-q)){
						y -= q;
						x -= (b-q)-p;
						break;
					}
					if (p>((b-1)-q-q-q)){
						y += (b-p-q-q-q);
						x -= q;
						break;
					}
					x-=p-((q-1)*(q-1));
					break;
				}
				x++;
				y++;
			}
			System.out.println("Line = "+y+", column = "+x+".");
		}
	}
}