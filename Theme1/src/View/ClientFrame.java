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

public class ClientFrame extends JFrame {	
	private Controller ctrl = new Controller();
	
	private JPanel contentPane;	
	private JButton backBtn = new JButton("Back");
	
	public ClientFrame() {
		setTitle("ClientPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JLabel lblBunaZiua = new JLabel("Mai multe informatii accesand butoanele de mai jos");
		lblBunaZiua.setBounds(122, 10, 562, 104);
		lblBunaZiua.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 19));
		contentPane.add(lblBunaZiua);
		setContentPane(contentPane);
		
		
		backBtn.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		backBtn.setBounds(610, 452, 124, 55);
		contentPane.add(backBtn);
		setVisible(true);
		
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ctrl.backToWelcomeWindow();
				
				
			}
			
			
		});
	}
	
	public void setController(Controller c) {
		this.ctrl = c;
	}
}
