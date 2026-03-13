package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import Arreglos.ClienteArray;
import Arreglos.vehicleArray;
import clases.Factura;
import clases.cliente;
import clases.vehiculo;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Registro extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblRegistrarNuevoVehculo_1;
	private JLabel lblNewLabel_1;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JLabel lblMarca;
	private JLabel lblVehculo;
	private JComboBox cmbTipo;
	private JLabel lblRegistrarChofer;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JTextField txtTelf;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	
	vehicleArray listaVehiculo = vehicleArray.getInstancia();
	private JButton btnModificar;
	
	/**
	 * Create the panel.
	 */
	public Registro() {
		
		setLayout(null);
		
		{
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtApellido.setColumns(10);
			txtApellido.setBounds(141, 329, 170, 20);
			add(txtApellido);
		}
		{
			lblRegistrarChofer = new JLabel("Chofer");
			lblRegistrarChofer.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblRegistrarChofer.setBounds(61, 270, 215, 26);
			add(lblRegistrarChofer);
		}
		{
			cmbTipo = new JComboBox();
			cmbTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Ligero", "Pesado"}));
			cmbTipo.setBounds(129, 169, 182, 26);
			add(cmbTipo);
		}
		{
			lblNewLabel_2 = new JLabel("Imagen");
			lblNewLabel_2.setBounds(529, 44, 139, 96);
			add(lblNewLabel_2);
		}
		{
			txtTelf = new JTextField();
			txtTelf.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtTelf.setColumns(10);
			txtTelf.setBounds(141, 354, 170, 20);
			add(txtTelf);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(129, 113, 182, 20);
			add(txtPlaca);
		}
		{
			lblNewLabel_1 = new JLabel("Placa:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(64, 116, 62, 14);
			add(lblNewLabel_1);
		}
		{
			lblVehculo = new JLabel("Vehículo: ");
			lblVehculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVehculo.setBounds(61, 173, 65, 14);
			add(lblVehculo);
		}
		{
			txtMarca = new JTextField();
			txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtMarca.setColumns(10);
			txtMarca.setBounds(129, 141, 182, 20);
			add(txtMarca);
		}
		{
			lblTelefono = new JLabel("Telefono :");
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTelefono.setBounds(61, 355, 82, 19);
			add(lblTelefono);
		}
		{
			btnNewButton = new JButton("Ingresar");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(556, 450, 139, 26);
			add(btnNewButton);
		}
		{
			lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMarca.setBounds(61, 144, 84, 14);
			add(lblMarca);
		}
		{
			lblNombre = new JLabel("Nombre :");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNombre.setBounds(62, 309, 83, 14);
			add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido :");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblApellido.setBounds(62, 329, 83, 20);
			add(lblApellido);
		}
		{
			lblRegistrarNuevoVehculo_1 = new JLabel("Nuevo vehículo");
			lblRegistrarNuevoVehculo_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblRegistrarNuevoVehculo_1.setBounds(61, 79, 287, 26);
			add(lblRegistrarNuevoVehculo_1);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtNombre.setColumns(10);
			txtNombre.setBounds(141, 304, 170, 20);
			add(txtNombre);
		}
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBounds(388, 450, 139, 26);
		add(btnModificar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	
	String Placa() {
		return txtPlaca.getText();
	}
	String Marca() {
		return txtMarca.getText();
	}
	String tipoVehiculo() {
		return  cmbTipo.getSelectedItem().toString();
	}
	String NomCliente() {
		return txtNombre.getText();
	}
	String ApeCliente() {
		return txtApellido.getText();
	}
	String Telf() {
		return txtTelf.getText();	
	}
	int Contador() {
		int b=0;
		if(listaVehiculo.Size()==b)return 1;
		else if(listaVehiculo.Size()>b)return listaVehiculo.Size()+1;
		return b+1;
		
	}
	
	private void limpiarCampos() {
	    txtPlaca.setText("");
	    txtMarca.setText("");
	    txtNombre.setText("");
	    txtApellido.setText("");
	    txtTelf.setText("");
	    cmbTipo.setSelectedIndex(0);
	    txtPlaca.requestFocus(); // Pone el foco en el campo de placa
	}
	public boolean MensajesVacios() {
		if(Placa().isEmpty() || Marca().isEmpty() || NomCliente().isEmpty() || 
		           ApeCliente().isEmpty() || Telf().isEmpty()) {
		            JOptionPane.showMessageDialog(this, 
		                "Todos los campos son obligatorios", 
		                "Error", 
		                JOptionPane.ERROR_MESSAGE);
		            return false;
		        }
		return true;
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	try {
	        // Validar campos obligatorios
	        if(MensajesVacios()==false)return;

	        vehiculo v = listaVehiculo.Search(Placa());
	        
	        if(v != null) {
	            JOptionPane.showMessageDialog(
	                this,
	                "La placa " + Placa() + " ya está registrada",
	                "Placa duplicada",
	                JOptionPane.WARNING_MESSAGE
	            );
	        }
	        else {
	            int k = Contador(); //ayuda estabilizar el mismo a vehiculo y chofer
	            cliente a = new cliente(NomCliente(), ApeCliente(), Telf(), k);
	            Factura b = new Factura(k);
	            v = new vehiculo(Placa(), Marca(), tipoVehiculo(), a, k,b);
	            
	            //listaVehiculo.Add(v);
	           vehicleArray.getInstancia().Add(v);
	           
	                
	                // Mensaje de confirmación
	                JOptionPane.showMessageDialog(
	                    this,
	                    "Vehículo registrado:\n" +
	                    "Placa: " + v.getPlacVehiculo() + "\n" +
	                    "Marca: " + v.getMarVehiculo() + "\n" +
	                    "Dueño: " + a.getNomCliente() + " " + a.getApeCliente(),
	                    "Registro exitoso",
	                    JOptionPane.INFORMATION_MESSAGE
	                );
	                
	                // Limpiar campos después del registro
	                
	                limpiarCampos();
	            }
	        
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this,"Error al registrar");
	    }
		
	}
	//private lista panelLista;
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
		if(MensajesVacios()==false)return;
		
		 vehiculo v = listaVehiculo.Search(Placa());
		 
		 if(v != null) {
			v.setPlacVehiculo(Placa());
			v.setMarVehiculo(Marca());
			v.setTipVehiculo(tipoVehiculo());
			v.getCli().setNomCliente(NomCliente());
			v.getCli().setApeCliente(ApeCliente());
			v.getCli().setTelfCliente(Telf());
	                
	                // Mensaje de confirmación
	                JOptionPane.showMessageDialog(
	                    this,
	                    "Vehículo registrado:\n" +
	                    "Placa: " + v.getPlacVehiculo() + "\n" +
	                    "Marca: " + v.getMarVehiculo() + "\n" +
	                    "Dueño: " + v.getCli().getNomCliente() + " " + v.getCli().getApeCliente(),
	                    "Registro exitoso",
	                    JOptionPane.INFORMATION_MESSAGE
	                );
	             
	                // Limpiar campos después del registro
	                listaVehiculo.Notificar();
	                limpiarCampos();
	        }else {
	        	JOptionPane.showMessageDialog(
						 this,
		                   "Placa NO existe",
		                    "Modificar ",
		                    JOptionPane.INFORMATION_MESSAGE);
	        }
		} catch (Exception ex) {
	        JOptionPane.showMessageDialog(this,"Error al Modificar");
	    }	 	
		
	}
}
