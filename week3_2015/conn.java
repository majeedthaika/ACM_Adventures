import java.util.*;
import java.io.*;

class Main {
    static int [] arr;
    static int findSet(int i){
        return (arr[i] == i) ? i : (arr[i] = findSet(arr[i]));
    }
    static void unionSet(int i, int j){
    	arr[findSet(i)] = arr[findSet(j)];
    }
    static boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j); 
    }
    static void initSet(int s) { 
    	arr = new int[s]; for (int i = 0; i < s; i++) arr[i] = i; 
    }
	public static void main(String args[]) throws Exception {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(cin.readLine());
		cin.readLine();
		
		for (int a=0;a<n;a++){
			int m = Integer.parseInt(cin.readLine());

			initSet(m+1);
				
			int right = 0;
			int wrong = 0;
			
			String line;
			while((line=cin.readLine())!=null){
				if (line.length()==0){
					break;
				}
				String[] sl= line.split(" ");
				char c = sl[0].charAt(0);
				int x = Integer.parseInt(sl[1]);
				int y = Integer.parseInt(sl[2]);
				
				if (c == 'c'){
					unionSet(x,y);
				} else if (c == 'q') {
					if(isSameSet(x,y)){
                        right++;
					}else{
                        wrong++;
					}
				}
			}
			System.out.println(right+","+wrong);
			if (a<(n-1)){
				System.out.println();
			}
		}
	}
}