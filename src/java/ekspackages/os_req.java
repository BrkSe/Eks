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
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Burak KUTBAY
 * @site www.burakkutbay.com
 * @blog blog.burakkutbay.com
 */
@ManagedBean(name = "os_req")
@RequestScoped

public class os_req implements Serializable {

    private int say, say1, say2, say3, pcsayisi;

    Connection con;
    Statement s;

    public int getOSmacdata() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT COUNT(os) FROM donanim_kayit WHERE os=\"Mac\"")) {
            r.next();
            say = r.getInt(1);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return say;
    }

    public int getOSwin7data() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT COUNT(os) FROM donanim_kayit WHERE os=\"Windows 7\"")) {
            r.next();
            say1 = r.getInt(1);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return say1;
    }

    public int getOSwinxpdata() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT COUNT(os) FROM donanim_kayit WHERE os=\"Windows XP\"")) {
            r.next();
            say2 = r.getInt(1);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return say2;
    }

    public int getOSwin8data() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT COUNT(os) FROM donanim_kayit WHERE os=\"Windows 8\"")) {
            r.next();
            say3 = r.getInt(1);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return say3;
    }

    public int getOSpctotal() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT COUNT(*) FROM donanim_kayit")) {
            r.next();
            pcsayisi = r.getInt(1);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return pcsayisi;
    }

    public int getPcsayisi() {
        return pcsayisi;
    }

    public void setPcsayisi(int pcsayisi) {
        this.pcsayisi = pcsayisi;
    }

    public int getSay3() {
        return say3;
    }

    public void setSay3(int say3) {
        this.say3 = say3;
    }

    public int getSay2() {
        return say2;
    }

    public void setSay2(int say2) {
        this.say2 = say2;
    }

    public int getSay1() {
        return say1;
    }

    public void setSay1(int say1) {
        this.say1 = say1;
    }

    public int getSay() {
        return say;
    }

    public void setSay(int say) {
        this.say = say;
    }
}
