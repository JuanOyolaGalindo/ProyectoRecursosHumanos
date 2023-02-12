package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.FrameMenu;

public class Controller implements ActionListener{

	private FrameMenu menu;
	
	
	
	public Controller() {
		menu = new FrameMenu(this);
		menu.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("AGREGAR")) {
			menu.abrirFrameAgregar(this);
		}
	}

}
