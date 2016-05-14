import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		BigDecimal n = cin.nextBigDecimal();
		BigDecimal m = cin.nextBigDecimal();
		BigDecimal a = cin.nextBigDecimal();

		BigDecimal s1 = (n.divide(a,0,BigDecimal.ROUND_CEILING));
		BigDecimal s2 = (m.divide(a,0,BigDecimal.ROUND_CEILING));
		
		BigDecimal out = (s1.multiply(s2));
		System.out.println(out.toBigIntegerExact());
    }
}