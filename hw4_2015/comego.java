import java.util.*;

public class Main {
	static int n; 
	public static int sdfs(boolean[][] matrix, int root){
	    Stack<Integer> stack = new Stack<Integer>();
	    boolean[] visited = new boolean[n+1];
	    stack.push(root);
	    int node = 0;
	    while (true){
		    while(!stack.isEmpty()){
		    	node = stack.pop();
		    	visited[node] = true;
		    	for(int i=1;i<=n;i++){
		    		if(matrix[node][i]){
		    			if(!stack.contains(i) && !(visited[i])){
		    				stack.push(i);
		    			}
		    		}
		    	}
		   	}
		    boolean done = true;
		    for(int i=1;i<=n;i++){
	    		if(!visited[i]){
	    			stack.push(i);
	    			done = false;
	    			break;
	    		}
	    	}
		    if (done) {
		    	return node;
		    }
	    }
	}
	public static void dfs(boolean[][] matrix, int root){
	    Stack<Integer> stack = new Stack<Integer>();
	    ArrayList<Integer> visited = new ArrayList<Integer>();
	    stack.push(root);
	    int node = 0;
	    while(!stack.isEmpty()){
	    	node = stack.pop();
	    	visited.add(node);
	    	for(int i=1;i<=n;i++){
	    		if(matrix[node][i]){
	    			if(!stack.contains(i) && !visited.contains(i)){
	    				stack.push(i);
	    			}
	    		}
	    	}
	   	}
	    if (visited.size()==n){
	    	System.out.println(1);
	    } else {
	    	System.out.println(0);
	    }
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNextInt()){
			n = cin.nextInt();
			int m = cin.nextInt();
			
			if ((n==0)&&(m==0)) break;

			boolean[][] e = new boolean[n+1][n+1];
			boolean[][] re = new boolean[n+1][n+1];
			
			for (int a=0;a<m;a++){
				int e1 = cin.nextInt();
				int e2 = cin.nextInt();
				int p = cin.nextInt();

				e[e1][e2] = true;
				re[e2][e1] = true;
				
				if (p==2){
					e[e2][e1] = true;
					re[e1][e2] = true;
				}
			}
			int sink = sdfs(re,1);
			dfs(e,sink);
		}
	}
}