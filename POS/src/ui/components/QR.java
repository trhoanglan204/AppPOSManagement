/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import com.google.zxing.*;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author crow
 */
public class QR extends JFrame {
    public QR(String content){
        setTitle("QR Code");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout());
        JLabel qrLabel = new JLabel("",SwingConstants.CENTER);
        // I hate coding java on Net Bean, doesn't have intelligence to suggest function powerful and fast like in VS
        qrLabel.setIcon(new ImageIcon(generateQRImage(content, 250, 250)));
        
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,20));
        panel.add(qrLabel, BorderLayout.CENTER);
        panel.add(closeBtn, BorderLayout.SOUTH);
        
        add(panel);
    }
    
     private Image generateQRImage(String text, int width, int height) {
        QRCodeWriter qrWriter = new QRCodeWriter();
        try {
            BitMatrix matrix = qrWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, matrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }
            return image;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
