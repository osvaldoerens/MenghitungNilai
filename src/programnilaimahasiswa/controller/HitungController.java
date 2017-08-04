/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programnilaimahasiswa.controller;

import java.sql.SQLException;
import programnilaimahasiswa.MenghitungNilai;

/**
 *
 * @author User
 */
public interface HitungController {
    public void Hitung(MenghitungNilai mn);
    public void Bersih(MenghitungNilai mn);
    public void Keluar(MenghitungNilai mn);
    public void Simpan(MenghitungNilai mn) throws SQLException;
    
    
}

