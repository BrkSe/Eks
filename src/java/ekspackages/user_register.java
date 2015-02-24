import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.*;

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkıtbay.com
 */
@ManagedBean
@RequestScoped
public class user_register {
int id;
String isim;
String soyad;
String email;
String sifre;

int i=0;
int sayac=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getIsim() {
        return isim;
    }
 
    public void setIsim(String isim) {
        this.isim = isim;
    }
 
    public String getSoyad() {
        return soyad;
    }
 
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
     
    public String veriTabaninaGonder()//Sayfadan girilen verileri veri tabanına gönderem metot.
    {
        PreparedStatement ps=null;//Veri tabanına gönderilecek bilgileri bu nesne tuttacak ve veri tabanına gönderecek.
        Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.
        try{
            Class.forName("com.mysql.jdbc.Driver");//Hangi türde bir veri tabanını kullanacağını bildiriyoruz.
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eks","root","1111");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            //String sql = "INSERT INTO yazarlar(Adı,Alanı) VALUES(?,?)";//Yazarlar tablosunun Adı ve Alanı sütununa değer göndereceğimi söylüyoruz.
            ps=con.prepareStatement("INSERT INTO uye_kayit(userID,Adi, Soyadi, Email, Sifre) VALUES(?,?,?,?,?)");//ps nesnesine SQL komutunu bildiriyoruz.İsterseniz parametre olarak SQL kodu yerine üstteki sql de verebilirsiniz.
             ps.setInt(1, id);
            ps.setString(2, isim);//ps nesnesine gelen simi koyduk.
            ps.setString(3, soyad);//ps nesnesine gelen alanı koyduk.
            ps.setString(4, email);//ps nesnesine gelen alanı koyduk.
            ps.setString(5, sifre);//ps nesnesine gelen alanı koyduk.
            i=ps.executeUpdate();//executeUpdate verilen sorguyu çalıştırır ve integer değer döndürür.
            //exequteUdate eğer 0'dan büyük değer döndürürse kayıt başarılı olmuş demektir.  
            
        }
        catch(Exception e)//Hata olduğunda konsola verilecek.
        {
            System.out.println(e);
            sayac--;
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
        if(i>0) //Sorgu başarılı olarak çalışınca i 0'dan büyük oluyor ve bizi başarılı sayfasına yönlediriyor.
        {  
               return "basarili";
        }
        else //Sorgu başarısız ise başarısız sayfasına gidiyoruz.
        {
              return "basarisiz";
        }
        /*İsim ve Alani nesnelerini konsola yazdırmamın sebei xhtml içinden girdiğiniz değerler bu nesnelere
        atanıyor mu diye kontrol amacıdır.*/
    }
}