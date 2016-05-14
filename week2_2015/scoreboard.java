import java.util.*;

class Main {
	static class Pscore {
		Integer player;
		Integer correct;
		Integer penalty;
		int[] iscore;
		int[] done;

	    public Pscore(int player, int correct, int penalty, int[] done, int[] iscore){
	        this.player = player;
	        this.correct = correct;
	        this.penalty = penalty;
	        this.done = done;
	        this.iscore = iscore;
	    }
	}
	static class cmp implements Comparator<Pscore> {
		public int compare(Pscore one, Pscore two) {
			int cresult = two.correct.compareTo(one.correct);
			if (cresult != 0){
	            return cresult;
	        } else {
	        	int presult = one.penalty.compareTo(two.penalty);
	        	if (presult != 0){
		            return presult;
		        } else {
		        	return one.player-two.player;
		        }
	        }
		}
	}
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		cin.nextLine();
		cin.nextLine();
		
		for (int a=0;a<n;a++){
			
			HashMap<Integer,Pscore> hscore = new HashMap<Integer,Pscore>(); 
			
			while (cin.hasNextLine()){
				String line = cin.nextLine();
				if (line.length()<2){
					break;
				}
				Scanner cline = new Scanner(line);
				int player = cline.nextInt();
				int problem = cline.nextInt();
				int time = cline.nextInt();
				char sym = cline.next().charAt(0);
				
				if (hscore.containsKey(player)!=true){
					int[] arr = new int[10];
					int[] arr2 = new int[10];
					hscore.put(player, new Pscore(player,0,0,arr,arr2));
				}
				
				Pscore curr = hscore.get(player);
				
				if (sym == 'I'){
					if (curr.done[problem]==0){
						int newp = (curr.iscore[problem] + 20);
						curr.iscore[problem] = newp;
						hscore.put(player, curr);
					}
				}
				if (sym == 'C'){
					if (curr.done[problem]==0){
						int newp = (curr.iscore[problem] + time);
						curr.penalty += newp;
						int newc = curr.correct+1;
						curr.correct = newc;
						curr.done[problem]=1;
						hscore.put(player, curr);
					}
				}
			}
			
			cmp hcmp = new cmp();
			PriorityQueue<Pscore> psorted = new PriorityQueue<Pscore>(10,hcmp);
			for (Pscore value:hscore.values()){
				psorted.add(value);
			}
			
			int j = psorted.size();
			for (int c=0;c<j;c++){
				Pscore out = psorted.poll();

				System.out.println(out.player+" "+out.correct+" "+out.penalty);
			}
			if (a<(n-1)){
				System.out.println("");
			}
		}
	}
}