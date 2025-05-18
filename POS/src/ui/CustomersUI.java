package ui;

import ui.components.CommonHandler;
import java.util.ArrayList;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import model.POSController;
import model.POSFactory;
import model.dto.*;
import ui.components.AddUpdateCustomerDialog;

public class CustomersUI extends javax.swing.JPanel {

    private POSController controller;
    private ArrayList<CustomerDTO> customersList;

    /**
     *
     * @param controller
     */
    public CustomersUI(POSController controller) {
        initComponents();
        this.controller = controller;
        populateData();
        rSTableMetro1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    handleRowSelection();
                    System.out.println( e.toString());
                }
            }
        });
    }

    private void updateTableData(ArrayList<CustomerDTO> customers) {
        DefaultTableModel model = (DefaultTableModel) rSTableMetro1.getModel();
        model.setRowCount(0); // Clear the existing table data

        for (CustomerDTO customer : customers) {
            Object[] rowData = {customer.getId(), customer.getName(), customer.getPhoneNumber()};
            model.addRow(rowData);
        }
        rSTableMetro1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        jPanel3 = new javax.swing.JPanel();
        searchByName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        saveCustomer = new ui.components.Button();
        delete = new ui.components.Button();
        update = new ui.components.Button();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        rSTableMetro1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "PhoneNo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        rSTableMetro1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(rSTableMetro1);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(1).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        searchByName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        searchByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchByNameKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setText("Search by Name:");

        saveCustomer.setBackground(new java.awt.Color(255, 0, 51));
        saveCustomer.setForeground(new java.awt.Color(255, 255, 255));
        saveCustomer.setText("Add");
        saveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCustomerActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 0, 51));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 0, 51));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(saveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(searchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Information");
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void saveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCustomerActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddUpdateCustomerDialog d = new AddUpdateCustomerDialog(parentFrame, "Add Customer");
        d.setVisible(true);
        if (d.isSaveClicked()){
            CustomerDTO customer = d.getCustomer();
            Response res = this.controller.saveCustomer(customer);
            if (res.isSuccessfull()) {
                searchByName.setText("");
                populateData();
            }
            CommonHandler.handleResponse(res);

        }
    }//GEN-LAST:event_saveCustomerActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int rowIndex = rSTableMetro1.getSelectedRow();
        if (rowIndex == -1){
            Response res = new Response();
            res.messagesList.add(new Message("Please select a customer to delete.",MessageType.Error));
            CommonHandler.handleResponse(res);
            return;
        }
        CustomerDTO c = new CustomerDTO();
        c = this.customersList.get(rowIndex);
        Response res = this.controller.deleteCustomer(c);

        if (res.isSuccessfull()) {
            clear();
        }
        CommonHandler.handleResponse(res);
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int rowIndex = rSTableMetro1.getSelectedRow();
        if (rowIndex == -1){
            Response res = new Response();
            res.messagesList.add(new Message("Please select a customer to edit.",MessageType.Error));
            CommonHandler.handleResponse(res);
            return;
        }
        CustomerDTO customer = this.customersList.get(rowIndex);
       
        customer.setName((String)rSTableMetro1.getValueAt(rowIndex,1));
        customer.setPhoneNumber((String) rSTableMetro1.getValueAt(rowIndex, 2));
        
        Response response = this.controller.updateCustomer(customer);
        if (response.isSuccessfull()) {
            clear();
        }
        CommonHandler.handleResponse(response);
    }//GEN-LAST:event_updateActionPerformed

    private void clear(){
        searchByName.setText("");
        populateData();
    }
    
    private void searchByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchByNameKeyReleased
        updateSearchResults(); //dynamic search
    }//GEN-LAST:event_searchByNameKeyReleased

    private CustomerDTO initialCustomerData = null;
    
    private void updateSearchResults() {
        String searchText = searchByName.getText();
        Response res = POSFactory.getInstanceOfResponse();
        customersList = controller.searchCustomersByName(searchText, res);
        updateTableData(customersList);
    }

    private void populateData() {
        Response res = POSFactory.getInstanceOfResponse();
        customersList = controller.getCustomers(res);
        
        String[] columnNames = {"Id", "Name", "Phone No"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (CustomerDTO customer : customersList) {
            Object[] rowData = {customer.getId(), customer.getName(), customer.getPhoneNumber()};
            defaultTableModel.addRow(rowData);
        }
        rSTableMetro1.setModel(defaultTableModel);
    }
    
    private void handleRowSelection() {
        int rowIndex = rSTableMetro1.getSelectedRow();

        if (rowIndex != -1) {
            initialCustomerData = this.customersList.get(rowIndex);
//            nameField.setText(c.getName());
//            phoneNoField.setText(c.getPhoneNumber());
        } else {
            // Handle the case where no row is selected
            // You might want to clear or handle the fields accordingly
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.Button delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro rSTableMetro1;
    private ui.components.Button saveCustomer;
    private javax.swing.JTextField searchByName;
    private ui.components.Button update;
    // End of variables declaration//GEN-END:variables
}
