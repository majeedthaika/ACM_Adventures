import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int a=1;a<=t;a++){
        	int x1 = 0;
        	int y1 = 0;
        	int z1 = 0;
        	int x2 = 1000;
        	int y2 = 1000;
        	int z2 = 1000;
        	
        	int n = cin.nextInt();
        	for (int b=0;b<n;b++){
        		x1 = Math.max(x1, cin.nextInt());
        		y1 = Math.max(y1, cin.nextInt());
        		z1 = Math.max(z1, cin.nextInt());
        		
        		x2 = Math.min(x2, cin.nextInt());
        		y2 = Math.min(y2, cin.nextInt());
        		z2 = Math.min(z2, cin.nextInt());
        	}
        	if((x2>x1)&&(y2>y1)&&(z2>z1))  
                System.out.println("Case "+a+": "+(x2-x1)*(y2-y1)*(z2-z1));  
            else  
            	System.out.println("Case "+a+": "+"0");
        }
    }
}