/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3clasesjava;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author friosa
 */
public class AnaLex7TokensApp extends javax.swing.JFrame {
    Lexico anaLex = new Lexico();
    SintDescNRP anaSintNRP = new SintDescNRP();
    /**
     * Creates new form AnaLex7TokensApp
     */
    
      public AnaLex7TokensApp() {
        initComponents();
        this.setSize(800, 600);
        
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaProgFuente = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblParejasTL = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAnaSin = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LyA II");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("PROGRAMA FUENTE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(24, 50, 136, 17);

        txaProgFuente.setColumns(20);
        txaProgFuente.setRows(5);
        jScrollPane1.setViewportView(txaProgFuente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(24, 73, 349, 320);

        tblParejasTL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOKENS", "LEXEMAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblParejasTL);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(390, 70, 370, 320);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PAREJAS TOKENS-LEXEMAS ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(390, 50, 200, 17);

        btnAnaSin.setLabel("Análisis Sintáctico");
        btnAnaSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaSinActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnaSin);
        btnAnaSin.setBounds(300, 430, 150, 30);

        lblResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblResult.setText("Resultado del Análisis Sintáctico");
        getContentPane().add(lblResult);
        lblResult.setBounds(60, 440, 200, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnaSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaSinActionPerformed
        anaLex.Inicia();
        if(anaLex.Analiza(txaProgFuente.getText())) {
            anaSintNRP.Inicia();
            switch(anaSintNRP.Analiza(anaLex)) {
                case 1: 
                    lblResult.setText("Syntax Error");
                    break;
                case 2:
                    lblResult.setText("Syntax Error");
                    break;
                case 0:
                    lblResult.setText("Análisis exitoso");
                    break;
            }
        } else {
            lblResult.setText("Lexical error");
        }
        DefaultTableModel modelo = (DefaultTableModel) tblParejasTL.getModel();
        modelo.setRowCount(0);
        for(int i=0;i<anaLex.NoTokens();i++) {
            Object o[] = {anaLex.Tokens()[i],anaLex.Lexemas()[i]};
            modelo.addRow(o);
        }
        
    }//GEN-LAST:event_btnAnaSinActionPerformed

    
    
   
    
    //PARTE DE btnDIActionPerformed
    
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
            java.util.logging.Logger.getLogger(AnaLex7TokensApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaLex7TokensApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaLex7TokensApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaLex7TokensApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaLex7TokensApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tblParejasTL;
    private javax.swing.JTextArea txaProgFuente;
    // End of variables declaration//GEN-END:variables

    private void caracter(String[] Lexemas, int i) {
        if(Lexemas[i].length()>3){
                         //Si su longitud es mayor que tres, es que tenemos un octal.
                         //o hexadecimal
                        String tex = Lexemas[i].substring(1,Lexemas[i].length()-1);
                        int k=0;
                        if(tex.charAt(1)=='x'){
                            //Si tiene una x, es hexadecimal y tomamos todo, desde
                                //después de la x (por ello el substring(2), toma toda
                                //la cadena desde el indice dos hasta el final), 
                                //
                                //el 16, para usar el sistema hexadecimal.
                            k = Integer.parseInt(tex.substring(2),16);
                            //O también puede ser que tenga una h al final, para.
                                //Aplica lo mismo
                        }else if(tex.charAt(tex.length()-1)=='h'){
                            k = Integer.parseInt(tex.substring(0,tex.length()-1),16);
                        }else
                            //Aquí llegamos si es un octal. Por suerte, la clase
                            //Integer con su parse se encarga de esto.
                            try{
                            k = Integer.parseInt(tex,8);}catch(NumberFormatException e){
                                System.out.println("Introduce un caracter valido"+e.getMessage());
                            }
                        //char c = 1;
                        //Lo convertimos a char para almacenarlo
                        char c = (char)k;
                        Lexemas[i] = Character.toString(c);
                    }
    }
}
