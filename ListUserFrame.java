package view;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.User;
import service.UserService;

/**
 *
 * @author leanh
 */
public class ListUserFrame extends javax.swing.JFrame {

    UserService userService;
    DefaultTableModel defaultTableModel;

    public ListUserFrame() throws SQLException {
        initComponents();
        userService = new UserService();

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Ten");
        defaultTableModel.addColumn("So DT");
        defaultTableModel.addColumn("Tai khoan");
        defaultTableModel.addColumn("Mat khau");
        defaultTableModel.addColumn("Vai tro");
        defaultTableModel.addColumn("So thich");
        defaultTableModel.addColumn("Gioi thieu");

        setTableData(userService.getAllUsers());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButtonUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButtonUser.setText("Them moi");
        addButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonUserActionPerformed(evt);
            }
        });

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        userTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(userTable);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xoa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editUserButton.setText("Sua");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(addButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(editUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButtonUser)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(editUserButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setTableData(List<User> users) {
        for (User user : users) {
            defaultTableModel.addRow(new Object[]{user.getId(), user.getName(), user.getPhone(), user.getUsername(), user.getPassword(), user.getRole(), user.getFavourites(), user.getAbout()});
        }
    }
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            defaultTableModel.setRowCount(0);
            setTableData(userService.getAllUsers());
        } catch (SQLException ex) {
            Logger.getLogger(ListUserFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void addButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonUserActionPerformed
        new AddUserFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addButtonUserActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ListUserFrame.this, "Vui long chon user truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(ListUserFrame.this, "Ban chac chan muon xoa khong?");

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int userId = Integer.valueOf(String.valueOf(userTable.getValueAt(row, 0)));
                    userService.deleteUser(userId);

                    defaultTableModel.setRowCount(0);
                    setTableData(userService.getAllUsers());
                } catch (SQLException ex) {
                    Logger.getLogger(ListUserFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void userTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_userTableAncestorAdded

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ListUserFrame.this, "Vui long chon user truoc", "Loi", JOptionPane.ERROR_MESSAGE);
        }  else {
            int userId = Integer.valueOf(String.valueOf(userTable.getValueAt(row, 0)));
            new EditUserFrame().setVisible(true);
            this.dispose();
        }            
    }//GEN-LAST:event_editUserButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ListUserFrame().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ListUserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButtonUser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
