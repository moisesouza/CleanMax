package br.com.aplicativo.CleanMax.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.aplicativo.CleanMax.util.ConnectionFactory;




public class TipoServicoDao {

				private Connection connection;

				public TipoServicoDao() {
					try {
						this.connection = (Connection) new ConnectionFactory().getConnection();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
			
				public void salvar(TipoServico servico) {
					try {
						String sql = "INSERT INTO tipoServico (nome, descricao, tipoDescricao) VALUES (?,?,?,)";
						PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
						stmt.setString(1, servico.getNome());				
						stmt.setString(2, servico.getDescricao());						
						stmt.setString(3, servico.getTipoDescricao());
											
						stmt.execute();
						connection.close();

					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
		
				public void alterar(TipoServico servico) {

					try {
						String sql = "UPDATE tipoServico SET nome = ?, descricao = ?, tipoDescricao = ? WHERE id = ?";
						PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
						stmt.setString(1, servico.getNome());
						stmt.setString(1, servico.getDescricao());
						stmt.setString(1, servico.getTipoDescricao());

						stmt.execute();
						connection.close();

					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}

				public List<TipoServico> listar() {

					try {
						List<TipoServico> listaServico = new ArrayList<TipoServico>();

						String sql = "SELECT * FROM Servicos ORDER BY tipoServico";
						PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {

							TipoServico servico = new TipoServico();

							servico.setId(rs.getInt("id"));
							servico.setNome(rs.getString("nome"));
							servico.setDescricao(rs.getString("descricao"));
							servico.setTipoDescricao(rs.getString("tipoDescricao"));
							
							

							listaServico.add(servico);
						}

						rs.close();
						stmt.close();
						connection.close();

						return listaServico;

					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
				
				public TipoServico buscarPorId(int id) {

					try {
						PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM tipoServico WHERE id = ?");
						stmt.setInt(1, id);
						ResultSet rs = stmt.executeQuery();

						TipoServico servico = null;

						if (rs.next()) {

							servico = new TipoServico();

							servico.setId(rs.getInt("id"));
							servico.setNome(rs.getString("nome"));
							servico.setDescricao(rs.getString("descricao"));
							servico.setTipoDescricao(rs.getString("tipoDescricao"));
							
							
						}

						rs.close();
						stmt.close();
						connection.close();

						return servico;

					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
					

				public void remover(TipoServico servico) {

					try {
						String sql = "DELETE FROM tipoServico WHERE id = ?";
						PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
						stmt.setInt(1, servico.getId());
						stmt.execute();
						connection.close();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				
				}	
	
	
}
