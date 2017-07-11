import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.alexmerz.graphviz.ParseException;
import com.alexmerz.graphviz.Parser;
import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;
import com.alexmerz.graphviz.objects.Id;
import com.alexmerz.graphviz.objects.Node;
import com.alexmerz.graphviz.objects.PortNode;

public class ParseGraph {

	public static ArrayList<String> readFile(File f) {
		ArrayList<String> res = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				String addLine = line.toUpperCase();
				addLine = addLine.replaceAll("PROGRAM PATH: ", "");
				res.add(addLine.toUpperCase());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		FileReader in = null;
		File succFile = new File("firefoxfilezillasuccess.txt");
		File failFile = new File("firefoxfilezillafailure.txt");
		ArrayList<String> succArray = readFile(succFile);
		ArrayList<String> failArray = readFile(failFile);

		String s = new String(Files.readAllBytes(Paths
				.get("filezilla_original.dot"))).replace("\\", "|");

		Parser p = null;
		try {
			p = new Parser();
			p.parse(new StringBuffer(s));

		} catch (Exception e) {
			// do something if the parser caused a parser error
			e.printStackTrace();
		}

		// everything ok
		ArrayList<Graph> gl = p.getGraphs();

		// do something with the Graph objects
		PrintWriter out = new PrintWriter("test.dot");
		for (Graph g : gl) {
			for (Edge e : g.getEdges()) {
				PortNode source = e.getSource();
				String sourceStr = source.toString().replace("|", "\\")
						.toUpperCase();
				for (String path : succArray) {
					if (sourceStr.contains(path)) {
						source.getNode().setAttribute("color", "green");
					}
				}

				for (String path : failArray) {
					if (sourceStr.contains(path)) {
						source.getNode().setAttribute("color", "purple");
						source.getNode().setAttribute("fillcolor", "purple");
					}
				}

			}
			g.setId(new Id());
			System.out.println(g);
			out.println(g);
		}
		out.close();
	}
}
