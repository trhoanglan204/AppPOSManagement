package ui;

import java.awt.event.*;
import model.POSController;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import model.POSFactory;
import model.dto.*;
import ui.components.CommonHandler;

public class ProductUI extends javax.swing.JPanel {

    private POSController controller;
    ArrayList<ProductDTO> productsList;

    public ProductUI(POSController controller) {
        initComponents();
        this.controller = controller;
        loadDataIntoSupplierCheckBox();
        loadDataIntoCategoryCheckBox();
        loadDataIntojComboBox1();
        populateData();
        // Add document listener to search field
        searchByNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components don't fire these events
            }

            private void performSearch() {
                String searchName = searchByNameField.getText();
                if (!searchName.isEmpty()) {
                    Response res = POSFactory.getInstanceOfResponse();
                    productsList= controller.searchProductsByName(searchName, res);
                    updateTableData(productsList);
                } else {
                    // If search field is empty, show all products
                    populateData();
                }
            }
        });

        rSTableMetro1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                int row = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());

                for (ProductDTO p : productsList) {
                    if (id == p.getProductId()) {
                        name.setText(p.getProductName());
                        stock.setText(String.valueOf(p.getStockQuantity()));
                        price.setText(String.valueOf(p.getPrice()));
                        barcode.setText(p.getBarcode());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelMain = new javax.swing.JPanel();
        table = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        headerPanel = new javax.swing.JPanel();
        supplierDD = new javax.swing.JComboBox<>();
        HeaderDisplay = new javax.swing.JLabel();
        CategoryDisplay = new javax.swing.JLabel();
        SupplierDisplay = new javax.swing.JLabel();
        categoryDD = new javax.swing.JComboBox<>();
        BarcodeDisplay = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        NameDisplay = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        PriceDisplay = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        StockDisplay = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        QuantityTypeDisplay = new javax.swing.JLabel();
        quantitytype = new javax.swing.JComboBox<>();
        searchByNameField = new javax.swing.JTextField();
        SearchByNameDisplay = new javax.swing.JLabel();
        clear = new ui.components.Button();
        update = new ui.components.Button();
        add = new ui.components.Button();
        delete = new ui.components.Button();

        setLayout(new java.awt.BorderLayout());

        PanelMain.setLayout(new java.awt.BorderLayout());

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
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
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        table.setViewportView(rSTableMetro1);

        PanelMain.add(table, java.awt.BorderLayout.PAGE_END);

        headerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        headerPanel.setLayout(new java.awt.GridBagLayout());

        supplierDD.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        supplierDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierDDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 53;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 56;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 3);
        headerPanel.add(supplierDD, gridBagConstraints);

        HeaderDisplay.setBackground(new java.awt.Color(255, 0, 51));
        HeaderDisplay.setFont(new java.awt.Font("SansSerif", 1, 21)); // NOI18N
        HeaderDisplay.setForeground(new java.awt.Color(255, 0, 51));
        HeaderDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderDisplay.setText("Product Information");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 55;
        gridBagConstraints.ipadx = 597;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        headerPanel.add(HeaderDisplay, gridBagConstraints);

        CategoryDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        CategoryDisplay.setText("Category");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 39;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 27, 0, 0);
        headerPanel.add(CategoryDisplay, gridBagConstraints);

        SupplierDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        SupplierDisplay.setText("Supplier");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 52;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 0, 0);
        headerPanel.add(SupplierDisplay, gridBagConstraints);

        categoryDD.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        categoryDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 28, 0, 0);
        headerPanel.add(categoryDD, gridBagConstraints);

        BarcodeDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        BarcodeDisplay.setText("Barcode");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 0, 0);
        headerPanel.add(BarcodeDisplay, gridBagConstraints);

        barcode.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 20, 0, 0);
        headerPanel.add(barcode, gridBagConstraints);

        NameDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        NameDisplay.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 52, 0, 0);
        headerPanel.add(NameDisplay, gridBagConstraints);

        name.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        name.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        headerPanel.add(name, gridBagConstraints);

        PriceDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        PriceDisplay.setText("Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 52, 0, 0);
        headerPanel.add(PriceDisplay, gridBagConstraints);

        price.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        headerPanel.add(price, gridBagConstraints);

        StockDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        StockDisplay.setText("Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 39;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 27, 0, 0);
        headerPanel.add(StockDisplay, gridBagConstraints);

        stock.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 28, 0, 0);
        headerPanel.add(stock, gridBagConstraints);

        QuantityTypeDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        QuantityTypeDisplay.setText("Quantity Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 0, 0);
        headerPanel.add(QuantityTypeDisplay, gridBagConstraints);

        quantitytype.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        quantitytype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        headerPanel.add(quantitytype, gridBagConstraints);

        searchByNameField.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 52;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 27, 0, 0);
        headerPanel.add(searchByNameField, gridBagConstraints);

        SearchByNameDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        SearchByNameDisplay.setText("Search by name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 51;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 16, 0, 0);
        headerPanel.add(SearchByNameDisplay, gridBagConstraints);

        clear.setBackground(new java.awt.Color(255, 0, 51));
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_26px.png"))); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 18, 2, 0);
        headerPanel.add(clear, gridBagConstraints);

        update.setBackground(new java.awt.Color(255, 0, 51));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_26px.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 18, 2, 0);
        headerPanel.add(update, gridBagConstraints);

        add.setBackground(new java.awt.Color(255, 0, 51));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_26px.png"))); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 65, 2, 0);
        headerPanel.add(add, gridBagConstraints);

        delete.setBackground(new java.awt.Color(255, 0, 51));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_26px.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 11, 2, 0);
        headerPanel.add(delete, gridBagConstraints);

        PanelMain.add(headerPanel, java.awt.BorderLayout.CENTER);

        add(PanelMain, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void supplierDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierDDActionPerformed

    private void categoryDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryDDActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        name.setText("");
        barcode.setText("");
        stock.setText("");
        price.setText("");
        searchByNameField.setText("");

        // Set the default selection in dropdowns
        supplierDD.setSelectedIndex(0);
        categoryDD.setSelectedIndex(0);
        quantitytype.setSelectedIndex(0);

        // Refresh the table data to display all products
        populateData();
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:                                    
        int selectedRow = rSTableMetro1.getSelectedRow();
        if (selectedRow == -1) {
            Response res = new Response();
            res.messagesList.add(new Message("Please select a customer to delete.",MessageType.Error));
            CommonHandler.handleResponse(res);
            return;
        }

        ProductDTO selectedProduct = productsList.get(selectedRow); // Get the selected ProductDTO from the list

        // Update the selected product with the new values from the input fields
        selectedProduct.setCategoryId(controller.getCategoryByName((String) categoryDD.getSelectedItem()).getId());
        selectedProduct.setSupplierId(controller.getSupplierByName((String) supplierDD.getSelectedItem()).getId());
        selectedProduct.setBarcode(barcode.getText());
        selectedProduct.setPrice(Double.parseDouble(price.getText()));
        selectedProduct.setQuantityType((String) quantitytype.getSelectedItem());
        selectedProduct.setProductName(name.getText());
        selectedProduct.setStockQuantity(Double.parseDouble(stock.getText()));

        // Call the controller to update the product in the database
        Response res = controller.updateProduct(selectedProduct);
        CommonHandler.handleResponse(res);
        if (res.isSuccessfull()) {
            // Update the table data to reflect the changes
            populateData();
        }
    }//GEN-LAST:event_updateActionPerformed


    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        if (name.getText().isEmpty() || barcode.getText().isEmpty() || price.getText().isEmpty() ||
                stock.getText().isEmpty() || supplierDD.getSelectedItem() == null || categoryDD.getSelectedItem() == null) { 
            Response res = new Response();
            res.messagesList.add(new Message("Please fill all required fields.",MessageType.Warning));
            CommonHandler.handleResponse((res));
            return;   
        }
        try{
            ProductDTO product = new ProductDTO();
            product.setCategoryId(this.controller.getCategoryByName((String) this.categoryDD.getSelectedItem()).getId());
            product.setSupplierId(this.controller.getSupplierByName((String) this.supplierDD.getSelectedItem()).getId());
            product.setBarcode(barcode.getText());
            product.setPrice(Double.parseDouble(price.getText()));

            product.setQuantityType((String) quantitytype.getSelectedItem());
            product.setProductName(name.getText());
            product.setStockQuantity(Double.parseDouble(stock.getText()));
            Response res = this.controller.addProduct(product);
            CommonHandler.handleResponse(res);
            if (res.isSuccessfull()) {
                populateData();
            }
        }
        catch (NumberFormatException ex) {
            price.setText("Invalid");
            stock.setText("Invalid");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        // Get the selected row index from the table
        int selectedRowIndex = rSTableMetro1.getSelectedRow();
        if (selectedRowIndex == -1){
            Response res = new Response();
            res.messagesList.add(new Message("Please select at least 1 item.",MessageType.Warning));
            CommonHandler.handleResponse((res));
            return; 
        }
        // Get the product ID from the selected row
        int productId = Integer.parseInt(rSTableMetro1.getValueAt(selectedRowIndex, 0).toString());

        // Call the method to delete the product
        ProductDTO p = new ProductDTO();
        p.setProductId(productId);
        Response response = controller.deleteProduct(p);

        CommonHandler.handleResponse(response);
        // Check if the deletion was successful
        if (response.isSuccessfull()) {
            // Refresh the table data
            populateData();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateTableData(ArrayList<ProductDTO> searchResults) {
        String[] columnNames = {"Id", "Name", "Bar Code", "Price", "Stock"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (ProductDTO product : searchResults) {
            Object[] rowData = {product.getProductId(), product.getProductName(), product.getBarcode(),
                product.getPrice(), product.getStockQuantity()};
            defaultTableModel.addRow(rowData);
        }
        rSTableMetro1.setModel(defaultTableModel);
    }

    private void populateData() {
        Response res = POSFactory.getInstanceOfResponse();
        productsList = controller.getProducts(res);
        String[] columnNames = {"Id", "Name", "Bar Code", "Price", "Stock"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (ProductDTO product : productsList) {
            Object[] rowData = {product.getProductId(), product.getProductName(), product.getBarcode(), product.getPrice(), product.getStockQuantity()};
            defaultTableModel.addRow(rowData);
        }
        rSTableMetro1.setModel(defaultTableModel);
    }

    private void loadDataIntoSupplierCheckBox() {
        Response r = new Response();
        ArrayList<SupplierDTO> lis = this.controller.getSuppliers(r);

        ArrayList<String> names = new ArrayList<>();
        for (SupplierDTO supplier : lis) {
            names.add(supplier.getName());
        }

        ComboBoxModel<String> model = new DefaultComboBoxModel<>(names.toArray(new String[0]));

        supplierDD.setModel(model);
    }

    private void loadDataIntoCategoryCheckBox() {
        Response r = new Response();
        ArrayList<CategoryDTO> lis = this.controller.getCategories(r);

        ArrayList<String> names = new ArrayList<>();
        for (CategoryDTO cat : lis) {
            names.add(cat.getName());
        }

        ComboBoxModel<String> model = new DefaultComboBoxModel<>(names.toArray(new String[0]));

        categoryDD.setModel(model);
    }

    private void loadDataIntojComboBox1() {

        ArrayList<String> names = new ArrayList<>();
        names.add("counted");
        names.add("weighted");

        ComboBoxModel<String> model = new DefaultComboBoxModel<>(names.toArray(new String[0]));

        quantitytype.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarcodeDisplay;
    private javax.swing.JLabel CategoryDisplay;
    private javax.swing.JLabel HeaderDisplay;
    private javax.swing.JLabel NameDisplay;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JLabel PriceDisplay;
    private javax.swing.JLabel QuantityTypeDisplay;
    private javax.swing.JLabel SearchByNameDisplay;
    private javax.swing.JLabel StockDisplay;
    private javax.swing.JLabel SupplierDisplay;
    private ui.components.Button add;
    private javax.swing.JTextField barcode;
    private javax.swing.JComboBox<String> categoryDD;
    private ui.components.Button clear;
    private ui.components.Button delete;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JComboBox<String> quantitytype;
    private rojerusan.RSTableMetro rSTableMetro1;
    private javax.swing.JTextField searchByNameField;
    private javax.swing.JTextField stock;
    private javax.swing.JComboBox<String> supplierDD;
    private javax.swing.JScrollPane table;
    private ui.components.Button update;
    // End of variables declaration//GEN-END:variables
}
