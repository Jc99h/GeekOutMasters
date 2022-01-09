package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 * @version @version v.1.0.0 date:10/12/2021
 */
public class GUI extends JFrame {

	private static final String MENSAJE_INICIO= "El objetivo de este juego es conseguir la mayor cantidad\n"+
																							"de puntos juntando dados cuya cara visible es la cara 42.\n"+
																							"Geek Out Masters no es solo suerte, también importa la\n"+
																							"estrategia ya que una vez que se lanzan los dados TODAS las\n"+
																							"caras deberán ejecutarse:\n"+
																							"1) Los Meeples permiten relanzar un dado activo\n"+
																							"2) Las Naves Espaciales pasan un dado al area de inactivos\n"+
																							"3) Los Dragones causaran la perdida del juego si no hay mas acciones disponibles\n"+
																							"4) Los Superhéroes dan vuelta un dado\n"+
																							"5) Los Corazones nos permitiran lanzar un dado del area inactivos\n"+
																							"6) Los 42 nos permiten ganar puntos\n"+
																							"El juego está compuesto por: 10 dados de Geek Out\n"+
																							"1 ayuda memoria, 1 Tarjeta de puntuación.";

	private Header headerProject;
	private JLabel  dado0, dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, marcadorDePuntaje;
  private JButton ayuda, salir, jugar;
	private JPanel panelDadosInactivos, panelDadosUtilizados, panelDadosActivos, panelMarcadorDePuntaje;
	private ImageIcon imagenDado, imagenMarcadorDePuntaje;
	private JTextArea mensaje, numeroRonda, numeroPuntaje;
	private Escucha escucha;
	private ModelGeekOutMasters modelGeekOutMasters;

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
		modelGeekOutMasters = new ModelGeekOutMasters();
		//Set up JComponents
		headerProject = new Header("Mesa Juego Geek Out Masters", Color.BLACK);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=4;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		this.add(headerProject,constraints);

		ayuda = new JButton("?");
		ayuda.addActionListener(escucha);
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
		constraints.gridx=2;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		this.add(numeroPuntaje, constraints);

		salir = new JButton("Salir");
		salir.addActionListener(escucha);
		constraints.gridx=3;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.fill=GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.LINE_END;
		this.add(salir, constraints);

		panelDadosInactivos = new JPanel();
		panelDadosInactivos.setPreferredSize(new Dimension(250,200));
		panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
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
		dado0 = new JLabel();
		panelDadosActivos.add(dado0);
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.gridwidth=2;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.CENTER;
		add(panelDadosActivos, constraints);

		panelMarcadorDePuntaje = new JPanel();
		panelMarcadorDePuntaje.setPreferredSize(new Dimension(250,200));
		panelMarcadorDePuntaje.setBorder(BorderFactory.createTitledBorder("Marcador de Puntaje"));
		imagenMarcadorDePuntaje = new ImageIcon(getClass().getResource("/resources/puntaje.png"));
		marcadorDePuntaje = new JLabel(imagenMarcadorDePuntaje);
		panelMarcadorDePuntaje.add(marcadorDePuntaje);
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

		jugar = new JButton("Presione para jugar");
		jugar.addActionListener(escucha);
		constraints.gridx=0;
		constraints.gridy=5;
		constraints.gridwidth=4;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.anchor=GridBagConstraints.CENTER;
		this.add(jugar, constraints);

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
	private class Escucha implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent objectEvent)
		{
		  if(objectEvent.getSource()==ayuda)
			{
				JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
			}
			if(objectEvent.getSource()==salir)
			{
				System.exit(0);
			}
			if(objectEvent.getSource()==jugar)
			{
				modelGeekOutMasters.lanzarDado();
				String caras[] = modelGeekOutMasters.getCaras();
				for(int cual=0; cual<10; cual++)
				{
					imagenDado = new ImageIcon(getClass().getResource("/resources/42.jpg"));
					dado0.setIcon(imagenDado);
				}
			}
		}
	}
}