/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasprakpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static uasprakpbo.GUILogin.conn;

/**
 *
 * @author marti
 */
public class GUIGame {
    private JFrame frame;
    private JPanel panel;
    private JButton btntransaksi;
    private JLabel nameGame;
    private JLabel genreGame;
    private JLabel priceGame;
    private JButton buyGame;
    private JTextField fieldName;
    private JTextField fieldGenre;
    private JTextField fieldPrice;
    private Games game;
    private Transactions transaksi;
    private Users user;
    private GUILogin gui1;
    static DatabaseHandler conn = new DatabaseHandler();

    public GUIGame(){
        frame = new JFrame("Game List");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        btntransaksi = new JButton("Transactions");
        btntransaksi.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(btntransaksi,new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        
        
        
        nameGame = new JLabel("Name");
        nameGame.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(nameGame,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,70, -1, -1));
        
        fieldName = new JTextField();
        panel.add(fieldName,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,100, 300, 20));
        
        genreGame = new JLabel("Genre");
        genreGame.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(genreGame,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,130, -1, -1));
        
        fieldGenre = new JTextField();
        panel.add(fieldGenre,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,160, 300, 20));
        
        priceGame = new JLabel("Price");
        priceGame.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        panel.add(priceGame,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,190, -1, -1));
        
        fieldPrice = new JTextField();
        panel.add(fieldPrice,new org.netbeans.lib.awtextra.AbsoluteConstraints(30,220, 300, 20));
        
        
        buyGame = new JButton("Buy Game");
        buyGame.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                conn.connect();
                getData();
                String query = "INSERT INTO transactions VALUES(?,?,?)";
                try {
                    PreparedStatement stmt = conn.con.prepareStatement(query);
                    stmt.setInt(1, transaksi.getId());
                    stmt.setInt(2, game.getId());
                    stmt.setInt(3, user.getId());
                    stmt.executeUpdate();
                    conn.disconnect();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    conn.disconnect();
                    System.out.println("Success");
                }
            }
        });
        panel.add(buyGame,new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        
        frame.add(panel);
        frame.setVisible(true);
    }
    public Games getData(){
        conn.connect();
        String query = "SELECT * FROM games WHERE name='" + fieldName.getText() + "'";
        Games g;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {


                g = new Games(rs.getInt("id"),rs.getString("name"),rs.getString("genre"),rs.getInt("price"));
                return g;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        new GUIGame();
    }
}
