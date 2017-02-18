package telas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import controlador.MainBO;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.SystemColor;


public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private MainBO controlador;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPrincipal frame = new TelaPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(MainBO controlador) {
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCabealho = new JLabel("Cabeçalho");
		lblCabealho.setForeground(Color.WHITE);
		panel.add(lblCabealho);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {				
	            System.out.println("Tab " + tabbedPane.getSelectedIndex());
			}
	    });
		
		tabbedPane.setBackground(SystemColor.textInactiveText);
		panel_1.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tab1 = new JPanel();
		tab1.setBackground(Color.GREEN);
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Entrei na tab1");
			}
		});
		
		tabbedPane.addTab("Tab1", null, tab1, null);
		
		
		JPanel tab2 = new JPanel();
		tab2.setBackground(SystemColor.textHighlight);
		tabbedPane.addTab("Tab2", null, tab2, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblRodap = new JLabel("Rodapé");
		panel_2.add(lblRodap);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.windowBorder);
		contentPane.add(panel_3, BorderLayout.WEST);
		
		JMenuBar menuBar = new JMenuBar();
		panel_3.add(menuBar);
	}

}
