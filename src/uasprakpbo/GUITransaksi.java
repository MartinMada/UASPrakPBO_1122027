/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasprakpbo;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marti
 */
public class GUITransaksi {
    private JFrame frame;
    private JPanel panel;
    
    public GUITransaksi(){
        frame = new JFrame("Transaksi");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }
    
    public static void main(String[] args) {
        
    }
}
