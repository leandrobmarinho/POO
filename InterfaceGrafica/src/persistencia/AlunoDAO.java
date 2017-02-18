package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;

public class AlunoDAO {

	private Connection connection;

	public AlunoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean login(Aluno aluno){
		try {
			boolean logado = false;
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from aluno where matricula = ?");			
			stmt.setInt(1, aluno.getMatricula());
						
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){

				// Criando o objeto Aluno do banco
				Aluno aluno_bd = new Aluno();
				aluno_bd.setMatricula(rs.getInt("matricula"));
				aluno_bd.setNome(rs.getString("nome"));
				aluno_bd.setSenha(rs.getString("senha"));
				
				if (aluno.getSenha().equals(aluno_bd.getSenha()))
					logado =  true;

			}
			rs.close();
			stmt.close();
			
			return logado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
