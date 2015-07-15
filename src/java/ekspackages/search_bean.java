/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekspackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hasanburakkutbay
 */
public class search_bean {

    String aramakriteri;
    String arama;
    String os;

    public String getAramakriteri() {
        return aramakriteri;
    }

    public void setAramakriteri(String aramakriteri) {
        this.aramakriteri = aramakriteri;
    }

   public String getArama() {
        return arama;
    }

    public void setArama(String arama) {
        this.arama = arama;
    }
    

    /*public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }*/
    
    public String veriTabanindaara() throws ClassNotFoundException, SQLException{ //Sayfadan girilen verileri veri tabanına gönderem metot.
    Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT * FROM donanim_kayit WHERE '" + aramakriteri + "'='"+ arama+"'")) {
            r.next();
            say = r.getInt(1);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return say;
    }
        
    }

}
