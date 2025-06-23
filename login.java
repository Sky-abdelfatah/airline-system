
package airline;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame  implements ActionListener{
JButton submit,reset,close;
JPasswordField tfpas;
JTextField tfusername;

    
    public login(){
    setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("airline/icon/401734734078.jpg"))));
    setLayout(null);
    JLabel lblusername = new JLabel("username");
    lblusername.setBounds(20, 20, 100, 20);
    lblusername.setFont(new Font("Arial", Font.BOLD, 16)); 
            lblusername.setForeground(new Color(0, 139, 139));
    add(lblusername);
    
    
     tfusername=new JTextField();
    tfusername.setBounds(130, 20, 200, 20);
    add(tfusername);
    
    JLabel lblpas = new JLabel("password");
    lblpas.setBounds(20, 80, 100, 20);
    lblpas.setFont(new Font("Arial", Font.BOLD, 16)); 
            lblpas.setForeground(new Color(0, 139, 139));
    add(lblpas);
    
    
     tfpas=new JPasswordField();
    tfpas.setBounds(130, 80, 200, 20);
    add(tfpas);
    
 reset =new JButton("reset");
    reset.setBounds(40, 120, 120, 20);
    reset.setBackground(new Color(255, 182, 193));
    reset.setForeground(new Color(0, 139, 139));
    reset.addActionListener(this);
    add(reset);
    
     submit =new JButton("submit");
    submit.setBounds(190, 120, 120, 20);
    submit.setBackground(new Color(255, 182, 193));
    submit.setForeground(new Color(0, 139, 139));
    submit.addActionListener(this);
    add(submit);
    
     close =new JButton("close");
    close.setBounds(120, 160, 120, 20);
    close.setBackground(new Color(255, 182, 193));
    close.setForeground(new Color(0, 139, 139));
    close.addActionListener(this);
    add(close);
    
    setLocation(600,250);
    setSize(400,250);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    if (ae.getSource()  == submit){
        String username = tfusername .getText();
        String password = tfpas.getText();
    try {
    conn c= new conn();
    String query =" select * from login where username='"+username+"' and password='"+password+"'";
     ResultSet rs =c.s.executeQuery(query);
     if(rs.next()){
         new home();
         setVisible(false);
     }
     else{
         JOptionPane.showMessageDialog(null,"invalid username or password");
         setVisible(false);
     }
    }catch (Exception e){
        e.printStackTrace();}
    }
    else if(ae.getSource()== close)
    {setVisible(false) ; }
    else if(ae.getSource()==reset){
        tfusername.setText("");
        tfpas.setText("");
}
}
    public static void main (String[] args){
       new login();
}
}        


