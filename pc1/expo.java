import java.util.*;
import java.math.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			BigDecimal r = cin.nextBigDecimal();
			int n = cin.nextInt();
			String out = r.pow(n).stripTrailingZeros().toPlainString();
			out = out.replaceAll("^0+","");
			System.out.println(out);
		}
	}
}