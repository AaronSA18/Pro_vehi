package Arreglos;

import java.util.ArrayList;

import clases.cliente;


public class ClienteArray {
	
	private static ArrayList<cliente> ListaCliente;
	
	public ClienteArray() {
		ListaCliente = new ArrayList<cliente>();			
	}
	
	public void Agregar(cliente v) {
		ListaCliente.add(v);
	}
	
	public cliente Obtener(int v) {
		return ListaCliente.get(v);
	}
	
	public int Tamaño() {
		return ListaCliente.size();
	}
	
	public cliente Search(String nombre) {
		for (int i = 0; i < Tamaño(); i++) {
			if (Obtener(i).getNomCliente().equals(nombre)) {
				return Obtener(i);
			}
		}
		return null;
	}
	
	public void Delete(cliente x) {
		ListaCliente.remove(x);
	}
}
