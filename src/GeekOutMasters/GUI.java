package GeekOutMasters;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 * @version @version v.1.0.0 date:10/12/2021
 */
public class GUI extends JFrame {

	private Header headerProject;
	private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
  private JButton ayuda, salir;
	private JPanel panelDadosInactivos, panelDadosUtilizados, panelDadosActivos, panelMarcadorDePuntaje;
	private ImageIcon imagenDado, imagenMarcadorDePuntaje;
	private JTextArea mensaje, numeroRonda, numeroPuntaje;
	private Escucha escucha;

	/**
	 * Constructor of GUI class
	 */
	public GUI(){
		initGUI();

		//Default JFrame configuration
		this.setTitle("Geek Out Masters");
		this.pack();
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method is used to set up the default JComponent Configuration,
	 * create Listener and control Objects used for the GUI class
	 */
	private void initGUI() {
		//Set up JFrame Container's Layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		//Create Listener Object and Control Object
		escucha = new Escucha();
		//Set up JComponents
		headerProject = new Header("Mesa Juego Geek Out Masters", Color.BLACK);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=4;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		this.add(headerProject,constraints);

		ayuda = new JButton("?");
		//ayuda.addActionListener(escucha);
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.fill=GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.LINE_START;
		this.add(ayuda, constraints);

		numeroRonda = new JTextArea(1, 10);
		numeroRonda.setBorder(BorderFactory.createTitledBorder("Ronda:"));
		numeroRonda.setText("#1");
		numeroRonda.setEditable(false);
		//ayuda.addActionListener(escucha);
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.fill=GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.CENTER;
		this.add(numeroRonda, constraints);

		numeroPuntaje = new JTextArea(1, 10);
		numeroPuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje:"));
		numeroPuntaje.setText("0 puntos");
		numeroPuntaje.setEditable(false);
		//ayuda.addActionListener(escucha);
		constraints.gridx=2;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		this.add(numeroPuntaje, constraints);

		salir = new JButton("Salir");
		//ayuda.addActionListener(escucha);
		constraints.gridx=3;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.fill=GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.LINE_END;
		this.add(salir, constraints);

		panelDadosInactivos = new JPanel();
		panelDadosInactivos.setPreferredSize(new Dimension(250,200));
		panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
		//panelDadosInactivos.add(cartaMaquina);
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth=2;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		add(panelDadosInactivos, constraints);

		panelDadosUtilizados = new JPanel();
		panelDadosUtilizados.setPreferredSize(new Dimension(250,200));
		panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Utilizados"));
		//panelDadosUtilizados.add(cartaMaquina);
		constraints.gridx=2;
		constraints.gridy=2;
		constraints.gridwidth=2;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		add(panelDadosUtilizados, constraints);

		panelDadosActivos = new JPanel();
		panelDadosActivos.setPreferredSize(new Dimension(250,200));
		panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
		//panelDadosUtilizados.add(cartaMaquina);
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.gridwidth=2;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		add(panelDadosActivos, constraints);

		panelMarcadorDePuntaje = new JPanel();
		panelMarcadorDePuntaje.setPreferredSize(new Dimension(250,200));
		panelMarcadorDePuntaje.setBorder(BorderFactory.createTitledBorder("Marcador de Puntaje"));
		//panelDadosUtilizados.add(cartaMaquina);
		constraints.gridx=2;
		constraints.gridy=3;
		constraints.gridwidth=2;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		add(panelMarcadorDePuntaje, constraints);

		mensaje = new JTextArea(5, 20);
		mensaje.setBorder(BorderFactory.createTitledBorder("Mensajes:"));
		mensaje.setText("0 puntos");
		mensaje.setEditable(false);
		//ayuda.addActionListener(escucha);
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.gridwidth=4;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.anchor=GridBagConstraints.CENTER;
		this.add(mensaje, constraints);

	}

	/**
	 * Main process of the Java program
	 * @param args Object used in order to send input data from command line when
	 *             the program is execute by console.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(() -> {
			GUI miProjectGUI = new GUI();
		});
	}

	/**
	 * inner class that extends an Adapter Class or implements Listeners used by GUI class
	 */
	private class Escucha
	{

	}
}