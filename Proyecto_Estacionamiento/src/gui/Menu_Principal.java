package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.SystemColor;

public class Menu_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;
	private Registro regis;
	private lista lis;
	private Salida salida;
	private Estacionamiento estacinamiento;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
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
	public Menu_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		{
			panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.activeCaption);
			panel_1.setBounds(0, 0, 203, 516);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				btnNewButton = new JButton("Registrar");
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				btnNewButton.addActionListener(this);
				btnNewButton.setBounds(0, 107, 204, 71);
				panel_1.add(btnNewButton);
			}
			{
				btnNewButton_1 = new JButton("Estacionamiento");
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
				btnNewButton_1.addActionListener(this);
				btnNewButton_1.setBounds(0, 271, 204, 71);
				panel_1.add(btnNewButton_1);
			}
			{
				btnNewButton_2 = new JButton("Salida");
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
				btnNewButton_2.addActionListener(this);
				btnNewButton_2.setBounds(0, 189, 204, 71);
				panel_1.add(btnNewButton_2);
			}
			{
				btnNewButton_3 = new JButton("Estacionamiento_ESTA");
				btnNewButton_3.addActionListener(this);
				btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
				btnNewButton_3.setBounds(0, 353, 204, 71);
				panel_1.add(btnNewButton_3);
			}
			 regis = new Registro();
		     regis.setBounds(205, 0, 751, 516);
		        
		     lis = new lista(); 
		     lis.setBounds(205, 0, 751, 516);
		     
		     salida = new Salida();
		     salida.setBounds(205, 0, 751, 516);
		     
		     estacinamiento = new Estacionamiento();
		     estacinamiento.setBounds(205, 0, 751, 516);
		     
		     nuevoPanel(regis);
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_3) {
			do_btnNewButton_3_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		 //regis.setBounds(204, 0, 473, 373); 
		nuevoPanel(regis);
	}
	
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
		//lis.setBounds(204, 0, 473, 373);  
		nuevoPanel(lis);
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		//salida.setBounds(204, 0, 473, 373);  
		nuevoPanel(salida);
	}
	private void nuevoPanel(JPanel nuevoPanel) {
        if (panel != null) {
            contentPane.remove(panel);
        }
        panel = nuevoPanel;
        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();
    }
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		nuevoPanel(estacinamiento);
		
	}
}
