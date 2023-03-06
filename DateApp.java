package sockets;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DateApp {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateApp window = new DateApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DateApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel ip = new JLabel("IP");
		ip.setBounds(25, 29, 46, 14);
		frame.getContentPane().add(ip);
		
		JLabel portnum = new JLabel("PORT NUM");
		portnum.setBounds(25, 63, 55, 14);
		frame.getContentPane().add(portnum);
		
		tf1 = new JTextField();
		tf1.setBounds(90, 26, 113, 20);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(90, 60, 113, 20);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String host = tf1.getText();
					int port = Integer.parseInt(tf2.getText());
					Socket socket = new Socket(host, port);
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println("date");
					String response = in.readLine();
					lblDate.setText(response);
					socket.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(154, 175, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblDate = new JLabel("");
		lblDate.setBounds(25, 110, 400, 20);
		frame.getContentPane().add(lblDate);
	}
}
