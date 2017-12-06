package myhashtable;

import java.io.File;
import java.util.Map;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends javax.swing.JFrame {

    private OpenAdressTable table;
    private Files files;
    private JFileChooser openClose;
    private AddElementDialog dialog;
    
    public MyFrame() {
        initComponents();
        table = new OpenAdressTable();
        files = new Files();
        openClose = new JFileChooser(new File("."));
        this.setBounds(10, 10, 800, 500);
        dialog = new AddElementDialog(this, true);
        dialog.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butCleanFields = new javax.swing.JButton();
        butGetValue = new javax.swing.JButton();
        butDelByKey = new javax.swing.JButton();
        textKey = new javax.swing.JTextField();
        textValue = new javax.swing.JTextField();
        inputKey = new javax.swing.JLabel();
        resultValue = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuOpenTable = new javax.swing.JMenuItem();
        menuSaveTable = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuAdd = new javax.swing.JMenuItem();
        menuClean = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenAddressHashTable");
        setBounds(new java.awt.Rectangle(100, 10, 0, 0));
        setResizable(false);

        butCleanFields.setText("Clean all fields");
        butCleanFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCleanFieldsActionPerformed(evt);
            }
        });

        butGetValue.setText("Get Value");
        butGetValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGetValueActionPerformed(evt);
            }
        });

        butDelByKey.setText("Delete by key");
        butDelByKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDelByKeyActionPerformed(evt);
            }
        });

        textKey.setBackground(new java.awt.Color(255, 153, 153));
        textKey.setText(" ");

        textValue.setEditable(false);
        textValue.setBackground(new java.awt.Color(204, 255, 204));
        textValue.setText(" ");

        inputKey.setText("Give me a key");

        resultValue.setText("Result value");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "HashCode", "[index]", "Key", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.setRowHeight(25);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        fileMenu.setText("File");

        menuOpenTable.setText("OpenTable");
        menuOpenTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenTableActionPerformed(evt);
            }
        });
        fileMenu.add(menuOpenTable);

        menuSaveTable.setText("SaveTable");
        menuSaveTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveTableActionPerformed(evt);
            }
        });
        fileMenu.add(menuSaveTable);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        fileMenu.add(menuExit);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        menuAdd.setText("Add");
        menuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddActionPerformed(evt);
            }
        });
        editMenu.add(menuAdd);

        menuClean.setText("Clean");
        menuClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCleanActionPerformed(evt);
            }
        });
        editMenu.add(menuClean);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(butGetValue)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(butDelByKey))
                            .addComponent(textValue, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(inputKey))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(butCleanFields)
                            .addComponent(textKey, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(resultValue)))
                .addContainerGap(1573, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(butCleanFields)
                        .addGap(46, 46, 46)
                        .addComponent(inputKey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butGetValue)
                            .addComponent(textValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butDelByKey))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuExitActionPerformed
   
    private void fillTable(String[][] str) {
        int dev = str.length - jTable1.getRowCount();
        if (dev > 0) {
            DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
            for (int i=0; i<dev; i++) 
                tableModel.addRow(new String[] {"", "", "", ""});
        }
        for (int i=0; i<str.length; i++) {
            for (int j=0; j<str[0].length; j++) {
                jTable1.setValueAt(str[i][j], i, j);
            }
        }
    }
    
    private void menuOpenTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenTableActionPerformed
        openClose.setDialogTitle("Choose .txt file with table");
        FileFilter filter = openClose.getFileFilter(); //получила фильтр All
        openClose.removeChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Text files (*.txt)", "txt");
        openClose.addChoosableFileFilter(filter);
        int n = openClose.showOpenDialog(this);
        if (n == JFileChooser.CANCEL_OPTION)
            return;
        File file = openClose.getSelectedFile();
        Map map = files.reading(file.getPath());
        table.putAll(map);
        fillTable(table.printGUI());
    }//GEN-LAST:event_menuOpenTableActionPerformed

    private void menuSaveTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveTableActionPerformed
        openClose.setDialogTitle("Choose .txt file for saving");
        FileFilter filter = openClose.getFileFilter(); //получила фильтр All
        openClose.removeChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Text files (*.txt)", "txt");
        openClose.addChoosableFileFilter(filter);
        int n = openClose.showSaveDialog(this);
        if (n == JFileChooser.CANCEL_OPTION)
            return;
        File file = openClose.getSelectedFile();
        files.writing(table, file.getPath());
    }//GEN-LAST:event_menuSaveTableActionPerformed

    private void menuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddActionPerformed
        dialog.clearField();
        dialog.setVisible(true);
        if (!dialog.isOK())
            return;
        table.put(dialog.getKey(), dialog.getValue());
        fillTable(table.printGUI());
    }//GEN-LAST:event_menuAddActionPerformed

    private void menuCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCleanActionPerformed
        table.clear();
        fillTable(table.printGUI());
    }//GEN-LAST:event_menuCleanActionPerformed

    private void butCleanFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCleanFieldsActionPerformed
        textKey.setText("");
        textValue.setText("");
    }//GEN-LAST:event_butCleanFieldsActionPerformed

    private void butGetValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGetValueActionPerformed
        String key = textKey.getText();
        textValue.setText("");
        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Заполните ВСЕ поля!");
            return;
        }
        String value = (String)table.get(key);
        if (value == null) {
            JOptionPane.showMessageDialog(this, "Ключ не найден :с");
            return;
        }
        textValue.setText(value);
    }//GEN-LAST:event_butGetValueActionPerformed

    private void butDelByKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDelByKeyActionPerformed
        String key = textKey.getText();
        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введите ключ!");
            return;
        }
        table.remove(key);
        fillTable(table.printGUI());
        textKey.setText("");
    }//GEN-LAST:event_butDelByKeyActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCleanFields;
    private javax.swing.JButton butDelByKey;
    private javax.swing.JButton butGetValue;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel inputKey;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menuAdd;
    private javax.swing.JMenuItem menuClean;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuOpenTable;
    private javax.swing.JMenuItem menuSaveTable;
    private javax.swing.JLabel resultValue;
    private javax.swing.JTextField textKey;
    private javax.swing.JTextField textValue;
    // End of variables declaration//GEN-END:variables
}
