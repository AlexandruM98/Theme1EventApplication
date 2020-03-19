package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.Color;

public class CoordonatorFrame extends JFrame {
	
	private Controller ctrl = new Controller();

	private JPanel contentPane;
	
	public CoordonatorFrame() {
		setTitle("CoordonatorFrame");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 573);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
	}
	
	public void setController(Controller c) {
		this.ctrl = c;
	}
}
