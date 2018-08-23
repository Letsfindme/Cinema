package com.objet.demojdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Cinema {

	public static Connection openConnection(Statement st) {
		Connection cn =null;


		String url="jdbc:mysql://localhost/cinema?useSSL=false";
		String user="root";
		String pwd="root";


		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Ok");

			cn = (Connection) DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cn;
	}

	public static void closeConnection(Connection cn, Statement st){


		try {
			cn.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Statement  selectAll(Connection cn ) {
		Statement st = null;
		
		try {

			st = (Statement) cn.createStatement();
			String sql = "SELECT * FROM personne";
			ResultSet result = st.executeQuery(sql);

			String prenom;

			while(result.next()) {

				prenom = result.getString("prenom");
				System.out.println("La personne est: "+prenom );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection cn = null;
		Statement st = null;
		cn = openConnection(st);

		st = selectAll(cn);
		
		closeConnection(cn, st);

	}

}
