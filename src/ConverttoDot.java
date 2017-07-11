
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;
import com.alexmerz.graphviz.objects.Id;
import com.alexmerz.graphviz.objects.Node;
import com.alexmerz.graphviz.objects.PortNode;

public class ConverttoDot {

    public static void main(String[] args) throws IOException {
        convertToDot("C:\\Users\\xsxiao\\Documents\\Projects\\policy-visualization\\malicious.txt", "graph.dot");
    }

    public static Graph convertToDot(String path, String outputPath) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        
        FileInputStream in = new FileInputStream(path);

        // ~/Documents/workspace/Convert2Gexf/malicious.txt
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // double delta = 1;
        String strLine = null;
        String[] mystring = new String[4];

        HashMap<String, String> objectMap = new HashMap<String, String>();
        HashMap<String, Node> objectNodeMap = new HashMap<String, Node>();
        HashMap<String, String> permissionMap = new HashMap<String, String>();
        HashMap<String, String> subjectMap = new HashMap<String, String>();
        HashMap<String, Node> subjectNodeMap = new HashMap<String, Node>();

        int accessPatternCount = 0;

        int objectId = 1;
        int permissionId = 1;
        int subjectId = 1;

        System.out.println("=======START HERE=======");

        // scan the file to index all the subjects, permissions and objects,
        // load them into hashmaps.
        int objectcount = 0;
        int subjectcount = 0;
        Graph g = new Graph();
        Id id = new Id();
        g.setType(Graph.DIRECTED);
        g.setId(id);
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
                String objectId_s = "o" + String.valueOf(objectId);
                objectMap.put(object, objectId_s);
                objectId++;
                Node n = new Node();
                Id nid = new Id();
                n.setId(nid);
                nid.setId("\"" + objectId_s + "\"");
                n.setAttribute("label", object + "");
                n.setAttribute("shape", "box");
                g.addNode(n);
                objectNodeMap.put(objectId_s + "", n);
                objectcount++;
            }

            if (!permissionMap.containsKey(permission)) {
                String permissionId_s = "p" + String.valueOf(permissionId);
                permissionMap.put(permission, permissionId_s);
                permissionId++;
            }

            if (!subjectMap.containsKey(subject)) {
                String subjectId_s = "s" + String.valueOf(subjectId);
                subjectMap.put(subject, subjectId_s);
                subjectId++;
                Node n = new Node();
                Id nid = new Id();
                n.setId(nid);
                nid.setId("\"" + subjectId_s + "\"");
                n.setAttribute("label", "\"" + subject + "\"");
                g.addNode(n);
                subjectNodeMap.put(subjectId_s + "", n);
                subjectcount++;
            }

            String source = subjectMap.get(subject);
            String target = objectMap.get(object);

            Node sourceNode = subjectNodeMap.get(source);
            Node targetNode = objectNodeMap.get(target);

            Edge e = new Edge(new PortNode(sourceNode),
                    new PortNode(targetNode), Graph.DIRECTED);

            e.setAttribute("label", "\"" + permission + "\"");
            g.addEdge(e);
        }
        System.out.println("accesspatternCount is: " + accessPatternCount);

        in.close();

        PrintWriter out = new PrintWriter(outputPath);
        out.println(g.toString());
        out.close();
        
        return g;
    }

}
