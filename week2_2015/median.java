import java.util.*;

class Main {
	static class maxcomp implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
	static class mincomp implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return one - two;
		}
	}
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int median1 = cin.nextInt();
		int median2 = median1;
		int num = 1;
		System.out.println(median1);
		mincomp ncmp = new mincomp();
		maxcomp xcmp = new maxcomp();
		PriorityQueue<Integer> minheap = 
	            new PriorityQueue<Integer>(10, ncmp);
		PriorityQueue<Integer> maxheap = 
	            new PriorityQueue<Integer>(10, xcmp);
		while (cin.hasNextInt()){
			int n = cin.nextInt();
			num++;
			if (num%2==0){
				if (n<median1){
					maxheap.add(n);
					median1 = maxheap.poll();
				} else {
					minheap.add(n);
					median2 = minheap.poll();
				}
				System.out.println((median1+median2)/2);
			} else {
				if ((n>median1)&&(n<median2)){
					maxheap.add(median1);
					minheap.add(median2);
					median1 = n;
					median2 = n;
				} else if (n<median1) {
					maxheap.add(n);
					minheap.add(median2);
					median2 = median1;
				} else if (n>median2) {
					minheap.add(n);
					maxheap.add(median1);
					median1 = median2;
				}
				System.out.println(median1);
			}
		}
	}
}