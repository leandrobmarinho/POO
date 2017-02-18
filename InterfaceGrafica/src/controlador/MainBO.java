package controlador;

import persistencia.AlunoDAO;
import telas.TelaLogin;
import telas.TelaPrincipal;
import modelo.Aluno;

public class MainBO {
	private TelaLogin telaLogin;
	private TelaPrincipal telaPrincipal;
	
	public MainBO(TelaLogin tela){
		this.telaLogin = tela;
		System.out.println("estou no comando!!!");
		
	}

	public boolean logar(Aluno aluno) {
		
		// Verifica as informações no banco de dados
		AlunoDAO alunodao = new AlunoDAO();
		return alunodao.login(aluno);
	}
	

}
