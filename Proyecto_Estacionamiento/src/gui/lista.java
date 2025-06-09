package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Arreglos.vehicleArray;
import clases.vehiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lista extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JScrollPane scrollPane = new JScrollPane();
	
	private final JTextArea txtS = new JTextArea();
	
	private final JButton btnBuscar = new JButton("Buscar");
	private final JButton btnNewButton = new JButton("Listar");
	
	private final JLabel lblNewLabel = new JLabel("Ingresar Placa : ");
	
	private final JTextField txtPlaca = new JTextField();
	private vehicleArray list = vehicleArray.getInstancia();
	

	/**
	 * Create the panel.
	 */
	public lista() {
		setLayout(null);
		list.registrarPanelLista(this);
		
		{
			
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(150, 58, 105, 23);
			add(btnBuscar);
		}
		{
			
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(20, 58, 105, 23);
			add(btnNewButton);
		}
		{
			
			scrollPane.setBounds(20, 103, 408, 195);			
		    scrollPane.setViewportView(txtS);
			add(scrollPane);
			mostrarDatos();						
		}
		{
			
			txtPlaca.setBounds(130, 25, 125, 20);
			add(txtPlaca);
			txtPlaca.setColumns(10);
		}
		{
			
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(20, 22, 131, 23);
			add(lblNewLabel);
		}
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	
	String Placa() {
		if(txtPlaca.getText().isEmpty())
			return null;
		return txtPlaca.getText();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) { //Listar todo
		mostrarDatos();
	}
	
	
	public void mostrarDatos() {
        SwingUtilities.invokeLater(() -> {
            txtS.setText("");
            if (list.Size() > 0) {
                for (int i = 0; i < list.Size(); i++) {
                    txtS.append(list.Get(i).Entrada() + "\n");
                }
            } else {
                txtS.setText("No hay vehículos registrados");
            }
        });
    }
	
	
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) { //Buscar
		txtS.setText("");
		if(Placa()==null) {
			JOptionPane.showMessageDialog(
					 this,
	                   "Ingrese placa",
	                    "DATO VACIO",
	                    JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		vehiculo a = list.Search(Placa());
		
		 if(a!=null) {
			 JOptionPane.showMessageDialog(
					 this,
	                   a.DatoVehiculo(),
	                    "Registro exitoso",
	                    JOptionPane.INFORMATION_MESSAGE);
		 }else {
			 JOptionPane.showMessageDialog(
					 this,
	                   "Placa no existe",
	                    "Registro ERROR",
	                    JOptionPane.INFORMATION_MESSAGE);
			 return;
			 
		 }
		 for (int i = 0; i < list.Size(); i++) {			
				txtS.append(list.Get(i).Entrada());			
			}	
		
	
	}
}
