package ui.components;

import javax.swing.*;
import java.awt.*;
import model.dto.UserDTO;
import model.dto.UserDTO.SD_Role;

public class AddUpdateUserDialog extends JDialog{
    private JTextField nameField;
    private JComboBox<String> roleField;
    private JPasswordField passwordField;
    private UserDTO user;
    private boolean isSaveClicked = false; //track save btn was click
    
    //constructor Add
    public AddUpdateUserDialog(JFrame parent, String title) {
        super(parent, title, true);
        this.user = new UserDTO();
        setupUI();
    }
    
    private void setupUI(){
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,10,10));
        
        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        if(user.getUsername()!= null){
            nameField.setText(user.getUsername());//prepopulate if editing
        }
        panel.add(nameField);
        
        panel.add(new JLabel("Password"));
        passwordField = new JPasswordField();
        if(user.getUsername()!= null){
            passwordField.setText(user.getPassword());//prepopulate if editing
        }
        panel.add(passwordField);
        
        
        panel.add(new JLabel("Role"));
        roleField = new JComboBox<String>(SD_Role.getAllRoles());
        roleField.setSelectedItem(SD_Role.Cashier); //default
        panel.add(roleField);
        
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
        user.setUsername(nameField.getText());
        user.setRole(roleField.getSelectedItem().toString());
        user.setPassword(new String(passwordField.getPassword()));
        
        isSaveClicked = true;
        dispose();
    }
    
    public void onCancel(){
        dispose();   
    }
    
    public UserDTO getUser() {
        return user;
    }
    
    public boolean isSaveClicked(){
        return isSaveClicked;
    }
}
