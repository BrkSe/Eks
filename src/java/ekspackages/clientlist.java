/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekspackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkıtbay.com
 */
public class clientlist {

    public List<Uyeler> uyeler = new ArrayList<Uyeler>();
    
    

    public clientlist() {
        
        PreparedStatement ps=null;//Veri tabanına gönderilecek bilgileri bu nesne tuttacak ve veri tabanına gönderecek.
        Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.
        try{
            Class.forName("com.mysql.jdbc.Driver");//Hangi türde bir veri tabanını kullanacağını bildiriyoruz.
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eks","root","1111");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            //String sql = "INSERT INTO yazarlar(Adı,Alanı) VALUES(?,?)";//Yazarlar tablosunun Adı ve Alanı sütununa değer göndereceğimi söylüyoruz.
            ps=con.prepareStatement("INSERT INTO uye_kayit(userID,Adi, Soyadi, Email, Sifre) VALUES(?,?,?,?,?)");//ps nesnesine SQL komutunu bildiriyoruz.İsterseniz parametre olarak SQL kodu yerine üstteki sql de verebilirsiniz.
    
            
        }
        catch(Exception e)//Hata olduğunda konsola verilecek.
        {
            System.out.println(e);
         }
        finally //Ne olursa olsun her koşulda çalışacak kısım 
        {
            try{
            con.close();
            ps.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
       

    }
}
