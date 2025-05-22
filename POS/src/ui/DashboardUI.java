package ui;

import model.POSController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import raven.glasspanepopup.GlassPanePopup;

public class DashboardUI extends javax.swing.JFrame {

    private POSController controller;
    private FocusEvent evt;

    public DashboardUI(POSController controller) {
        this.controller = controller;
        initComponents();
         
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the JFrame to full size
        setResizable(false); // Make the JFrame non-resizable
        mainPanel.removeAll();
        mainPanel.add(new CustomersUI(this.controller), BorderLayout.CENTER);
        customerBtnFocusGained(this.evt);
        mainPanel.validate();
        username.setText(POSController.objApplicationSession.getUser().getUsername());
        GlassPanePopup.install(this);
        this.setMinimumSize(this.getSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogoutBtn = new ui.components.Button();
        username = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        menuPanel = new javax.swing.JScrollPane();
        sidebarPanel = new javax.swing.JPanel();
        supplierBtn = new javax.swing.JButton();
        employeeBtn = new javax.swing.JButton();
        productBtn = new javax.swing.JButton();
        customerBtn = new javax.swing.JButton();
        reportsBtn = new javax.swing.JButton();
        invoiceBtn = new javax.swing.JButton();
        saleBtn = new javax.swing.JButton();
        categoryBtn = new javax.swing.JButton();
        ContributeBtn = new javax.swing.JButton();
        SettingBtn = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POS Dashboard KMA");
        setUndecorated(true);
        setResizable(false);

        headerPanel.setBackground(new java.awt.Color(117, 117, 117));
        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_menu_48px_1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Point of Sale");

        LogoutBtn.setBackground(new java.awt.Color(204, 204, 0));
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/male_user_25px.png"))); // NOI18N
        username.setText("username");

        close.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("x");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 740, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(username)
                        .addGap(18, 18, 18)
                        .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addComponent(close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Menu))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(close)
                        .addGap(11, 11, 11)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        sidebarPanel.setBackground(new java.awt.Color(255, 102, 102));
        sidebarPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        supplierBtn.setBackground(new java.awt.Color(255, 0, 51));
        supplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_property_24px.png"))); // NOI18N
        supplierBtn.setText("Supplier");
        supplierBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                supplierBtnFocusGained(evt);
            }
        });
        supplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBtnActionPerformed(evt);
            }
        });

        employeeBtn.setBackground(new java.awt.Color(255, 0, 51));
        employeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/google_forms_24px.png"))); // NOI18N
        employeeBtn.setText("Employees");
        employeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeBtnFocusGained(evt);
            }
        });
        employeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeBtnActionPerformed(evt);
            }
        });

        productBtn.setBackground(new java.awt.Color(255, 0, 51));
        productBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_property_24px.png"))); // NOI18N
        productBtn.setText("Products");
        productBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productBtnFocusGained(evt);
            }
        });
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });

        customerBtn.setBackground(new java.awt.Color(255, 0, 51));
        customerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_user_group_woman_man_24px.png"))); // NOI18N
        customerBtn.setText("Customers");
        customerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerBtnFocusGained(evt);
            }
        });
        customerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBtnActionPerformed(evt);
            }
        });

        reportsBtn.setBackground(new java.awt.Color(255, 0, 51));
        reportsBtn.setText("Reports");
        reportsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                reportsBtnFocusGained(evt);
            }
        });
        reportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsBtnActionPerformed(evt);
            }
        });

        invoiceBtn.setBackground(new java.awt.Color(255, 0, 51));
        invoiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/categorize_24px.png"))); // NOI18N
        invoiceBtn.setText("Invoice");
        invoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invoiceBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                invoiceBtnFocusGained(evt);
            }
        });
        invoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceBtnActionPerformed(evt);
            }
        });

        saleBtn.setBackground(new java.awt.Color(255, 0, 51));
        saleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping_cart_24px.png"))); // NOI18N
        saleBtn.setText("Sales");
        saleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saleBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                saleBtnFocusGained(evt);
            }
        });
        saleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleBtnActionPerformed(evt);
            }
        });

        categoryBtn.setBackground(new java.awt.Color(255, 0, 51));
        categoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_property_24px.png"))); // NOI18N
        categoryBtn.setText("Category");
        categoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categoryBtnFocusGained(evt);
            }
        });
        categoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBtnActionPerformed(evt);
            }
        });

        ContributeBtn.setBackground(new java.awt.Color(255, 0, 51));
        ContributeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/account_24px.png"))); // NOI18N
        ContributeBtn.setText("KPI");
        ContributeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContributeBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ContributeBtnFocusGained(evt);
            }
        });
        ContributeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContributeBtnActionPerformed(evt);
            }
        });

        SettingBtn.setBackground(new java.awt.Color(255, 0, 51));
        SettingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings-icon.png"))); // NOI18N
        SettingBtn.setText("Setting");
        SettingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SettingBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SettingBtnFocusGained(evt);
            }
        });
        SettingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SettingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoiceBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(supplierBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContributeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(customerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(categoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(ContributeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SettingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuPanel.setViewportView(sidebarPanel);

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
        controller.expireSession();
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        controller.expireSession();
    }//GEN-LAST:event_closeMouseClicked

    private void categoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new CategoryUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_categoryBtnActionPerformed

    private void categoryBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoryBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        categoryBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_categoryBtnFocusGained

    private void saleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new CartUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_saleBtnActionPerformed

    private void saleBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saleBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        saleBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_saleBtnFocusGained

    private void invoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new InvoiceUI(), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_invoiceBtnActionPerformed

    private void invoiceBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invoiceBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        invoiceBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_invoiceBtnFocusGained

    private void reportsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new ReportsUI(), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_reportsBtnActionPerformed

    private void reportsBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reportsBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        reportsBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_reportsBtnFocusGained

    private void customerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new CustomersUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_customerBtnActionPerformed

    private void customerBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        customerBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_customerBtnFocusGained

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new ProductUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_productBtnActionPerformed

    private void productBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        productBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_productBtnFocusGained

    private void employeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new EmployeeUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_employeeBtnActionPerformed

    private void employeeBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        employeeBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_employeeBtnFocusGained

    private void supplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new SupplierUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_supplierBtnActionPerformed

    private void supplierBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplierBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        supplierBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_supplierBtnFocusGained

    private void ContributeBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContributeBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        ContributeBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_ContributeBtnFocusGained

    private void ContributeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContributeBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new KPI_UI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_ContributeBtnActionPerformed

    private void SettingBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SettingBtnFocusGained
        // TODO add your handling code here:
        allBtnFocusLost();
        SettingBtn.setBackground(Color.ORANGE);
    }//GEN-LAST:event_SettingBtnFocusGained

    private void SettingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new UserUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_SettingBtnActionPerformed

    private void allBtnFocusLost(){
        supplierBtn.setBackground(new Color(255, 0, 51));
        reportsBtn.setBackground(new Color(255, 0, 51));
        invoiceBtn.setBackground(new Color(255, 0, 51));
        saleBtn.setBackground(new Color(255, 0, 51));
        categoryBtn.setBackground(new Color(255, 0, 51));
        productBtn.setBackground(new Color(255, 0, 51));
        employeeBtn.setBackground(new Color(255, 0, 51));
        customerBtn.setBackground(new Color(255, 0, 51));
        ContributeBtn.setBackground(new Color(255, 0, 51));
        SettingBtn.setBackground(new Color(255, 0, 51));
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContributeBtn;
    private ui.components.Button LogoutBtn;
    private javax.swing.JLabel Menu;
    private javax.swing.JButton SettingBtn;
    private javax.swing.JButton categoryBtn;
    private javax.swing.JLabel close;
    private javax.swing.JButton customerBtn;
    private javax.swing.JButton employeeBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton invoiceBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane menuPanel;
    private javax.swing.JButton productBtn;
    private javax.swing.JButton reportsBtn;
    private javax.swing.JButton saleBtn;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JButton supplierBtn;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    
}
