import java.util.*;

public class Main {
	
	public static ArrayList<Integer> output = new ArrayList();
	
	public static void binary(ArrayList<Integer> input){
		if(input.size() == 0){
			return;
		}
		else if(input.size() == 1){
			output.add(input.get(0));
		}
		
		else{
			int root = input.get(0);	
			
			ArrayList<Integer> left = new ArrayList();
			ArrayList<Integer> right = new ArrayList();
			
			for(int i = 1 ; i < input.size(); i++){
				
				if(input.get(i) < root){
					left.add(input.get(i));
				}
				else if(input.get(i) > root){
					right.add(input.get(i));
				}
			}
			binary(left);
			binary(right);
			output.add(root);
		}
		
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> input = new ArrayList();
		Scanner cin = new Scanner(System.in);
		
		while(cin.hasNext()){
			input.add(cin.nextInt());
		}
		binary(input);
		for(int out = 0 ; out < output.size(); out++){
			System.out.println(output.get(out));
		}
	}
}