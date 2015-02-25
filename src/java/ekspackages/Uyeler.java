/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekspackages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Brk
 */
@ManagedBean (name = "Uyeler")
@SessionScoped
class Uyeler {
    
    private int userID;
    private String adi;
    private String soyadi;
    private String email;
    private String deneme="burak";
    
    
    public Uyeler() {    }

    public String getAdi() {
        return adi;
    }

    public String getEmail() {
        return email;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDeneme() {
        return deneme;
    }

    public void setDeneme(String deneme) {
        this.deneme = deneme;
    }
    
    
    
    
}
