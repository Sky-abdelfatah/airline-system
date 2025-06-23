 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class home extends JFrame  implements ActionListener{


  public home(){
    setLayout(null);
    ImageIcon il= new ImageIcon(ClassLoader.getSystemResource("airline/icon/تنزيل.jpeg"));
    JLabel image=  new JLabel(il);
    image.setBounds(0, 0, 1600, 800);
    add(image);
    JLabel heading= new JLabel("SKY airline welcomes you");
    heading .setBounds(500, 20, 800, 100);
    heading.setForeground(Color.WHITE);
    heading.setFont(new Font("Georgia", Font.BOLD, 36));
    image.add(heading);
    JMenuBar menubar= new JMenuBar();
    setJMenuBar(menubar);
    JMenu details= new JMenu("details");
    menubar.add(details);
    JMenuItem flaightdetails= new JMenuItem("flight details");
    flaightdetails.addActionListener(this);
    details.add(flaightdetails);
    
    JMenuItem customerdetails= new JMenuItem("add customer details");
   customerdetails.addActionListener(this);
    details.add(customerdetails);
    
    
    JMenuItem bookflight= new JMenuItem("book flight");
    bookflight.addActionListener(this);
    details.add(bookflight);
    
     /*JMenuItem journeydetails= new JMenuItem("journey details");
    details.add(journeydetails);
    
     JMenuItem ticketcancellation= new JMenuItem("cancel ticket");
    details.add(ticketcancellation);
    
    
     JMenuItem ticket= new JMenuItem("ticket");
    menubar.add(ticket);
    
    
     JMenuItem boardingpass= new JMenuItem("boarding pass");
    ticket.add(boardingpass);*/
    
    
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    
setVisible(true);
}
public void actionPerformed(ActionEvent ae) { 
    String text = ae.getActionCommand(); 
    if (text.equals("add customer details")) { new addcustomer(); 
    } else if (text.equals("flight details")) 
    { new flightinfo(); 
    } else if (text.equals("book flight"))
    { new bookflight(); } }
    public static void main (String[] args){
       new home();
}
}        


