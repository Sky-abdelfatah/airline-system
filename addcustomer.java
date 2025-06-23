/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public   class addcustomer  extends JFrame implements ActionListener {
    
    JTextField tfname,tfnationality,tfnum,tfaddress;
    JRadioButton rbmale,rbfemale;
   public addcustomer(){
       getContentPane().setBackground(new Color(255, 182, 193));
       setLayout(null);
       
       
       
       JLabel  heading =new JLabel("ADD CUSTOMER DETAILS");
       heading.setBounds(230, 20, 500, 35);
       heading.setFont(new Font("Tahoma",Font.PLAIN,32));
       heading .setForeground(Color.WHITE);
       add(heading);
       
       
       JLabel  lblname =new JLabel("name");
       lblname.setBounds(60, 80, 150, 25);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblname .setForeground(Color.WHITE);
       add(lblname);
       
        tfname=new JTextField();
       tfname.setBounds(220, 80, 150, 25);
       add(tfname);
       
       
       
       JLabel  lblnationality =new JLabel("nationality");
       lblnationality.setBounds(60, 130, 150, 25);
       lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblnationality .setForeground(Color.WHITE);
       add(lblnationality);
       
       tfnationality=new JTextField();
       tfnationality.setBounds(220, 130, 150, 25);
       add(tfnationality);
       
       JLabel  lblnum =new JLabel("number");
       lblnum.setBounds(60, 180, 150, 25);
       lblnum.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblnum .setForeground(Color.WHITE);
       add(lblnum);
       
      tfnum=new JTextField();
       tfnum.setBounds(220, 180, 150, 25);
       add(tfnum);
       
       
       
       JLabel  lbladdress =new JLabel("address");
       lbladdress.setBounds(60, 230, 150, 25);
       lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
       lbladdress .setForeground(Color.WHITE);
       add(lbladdress);
       
        tfaddress=new JTextField();
       tfaddress.setBounds(220, 230, 150, 25);
       add(tfaddress);
       
       JLabel  lblgender =new JLabel("Gender");
       lblgender.setBounds(60, 280, 150, 25);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblgender .setForeground(Color.WHITE);
       add(lblgender);
       ButtonGroup gendergroup = new ButtonGroup();
       
        rbmale=new  JRadioButton("male");
       rbmale.setBounds(220, 280, 70, 25);
       rbmale.setBackground(new Color(255, 192, 203));
       rbmale.setForeground(Color.WHITE);
       add(rbmale);
       
       rbfemale=new  JRadioButton("female");
       rbfemale.setBounds(300, 280, 70, 25);
       rbfemale.setBackground(new Color(255, 192, 203));
       rbfemale.setForeground(Color.WHITE);
       add(rbfemale);
       gendergroup.add(rbmale);
       gendergroup.add(rbfemale);
       
       JButton save = new JButton("save");
       save .setBackground(new Color(231, 84, 128));
       save.setForeground(Color.WHITE);
       save.setBounds(220, 330, 150, 30);
       save.addActionListener(this);
       add(save);
       ImageIcon image = new  ImageIcon(ClassLoader.getSystemResource("airline/icon/50.jpg"));
       
       JLabel lblimage = new JLabel(image);
       lblimage.setBounds(450, 80, 280, 300);
       add(lblimage);
       
       
   setSize(900,500);
   setLocation(300,150);
   setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       String name = tfname.getText();
       String nationality = tfnationality.getText();
       String num = tfnum.getText();
       String address = tfaddress.getText();
       String gender = null;
       if(rbmale.isSelected()){gender="male";} else {gender="female";}
       
       try{conn conn = new conn();
       String query ="insert into passenger values('"+name+"','"+nationality+"','"+num+"','"+address+"','"+gender+"')";
       
       conn.s.executeUpdate(query);
       JOptionPane.showMessageDialog(null, "customer details added successfully");
       setVisible(false);}
       catch(Exception e){e.printStackTrace();}
   }

public static void main (String[] args){
new addcustomer();
}
}