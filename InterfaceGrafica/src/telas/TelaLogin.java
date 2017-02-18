package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import modelo.Aluno;
import controlador.MainBO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	private JFrame telaLogin;
	private JPanel contentPane;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private MainBO controlador;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		controlador = new MainBO(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCabecalho = new JPanel();
		contentPane.add(panelCabecalho, BorderLayout.NORTH);
		
		JLabel lblSejaBemVindo = new JLabel("Seja bem vindo!");
		lblSejaBemVindo.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panelCabecalho.add(lblSejaBemVindo);
		
		JPanel panelCorpo = new JPanel();
		contentPane.add(panelCorpo, BorderLayout.CENTER);
		panelCorpo.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(16, 6, 61, 16);
		panelCorpo.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(16, 38, 61, 16);
		panelCorpo.add(lblSenha);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(72, 0, 134, 28);
		panelCorpo.add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(72, 32, 134, 28);
		panelCorpo.add(pfSenha);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String login = tfLogin.getText();
				char[] senha = pfSenha.getPassword();
				
				System.out.println(login);	
				System.out.println(senha);


				if (login != null && !login.isEmpty() && senha.length != 0){
					// Monta o objeto aluno
					Aluno aluno = new Aluno();

					aluno.setMatricula(Integer.parseInt(login));
					aluno.setSenha(String.valueOf(senha));


					// Chama a função para logar				
					boolean aluno_logado = controlador.logar(aluno);

					// Chama a tela principal
					if (aluno_logado){
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						setVisible(false);
						new TelaPrincipal(controlador).setVisible(true);
					}
				}
				
			}
		});
		btnEnviar.setBounds(26, 66, 82, 29);
		panelCorpo.add(btnEnviar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(120, 66, 82, 29);
		panelCorpo.add(btnLimpar);
	}

}
