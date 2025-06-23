 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

/**
 *
 * @author L
 */
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
    try{Class.forName("com.mysql.cj.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql:///airline", "root", "1234567890");
    s=c.createStatement();
    }catch(Exception e)
    {e.printStackTrace();
    }
    }
    
}
