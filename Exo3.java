package com.objet.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Exo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost/formation?useSSL=false";
		String user = "root";
		String pwd ="root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = (Connection) DriverManager.getConnection(url,user,pwd);

			//create statement pour executer les requetes
			Statement st = (Statement) cn.createStatement();

			String select = "SELECT CLIENTS.NOMC " + 
					"FROM CLIENTS " + 
					"INNER JOIN VENTES ON CLIENTS.NC = VENTES.NC WHERE VENTES.QT > 180 and CLIENTS.ville = 'Lyon';";


			ResultSet result =  st.executeQuery(select);

			String nomR;

			while(result.next()) {
				nomR = result.getString("NOMC");

				System.out.println(nomR+" a vendu plus qu'un produit");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
