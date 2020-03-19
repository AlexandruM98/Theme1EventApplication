package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class WelcomePage extends JFrame {
	private Controller ctrl = new Controller();
	
	private JPanel contentPane;	
	
	private JButton clientBtn = new JButton("Client");
	private JButton coordBtn = new JButton("Coordonator");
	private JButton admBtn = new JButton("Administrator");
	
	public WelcomePage() {
		setForeground(Color.WHITE);
		setTitle("WelcomePage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 537);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		contentPane.setLayout(null);
		
		JLabel welcomeMessage = new JLabel("Va rugam selectati tipul de utilziator");
		welcomeMessage.setBounds(84, 43, 424, 73);
		welcomeMessage.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		contentPane.add(welcomeMessage);
		
		
		clientBtn.setBounds(213, 155, 198, 47);
		clientBtn.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		contentPane.add(clientBtn);
		
		
		coordBtn.setBounds(213, 257, 198, 53);
		coordBtn.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		contentPane.add(coordBtn);
		
		
		admBtn.setBounds(213, 377, 198, 53);
		admBtn.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		contentPane.add(admBtn);
		setContentPane(contentPane);
		setVisible(true);
		
		clientBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.openClientWindow();
				
			}
			
		});
		
		coordBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.openLogInWindow("coord");
				
			}
			
			
		});
		
		admBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.openLogInWindow("adm");
				
			}
			
		});
	}
	
	
	public void setController(Controller c) {
		this.ctrl = c;
	}
	
}
