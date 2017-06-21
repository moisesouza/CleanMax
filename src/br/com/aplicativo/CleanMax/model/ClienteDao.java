package br.com.aplicativo.CleanMax.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aplicativo.CleanMax.util.ConnectionFactory;

public class ClienteDao {
	
	private Connection connection;
	public ClienteDao() {
		try{
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Cliente cadastro) {
		try {

			String sql = "INSERT INTO cadastro (nome,senha,confirmeSenha,email,dataNascimento,celular,telefone,cpf) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, cadastro.getNome());
			stmt.setString(2, cadastro.getSenha());
			stmt.setString(3, cadastro.getConfirmeSenha());
			stmt.setString(4, cadastro.getEmail());
			stmt.setDate(5, new java.sql.Date(cadastro.getDataNascimento().getTime()));
			stmt.setString(6, cadastro.getCelular());
			stmt.setString(7, cadastro.getTelefone());
			stmt.setString(8, cadastro.getCpf());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> listar() {

		try {
			List<Cliente> cadastrar = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM cadastro ORDER BY nome");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cadastro = new Cliente();
				cadastro.setNome(rs.getString("nome"));
				cadastro.setSenha(rs.getString("senha"));
				cadastro.setConfirmeSenha(rs.getString("confirme sua senha"));
				cadastro.setEmail(rs.getString("email"));
				cadastro.setDataNascimento(rs.getDate("data de nascimento"));
				cadastro.setCelular(rs.getString("celular"));
				cadastro.setTelefone(rs.getString("telefone"));
				cadastro.setCpf(rs.getString("cpf"));
				
				
				cadastrar.add(cadastro);
			}

			rs.close();
			stmt.close();
			connection.close();

			return cadastrar;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void LimparTabela(){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM cadastro");
			stmt.execute();
			connection.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	} 
}


