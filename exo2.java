package com.objet.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class exo2 {



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

			String selectRouge = "SELECT * FROM formation.PRODUITS WHERE COUL = 'Rouge' && PDS > 2000;";


			ResultSet resultRouge =  st.executeQuery(selectRouge);

			int nP;
			String nomP;

			while(resultRouge.next()) {
				nP = resultRouge.getInt("NP");
				nomP = resultRouge.getString("NOMP");

				System.out.println("Le numéro de produit: "+ nP+ "Le produit: "+ nomP);
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
