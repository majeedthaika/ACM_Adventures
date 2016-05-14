import java.util.*;

public class Main {
	public static void main(String[] args) {
	    Scanner cin = new Scanner(System.in);
	    
	    while (cin.hasNextLine()){
	    	String line = cin.nextLine();
	    	if (line.equals(".")) break;

	    	int len = line.length();
	    	int i = 0;
	    	int j = -1;
	    	int[] tab = new int[len+1];
	    	tab[0] = -1;
	    	
	    	String jc;
	    	while (i<len){
	    		String ic = line.substring(i, i+1);
	    		if (j==-1) jc = line.substring(len-1, len);
	    		else jc = line.substring(j, j+1);
	    		if (j == -1 || (ic.equals(jc))) {
		    		i++;
		    		j++;
		    		tab[i] = j;
	    		} else {
	    			j = tab[j];
	    		}
	    	}
	    	
	    	int diff = len-tab[len-1]-1;
//	    	for (int b=0;b<len;b++){
//	    		System.out.println(tab[b]);
//	    	}
	    	if (len%diff==0){
	    		boolean done = true;
	            int idx = 0;
	            for(int a=diff;a<len;a++){
	            	String id = line.substring(a, a+1);
	            	String jd = line.substring(idx, idx+1);
	                if(!id.equals(jd)){
	                    done = false;
	                    break;
	                }
	                idx++;
	                if(idx==diff) j = 0;
	            }
	            if(done) System.out.println(len/diff);
	            else System.out.println(1);
	    	} else {
	    		System.out.println(1);
	    	}
	    }
	}
}