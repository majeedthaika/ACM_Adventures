import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextLine()){
			String line = cin.nextLine();
			if (line.contains("#")) {
				break;
			}
			ArrayList <Character> chars = new ArrayList <Character>();
			
			for (int i=0;i<line.length();i++){
				char a = line.charAt(i);
				chars.add(a);
			}
			
			int s = chars.size();
			char[] out = new char[s];
			
			int first = -1;
			char ifi = 'a';
			for (int j=s-1;j>0;j--){
				char flast = chars.get(j);
				char slast = chars.get(j-1);
				if (slast<flast){
					ifi = slast;
					first = j-1;
					break;
				}
			}
			int second = -1;
			char isi = 'a';
			for (int k=s-1;k>=0;k--){
				char flast = chars.get(k);
				if (ifi<flast){
					isi = flast;
					second = k;
					break;
				}
			}
			
			if ((first==-1)||(second==-1)){
				System.out.println("No Successor");
			} else {
				chars.set(first,isi);
				chars.set(second,ifi);
				
				for (int z=0;z<=first;z++){
					out[z] = chars.get(z);
				}
				int diff = s-(first+1);
				for (int y=0;y<diff;y++){
					out[(first+1)+y] = chars.get(s-1-y);
				}
				System.out.println(out);
			}
		}
	}
}