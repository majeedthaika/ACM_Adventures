import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner cin = new Scanner(System.in);
    	
    	HashMap<String,Integer> hm = new HashMap<String,Integer>();
    	ArrayDeque<String> rem = new ArrayDeque<String>();
    	
    	for (int i=0;i<65536;i++) hm.put(i+"", i);
    	
    	while (cin.hasNextLine()){
    		String line = cin.nextLine();
    		if (line.substring(0, 3).equals("NOT")){
				String[] tokens = line.substring(4).replace(" ", "").split("->");
				if (hm.containsKey(tokens[0])) hm.put(tokens[1], ~hm.get(tokens[0])&0xFFFF);
				else rem.add("N,"+tokens[0]+","+tokens[1]);
			} else {
				String[] tokens = line.replace(" ", "").replace(" ", "->").split("->");
				if (tokens[0].contains("AND")){
					String[] t2 = tokens[0].split("AND");
					if (hm.containsKey(t2[0])&&hm.containsKey(t2[1])) hm.put(tokens[1], hm.get(t2[0])&hm.get(t2[1]));
    				else rem.add("A,"+t2[0]+","+t2[1]+","+tokens[1]);
				} else if (tokens[0].contains("OR")){
					String[] t2 = tokens[0].split("OR");
					if (hm.containsKey(t2[0])&&hm.containsKey(t2[1])) hm.put(tokens[1], hm.get(t2[0])|hm.get(t2[1]));
    				else rem.add("O,"+t2[0]+","+t2[1]+","+tokens[1]);
				} else if (tokens[0].contains("LSHIFT")){
					String[] t2 = tokens[0].split("LSHIFT");
					if (hm.containsKey(t2[0])) hm.put(tokens[1], hm.get(t2[0]) << Integer.parseInt(t2[1]));
    				else rem.add("L,"+t2[0]+","+t2[1]+","+tokens[1]);
				} else if (tokens[0].contains("RSHIFT")){
					String[] t2 = tokens[0].split("RSHIFT");
					if (hm.containsKey(t2[0])) hm.put(tokens[1], hm.get(t2[0]) >>> Integer.parseInt(t2[1]));
    				else rem.add("R,"+t2[0]+","+t2[1]+","+tokens[1]);
				} else {
					String[] t2 = line.replace(" ", "").split("->");
					if (hm.containsKey(t2[0])) hm.put(t2[1], hm.get(t2[0]));
    				else rem.add("P,"+t2[0]+","+t2[1]);
				}
    		}
    	}
    	while (!rem.isEmpty()){
    		String ins = rem.pollFirst();
    		String[] tok = ins.replace(" ", "").split(",");
    		if (tok[0].equals("N")){
    			if (hm.containsKey(tok[1])) hm.put(tok[2], ~hm.get(tok[1])&0xFFFF);
				else rem.add(ins);
    		} else if (tok[0].equals("A")){
				if (hm.containsKey(tok[1])&&hm.containsKey(tok[2])) hm.put(tok[3], hm.get(tok[1])&hm.get(tok[2]));
				else rem.add(ins);
    		} else if (tok[0].equals("O")){
				if (hm.containsKey(tok[1])&&hm.containsKey(tok[2])) hm.put(tok[3], hm.get(tok[1])|hm.get(tok[2]));
				else rem.add(ins);
    		} else if (tok[0].equals("L")){
				if (hm.containsKey(tok[1])) hm.put(tok[3], hm.get(tok[1]) << Integer.parseInt(tok[2]));
				else rem.add(ins);
    		} else if (tok[0].equals("R")){
				if (hm.containsKey(tok[1])) hm.put(tok[3], hm.get(tok[1]) >>> Integer.parseInt(tok[2]));
				else rem.add(ins);
    		} else {
    			if (hm.containsKey(tok[1])) hm.put(tok[2], hm.get(tok[1]));
				else rem.add(ins);
    		}
//    		System.out.println(rem.size());
    	}
    	System.out.println(hm.get("a"));
    }
}
