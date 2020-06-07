package br.com.api;

//import java.lang.invoke.ClassSpecializer.Factory;
import java.sql.Connection; 

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstoqueDao {
    public ArrayList<String> estoque = new ArrayList<String>();
    private Connection conexao;
	//private PreparedStatement preparedStatement;
	private Statement statement;
    private ResultSet resultSet;
    
    public EstoqueDao(){
        try {
            conexao = new FactoryConnection().getConnection();
        } catch (Exception e) {
            
        }
    }

    public ArrayList<String> buscarDados() {
        String select = "SELECT * FROM Estoque";
		try {
			statement = conexao.createStatement();
			resultSet = statement.executeQuery(select);
			while (resultSet.next()) {
                estoque.add(resultSet.getString("item"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
        }
        return estoque;
	}
}