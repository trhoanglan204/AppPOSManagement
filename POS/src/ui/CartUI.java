package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import model.POSController;
import model.POSFactory;
import model.dto.*;
import raven.glasspanepopup.GlassPanePopup;
import ui.components.*;

public class CartUI extends javax.swing.JPanel {

    private POSController controller;
    private ArrayList<ProductDTO> productsList;
    private ArrayList<CustomerDTO> customersList;
    private int initialDiscount = 0;
    SaleDTO sale;
    /**
     * Creates new form SalesUI
     * @param controller
     */
    public CartUI(POSController controller) {
        this.controller = controller;
        initComponents();
        populateProductsData();
        customersList = this.controller.getCustomers(new Response());
        updateTableDataIntoCustomers(customersList);
        
        sale=new SaleDTO();
        productsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    handleRowSelection();
                }
            }
        });
        initializeCart();
        populateDataIntoCustomers();
        searchHandlerProducts();
        searchHandlerCustomers();
    }
    
    private void searchHandlerCustomers(){
        searchCustomerByName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Handle text insertion
                customersList=controller.searchCustomersByName(searchCustomerByName.getText(),new Response());
        updateTableDataIntoCustomers(customersList);
        
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Handle text removal
                 customersList=controller.searchCustomersByName(searchCustomerByName.getText(),new Response());
        updateTableDataIntoCustomers(customersList);
        
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Handle change in attributes (unlikely for text fields)
            }
        });
    }
    private void searchHandlerProducts(){
        searchByname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Handle text insertion
                handleSearchTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Handle text removal
                handleSearchTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Handle change in attributes (unlikely for text fields)
            }
        });
    }

    private void handleSearchTextChanged() {
        String searchText = searchByname.getText();
        if (!searchText.isEmpty()) {
            Response res = POSFactory.getInstanceOfResponse();
            productsList = controller.searchProductsByName(searchText, res);
             updateProductsTableData(productsList);
        } else {
            // If search field is empty, show all categories
            populateProductsData();
        }
    }

    private void initializeCart() {
        String[] columnNames = {"Name", "Price", "Quantity", "Total"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        cartTable.setModel(defaultTableModel);
    }

    private void updateProductsTableData(ArrayList<ProductDTO> searchResults) {
        String[] columnNames = {"Name", "Price", "Stock"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (ProductDTO product : searchResults) {
            Object[] rowData = {product.getProductName(),
                product.getPrice(), (int)product.getStockQuantity()};
            defaultTableModel.addRow(rowData);
        }
        productsTable.setModel(defaultTableModel);
    }

    private void updateTableDataIntoCustomers(ArrayList<CustomerDTO> searchResults) {
        String[] columnNames =  {"Name","Phone No"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (CustomerDTO customer : searchResults) {
            Object[] rowData = { customer.getName(),customer.getPhoneNumber()};
            defaultTableModel.addRow(rowData);
        }
        customerTable.setModel(defaultTableModel);
    }

    private void handleRowSelection() {
        int rowIndex = productsTable.getSelectedRow();

        if (rowIndex != -1) {
            // Handle what ever you want
        } else {
            // Handle the case where no row is selected
            // You might want to clear or handle the fields accordingly
        }
    }

    private void populateProductsData() {
        Response res = POSFactory.getInstanceOfResponse();
        productsList = controller.getProducts(res);

        String[] columnNames = {"Name", "Price", "Stock"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (ProductDTO product : productsList) {
            Object[] rowData = {product.getProductName(), product.getPrice(), product.getStockQuantity()};
            defaultTableModel.addRow(rowData);
        }
        productsTable.setModel(defaultTableModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        cartList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new rojerusan.RSTableMetro();
        PanelSaleItem = new javax.swing.JPanel();
        SaleItemText = new javax.swing.JLabel();
        PanelRemove = new javax.swing.JPanel();
        removeItem = new ui.components.Button();
        productList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new rojerusan.RSTableMetro();
        SearchPanel = new javax.swing.JPanel();
        SearchText = new javax.swing.JLabel();
        searchByname = new javax.swing.JTextField();
        PanelQuantity = new javax.swing.JPanel();
        addToCartBtn = new ui.components.Button();
        quantity = new javax.swing.JTextField();
        QuantityText = new javax.swing.JLabel();
        controls = new javax.swing.JPanel();
        create_invoice = new javax.swing.JButton();
        PayBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TotalAmountPanel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DiscountPanel = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerTable = new rojerusan.RSTableMetro();
        searchCustomerByName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PaidAmountPanel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PendingAmountPanel = new javax.swing.JTextField();
        footer = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(102, 102, 102));
        header.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Process Sale");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(24, 24, 24))
        );

        jPanel2.add(header, java.awt.BorderLayout.NORTH);

        cartList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.setAltoHead(20);
        cartTable.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        cartTable.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        cartTable.setColorBordeHead(new java.awt.Color(255, 0, 51));
        cartTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        cartTable.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        cartTable.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        cartTable.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        cartTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cartTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(cartTable);

        PanelSaleItem.setBackground(new java.awt.Color(153, 153, 153));
        PanelSaleItem.setForeground(new java.awt.Color(255, 255, 255));

        SaleItemText.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        SaleItemText.setForeground(new java.awt.Color(255, 255, 255));
        SaleItemText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaleItemText.setText("Sale Items");

        javax.swing.GroupLayout PanelSaleItemLayout = new javax.swing.GroupLayout(PanelSaleItem);
        PanelSaleItem.setLayout(PanelSaleItemLayout);
        PanelSaleItemLayout.setHorizontalGroup(
            PanelSaleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SaleItemText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSaleItemLayout.setVerticalGroup(
            PanelSaleItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSaleItemLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(SaleItemText)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        PanelRemove.setBackground(new java.awt.Color(204, 204, 204));
        PanelRemove.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelRemove.setForeground(new java.awt.Color(255, 255, 255));

        removeItem.setForeground(new java.awt.Color(255, 0, 51));
        removeItem.setText("Remove Item");
        removeItem.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRemoveLayout = new javax.swing.GroupLayout(PanelRemove);
        PanelRemove.setLayout(PanelRemoveLayout);
        PanelRemoveLayout.setHorizontalGroup(
            PanelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRemoveLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        PanelRemoveLayout.setVerticalGroup(
            PanelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRemoveLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cartListLayout = new javax.swing.GroupLayout(cartList);
        cartList.setLayout(cartListLayout);
        cartListLayout.setHorizontalGroup(
            cartListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addComponent(PanelSaleItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cartListLayout.setVerticalGroup(
            cartListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartListLayout.createSequentialGroup()
                .addComponent(PanelSaleItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        productList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        productsTable.setAltoHead(20);
        productsTable.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        productsTable.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        productsTable.setColorBordeHead(new java.awt.Color(255, 0, 51));
        productsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        productsTable.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        productsTable.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        productsTable.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        productsTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        productsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productsTable);

        SearchPanel.setBackground(new java.awt.Color(153, 153, 153));
        SearchPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SearchText.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        SearchText.setForeground(new java.awt.Color(255, 255, 255));
        SearchText.setText("Search  By Name :");

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(SearchText)
                .addGap(26, 26, 26)
                .addComponent(searchByname, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchText)
                    .addComponent(searchByname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        PanelQuantity.setBackground(new java.awt.Color(204, 204, 204));
        PanelQuantity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelQuantity.setForeground(new java.awt.Color(255, 255, 255));

        addToCartBtn.setForeground(new java.awt.Color(255, 0, 51));
        addToCartBtn.setText("Add to Cart");
        addToCartBtn.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        quantity.setText("1");

        QuantityText.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        QuantityText.setForeground(new java.awt.Color(255, 255, 255));
        QuantityText.setText("Quantity:");

        javax.swing.GroupLayout PanelQuantityLayout = new javax.swing.GroupLayout(PanelQuantity);
        PanelQuantity.setLayout(PanelQuantityLayout);
        PanelQuantityLayout.setHorizontalGroup(
            PanelQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelQuantityLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(QuantityText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelQuantityLayout.setVerticalGroup(
            PanelQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQuantityLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(PanelQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityText)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout productListLayout = new javax.swing.GroupLayout(productList);
        productList.setLayout(productListLayout);
        productListLayout.setHorizontalGroup(
            productListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productListLayout.setVerticalGroup(
            productListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productListLayout.createSequentialGroup()
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        controls.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        create_invoice.setText("create invoice");
        create_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_invoiceActionPerformed(evt);
            }
        });

        PayBtn.setText("Pay");
        PayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PayBtnMouseReleased(evt);
            }
        });

        jLabel6.setText("Total:");

        TotalAmountPanel.setText("0");

        jLabel7.setText("Discount:");

        DiscountPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DiscountPanelMouseClicked(evt);
            }
        });

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.setAltoHead(20);
        customerTable.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        customerTable.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        customerTable.setColorBordeHead(new java.awt.Color(255, 0, 51));
        customerTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        customerTable.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        customerTable.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        customerTable.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        customerTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        customerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(customerTable);

        searchCustomerByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCustomerByNameKeyPressed(evt);
            }
        });

        jLabel8.setText("Search Customer");

        jLabel3.setText("Paid Amount:");

        PaidAmountPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaidAmountPanelMouseClicked(evt);
            }
        });

        jLabel10.setText("Pending Amount:");

        javax.swing.GroupLayout controlsLayout = new javax.swing.GroupLayout(controls);
        controls.setLayout(controlsLayout);
        controlsLayout.setHorizontalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlsLayout.createSequentialGroup()
                            .addComponent(create_invoice)
                            .addGap(18, 18, 18)
                            .addComponent(PayBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(controlsLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TotalAmountPanel))
                                .addGroup(controlsLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DiscountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchCustomerByName))
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PaidAmountPanel)
                            .addComponent(PendingAmountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlsLayout.setVerticalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PaidAmountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PendingAmountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCustomerByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(DiscountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TotalAmountPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_invoice)
                    .addComponent(PayBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addComponent(productList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cartList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(body, java.awt.BorderLayout.CENTER);

        footer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1103, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(footer, java.awt.BorderLayout.SOUTH);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
        int selectedRowIndex = productsTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            ProductDTO selectedProduct = productsList.get(selectedRowIndex);
            DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
            Object[] rowData = {selectedProduct.getProductName(), selectedProduct.getPrice(), quantity.getText(), selectedProduct.getPrice() * Integer.parseInt(quantity.getText())};
            cartTableModel.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        calculateTotal();
        productsTable.clearSelection();
    }//GEN-LAST:event_addToCartBtnActionPerformed
    private void calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < cartTable.getRowCount(); i++) {
            // Extract price and quantity of each item
            double totalPrice = Double.parseDouble(cartTable.getValueAt(i, 3).toString());
            total += totalPrice;
            if (initialDiscount != 0){
                total -= initialDiscount;   
            }
        }
        TotalAmountPanel.setText(String.valueOf(total));
    }
    private void create_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_invoiceActionPerformed
        // TODO add your handling code here:
        int rowIndex=customerTable.getSelectedRow();
        if(rowIndex == -1){
            Response res = new Response();
            res.messagesList.add(new Message("Please select a customer to create invoice.",MessageType.Error));
            CommonHandler.handleResponse(res);
            return;
        }
        CustomerDTO customer=customersList.get(rowIndex);
        sale.setCustomer(customer);
        StringBuilder invoice = new StringBuilder();
        invoice.append("--------------------------------------------------------------\n");
        invoice.append("|                          INVOICE                           |\n");
        invoice.append("--------------------------------------------------------------\n\n");

        // Add invoice details
        invoice.append("Invoice Number: ").append(generateInvoiceNumber()).append("\n");
        invoice.append("Date: ").append(getCurrentDateTime()).append("\n");
        invoice.append("Customer: ").append(sale.getCustomer().getName()).append("\n\n"); // You can replace [Customer Name] with actual customer name

        // Add table header
        invoice.append(String.format("| %-30s | %-10s | %-10s | %-10s |\n", "Product Name", "Quantity", "Unit Price", "Total Price"));
        invoice.append("--------------------------------------------------------------\n");

        // Iterate over each row in the cart table to add product details to the invoice
        for (int i = 0; i < cartTable.getRowCount(); i++) {
            String productName = cartTable.getValueAt(i, 0).toString();
            String quantity = cartTable.getValueAt(i, 2).toString();
            String unitPrice = cartTable.getValueAt(i, 1).toString();
            double totalUnitPrice = Double.parseDouble(unitPrice) * Double.parseDouble(quantity);
            invoice.append(String.format("| %-30s | %-10s | %-10s | %-10s |\n", productName, quantity, unitPrice, totalUnitPrice));
        }

        // Add total to the invoice
        invoice.append("--------------------------------------------------------------\n");
        invoice.append(String.format("| %-50s | %-10s |\n", "Total:", TotalAmountPanel.getText()));
        invoice.append("--------------------------------------------------------------\n");

        // Display the invoice
        JOptionPane.showMessageDialog(this, "<html><pre>" + invoice.toString() + "</pre></html>", "Invoice", JOptionPane.INFORMATION_MESSAGE);

        // Optionally, you can reset the cart after creating the invoice
        resetCart();
        customerTable.clearSelection();
    }//GEN-LAST:event_create_invoiceActionPerformed

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = cartTable.getSelectedRow();
        // Check if a row is selected
        if (selectedRowIndex == -1){
            Response res = new Response();
            res.messagesList.add(new Message("Please select a item before click remove",MessageType.Error));
            CommonHandler.handleResponse(res);
            return;
        }
        DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
        cartTableModel.removeRow(selectedRowIndex);
        calculateTotal();
    }//GEN-LAST:event_removeItemActionPerformed

    private void searchCustomerByNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerByNameKeyPressed
        // TODO add your handling code here:
        customersList=this.controller.searchCustomersByName(searchCustomerByName.getText(),new Response());
        this.updateTableDataIntoCustomers(customersList);
    }//GEN-LAST:event_searchCustomerByNameKeyPressed

    private void PayBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PayBtnMouseReleased
        // TODO add your handling code here:
        try {
            double paid = Double.parseDouble(PaidAmountPanel.getText());
            double total = Double.parseDouble(TotalAmountPanel.getText());
            if (total == 0){
                Response res = new Response();
                res.messagesList.add(new Message("There is no item need to pay",MessageType.Error));
                CommonHandler.handleResponse(res);
                return;
            }
            if (paid < total) {
                Response res = new Response();
                res.messagesList.add(new Message("Paid amount is less than total. Please collect enough payment",MessageType.Error));
                CommonHandler.handleResponse(res);
                return;
            }
            double change = paid - total;
            String qrContent = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"; //replace with your qrcode payment method
            PendingAmountPanel.setText(String.format("%.2f", change));
            QR qrFrame = new QR(qrContent);
            qrFrame.setVisible(true);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            Response res = new Response();
            res.messagesList.add(new Message("Paid amount is less than total. Please collect enough payment",MessageType.Error));
            CommonHandler.handleResponse(res);
            return;
        }
    }//GEN-LAST:event_PayBtnMouseReleased

    private void PaidAmountPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaidAmountPanelMouseClicked
        // TODO add your handling code here:
        int result = NumericKeyPad.showNumericKeyPad(PaidAmountPanel);
    
        if (result >=0 ) {
            PaidAmountPanel.setText(String.valueOf(result)); // Get numeric result
            try {
                double paid = Double.parseDouble(PaidAmountPanel.getText());
                double total = Double.parseDouble(TotalAmountPanel.getText());
                double pending = paid - total;
                PendingAmountPanel.setText(String.format("%.2f", pending));
            }
            catch (NumberFormatException e){
                PaidAmountPanel.setText("Invalid");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_PaidAmountPanelMouseClicked

    private void DiscountPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DiscountPanelMouseClicked
        // TODO add your handling code here:
        int result = NumericKeyPad.showNumericKeyPad(DiscountPanel);
    
        if (result >= 0) {
            DiscountPanel.setText(String.valueOf(result)); // Get numeric result
            try{
                initialDiscount = Integer.parseInt(DiscountPanel.getText());
                calculateTotal();
            }
            catch (NumberFormatException ex) {
                DiscountPanel.setText("Invalid");
                ex.fillInStackTrace();
            }
        }
    }//GEN-LAST:event_DiscountPanelMouseClicked
    
    private String generateInvoiceNumber() {
        // Generate a random invoice number or use a sequence generator
        return "INV-" + Math.round(Math.random() * 10000);
    }

    private String getCurrentDateTime() {
        // Get the current date and time in a desired format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        return now.format(formatter);
    }

    private void resetCart() {
        DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
        cartTableModel.setRowCount(0); // Clear cart table
        TotalAmountPanel.setText("0"); // Reset total
        DiscountPanel.setText("0");// Reset discount
        initialDiscount = 0; //reinit
    }

    private void populateDataIntoCustomers() {
        Response res = POSFactory.getInstanceOfResponse();

        String[] columnNames = {"Name", "Phone No"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        customersList=controller.getCustomers(res);
        for (CustomerDTO customer : customersList) {
            Object[] rowData = {customer.getName(), customer.getPhoneNumber()};
            defaultTableModel.addRow(rowData);
        }
        customerTable.setModel(defaultTableModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DiscountPanel;
    private javax.swing.JTextField PaidAmountPanel;
    private javax.swing.JPanel PanelQuantity;
    private javax.swing.JPanel PanelRemove;
    private javax.swing.JPanel PanelSaleItem;
    private javax.swing.JButton PayBtn;
    private javax.swing.JTextField PendingAmountPanel;
    private javax.swing.JLabel QuantityText;
    private javax.swing.JLabel SaleItemText;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JLabel SearchText;
    private javax.swing.JLabel TotalAmountPanel;
    private ui.components.Button addToCartBtn;
    private javax.swing.JPanel body;
    private javax.swing.JPanel cartList;
    private rojerusan.RSTableMetro cartTable;
    private javax.swing.JPanel controls;
    private javax.swing.JButton create_invoice;
    private rojerusan.RSTableMetro customerTable;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel productList;
    private rojerusan.RSTableMetro productsTable;
    private javax.swing.JTextField quantity;
    private ui.components.Button removeItem;
    private javax.swing.JTextField searchByname;
    private javax.swing.JTextField searchCustomerByName;
    // End of variables declaration//GEN-END:variables
}
