package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.vehicleArray;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import java.awt.FlowLayout;
import javax.swing.JSlider;

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
		setBounds(100, 100, 664, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 128, 128));
			panel_1.setBounds(0, 0, 204, 316);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				btnNewButton = new JButton("Registrar");
				btnNewButton.addActionListener(this);
				btnNewButton.setBounds(0, 100, 204, 23);
				panel_1.add(btnNewButton);
			}
			{
				btnNewButton_1 = new JButton("Reporte");
				btnNewButton_1.addActionListener(this);
				btnNewButton_1.setBounds(0, 121, 204, 23);
				panel_1.add(btnNewButton_1);
			}
			{
				btnNewButton_2 = new JButton("Salida");
				btnNewButton_2.addActionListener(this);
				btnNewButton_2.setBounds(0, 143, 204, 23);
				panel_1.add(btnNewButton_2);
			}
		}
		
		 regis = new Registro();
	     regis.setBounds(204, 0, 473, 373);
	        
	     lis = new lista(); 
	     lis.setBounds(204, 0, 473, 373);
	     
	     salida = new Salida();
	     salida.setBounds(204, 0, 473, 373);
	     vehicleArray.initializeSampleData(); // agrego datos
	     nuevoPanel(regis);
	}
	
	public void actionPerformed(ActionEvent e) {
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
		
		 regis.setBounds(204, 0, 473, 373); 
		nuevoPanel(regis);
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
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
		lis.setBounds(204, 0, 473, 373);  
		nuevoPanel(lis);
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		salida.setBounds(204, 0, 473, 373);  
		nuevoPanel(salida);
	}
}
