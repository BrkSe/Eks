/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekspackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkıtbay.com
 */
@ManagedBean(name="clientlist")
@RequestScoped
public class clientlist {

    PreparedStatement ps = null;
    Connection con = null;

    public List<Uyeler> getUyelerTablosu() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");//Bağlantı
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        ps = con.prepareStatement("SELECT * FROM uye_kayit");
        ResultSet rs = ps.executeQuery();
        
        List<Uyeler> liste = new ArrayList<Uyeler>();//Sonuçlar Listeye Eklenecek
        
        while (rs.next())//Kayıtları döndür ve listeye ekle
        {
            Uyeler ekle = new Uyeler();
           ekle.setUserID(rs.getInt("UserID"));
           ekle.setAdi(rs.getString("Adi"));
           ekle.setSoyadi(rs.getString("Soyadi"));
           ekle.setEmail(rs.getString("Email"));
           
            liste.add(ekle);
        }
        System.out.print(rs);
        return liste; //Listeyi döndür
    }
    
}
