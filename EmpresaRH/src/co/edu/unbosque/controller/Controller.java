package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.unbosque.model.Empresa;
import co.edu.unbosque.view.FrameMenu;

public class Controller implements ActionListener{

	private FrameMenu menu;
	private Empresa emp;
	
	
	public Controller() {
		menu = new FrameMenu(this);
		menu.setVisible(true);
		emp = new Empresa();
	}
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("AGREGAR")) {
			menu.abrirFrameAgregar(this);
		}if(e.getActionCommand().equals("SIGUIENTE")) {
			if(!menu.getFa().getNomtf().getText().matches("[a-zA-Z\s]*")){
				menu.mostrarFallo("Ingresa solo letras en el campo del nombre");
			}else if (!menu.getFa().getApetf().getText().matches("[a-zA-Z\s]*")){
				menu.mostrarFallo("Ingresa solo letras en el campo de los apellidos");
			}else if (!menu.getFa().getCartf().getText().matches("[a-zA-Z\s]*")){
				menu.mostrarFallo("Ingresa solo letras en el campo de el cargo");
			}else if (!menu.getFa().getCedtf().getText().matches("[0-9\s]*")) {
				menu.mostrarFallo("Ingresa solo números en el campo de la cédula");
			}else if (!menu.getFa().getEdadtf().getText().matches("[0-9\s]*")) {
				menu.mostrarFallo("Ingresa solo números en el campo de la edad");
			}else {
				String nombres = menu.getFa().getNomtf().getText();
				String cargo = menu.getFa().getCartf().getText();
				String apellidos = menu.getFa().getApetf().getText();
				try{
					int edad = Integer.parseInt(menu.getFa().getEdadtf().getText());
					int cedula = Integer.parseInt(menu.getFa().getCedtf().getText());	
					emp.getCandi().agregarCandidato(nombres, apellidos, cedula, edad, cargo);
					emp.getCandfil().guardarCandidatos(emp.getCandi().getCandidatos());
				}catch(NumberFormatException nfe){
					menu.mostrarFallo("No dejes espacios en blanco!");
				}
				menu.abrirFrameMenu();
			}
		}if(e.getActionCommand().equals("LISTAR")) {
			if(emp.getCandi().listarCandidatos().equals("")) {
				menu.mostrarFallo("No hay candidatos en la lista");
			}else {
				menu.mostrarMensaje(emp.getCandi().listarCandidatos());
			}
		}if(e.getActionCommand().equals("VOLVER")) {
			menu.abrirFrameMenu();
		}if(e.getActionCommand().equals("LISTARFIL")) {
			try{
				menu.mostrarMensaje(emp.getCandi().listarCandidatoPorCedula(menu.capturarDatos()));
			}catch(NumberFormatException nfe) {
				menu.abrirFramePrincipal();
			}
		}if(e.getActionCommand().equals("ELIMINAR")) {
			emp.getCandi().eliminarCandidatos();
			menu.mostrarMensaje("Candidatos eliminados");
		}
	}

}
