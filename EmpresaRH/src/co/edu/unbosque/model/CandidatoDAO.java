package co.edu.unbosque.model;

import java.util.ArrayList;

public class CandidatoDAO {
	private ArrayList<CandidatoDTO> candidatos;
	
	public CandidatoDAO(){
		candidatos = new ArrayList<>();
	}
	
	public void agregarCandidato(String pNom,String pApe, String pCed, int pEdad, String pCar) {
		CandidatoDTO candidato = new CandidatoDTO(pNom, pApe, pCed, pEdad, pCar);
		candidatos.add(candidato);
	}
	
	public String listarCandidatos() {
		String lista = "";
		for (int i =0;i<candidatos.size();i++) {
		 lista +=
				  "Cedula: "+ candidatos.get(i).getCedula() + "\n" +
				  "Nombres: " + candidatos.get(i).getNombre() + "\n" +
				  "Apellidos: " + candidatos.get(i).getApellido() + "\n"+
				  "Edad: " + candidatos.get(i).getEdad() + "\n" +
				  "Cargo: " + candidatos.get(i).getEdad() + "\n";
		}
		return lista;
	}
	public String listarCandidatoPorCedula(String pCed) {
		String candidato = "";
		int i = 0;
		boolean encontrado = false;
		while(i<candidatos.size()&&!encontrado) {
			if(pCed.equals(candidatos.get(i).getCedula())) {				
				candidato = "Cedula: "+ candidatos.get(i).getCedula() + "\n" +
						  "Nombres: " + candidatos.get(i).getNombre() + "\n" +
						  "Apellidos: " + candidatos.get(i).getApellido() + "\n"+
						  "Edad: " + candidatos.get(i).getEdad() + "\n" +
						  "Cargo: " + candidatos.get(i).getEdad() + "\n";
				encontrado = true;
			}else {
				encontrado = false;
				i++;
			}
		}
		return candidato;
	}
	public void eliminarCandidatos() {
		int i = 0;
		while(candidatos.get(i)!= null) {
			candidatos.remove(i);
			i++;
		}
	}
	
	public ArrayList<CandidatoDTO> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<CandidatoDTO> candidatos) {
		this.candidatos = candidatos;
	}
	
	
}
