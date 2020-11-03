/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlleer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fer
 */
public class MySQLLeer {

    Connection con;

    public MySQLLeer() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreriadb;", "root", "");

        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public static void main(String[] args) {
        MySQLLeer cn = new MySQLLeer();
        String query = "SELECT * FROM Autores";
        try {
            PreparedStatement pst;
            pst = cn.con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getInt(1));
                System.out.println(" : ");
                System.out.println(rs.getString(2));

            }

            cn.con.close();
        } catch (Exception e) {
        }

    }

}
