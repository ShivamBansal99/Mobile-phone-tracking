package mobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class assn2checker
{
	public static void main ( String args [])
	{
		BufferedReader br = null;
		RoutingMapTree r = new RoutingMapTree();

		try {
			String actionString;
			br = new BufferedReader(new FileReader("actions1.txt"));
                        
			while ((actionString = br.readLine()) != null) {
				try{System.out.println(r.performAction(actionString));}catch(Exception e){
                                    e.printStackTrace();
                                }
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
