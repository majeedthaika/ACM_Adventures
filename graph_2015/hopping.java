import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int c = 1;
		
		while (cin.hasNextInt()){
			int[][] arr = new int[101][101];

			int p1 = cin.nextInt();
			int p2 = cin.nextInt();
			
			if (p1==0){
				break;
			}
				
			for(int i=0;i<101;i++)
				for(int j=0;j<101;j++)
					arr[i][j] = 65000;
			
			do{
				arr[p1][p2] = 1;
				arr[p1][p1] = 0;
				arr[p2][p2] = 0;
 
                p1 = cin.nextInt();
                p2 = cin.nextInt();
 
            } while(p1>0);
	 
          //Floyd Warshall algorithm
            for(int k=1;k<101;k++){
                for(int i=1;i<101;i++){
                    for(int j=1;j<101;j++){
                        if(j==i) continue;
                        if(arr[i][j] > arr[i][k] + arr[k][j]) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
			}

			int n=0;
            float sum=0;
 
            for(int i=1;i<101;i++){
                for(int j=1;j<101;j++){
                    if(i==j && arr[i][i] == 0) n++;
                    else if(i!=j && arr[i][j] != 65000){
                        sum+=arr[i][j];
                    }
                }
            }
 
            float pairs = n*(n-1);
            float avg = sum/pairs;
            
			System.out.printf("Case "+c+": average length between pages = %.3f clicks\n", avg);
			c++;
		}
	}
}