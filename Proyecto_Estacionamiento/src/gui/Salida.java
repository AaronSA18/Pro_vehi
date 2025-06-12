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
			txtPlaca.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(61, 178, 224, 26);
			add(txtPlaca);
		}
		{
			btnNewButton = new JButton("Generar comprobante");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(61, 310, 224, 33);
			add(btnNewButton);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(339, 76, 342, 361);
			add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			lblNewLabel_1 = new JLabel("Ingresar Placa : ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(61, 144, 131, 23);
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
		
		if(Placa().isEmpty()) {
			JOptionPane.showMessageDialog(this, 
	                "Campo vacio", 
	                "Error", 
	                JOptionPane.ERROR_MESSAGE);
	            return;
		}
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
		 }else {JOptionPane.showMessageDialog(
	                this,
	                "La placa " + Placa() + " NO  está registrada",
	                "Placa duplicada",
	                JOptionPane.WARNING_MESSAGE);
			 
		 }
	}
}
