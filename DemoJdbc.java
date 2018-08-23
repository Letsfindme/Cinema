package com.objet.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DemoJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost/formation?useSSL=false";
		String user = "root";
		String pwd ="root";
		
		//chargement du driver 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = (Connection) DriverManager.getConnection(url,user,pwd);
			
			//create statement pour executer les requetes
			Statement st = (Statement) cn.createStatement();
			
			String sql = "SELECT * FROM formation.CLIENTS";
			//execution requete et recuperer les résultats par le method next()
			ResultSet result =  st.executeQuery(sql);
			
			int ncVar;
			String nomcVar;
			String villeVar;
			
			
			while (result.next()) {
				//recuperer le nc
				ncVar=result.getInt("nc");
				nomcVar=result.getString("nomc");
				villeVar=result.getString("ville");
				
				System.out.println("Numéro client: "+ncVar +", Prénom: "+nomcVar+", Ville "+villeVar);
				
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
