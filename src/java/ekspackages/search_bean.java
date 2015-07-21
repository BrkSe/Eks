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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hasanburakkutbay
 *
 */
@ManagedBean(name = "search_bean")
public class search_bean {

    String aramakriteri;
    PreparedStatement ps = null;
    Connection con = null;

    public String getAramakriteri() {
        return aramakriteri;
    }

    public void setAramakriteri(String aramakriteri) {
        this.aramakriteri = aramakriteri;
    }

    public List<Sonuclar> getSonuclarTablosu() throws ClassNotFoundException, SQLException {

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
//Bunun yapılacak çok işi var be gülüm
 /*   public String veriTabanindaara() throws ClassNotFoundException, SQLException { //Sayfadan girilen verileri veri tabanına gönderem metot.
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
     Statement s = con.createStatement();
     try (ResultSet r = s.executeQuery("SELECT * FROM donanim_kayit WHERE '" + aramakriteri + "'='" + arama + "'")) {
     r.next();
     say = r.getInt(1);
     } catch (SQLException x) {
     System.out.println(x);
     }
     return say;
     }
     */
}
