import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GetSetAttrInfoFlowGraph {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream in = new FileInputStream(
				"/Users/lingchen/Documents/workspace/Convert2Gexf/malicious.txt");

		// ~/Documents/workspace/Convert2Gexf/malicious.txt
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		FileInputStream in1 = new FileInputStream(
				"/Users/lingchen/Documents/workspace/Convert2Gexf/malicious1.txt");
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));

		BufferedWriter out = null;
		// Create file
		FileWriter fstream = new FileWriter(
				"/Users/lingchen/Documents/workspace/Convert2Gexf/readWriteGraph.gml");

		// double delta = 1;
		out = new BufferedWriter(fstream);

		String strLine = null;
		String strLine1 = null;
		
		String[] mystring = new String[4];

		HashMap<String, String> objectMap = new HashMap<String, String>();
		HashMap<String, String> permissionMap = new HashMap<String, String>();
		HashMap<String, String> subjectMap = new HashMap<String, String>();

		int accessPatternCount = 0;

		int objectId = 1;
		int permissionId = 1;
		int subjectId = 1;

		System.out.println("=======START HERE=======");
		
		out.write("graph"+"\n");
		out.write("[\n");
		

		// scan the file to index all the subjects, permissions and objects, load them into hashmaps.
		while ((strLine = br.readLine()) != null) {

			strLine = strLine.trim();
			mystring = strLine.split("	");
			// System.out.println("mystring length is: " + mystring.length);

			if (mystring.length != 4) {
				System.out.println("the string length is NOT 4!!!");
				continue;
			}
		

			accessPatternCount++;

			String object = mystring[0] + ": " + mystring[2];
			System.out.println("object is: " + object);
			String permission = mystring[1];
			System.out.println("permission is: " + permission);
			String subject = mystring[3];
			System.out.println("subject is: " + subject);
			System.out.println();

			if (!objectMap.containsKey(object)) {
				String objectId_s = "o"+ String.valueOf(objectId);
				objectMap.put(object, objectId_s);
				objectId++;

			}

			if (!permissionMap.containsKey(permission)) {
				String permissionId_s = "p"+ String.valueOf(permissionId);
				permissionMap.put(permission, permissionId_s);
				permissionId++;

			}

			if (!subjectMap.containsKey(subject)) {
				String subjectId_s = "s"+ String.valueOf(subjectId);
				subjectMap.put(subject, subjectId_s);
				subjectId++;

			}

			// out.write("object-1 is: " + mystring[0]);
			// out.newLine();
			//
			// out.write("permission is: " + mystring[1]);
			// out.newLine();
			//
			// out.write("object-2 is: " + mystring[2]);
			// out.newLine();
			//
			// out.write("subject is: " + mystring[3]);
			// out.newLine();
	
		}
		System.out.println("accesspatternCount is: " + accessPatternCount);
		
		
		// write object NODEs into file
		Set<Entry<String, String>> objectSet = objectMap.entrySet();
		Iterator<Entry<String, String>> objectiterator = objectSet.iterator();
		int objectcount = 0;
		while (objectiterator.hasNext()) {
			Map.Entry objectEntry = (Map.Entry) objectiterator.next();
			System.out.println("object-Key is: " + objectEntry.getKey());
			System.out.println("object-Value is: " + objectEntry.getValue());
			System.out.println(" ");

			out.write("  node" + "\n");
			out.write("  [" + "\n");
			out.write("    id " + objectEntry.getValue() + "\n");
			out.write("    label " + "\"" + objectEntry.getKey() + "\"" + "\n");
			out.write("  ]" + "\n");

			objectcount++;
		}
		System.out.println("objectcount is: " + objectcount);
		
	 
		// write subject NODEs into file
		 Set<Entry<String, String>> subjectSet = subjectMap.entrySet();
		 Iterator<Entry<String, String>> subjectiterator = subjectSet.iterator();
		 int subjectcount = 0;
		 while (subjectiterator.hasNext()) {
		 Map.Entry subjectEntry = (Map.Entry) subjectiterator.next();
		 System.out.println("subject-Key is: " + subjectEntry.getKey());
		 System.out.println("subject-Value is: " + subjectEntry.getValue());
		 System.out.println(" ");
		 
		 out.write("  node" + "\n");
		 out.write("  [" + "\n");
		 out.write("    id " + subjectEntry.getValue() + "\n");
		 out.write("    label " + "\"" + subjectEntry.getKey() + "\"" + "\n");
		 out.write("  ]" + "\n");
		 
		 subjectcount++;
		 }
		 System.out.println("subjectcount is: " + subjectcount);
		 	 
		 
		 System.out.println("Ling CHen");

		 
		 String Read = "read";
		 String Write = "write";
		 
		// write edges into file
		while ((strLine1 = br1.readLine()) != null) {


			strLine1 = strLine1.trim();
			mystring = strLine1.split("	");
			// System.out.println("mystring length is: " + mystring.length);

			if (mystring.length != 4) {
				System.out.println("the string length is NOT 4!!!");
				continue;
			}

		
			String object = mystring[0] + ": " + mystring[2];
			System.out.println("object is: " + object);
			String permission = mystring[1];
			System.out.println("permission is: " + permission);
			String subject = mystring[3];
			System.out.println("subject is: " + subject);
			System.out.println();
			
			
			
			String source = subjectMap.get(subject);
			String target = objectMap.get(object);
			System.out.println("source: " + source);
			System.out.println("target: " + target);
			System.out.println("===========");
			
				
				// if the permission is "read", then the information flow is flowing from Object (e.g. files, directories) to Subject (e.g. process or app)
				
			if (permission.equals(Read))
			{
				System.out.println("Inside READ!!!!!!!");
				System.out.println("mystring[1] is: " + mystring[1]);
						
				
				out.write("  edge" + "\n");
				out.write("  [" + "\n");
				out.write("    source " + target + "\n");
				out.write("    target " + source + "\n");
				out.write("    label " + permission + "\n");
				out.write("  ]" + "\n");
			}
			
			
			if (permission.equals(Write))
			{
				System.out.println("Inside Write!!!!!!!");
				System.out.println("mystring[1] is: " + mystring[1]);
				
							
				out.write("  edge" + "\n");
				out.write("  [" + "\n");
				out.write("    source " + source + "\n");
				out.write("    target " + target + "\n");
				out.write("    label " + permission + "\n");
				out.write("  ]" + "\n");
			}
			
		
			
//			String object = mystring[0] + mystring[2];
//			System.out.println("object is: " + object);
//			String permission = mystring[1];
//			System.out.println("permission is: " + permission);
//			String subject = mystring[3];
//			System.out.println("subject is: " + subject);
//			System.out.println();
//			
//			String source = subjectMap.get(subject);
//			String target = objectMap.get(object);
//			
//			out.write("  edge" + "\n");
//			out.write("  [" + "\n");
//			out.write("    source " + source + "\n");
//			out.write("    target " + target + "\n");
//			out.write("    label " + permission + "\n");
//			out.write("  ]" + "\n");
		
		}
		out.write("]\n");
		
//		 Set<Entry<String, String>> permissionSet = permissionMap.entrySet();
//		 Iterator<Entry<String, String>> permissioniterator = permissionSet.iterator();
//		 int permissioncount = 0;
//		 while (permissioniterator.hasNext()) {
//		 Map.Entry permissionEntry = (Map.Entry) permissioniterator.next();
//		 System.out.println("permission-Key is: " + permissionEntry.getKey());
//		 System.out.println("permission-Value is: " +
//		 permissionEntry.getValue());
//		 System.out.println(" ");
//		 permissioncount++;
//		 }
//		 System.out.println("permissioncount is: " + permissioncount);
//		


		in.close();
		in1.close();
		out.flush();
		out.close();

	}

}
