import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int a = cin.nextInt();
		int count=0;
		for (int i=1;i<=a;i++) {
			int temp=0;
			for (int j=i;;j++) {
				if (temp == a) {
					count = count + 1;
					break;
				}

				if (temp>=a){
					break;
				} else {
					temp = temp + j;
				}
			}
		}
		System.out.println(count);
	}
}