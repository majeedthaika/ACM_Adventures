import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int n = cin.nextInt();
		for (int i=0;i<n;i++) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			int c = cin.nextInt();
			
			int fx = 10001;
			int fy = 10001;
			int fz = 10001;
			for (int x=-100;x<=100;x++)
				for (int y=-100;y<=100;y++) {
					int z = (a-x)-y;
					if ((x==y)||(x==z)||(y==z)){
						continue;
					}
					if (((x*y*z)==b)&&(((x*x)+(y*y)+(z*z))==c)){
						if (x < fx) {
							fx = x;
							fy = y;
							fz = z;
						} else if ((x==fx)&&(y<fy)) {
							fx = x;
							fy = y;
							fz = z;
						} else if ((x==fx)&&(y==fy)&&(z<fz)) {
							fx = x;
							fy = y;
							fz = z;
						}
					}
				}
			if (fx==10001){
				System.out.println("No solution.");
			} else {
				System.out.println(fx+" "+fy+" "+fz);
			}
		}
	}
}