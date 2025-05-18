package ui.components;

import javax.swing.*;
import java.awt.*;
import model.dto.CustomerDTO;

public class AddUpdateCustomerDialog extends JDialog{
    private JTextField nameField;
    private JTextField phoneField;
    private CustomerDTO customer;
    private boolean isSaveClicked = false; //track save btn was click
    
    //constructor Add
    public AddUpdateCustomerDialog(JFrame parent, String title) {
        super(parent, title, true);
        this.customer = new CustomerDTO();
        setupUI();
    }
    
    private void setupUI(){
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,10,10));
        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        if(customer.getName() != null){
            nameField.setText(customer.getName());//prepopulate if editing
        }
        panel.add(nameField);
        
        panel.add(new JLabel("Phone Number"));
        phoneField = new JTextField();
        if(customer.getPhoneNumber() != null){
            phoneField.setText(customer.getPhoneNumber());
        }
        panel.add(phoneField);
        
        add(panel, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        
        saveBtn.addActionListener(e -> onSave());
        cancelBtn.addActionListener(e -> onCancel());
        
        btnPanel.add(saveBtn);
        btnPanel.add(cancelBtn);
        
        add(btnPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
    
    public void onSave(){
        customer.setName(nameField.getText());
        customer.setPhoneNumber(phoneField.getText());
        
        isSaveClicked = true;
        dispose();
    }
    
    public void onCancel(){
        dispose();   
    }
    
    public CustomerDTO getCustomer() {
        return customer;
    }
    
    public boolean isSaveClicked(){
        return isSaveClicked;
    }
}
