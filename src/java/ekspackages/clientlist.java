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
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkıtbay.com
 */
@ManagedBean(name = "clientlist")
@SessionScoped
public class clientlist {

    private List<Uyeler> uyeler = new ArrayList<Uyeler>();

    public clientlist() {

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1111");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            PreparedStatement pr = con.prepareStatement("SELECT * FROM UYE_KAYIT");
            ResultSet rs = pr.executeQuery();
            
            while (rs.next()) {
                Uyeler uye = new Uyeler();
                uye.setUserID(rs.getInt("userID"));
                uye.setAdi(rs.getString("Adi"));
                uye.setSoyadi(rs.getString("Soyadi"));
                uye.setEmail(rs.getString("Email"));
                uyeler.add(uye);
                
            }
            rs.close();
            pr.close();
            con.close();

        } catch (Exception e)//Hata olduğunda konsola verilecek.
        {
            System.out.println(e);
        }

    }
    public List<Uyeler> getUyeler() {
        return uyeler;    }
    public void setUyeler(List<Uyeler> uyeler) {
        this.uyeler = uyeler;    }
}
