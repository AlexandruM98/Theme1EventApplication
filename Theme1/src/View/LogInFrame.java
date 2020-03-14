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

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usrTextField;
	private JTextField passTextField;
	private JButton btnLogare = new JButton("Logare ");
	private JButton btnBack = new JButton("Back");
	
	public LogInFrame() {
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
		
		
		btnLogare.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 26));
		btnLogare.setBounds(262, 423, 210, 61);
		contentPane.add(btnLogare);
		
		btnBack.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		btnBack.setBounds(600, 491, 124, 55);
		contentPane.add(btnBack);
		setVisible(true);
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controller.backToWelcomeWindow();
				
				
			}
			
			
		});
	}
}
