package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Temporizador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField txtUsuario;
	private JButton btnNewButton;
	private JPasswordField passContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			contentPane_1 = new JPanel();
			contentPane_1.setLayout(null);
			contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane_1.setBounds(0, 0, 677, 373);
			contentPane.add(contentPane_1);
			{
				panel = new JPanel();
				panel.setBackground(new Color(255, 128, 128));
				panel.setBounds(0, 0, 347, 373);
				contentPane_1.add(panel);
			}
			{
				lblNewLabel = new JLabel("Iniciar sesion");
				lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 27));
				lblNewLabel.setBounds(437, 95, 182, 44);
				contentPane_1.add(lblNewLabel);
			}
			{
				lblNewLabel_1 = new JLabel("Usuario ");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(369, 173, 119, 14);
				contentPane_1.add(lblNewLabel_1);
			}
			{
				lblNewLabel_1_1 = new JLabel("Contraseña ");
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_1.setBounds(369, 242, 95, 14);
				contentPane_1.add(lblNewLabel_1_1);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setColumns(10);
				txtUsuario.setBounds(369, 198, 281, 20);
				contentPane_1.add(txtUsuario);
			}
			{
				btnNewButton = new JButton("Ingresar");
				btnNewButton.addActionListener(this);
				btnNewButton.setBounds(561, 327, 89, 23);
				contentPane_1.add(btnNewButton);
			}
			{
				passContraseña = new JPasswordField();
				passContraseña.setBounds(369, 275, 281, 20);
				contentPane_1.add(passContraseña);
			}
		}
		Registro registro = new Registro();
		registro.setSize(getPreferredSize());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	int error=0;
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String adm=txtUsuario.getText();
		String pass= new String(passContraseña.getPassword());
		if(adm.equalsIgnoreCase("Aaron")&&pass.equals("123")){
			Menu_Principal test=new Menu_Principal();
			test.setVisible(true);
			dispose();
		}
		else{
			JOptionPane.showMessageDialog(this,"Usuario y/o contraseña incorrecto(s)");
			error++;
			if(error==3){
			JOptionPane.showMessageDialog(this,"Se excedio el limite de intentos");
			JOptionPane.showMessageDialog(this, "Penalidad de 30 segundos :)");
			Temporizador t=new Temporizador();
			t.setVisible(true);
			error--;
			error--;
			error--;
	    }
			else{
				JOptionPane.showMessageDialog(this, "Le queda "+(3-error)+" intentos(s)");
			}
	}
	}
}
