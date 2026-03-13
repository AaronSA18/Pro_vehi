package clases;

import Arreglos.ClienteArray;

public class cliente {
	private String nomCliente,apeCliente,telfCliente;
	private int codCliente;
	private ClienteArray listaCliente;

	public cliente(String nomCliente, String apeCliente, String telfCliente, int codCliente) {
		this.nomCliente = nomCliente;
		this.apeCliente = apeCliente;
		this.telfCliente = telfCliente;
		this.codCliente = codCliente;
		this.listaCliente = new ClienteArray();
		
	}
	
	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getApeCliente() {
		return apeCliente;
	}

	public void setApeCliente(String apeCliente) {
		this.apeCliente = apeCliente;
	}

	public String getTelfCliente() {
		return telfCliente;
	}

	public void setTelfCliente(String telfCliente) {
		this.telfCliente = telfCliente;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public ClienteArray getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ClienteArray listaCliente) {
		this.listaCliente = listaCliente;
	}

	//method
	public  String toString() { //cod-nombre-apellido-telf
		return codCliente+"\t"+nomCliente+"\t"+apeCliente+"\t"+telfCliente ;
		
	}

	
}
