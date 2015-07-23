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

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkutbay.com
 */
@ManagedBean(name = "search_bean")
public class search_bean {

    PreparedStatement ps = null;
    Connection con = null;
    String a1, a2;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }
    String aramakriteri, arama;

    public String getArama() {
        return arama;
    }

    public void setArama(String arama) {
        this.arama = arama;
    }

    public String getAramakriteri() {
        return aramakriteri;
    }

    public void setAramakriteri(String aramakriteri) {
        this.aramakriteri = aramakriteri;
    }

    public void veriAl() {
        a1 = arama;
        a2 = aramakriteri;
    }

    public List<Donanimlar> getSonuclarTablosu() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");//Bağlantı
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        ps = con.prepareStatement("SELECT * FROM donanim_kayit WHERE " + aramakriteri + " ='" + arama + "'");
        ResultSet rs = ps.executeQuery();

        List<Donanimlar> liste = new ArrayList<Donanimlar>();//Sonuçlar Listeye Eklenecek

        while (rs.next())//Kayıtları döndür ve listeye ekle
        {
            Donanimlar ekle = new Donanimlar();
            ekle.setKullaniciadsoyad(rs.getString(2));
            ekle.setBilgisayar_adi(rs.getString(3));
            ekle.setRam(rs.getString(4));
            ekle.setHarddisk(rs.getString(5));
            ekle.setEkran_karti(rs.getString(6));
            ekle.setOs(rs.getString(7));
            liste.add(ekle);
        }
        return liste; //Listeyi döndür
    }
}
