/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekspackages;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkıtbay.com
 */
@ManagedBean(name = "login_bean")
@SessionScoped
public class login_bean implements  Serializable{

    private String kullanici_adi;
    private String sifre;
    private String dbad;
    private String dbemail;
    private String dbsifre;

    Connection con;
    Statement ps;
    ResultSet rs;
    
    public void dbData(String UName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1");
            ps = con.createStatement();
            String SQL_Str = "Select * from uye_kayit where Email like ('" + UName + "')";
            rs = ps.executeQuery(SQL_Str);
            rs.next();
            dbad=rs.getString(2).toString();
            dbemail= rs.getString(4).toString();
            dbsifre = rs.getString(5).toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occur :" + ex);
        }
    }
     public String getAd() {
        return dbad;
    }

    public String getdbSifre() {
        return dbsifre;
    }

    public String getEmail() {
        return dbemail;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String checkValidUser() {
        dbData(kullanici_adi);

        if (kullanici_adi.equalsIgnoreCase(dbemail)) {

            if (sifre.equals(dbsifre)) {
                return "tamam";
            } else {
                return "invalid";
            }
        } else {
            return "invalid";
        }
    }
    public String getDbad() {
        return dbad;
    }

}
