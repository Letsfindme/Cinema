package com.objet.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Exo4 {

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

			String select = "SELECT REPRESENTAIONS.NOMR, CLIENTS.NOMC\n" + 
					"\n" + 
					"		from VENTES\n" + 
					"\n" + 
					"		INNER JOIN REPRESENTAIONS ON VENTES.NR = REPRESENTAIONS.NP \n" + 
					"\n" + 
					"		INNER JOIN PRODUITS ON VENTES.NP = PRODUITS.NP \n" + 
					"		INNER JOIN CLIENTS ON  VENTES.NC = CLIENTS.NC\n" + 
					"\n" + 
					"		WHERE PRODUITS.COUL = 'Rouge' AND  VENTES.QT >100   ;";


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
