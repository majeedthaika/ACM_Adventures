import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
    	cin.nextLine();
        for (int a=1;a<=t;a++){
        	String[] arr = new String[100];
        	String cmd = cin.nextLine();
        	
        	System.out.println("Case "+a+":");
        	int idx = 0;
        	Arrays.fill(arr, idx, 100,"");
        	arr[0] = "http://www.lightoj.com/";
        	while (!cmd.substring(0,4).equals("QUIT")){
        		if (cmd.substring(0,4).equals("BACK")){
        			if (idx==0){
        				System.out.println("Ignored");
        			}else{
        				idx--;
        				System.out.println(arr[idx]);
        			}
        		} else if (cmd.substring(0,5).equals("VISIT")){
        			idx++;
        			arr[idx] = cmd.substring(6);
        			System.out.println(arr[idx]);
        			Arrays.fill(arr, idx+1, 100,"");
        		} else {
        			if (arr[idx+1].length()<1){
        				System.out.println("Ignored");
        			}else{
        				idx++;
        				System.out.println(arr[idx]);
        			}
        		}
        		cmd = cin.nextLine();
        	}
        }
    }
}