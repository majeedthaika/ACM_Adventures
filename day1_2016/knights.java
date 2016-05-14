import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int a=1;a<=t;a++){
        	String[] arr = br.readLine().split(" ");
        	int n = Integer.parseInt(arr[0]);
        	int m = Integer.parseInt(arr[1]);
        	if ((n==1)||(m==1)){
        		System.out.println("Case "+a+": "+(m*n));
        	} else if ((n==2)||(m==2)) {
        		int modk = Math.max(m,n)%4;
        		int k = Math.max(m,n)-modk;
        		if (modk==0){
        			System.out.println("Case "+a+": "+k);
        		}else if (modk==1){
        			System.out.println("Case "+a+": "+(k+2));
        		} else {
        			System.out.println("Case "+a+": "+(k+4));
        		}
        	} else {
        		System.out.println("Case "+a+": "+((m*n)+1)/2);
        	}
        }
    }
}