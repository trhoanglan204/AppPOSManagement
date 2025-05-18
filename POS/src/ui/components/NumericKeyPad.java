/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author crow
 */
public class NumericKeyPad extends JPanel implements KeyListener {
    private JLabel displayNumberPanel;
    private StringBuilder input = new StringBuilder();

    public NumericKeyPad() {
        initComponents();
        setFocusable(true);
        addKeyListener(this);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Number Display (Right-Aligned)
        displayNumberPanel = new JLabel("0", SwingConstants.RIGHT);
        displayNumberPanel.setFont(new Font("Tahoma", Font.BOLD, 24));
        displayNumberPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        displayNumberPanel.setVisible(true);
        add(displayNumberPanel, BorderLayout.NORTH);

        // Button Grid Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        
        String[] keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "<", "0", "OK"};
        for (String key : keys) {
            JButton button = createButton(key);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Tahoma", Font.BOLD, 18));
        button.addActionListener(e ->handleButtonPress(label));
        return button;
    }

    private void handleButtonPress(String key) {
        if (key.equals("<") && input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        } else if (key.equals("OK")) {
            SwingUtilities.getWindowAncestor(this).dispose(); // Close UI
        } else {
            input.append(key);
        }
        updateDisplay();
    }

    private void updateDisplay() {
        String formattedNumber = String.format("%d", Integer.parseInt(input.length() > 0 ? input.toString() : "0"));
        displayNumberPanel.setText(formattedNumber);
    }

    private int getEnteredNumber() {
        return input.length() > 0 ? Integer.parseInt(input.toString()) : 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isDigit(key)) {
            input.append(key);
        } else if (key == KeyEvent.VK_BACK_SPACE && input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        } else if (key == KeyEvent.VK_ENTER) {
            SwingUtilities.getWindowAncestor(this).dispose(); // Close UI
        }
        updateDisplay();
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static int showNumericKeyPad(Component parent) {
        Frame frame = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
        JDialog dialog = new JDialog(frame, "Enter Amount", true);
        NumericKeyPad keypad = new NumericKeyPad();
        SwingUtilities.invokeLater(() -> keypad.requestFocusInWindow()); // Ensure focus after showing

        dialog.setLayout(new BorderLayout());
        dialog.add(keypad, BorderLayout.CENTER);
        dialog.setSize(300, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        return keypad.getEnteredNumber();
    }

    
}
