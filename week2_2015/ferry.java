import java.util.*;

class Main {
	static class car{
		int start;
		int end;
		int idx;
		
		public car(int start, int idx, int end){
			this.start = start;
			this.idx = idx;
			this.end = end;
		}
	}
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int c = cin.nextInt();
		
		for (int a=0;a<c;a++){
			int n = cin.nextInt();
			int t = cin.nextInt();
			int m = cin.nextInt();
			cin.nextLine();
			
			Deque<car> left = new ArrayDeque<car>();
			Deque<car> right = new ArrayDeque<car>();
			Deque<car> ip = new ArrayDeque<car>();
			Deque<car> ferry = new ArrayDeque<car>();
			
			for (int b=0;b<m;b++){
				int at = cin.nextInt();
				String bk = cin.next();
				
				car curr = new car(at,b,0);
				if (bk.equals("left")){
					left.add(curr);
				} else {
					right.add(curr);
				}
				ip.add(curr);
			}

			int ctime = 0;
			int fs = 0;
			int nextl = Integer.MAX_VALUE;
			int nextr = Integer.MAX_VALUE;
			boolean dir = true;
			int lsize = left.size();
			int rsize = right.size();
			
			while ((lsize>0)||(rsize>0)||(fs>0)){
			
				while (fs>0){
					fs--;
					ferry.pop().end=ctime;
				}
//				System.out.println("lsize: " + lsize);
//				System.out.println("rsize: " + rsize);

				if (lsize>0){
					nextl = left.peek().start;
				} else {
					nextl = Integer.MAX_VALUE;
				}
				if (rsize>0){
					nextr = right.peek().start;
				} else {
					nextr = Integer.MAX_VALUE;
				}
				
				if (dir){
					while ((fs<=n)&&(nextl<=ctime)){
						if (fs<n){
							if (lsize>0) {
								ferry.push(left.poll());
								lsize--;
								fs++;
								if (lsize>0){
									nextl = left.peek().start;
								}
							} else {
								break;
							}
						} else {
							if (lsize>0){
								left.peek().start=ctime+t;
							}
							break;
						}
					}
				} else {
					while ((fs<=n)&&(nextr<=ctime)){
						if (fs<n){
							if (rsize>0) {
								ferry.push(right.poll());
								rsize--;
								fs++;
								if (rsize>0){
									nextr = right.peek().start;
								}
							} else {
								break;
							}
						} else {
							if (rsize>0){
								right.peek().start=ctime+t;
							}
							break;
						}
					}
				}
//				System.out.println(dir+","+fs+","+ctime+","+(ctime+t));
//				System.out.println("nextl: " + nextl);
//				System.out.println("nextr: " + nextr);

				if (fs>0){
					if (dir){
						dir = false;
					} else {
						dir = true;
					}
					ctime += t;
				} else if (nextr==nextl) {
					ctime = nextr;
				} else {
					if (nextr<nextl){
						if (dir) {
							dir = false;
							if (ctime>nextr){
								ctime+=t;
							} else {
								ctime = nextr+t;
							}
						} else {
							ctime = nextr;
						}
					} else {
						if (dir) {
							ctime = nextl;
						} else {
							dir = true;
							if (ctime>nextl){
								ctime+=t;
							} else {
								ctime = nextl+t;
							}
						}
					}
				}
			}
			int si = ip.size();
			while (si>0){
				System.out.println(ip.poll().end);
				si--;
			}
			if (a<(c-1)){
				System.out.println();
			}
		}
	}
}