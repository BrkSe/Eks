/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekspackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.stream.Stream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Brk
 * @site www.burakkutbay.com
 * @blog blog.burakkıtbay.com
 */

@ManagedBean
@RequestScoped
public class register_hardware {

String adisoyadi;
String pcadi;
String ram;
String harddisk;
String ekrankarti;
String os;
public String mesaj;
int id=0;

int i=0;

    public String getAdisoyadi() {
        return adisoyadi;
    }

    public void setAdisoyadi(String adisoyadi) {
        this.adisoyadi = adisoyadi;
    }

    public String getEkrankarti() {
        return ekrankarti;
    }

    public void setEkrankarti(String ekrankarti) {
        this.ekrankarti = ekrankarti;
    }

    public String getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk = harddisk;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPcadi() {
        return pcadi;
    }

    public void setPcadi(String pcadi) {
        this.pcadi = pcadi;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getI() {
        return i;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    

public String donanimKayit()//Sayfadan girilen verileri veri tabanına gönderem metot.
    { 
        PreparedStatement ps=null;//Veri tabanına gönderilecek bilgileri bu nesne tuttacak ve veri tabanına gönderecek.
        Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.
        try{
            Class.forName("com.mysql.jdbc.Driver");//Hangi türde bir veri tabanını kullanacağını bildiriyoruz.
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eks","root","1");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            //String sql = "INSERT INTO yazarlar(Adı,Alanı) VALUES(?,?)";//Yazarlar tablosunun Adı ve Alanı sütununa değer göndereceğimi söylüyoruz.
            ps=con.prepareStatement("INSERT INTO donanim_kayit(iddonanim_kayit,kullaniciadsoyad,bilgisayar_adi, ram, harddisk, ekran_karti,os) VALUES(?,?,?,?,?,?,?)");//ps nesnesine SQL komutunu bildiriyoruz.İsterseniz parametre olarak SQL kodu yerine üstteki sql de verebilirsiniz.
            ps.setInt(1,id);
            ps.setString(2, adisoyadi);
            ps.setString(3, pcadi);//ps nesnesine gelen simi koyduk.
            ps.setString(4, ram);//ps nesnesine gelen alanı koyduk.
            ps.setString(5, harddisk);//ps nesnesine gelen alanı koyduk.
            ps.setString(6, ekrankarti);//ps nesnesine gelen alanı koyduk.
            ps.setString(7, os);//ps nesnesine gelen alanı koyduk.
            i=ps.executeUpdate();//executeUpdate verilen sorguyu çalıştırır ve integer değer döndürür.
            //exequteUdate eğer 0'dan büyük değer döndürürse kayıt başarılı olmuş demektir.  
            
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
        
        if(i>0)
        {  
               mesaj="Kayıt İşlemi Başarılı Olmuştur";
                return "kayityapildi";
        }
        else
        {
            mesaj="Kayıt İşlemi Başarılı Olmamıştır.";  
            return "kayityapilmadi";
        }
     }
}
