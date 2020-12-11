/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.globalcode.aj3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import br.com.globalcode.aj3.beans.Cliente;
import br.com.globalcode.aj3.exception.GlobalcodeException;
import br.com.globalcode.aj3.util.ConnectionManager;

public class ClientesDAOImpl implements IClientesDAO {

	private final static String SALVAR_CLIENTE = "INSERT INTO clientes (nome,cpf,telefone) VALUES (?,?,?)";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  clientes (id int(3) NOT NULL AUTO_INCREMENT   PRIMARY KEY, nome VARCHAR(20) NOT NULL, cpf varchar(20) NOT NULL, telefone varchar(20) NOT NULL)";
	private final static String DELETE_CLIENTE = "DELETE FROM clientes WHERE cpf = '";
	private final static String GET_ALL_CLIENTES = "SELECT * FROM clientes";
	private final static String GET_CLIENTE_BY_CPF = "SELECT * FROM clientes WHERE cpf = ?";

	public void createTable() throws GlobalcodeException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE);
		} catch (SQLException e) {
			throw new GlobalcodeException(
					"Erro ao criar a tabela de clientes : " + CREATE_TABLE, e);
		} finally {
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	/*
	 * @see
	 * br.com.globalcode.aj3.dao.ClientesDAO#excluir(br.com.globalcode.beans
	 * .Cliente)
	 */
	public void excluir(String cpf) throws GlobalcodeException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			int numeroLinhas = stmt.executeUpdate(DELETE_CLIENTE + cpf + "'");
			System.out.println("Numero de clientes excluidos: " + numeroLinhas);
		} catch (SQLException e) {
			throw new GlobalcodeException("Erro ao excluir cliente: "
					+ DELETE_CLIENTE, e);
		} finally {
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	/*
	 * @see
	 * br.com.globalcode.aj3.dao.ClientesDAO#salvar(br.com.globalcode.beans.
	 * Cliente)
	 */
	public void salvar(Cliente cliente) throws GlobalcodeException {
		/*
		 * Gravar os dados do cliente no banco de dados usando a constante
		 * SALVAR_CLIENTE
		 */
		 
		// Criar uma variavel para a Connection
		Connection conn = null;
		
		// Criar uma variavel para o PreparedStatement
		PreparedStatement stmt = null;
		
		try {
			// Abrir a conexao
			conn = ConnectionManager.getConnection();
			
			// Criar o PreparedStatement
			stmt = conn.prepareStatement(SALVAR_CLIENTE);
			
			// Atribuir uma String para a 1a. interrogacao (nome)
			stmt.setString(1, cliente.getNome());
			
			// Atribuir uma String para a 3a. interrogacao (cpf)
			stmt.setString(2, cliente.getCpf());
			
			// Atribuir uma String para a 2a. interrogacao (telefone)
			stmt.setString(3, cliente.getTelefone());
			
			// Executar a instrucao
			int numeroLinhas = stmt.executeUpdate();
			
			System.out.println("Cliente Salvo com Sucesso!");
			
		} catch (SQLException e) {
			throw new GlobalcodeException("Erro ao salvar cliente: "
					+ SALVAR_CLIENTE, e);
		} finally {
			
			// Fechar a Connection e o PreparedStatement
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	/*
	 * @see br.com.globalcode.aj3.dao.ClientesDAO#getAllClientes()
	 */
	public List getAllClientes() throws GlobalcodeException {
		ArrayList clientes = new ArrayList();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(GET_ALL_CLIENTES);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				Cliente c = new Cliente(nome, telefone, cpf, id);
				clientes.add(c);
			}
			return clientes;
		} catch (SQLException e) {
			throw new GlobalcodeException(
					"Nao foi possivel recuperar os clientes da base de dados.",
					e);
		} finally {
			ConnectionManager.closeAll(conn, stmt, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.globalcode.aj3.dao.ClientesDAO#getClienteByID(int)
	 */
	public Cliente getClienteByCPF(String cpf) throws GlobalcodeException {
		/*
		 * Consultar um cliente no banco de dados usando a constante
		 * GET_CLIENTE_BY_CPF.
		 */

		// Declarar uma variavel para a Connection
		Connection conn = null;
		
		// Declarar uma variavel para o PreparedStatement
		PreparedStatement stmt = null;
		
		// Declarar uma variavel para o ResultSet
		ResultSet rs = null;
		
		try {
			// Abrir a conexao
			conn = ConnectionManager.getConnection();
			
			/// Criar o PreparedStatement
			stmt = conn.prepareStatement(GET_CLIENTE_BY_CPF);
			
			// Atribuir uma String para a 1a. interrogacao (cpf)
			stmt.setString(1, cpf);
			
			// Executar a consulta e guardar o resultado no ResultSet
			rs = stmt.executeQuery();
			
			if (rs.next()) {
			
				// Ler o ResultSet, recuperando um objeto cliente
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				Cliente c = new Cliente(nome, telefone, cpf, id);
				
				// Retornar o cliente
				return c;
			}
			
		} catch (SQLException e) {
			throw new GlobalcodeException("Erro ao selecionar cliente pelo CPF: "
					+ GET_CLIENTE_BY_CPF, e);
		} finally {
			// Fechar a Connection, o Statement e o ResultSet
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		
		return null;
	}
}
