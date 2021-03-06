/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Console.java
 *
 * Created on Jul 6, 2011, 6:25:05 AM
 */
package com.metaos.engine;

import java.io.*;
import javax.swing.*;

/**
 * Graphical console for restricted purposes.
 * 
 * @author l
 */
public class Console extends javax.swing.JFrame {

    //
    // Nested class
    //
    
    /**
     * Thread to write into graphical console output from Engine.
     * From: http://www.exampledepot.com/egs/javax.swing.text/ta_Console.html
     */
    class ReaderThread extends Thread {
        final PipedInputStream pi;
        final JTextArea textArea;

        ReaderThread(PipedInputStream pi, final JTextArea textArea) {
            this.pi = pi;
            this.textArea = textArea;
        }

        public void run() {
            final byte[] buf = new byte[1024];
            try {
                while (true) {
                    final int len = pi.read(buf);
                    if (len == -1) {
                        break;
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            textArea.append(new String(buf, 0, len));

                            // Make sure the last line is always visible
                            textArea.setCaretPosition(textArea.getDocument().getLength());

                            // Keep the text area down to a certain character size
                            int idealSize = 1000;
                            int maxExcess = 500;
                            int excess = textArea.getDocument().getLength() - idealSize;
                            if (excess >= maxExcess) {
                                textArea.replaceRange("", 0, excess);
                            }
                        }
                    });
                }
            } catch (IOException e) {
            }
        }
    }
    
    
    
    /** Creates new form Console */
    public Console() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        arg1 = new javax.swing.JTextField();
        scriptFileName1 = new javax.swing.JTextField();
        arg2 = new javax.swing.JTextField();
        arg3 = new javax.swing.JTextField();
        arg4 = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        primaryOutput = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        secondaryOutput = new javax.swing.JTextArea();
        outputFileName = new javax.swing.JTextField();
        sendOutputToFile = new javax.swing.JCheckBox();
        scriptFileName2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Script files:");

        arg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg1ActionPerformed(evt);
            }
        });

        scriptFileName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriptFileName1ActionPerformed(evt);
            }
        });

        arg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg2ActionPerformed(evt);
            }
        });

        arg3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg3ActionPerformed(evt);
            }
        });

        arg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg4ActionPerformed(evt);
            }
        });

        goButton.setText("Go!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        primaryOutput.setColumns(20);
        primaryOutput.setEditable(false);
        primaryOutput.setRows(5);
        jScrollPane1.setViewportView(primaryOutput);

        secondaryOutput.setColumns(20);
        secondaryOutput.setRows(5);
        jScrollPane2.setViewportView(secondaryOutput);

        sendOutputToFile.setText("Send output to file");
        sendOutputToFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendOutputToFileActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(scriptFileName1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                        .add(scriptFileName2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(goButton))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, arg2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, arg1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(arg3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .add(arg4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
                .add(20, 20, 20))
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(sendOutputToFile)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(outputFileName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 488, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(scriptFileName1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(goButton)
                    .add(scriptFileName2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(arg1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(arg3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(arg2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(arg4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(1, 1, 1)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(sendOutputToFile)
                    .add(outputFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arg1ActionPerformed

    private void arg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arg2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arg2ActionPerformed

    private void arg3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arg3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arg3ActionPerformed

    private void arg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arg4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arg4ActionPerformed

    private void sendOutputToFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendOutputToFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendOutputToFileActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        try {
            if(sendOutputToFile.isSelected()) {
                System.setOut(new PrintStream(
                        new File(outputFileName.getText())));
            } else {
                /* From 
                http://www.exampledepot.com/egs/javax.swing.text/ta_Console.html
                 */
                final PipedInputStream piOut = new PipedInputStream();
                final PipedOutputStream poOut = new PipedOutputStream(piOut);
                System.setOut(new PrintStream(poOut, true));

                // Create reader threads
                new ReaderThread(piOut, primaryOutput).start();
            }
            
            final String args[] = new String[4];
            args[0] = arg1.getText();
            args[1] = arg2.getText();
            args[2] = arg3.getText();
            args[3] = arg3.getText();
            final Engine engine = new Engine(
                    this.scriptFileName1.getText());
            engine.execute(this.scriptFileName2.getText(), args);
        } catch(IOException ioe) {
        }
    }//GEN-LAST:event_goButtonActionPerformed

    private void scriptFileName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriptFileName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scriptFileName1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Console().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arg1;
    private javax.swing.JTextField arg2;
    private javax.swing.JTextField arg3;
    private javax.swing.JTextField arg4;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField outputFileName;
    private javax.swing.JTextArea primaryOutput;
    private javax.swing.JTextField scriptFileName1;
    private javax.swing.JTextField scriptFileName2;
    private javax.swing.JTextArea secondaryOutput;
    private javax.swing.JCheckBox sendOutputToFile;
    // End of variables declaration//GEN-END:variables
}
