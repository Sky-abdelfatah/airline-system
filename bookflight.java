package airline;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;

public class bookflight extends JFrame implements ActionListener {
    JTextField tfname;
    JLabel tfnum, tfnationality, tfaddress, labelgender, lblf_name_display, lblf_code_display, lbldate;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    
    public bookflight() {
        getContentPane().setBackground(new Color(255, 182, 193));
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(470, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.WHITE);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);

        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(new Color(231, 84, 128));
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.WHITE);
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 180, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladdress.setForeground(Color.WHITE);
        add(lbladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(220, 180, 150, 25);
        add(tfaddress);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 230, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setForeground(Color.WHITE);
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(220, 230, 150, 25);
        add(labelgender);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 280, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblsource.setForeground(Color.WHITE);
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 280, 150, 25);
        add(source);

        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 330, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldest.setForeground(Color.WHITE);
        add(lbldest);

        destination = new Choice();
        destination.setBounds(220, 330, 150, 25);
        add(destination);

        flight = new JButton("Fetch Flights");
        flight.setBackground(new Color(231, 84, 128));
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 325, 150, 30);
        flight.addActionListener(this);
        add(flight);

        try {
            conn c = new conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblf_name = new JLabel("Flight Name");
        lblf_name.setBounds(60, 380, 150, 25);
        lblf_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblf_name.setForeground(Color.WHITE);
        add(lblf_name);

        lblf_name_display = new JLabel();
        lblf_name_display.setBounds(220, 380, 150, 25);
        add(lblf_name_display);

        JLabel lblf_code = new JLabel("Flight Code");
        lblf_code.setBounds(60, 430, 150, 25);
        lblf_code.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblf_code.setForeground(Color.WHITE);
        add(lblf_code);

        lblf_code_display = new JLabel();
        lblf_code_display.setBounds(220, 430, 150, 25);
        add(lblf_code_display);

        lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 480, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldate.setForeground(Color.WHITE);
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 480, 150, 25);
        add(dcdate);

        bookflight = new JButton("Book Flight");
        bookflight.setBackground(new Color(231, 84, 128));
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 530, 150, 30);
        bookflight.addActionListener(this);
        add(bookflight);

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("airline/icon/b2.jpg"));
        Image l2 = l1.getImage().getScaledInstance(450, 600, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(l2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 100, 380, 430);
        add(lblimage);

        setSize(1100, 700);
        setLocation(160, 90);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String name = tfname.getText();
            try {
                conn conn = new conn();
                String query = "select * from passenger where name='" + name + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a correct name.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == flight){
        
            String src = source.getSelectedItem();
            String dest=destination.getSelectedItem();
            try {
                conn conn = new conn();
                String query = "select * from flight where source='" + src + "' and destination='" + dest + "' ";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    lblf_name_display.setText(rs.getString("f_name"));
                   lblf_code_display.setText(rs.getString("f_code"));
                   
                } else {
                    JOptionPane.showMessageDialog(null, "NO flight found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                
            }}
    }

    public static void main(String[] args) {
        new bookflight();
    }
}
