package View;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class LogInFrame extends JFrame {
	
	private Controller ctrl;

	private JPanel contentPane;
	private JTextField usrTextField;
	private JTextField passTextField;
	private JTextArea infoArea;
	private JButton btnSalvareCont= new JButton("Salvare ");
	private JButton btnBack = new JButton("Back");
	private JButton btnStergere = new JButton("Stergere");
	private JButton btnLogare = new JButton("Logare");
	
	public LogInFrame(Controller ctrl) {
		this.ctrl = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAutentificare = new JLabel("Autentificare");
		lblAutentificare.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		lblAutentificare.setBounds(289, 39, 183, 61);
		contentPane.add(lblAutentificare);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		lblUsername.setBounds(87, 197, 165, 52);
		contentPane.add(lblUsername);
		
		usrTextField = new JTextField();
		usrTextField.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		usrTextField.setBounds(262, 211, 210, 32);
		contentPane.add(usrTextField);
		usrTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		lblPassword.setBounds(87, 317, 124, 32);
		contentPane.add(lblPassword);
		
		passTextField = new JTextField();
		passTextField.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		passTextField.setBounds(262, 317, 210, 32);
		contentPane.add(passTextField);
		passTextField.setColumns(10);
		
		
		btnSalvareCont.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 26));
		btnSalvareCont.setBounds(262, 423, 210, 61);
		contentPane.add(btnSalvareCont);
		
		btnBack.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		btnBack.setBounds(600, 491, 124, 55);
		contentPane.add(btnBack);
		
		
		btnStergere.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 26));
		btnStergere.setBounds(28, 423, 183, 61);
		contentPane.add(btnStergere);
		
		
		btnLogare.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 26));
		btnLogare.setBounds(511, 423, 183, 61);
		contentPane.add(btnLogare);
		
		infoArea = new JTextArea();
		infoArea.setBounds(518, 165, 176, 196);
		contentPane.add(infoArea);
		
		JLabel lblInfoLogIn = new JLabel("Info Log in");
		lblInfoLogIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInfoLogIn.setBounds(557, 132, 106, 23);
		contentPane.add(lblInfoLogIn);
		setVisible(true);
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				setVisible(false);
				ctrl.backToWelcomeWindow();
				
				
			}
			
			
		});
		
		btnSalvareCont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.salvareContNou(usrTextField.getText().toString(),passTextField.getText().toString());
				
			}
			
			
		});
		
		btnStergere.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.stergereCont(usrTextField.getText().toString(),passTextField.getText().toString());
				
			}
			
		});
		
		btnLogare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.logareCont(usrTextField.getText().toString(),passTextField.getText().toString());
				
			}
			
		});
	}

	public JButton getBtnSalvareCont() {
		return btnSalvareCont;
	}

	public void setBtnSalvareCont(JButton btnSalvareCont) {
		this.btnSalvareCont = btnSalvareCont;
	}

	public JButton getBtnStergere() {
		return btnStergere;
	}

	public void setBtnStergere(JButton btnStergere) {
		this.btnStergere = btnStergere;
	}

	public JButton getBtnLogare() {
		return btnLogare;
	}

	public void setBtnLogare(JButton btnLogare) {
		this.btnLogare = btnLogare;
	}	
	
	public void setInfoArea(String info) {
		this.infoArea.setText(info);
	}
}
