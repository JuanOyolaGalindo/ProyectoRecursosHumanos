package co.edu.unbosque.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import co.edu.unbosque.controller.Controller;

public class FrameMenu extends JFrame{
	private JButton agregarBut;
	private JButton listarBut;
	private JButton listarfilBut;
	private JButton eliminarBut;
	public 	static final String AGREGAR = "AGREGAR";
	public static final String LISTAR = "LISTAR";
	public static final String LISTARFIL = "LISTARFIL";
	public static final String ELIMINAR = "ELIMINAR";
	
	private FrameAgregar fa;
	
	public FrameMenu(Controller pControl) {
		agregarBut = new JButton("Agregar candidato");
		listarBut = new JButton("Listar candidatos");
		listarfilBut = new JButton("Encontrar candidato");
		eliminarBut= new JButton ("Eliminar candidatos");
		setSize(350,300);
		setResizable(false);
		setTitle("RecursosHumanos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		agregarBut.setActionCommand(AGREGAR);
		agregarBut.addActionListener(pControl);
		agregarBut.setFocusPainted(false);
		agregarBut.setBounds(90, 50, 155, 30);
		
		listarBut.setActionCommand(LISTAR);
		listarBut.addActionListener(pControl);
		listarBut.setFocusPainted(false);
		listarBut.setBounds(90, 90, 155, 30);
		
		listarfilBut.setActionCommand(LISTARFIL);
		listarfilBut.addActionListener(pControl);
		listarfilBut.setFocusPainted(false);
		listarfilBut.setBounds(90, 130, 155, 30);
		
		eliminarBut.setActionCommand(ELIMINAR);
		eliminarBut.addActionListener(pControl);
		eliminarBut.setFocusPainted(false);
		eliminarBut.setBounds(90, 170, 155, 30);
		
		add(agregarBut);
		add(listarBut);
		add(listarfilBut);
		add(eliminarBut);
	}
	
	public void abrirFrameAgregar(Controller pControl) {
		fa = new FrameAgregar(pControl);
		fa.setVisible(true);
		this.setVisible(false);
	}
	
	
	public JButton getAgregarBut() {
		return agregarBut;
	}

	public void setAgregarBut(JButton agregarBut) {
		this.agregarBut = agregarBut;
	}

	public JButton getListarBut() {
		return listarBut;
	}

	public void setListarBut(JButton listarBut) {
		this.listarBut = listarBut;
	}

	public JButton getListarfilBut() {
		return listarfilBut;
	}

	public void setListarfilBut(JButton listarfilBut) {
		this.listarfilBut = listarfilBut;
	}

	public JButton getEliminarBut() {
		return eliminarBut;
	}

	public void setEliminarBut(JButton eliminarBut) {
		this.eliminarBut = eliminarBut;
	}
	
	
}
