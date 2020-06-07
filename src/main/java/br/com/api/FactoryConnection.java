package br.com.api;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class FactoryConnection {
    //private String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbEstoque";
	private String user = "root";
    private String password = "Gus:_@123456";
    
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e+"-Deu Erro no banco!");
		}
	}
}