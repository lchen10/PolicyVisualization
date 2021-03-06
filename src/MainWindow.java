/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;
import com.alexmerz.graphviz.objects.Id;
import com.alexmerz.graphviz.objects.Node;
import com.alexmerz.graphviz.objects.PortNode;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author xsxiao
 */
public class MainWindow extends javax.swing.JFrame {

    private static HashMap<String, String> objectMap;
    private static HashMap<String, Node> objectNodeMap;
    private static HashMap<String, String> permissionMap;
    private static HashMap<String, String> subjectMap;
    private static HashMap<String, Node> subjectNodeMap;
    private static HashMap<String, ArrayList<Edge>> subjectEdgeMap;
    private static HashMap<String, ArrayList<Edge>> objectEdgeMap;

    private String path;
    private Graph graph;
    private DefaultListModel objectModel;
    private DefaultListModel subjectModel;
    private DefaultListModel permissionModel;
    private SettingConfig config = new SettingConfig();
    private SettingsDialog dialog = new SettingsDialog(this, false);

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        dialog.setConfig(config);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Import");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("File Path");

        jScrollPane2.setViewportView(jList1);

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel1.setText("Subjects:");

        jScrollPane3.setViewportView(jList2);

        jLabel2.setText("Objects:");

        jLabel3.setText("Actions:");

        jScrollPane4.setViewportView(jList3);

        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jLabel5);

        jLabel4.setText("Graph:");

        jButton3.setText("InfoFlow");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reachability");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Settings");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Show In Browser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane5)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(7, 7, 7))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
<<<<<<< HEAD
        JFileChooser fc = new JFileChooser("/Users/lingchen/policy-visualization");
=======
        JFileChooser fc = new JFileChooser("C:\\Users\\xsxiao\\workspace\\policy-visualization");
>>>>>>> 3e2a4d424aaa26f29254930c58a1ab8cba12922d
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            path = file.getAbsolutePath();
            //This is where a real application would open the file.
            jTextField1.setText(path);

            try {
                this.graph = convertToDot(path, outputPath);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            subjectModel = new DefaultListModel();
            for (Map.Entry<String, String> e : subjectMap.entrySet()) {
                subjectModel.addElement(e.getValue() + ":" + e.getKey());
            }
            jList1.setModel(subjectModel);

            objectModel = new DefaultListModel();
            for (Map.Entry<String, String> e : objectMap.entrySet()) {
                objectModel.addElement(e.getValue() + ":" + e.getKey());
            }
            jList2.setModel(objectModel);

            permissionModel = new DefaultListModel();
            for (Map.Entry<String, String> e : permissionMap.entrySet()) {
                permissionModel.addElement(e.getValue() + ":" + e.getKey());
            }
            jList3.setModel(permissionModel);

        } else {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

//    private String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
    private String dotPath = "dot";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (graph != null) {
            showPNG(graph.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showPNG(String graphString) {
        PrintWriter out = null;
        try {
            final String dotfile = config.getOutputPath() + "/graph.dot";
            out = new PrintWriter(dotfile);
            out.println(graphString);
            out.close();
            String outputfile = config.getOutputPath() + "/graph.png";
//            execCommand(new String[]{config.getDotPath(), "-Tpng", "-o" + outputfile, dotfile});
//            execCommand(new String[]{config.getDotPath(), "-Tsvg", "-o" + outputfile, dotfile});
            execCommand(new String[]{config.getDotPath(), "-Tpdf", "-o" + outputfile, dotfile});
            System.out.println("Successfully convert the png file");
            ImageIcon icon = new ImageIcon(outputfile);
//                Image img = icon.getImage();
//                Image newimg = img.getScaledInstance(1200, 600, java.awt.Image.SCALE_SMOOTH);
//                icon = new ImageIcon(newimg);
            icon.getImage().flush();
            jLabel5.setIcon(icon);

        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private void execCommand(String[] args) throws InterruptedException, IOException {
        final Process p = Runtime.getRuntime().exec(args);
        new Thread(new Runnable() {
            public void run() {
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;

                try {
                    while ((line = input.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        p.waitFor();
    }

    private ArrayList<Node> getReadTargets(ArrayList<Edge> edges) {
        ArrayList<Node> r = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getAttribute("label").replace("\"", "").equals("read")) {
                r.add(e.getTarget().getNode());
            }
        }
        return r;
    }

    private ArrayList<Node> getWriteSources(ArrayList<Edge> edges) {
        ArrayList<Node> r = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getAttribute("label").replace("\"", "").equals("write")) {
                r.add(e.getSource().getNode());
            }
        }
        return r;
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String selectedsub = (String) jList1.getSelectedValue();
        if (selectedsub == null || !selectedsub.contains(":")) {
            return;
        }
        String[] split = selectedsub.split(":");
        String subjectid = split[0];

        String selectedobj = (String) jList2.getSelectedValue();
        if (selectedobj == null || !selectedobj.contains(":")) {
            return;
        }

        split = selectedobj.split(":");
        String objectid = split[0];

        Node start = subjectNodeMap.get(subjectid);
        Node target = objectNodeMap.get(objectid);
        ArrayList<Node> tosearch = new ArrayList<>();
        tosearch.add(start);
        ArrayList<ArrayList<Edge>> contexts = new ArrayList<>();
        final ArrayList<Edge> first = new ArrayList<Edge>();
        contexts.add(first);
        Graph infoGraph = new Graph();
        infoGraph.setType(Graph.DIRECTED);
        infoGraph.setId(new Id());
        // BFS
        while (tosearch.size() != 0) {
            ArrayList<Node> next = new ArrayList<>();
            ArrayList<ArrayList<Edge>> nextCtx = new ArrayList<ArrayList<Edge>>();
            boolean found = false;
            int i = 0;
            for (Node current : tosearch) {
                String currentid = current.getId().getId().replace("\"", "");
                ArrayList<Edge> context = contexts.get(i);
                ArrayList<Edge> edges = subjectEdgeMap.get(currentid);
                ArrayList<Node> readNodes = getReadTargets(edges);
                for (Node readNode : readNodes) {
                    final String objid = readNode.getId().getId().replace("\"", "");
                    if (objid.equals(objectid)) {
                        found = true;
                        HashSet<String> subids = new HashSet<>();
                        HashSet<String> objids = new HashSet<>();
                        ArrayList<Edge> path = new ArrayList<>(context);
                        final Edge edge = new Edge(new PortNode(current), new PortNode(readNode), Graph.DIRECTED);
                        edge.setAttribute("label", "\"read\"");
                        path.add(edge);
                        for (Edge e : path) {
                            final String sid = e.getSource().getNode().getId().getId().replace("\"", "");
                            final String tid = e.getTarget().getNode().getId().getId().replace("\"", "");
                            if (!subids.contains(sid)) {
                                infoGraph.addNode(e.getSource().getNode());
                                subids.add(sid);
                            }

                            if (!objids.contains(tid)) {
                                infoGraph.addNode(e.getTarget().getNode());
                                objids.add(tid);
                            }

                            infoGraph.addEdge(e);
                        }
                        showPNG(infoGraph.toString());

                        break;
                    }
                    final ArrayList<Edge> objedges = objectEdgeMap.get(objid);
                    final ArrayList<Node> writeSources = getWriteSources(objedges);
                    for (Node writeSource : writeSources) {
                        next.add(writeSource);
                        final ArrayList<Edge> ctx = new ArrayList<Edge>();
                        ctx.addAll(context);
                        final Edge redge = new Edge(new PortNode(current), new PortNode(readNode), Graph.DIRECTED);
                        redge.setAttribute("label", "\"read\"");
                        ctx.add(redge);
                        final Edge wedge = new Edge(new PortNode(writeSource), new PortNode(readNode), Graph.DIRECTED);
                        wedge.setAttribute("label", "\"write\"");
                        ctx.add(wedge);
                        nextCtx.add(ctx);
                    }
                }
                if (found) {
                    tosearch.clear();
                    break;
                }
                i++;
            }
            tosearch = next;
            contexts = nextCtx;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
          //  execCommand(new String[]{config.getBrowserPath(), config.getOutputPath() + "/graph.png"});
//            execCommand(new String[]{config.getBrowserPath(), config.getOutputPath() + "/graph.svg"});
            execCommand(new String[]{config.getBrowserPath(), config.getOutputPath() + "/graph.pdf"});
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    
    // reachability
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String selectedsub = (String) jList1.getSelectedValue();
        if (selectedsub == null || !selectedsub.contains(":")) {
            return;
        }
        String[] split = selectedsub.split(":");
        String subjectid = split[0];

        Node start = subjectNodeMap.get(subjectid);
        ArrayList<Node> tosearch = new ArrayList<>();
        tosearch.add(start);
        Graph infoGraph = new Graph();
        infoGraph.setType(Graph.DIRECTED);
        infoGraph.setId(new Id());
        HashSet<String> sids = new HashSet<>();
        HashSet<String> tids = new HashSet<>();
        infoGraph.addNode(start);
        sids.add(start.getId().getId().replace("\"", ""));

        // BFS
        while (tosearch.size() != 0) {
            ArrayList<Node> next = new ArrayList<>();
            for (Node current : tosearch) {
                String currentid = current.getId().getId().replace("\"", "");
                ArrayList<Edge> edges = subjectEdgeMap.get(currentid);
                for (Edge e : edges) {
                    if (e.getAttribute("label").replace("\"", "").equals("read")) {
                        final Node readNode = e.getTarget().getNode();
                        final String objid = readNode.getId().getId().replace("\"", "");

                        if (!tids.contains(objid)) {
                            infoGraph.addNode(readNode);
                            tids.add(objid);
                        }
                        infoGraph.addEdge(e);

                        final ArrayList<Edge> objedges = objectEdgeMap.get(objid);
                        for (Edge objedge : objedges) {
                            if (objedge.getAttribute("label").replace("\"", "").equals("write")) {
                                final Node writenode = objedge.getSource().getNode();
                                final String writenodeid = writenode.getId().getId().replace("\"", "");
                                infoGraph.addEdge(objedge);
                                if (!sids.contains(writenodeid)) {
                                    infoGraph.addNode(writenode);
                                    next.add(writenode);
                                    sids.add(writenodeid);
                                }
                            }
                        }
                    }
                }
            }
            tosearch = next;
        }
        
        showPNG(infoGraph.toString());
    }//GEN-LAST:event_jButton4ActionPerformed
    private String outputPath = ".";

    public static Graph convertToDot(String path, String outputPath) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub

        FileInputStream in = new FileInputStream(path);

        // ~/Documents/workspace/Convert2Gexf/malicious.txt
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // double delta = 1;
        String strLine = null;
        String[] mystring = new String[4];

        objectMap = new HashMap<String, String>();
        objectNodeMap = new HashMap<String, Node>();
        permissionMap = new HashMap<String, String>();
        subjectMap = new HashMap<String, String>();
        subjectNodeMap = new HashMap<String, Node>();
        subjectEdgeMap = new HashMap<>();
        objectEdgeMap = new HashMap<>();

        int accessPatternCount = 0;

        int objectId = 1;
        int permissionId = 1;
        int subjectId = 1;

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
            String permission = mystring[1];
            String subject = mystring[3];

            String objectId_s = "";
            if (!objectMap.containsKey(object)) {
                objectId_s = "o" + String.valueOf(objectId);
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
            } else {
                objectId_s = objectMap.get(object);
            }

            if (!permissionMap.containsKey(permission)) {
                String permissionId_s = "p" + String.valueOf(permissionId);
                permissionMap.put(permission, permissionId_s);
                permissionId++;
            }

            String subjectId_s = "";
            if (!subjectMap.containsKey(subject)) {
                subjectId_s = "s" + String.valueOf(subjectId);
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
            } else {
                subjectId_s = subjectMap.get(subject);
            }

            String source = subjectMap.get(subject);
            String target = objectMap.get(object);

            Node sourceNode = subjectNodeMap.get(source);
            Node targetNode = objectNodeMap.get(target);

            Edge e = new Edge(new PortNode(sourceNode),
                    new PortNode(targetNode), Graph.DIRECTED);

            e.setAttribute("label", "\"" + permission + "\"");
            g.addEdge(e);

            if (!subjectEdgeMap.containsKey(subjectId_s)) {
                subjectEdgeMap.put(subjectId_s, new ArrayList<Edge>());
            }
            subjectEdgeMap.get(subjectId_s).add(e);

            if (!objectEdgeMap.containsKey(objectId_s)) {
                objectEdgeMap.put(objectId_s, new ArrayList<Edge>());
            }
            objectEdgeMap.get(objectId_s).add(e);
        }
        System.out.println("accesspatternCount is: " + accessPatternCount);

        in.close();

//        PrintWriter out = new PrintWriter(outputPath);
//        out.println(g.toString());
//        out.close();
        return g;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
