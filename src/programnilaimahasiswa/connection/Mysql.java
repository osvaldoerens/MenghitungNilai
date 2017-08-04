/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programnilaimahasiswa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Mysql {
     private static Connection kon;
    public static Connection getKoneksi(){
        if(kon == null){
            try{
                String url = "jdbc:mysql://localhost/hitungdb";
                String username = "userti";
                String passwprd = "passti";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                kon=DriverManager.getConnection(url,username,passwprd);
            }catch(SQLException x){
                JOptionPane.showMessageDialog(null,"Gagal Koneksi !!"+x.getMessage());
            }
        }
        return kon;
        
    }
    
}
