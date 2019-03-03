/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchvalera;

import java.awt.Font;

/**
 *
 * @author remai
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     * @param time
     */
    public MainWindow(double time[]) {
        initComponents();
        jTable1.getTableHeader().setFont( new Font("Tahoma", Font.PLAIN, 18) ) ;
        jTable2.getTableHeader().setFont( new Font("Tahoma", Font.PLAIN, 18) ) ;
        
        for (int i = 0; i <4; i++) {
            jTable1.setValueAt( time[i], 2, i+1 );
        }
        
        jTable2.setValueAt( time[01] / 4.000427489 , 2, 1);
        jTable2.setValueAt( time[1] / 0.924923943 , 2, 2);
        jTable2.setValueAt( time[2] / 19.92191575 , 2, 3);
        jTable2.setValueAt( time[3] / 4.1929000319379774 , 2, 4);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Benchmark");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"First computer",  new Double(1.457471746),  new Double(2.610622951),  new Double(3.627755365),  new Double(2.3988003106724323)},
                {"Second computer",  new Double(4.000427489),  new Double(0.924923943),  new Double(19.92191575),  new Double(4.1929000319379774)},
                {"Your computer", null, null, null, null}
            },
            new String [] {
                "", "first benchmark, sec", "second benchmark, sec", "third benchmark, sec", "index, sec"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"First computer",  new Double(0.364329),  new Double(2.822527161),  new Double(0.18209872),  new Double(0.5721100652055603)},
                {"Second computer",  new Double(1.0),  new Double(1.0),  new Double(1.0),  new Double(1.0)},
                {"Your computer", null, null, null, null}
            },
            new String [] {
                "", "first benchmark", "second benchmark", "third benchmark", "index"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setRowHeight(35);
        jTable2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
