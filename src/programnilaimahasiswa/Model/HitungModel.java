/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programnilaimahasiswa.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import programnilaimahasiswa.MenghitungNilai;
import programnilaimahasiswa.connection.Mysql;
import programnilaimahasiswa.controller.HitungController;

/**
 *
 * @author User
 */
public class HitungModel implements HitungController {

    @Override
    public void Hitung(MenghitungNilai mn) {
     // String nama=mn.tfNama.getText();
      double nilaiAbsensi = Double.valueOf(mn.tfAbsensi.getText());
      double  nilaiUTS = Double.valueOf(mn.tfUTS.getText());
      double  nilaiUAS = Double.valueOf(mn.tfUAS.getText());
      
      double nilaiAkhir=nilaiAbsensi * 0.2+nilaiUTS * 0.3+nilaiUAS * 0.5;
      
      char grade =0;
      String Status = " ";
      
      if(nilaiAkhir>0&&nilaiAkhir<30){
          grade = 'E';
          Status = "Tidak Lulus";
          
      }else if (nilaiAkhir>=30&&nilaiAkhir<45){
          grade = 'D';
          Status = "Tidak Lulus";
          
      }else if (nilaiAkhir>=45&&nilaiAkhir<65){
          grade = 'C';
          Status = "Lulus";
       
      }else if (nilaiAkhir>=65&&nilaiAkhir<80){
          grade = 'B';
          Status = "Lulus";   
      }else if (nilaiAkhir>=80&&nilaiAkhir<100){
          grade = 'A';
          Status = "Lulus";
      }else {
          grade = 0;
      }
      mn.txtNama.setText(mn.tfNama.getText());
      mn.txtNilRat.setText(String.valueOf(nilaiAkhir));
      mn.txtGrade.setText(String.valueOf(grade));
      mn.txtStatus.setText(Status);
        disable(mn);
    }

    @Override
    public void Bersih(MenghitungNilai mn) {
        mn.tfNama.setText("");
        mn.tfUTS.setText("");
        mn.tfUAS.setText("");
        mn.tfAbsensi.setText("");
        }

    @Override
    public void Keluar(MenghitungNilai mn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void disable(MenghitungNilai mn){
        mn.txtNama.setEditable(false);
        mn.txtNilRat.setEditable(false);
        mn.txtStatus.setEditable(false);
        mn.txtGrade.setEditable(false);
        
    }

    @Override
    public void Simpan(MenghitungNilai mn) throws SQLException {
        Connection con = Mysql.getKoneksi();
        try{
        String Sql = "insert into hasil_hitung values(?,?,?,?,?,?,?);";
        PreparedStatement ps=con.prepareStatement(Sql);
        ps.setString(1, mn.txtNama.getText());
        ps.setString(2, mn.tfUTS.getText());
        ps.setString(3, mn.tfUAS.getText());
        ps.setString(4, mn.tfAbsensi.getText());
        ps.setString(5, mn.txtNilRat.getText());
        ps.setString(6, mn.txtGrade.getText());
        ps.setString(7, mn.txtStatus.getText());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Simpan Berhasil");
        ps.close();
        }catch(SQLException x){
           JOptionPane.showMessageDialog(null, "Simpan Gagal !" +x.getMessage()); 
        }
        
    }
    
    
}