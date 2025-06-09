package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Arreglos.vehicleArray;
import clases.vehiculo;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Salida extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtPlaca;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	vehicleArray listavehiculo = vehicleArray.getInstancia();
	private JTextArea txtS;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public Salida() {
		setLayout(null);
		{
			txtPlaca = new JTextField();
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(144, 26, 96, 20);
			add(txtPlaca);
		}
		{
			btnNewButton = new JButton("Generar comprobante");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(266, 25, 163, 23);
			add(btnNewButton);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 69, 405, 215);
			add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			lblNewLabel_1 = new JLabel("Ingresar Placa : ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(24, 23, 131, 23);
			add(lblNewLabel_1);
		}
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	String Placa() {
		return txtPlaca.getText();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		txtS.setText("");
		vehiculo a = listavehiculo.Search(Placa());		
		 if(a!=null) {
			 a.registrarSalida(); // establezco el momento de Salido
			 //a.setFechaHoraSalida(LocalDateTime.of(2025, 6, 5, 20, 15)); //cambio la hora de salida;(AÑO, MES, DIA, 8:, 7)
			 //simular el tiempo adeleantado
			 txtS.setText("============Comprobante=========\n");
			 txtS.append(a.Salida());
			 listavehiculo.Delete(a);
			
			 JOptionPane.showMessageDialog(this,"Salida exitosa");
		 }else {JOptionPane.showMessageDialog(this,"Placa no existe");
			 
		 }
	}
}
