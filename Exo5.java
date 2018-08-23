package com.objet.demojdbc;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Exo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String url = "jdbc:mysql://localhost/gestion_spectacles?useSSL=false";
		String user = "root";
		String pwd ="root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = (Connection) DriverManager.getConnection(url,user,pwd);

			//create statement pour executer les requetes
			Statement st = (Statement) cn.createStatement();

			String select = "SELECT Concert.Date\n" + 
					"FROM Concert\n" + 
					"inner join Spectacle on Concert.Spectacle_ID = Spectacle.Spectacle_ID\n" + 
					"inner join Salle on Salle.Salle_ID=Spectacle.Salle_ID\n" + 
					"\n" + 
					"where Spectacle.Chanteur = 'Corneille' AND Salle.Nom = 'Zenith';";


			ResultSet result =  st.executeQuery(select);

			Date dateVar;

			while(result.next()) {
				dateVar = result.getDate("Date");

				System.out.println(" les dates du concert de Corneille au Zenith " + dateVar);
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
