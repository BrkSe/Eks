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
 * @blog blog.burakkıtbay.com
 */
@ManagedBean(name = "os_req")
@RequestScoped

public class os_req implements Serializable {
    private String dbmac;
    private int say,say1,say2;
    private String win7;
    private String win8;
    private String winxp;

    Connection con;
    Statement s;

    public int getOSdata() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eks", "root", "1234");
        Statement s = con.createStatement();
        try (ResultSet r = s.executeQuery("SELECT COUNT(os) FROM donanim_kayit WHERE os=\"Mac\"")) {
            r.next();
            say = r.getInt(1);
            System.out.println(say);
        } catch (SQLException x) {
            System.out.println(x);
        }
        return say;
     }

    public int getSay() {
        return say;
    }

    public void setSay(int say) {
        this.say = say;
    }
}