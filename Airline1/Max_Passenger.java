/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airline1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MeherunNesaShraboni
 */
public class Max_Passenger extends javax.swing.JFrame {

    /**
     * Creates new form Max_Passenger
     */
   
    
  
    static final int V = 6; //Number of vertices in graph 

	/* Returns true if there is a path from source 's' to sink 
	't' in residual graph. Also fills parent[] to store the 
	path */
	boolean bfs(int rGraph[][], int s, int t, int parent[]) 
	{ 
		// Create a visited array and mark all vertices as not 
		// visited 
		boolean visited[] = new boolean[V]; 
		for(int i=0; i<V; ++i) 
			visited[i]=false; 

		// Create a queue, enqueue source vertex and mark 
		// source vertex as visited 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(s); 
		visited[s] = true; 
		parent[s]=-1; 

		// Standard BFS Loop 
		while (queue.size()!=0) 
		{ 
			int u = queue.poll(); 

			for (int v=0; v<V; v++) 
			{ 
				if (visited[v]==false && rGraph[u][v] > 0) 
				{ 
					queue.add(v); 
					parent[v] = u; 
					visited[v] = true; 
				} 
			} 
		} 

		// If we reached sink in BFS starting from source, then 
		// return true, else false 
		return (visited[t] == true); 
	} 

	// Returns tne maximum flow from s to t in the given graph 
	int fordFulkerson(int graph[][], int s, int t) 
	{ 
		int u, v; 

		// Create a residual graph and fill the residual graph 
		// with given capacities in the original graph as 
		// residual capacities in residual graph 

		// Residual graph where rGraph[i][j] indicates 
		// residual capacity of edge from i to j (if there 
		// is an edge. If rGraph[i][j] is 0, then there is 
		// not) 
		int rGraph[][] = new int[V][V]; 

		for (u = 0; u < V; u++) 
			for (v = 0; v < V; v++) 
				rGraph[u][v] = graph[u][v]; 

		// This array is filled by BFS and to store path 
		int parent[] = new int[V]; 

		int max_flow = 0; // There is no flow initially 

		// Augment the flow while tere is path from source 
		// to sink 
		while (bfs(rGraph, s, t, parent)) 
		{ 
			// Find minimum residual capacity of the edhes 
			// along the path filled by BFS. Or we can say 
			// find the maximum flow through the path found. 
			int path_flow = Integer.MAX_VALUE; 
			for (v=t; v!=s; v=parent[v]) 
			{ 
				u = parent[v]; 
				path_flow = Math.min(path_flow, rGraph[u][v]); 
			} 

			// update residual capacities of the edges and 
			// reverse edges along the path 
			for (v=t; v != s; v=parent[v]) 
			{ 
				u = parent[v]; 
				rGraph[u][v] -= path_flow; 
				rGraph[v][u] += path_flow; 
			} 

			// Add path flow to overall flow 
			max_flow += path_flow; 
		} 

		// Return the overall flow 
		return max_flow; 
	} 
      public Max_Passenger(int a,int b) {
          initComponents();
        
        ArrayList<User> list =userList();
        //DefaultTableModel model=(DefaultTableModel)jTable_Display_User.getModel();
        Object[] row =new Object[11];
        int i=list.size();
                     // row[0]=list.get(i).getid();
                     // row[1]=list.get(i).getonetotwo();
                    //  row[2]=list.get(i).getonetothree();
                     // row[3]=list.get(i).gettwotothree();
                    //  row[4]=list.get(i).gettwotofour();
                    //  row[5]=list.get(i).getthreetotwo();
                    //  row[6]=list.get(i).getthreetofive();
                    //  row[7]=list.get(i).getfourtothree();
                    //  row[8]=list.get(i).getfourtosix();
                    //  row[9]=list.get(i).getfivetofour();
                    //  row[10]=list.get(i).getfivetosix();
                     // model.addRow(row);
        	
      int graph[][] =new int[][] { {0, list.get(i-1).getonetotwo(), list.get(i-1).getonetothree(), 0, 0, 0}, 
									{0, 0, list.get(i-1).gettwotothree(), list.get(i-1).gettwotofour(), 0, 0}, 
									{0, list.get(i-1).getthreetotwo(), 0, 0,list.get(i-1).getthreetofive(), 0}, 
									{0, 0, list.get(i-1).getfourtothree(), 0, 0, list.get(i-1).getfourtosix()}, 
									{0, 0, 0, list.get(i-1).getfivetofour(), 0, list.get(i-1).getfivetosix()}, 
									{0, 0, 0, 0, 0, 0} 
		
        						}; 
        
      
                        int s=a,t=b;
        //Ford_Fulkerson ff=new Ford_Fulkerson();
        ///ff.fordFulkerson(graph,s,t);
    
    String getValue=jLabel2.getText();
    jLabel2.setText(getValue+ " :"+fordFulkerson(graph,s,t));
                


                    /*    int s=a,t=b;
        Ford_Fulkerson ff=new Ford_Fulkerson();
        ///ff.fordFulkerson(graph,s,t);
    
    String getValue=jLabel2.getText();
    jLabel2.setText(getValue+ " :"+ff.fordFulkerson(int,s,t));
   */ 
   }
 
    public ArrayList < User > userList() { //hoitese na kn? :(
    ArrayList<User> userList=new ArrayList<>();
   
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
        String query1="SELECT * FROM `graph_capacity`";
       // PreparedStatement ps=con.prepareStatement("SELECT * FROM `graph_capacity`",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       
        
Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(query1);
       
        User user;
        while(rs.next()){//
            user=new User(rs.getInt("id"),rs.getInt("onetotwo"),rs.getInt("onetothree"),rs.getInt("twotothree"),rs.getInt("twotofour"),rs.getInt("threetotwo"),rs.getInt("threetofive"),rs.getInt("fourtothree"),rs.getInt("fourtosix"),rs.getInt("fivetofour"),rs.getInt("fivetosix"));
            userList.add(user);
        }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
    return userList;
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Number Of Passenger");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 200, 470, 120);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Click Here To Book");
        jButton1.setActionCommand("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(290, 370, 190, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(820, 380, 110, 31);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeherunNesaShraboni\\Downloads\\43222337274_07356f9f24_o.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       dispose();
        Book ai=new Book();
        ai.setLocationRelativeTo(null);
        ai.setVisible(true);
        
      // t.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         dispose();
        MainForm ai=new MainForm();
        ai.setLocationRelativeTo(null);
        ai.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Max_Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Max_Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Max_Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Max_Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable()); {
            @Override
            public void run() {
         */ 
                Max_Passenger mx=new Max_Passenger(int a,int b);
                mx.setVisible(true);
    //new Max_Passenger(int,int).setVisible(true);
 
            
            }
        //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

