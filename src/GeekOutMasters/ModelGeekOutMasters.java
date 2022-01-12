package GeekOutMasters;

/**
 * @autor Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 * @author Danny Lopez 1941453-2711 danny.cardenas@correounivalle.edu.co
 * @version v.1.0.0 date 09/01/2022
 */

public class ModelGeekOutMasters {
	private Dado[] dados;
	private String estadoToString;
	private int flag, estado;

	/**
	 * Class constructor
	 */
	public ModelGeekOutMasters()
	{
		dados = new Dado[10];

		for (int i = 0; i < dados.length; i++) {
			dados[i] = new Dado();
		}

		flag=5;
		estado=5;
	}

	/**
	 * Establece la cara del dado
	 */
	public void lanzarDado()
	{
		for(int cual=0; cual<10; cual++) {
			dados[cual].setCara();
		}

		dados[0].setCara(1);
	}

	/**
	 * Retorna la lista de dados
	 * @return dados
	 */
	public Dado[] getListaDados()
	{
		return dados;
	}

	/**
	 * Retorna el valor de flag
	 * @return flag
	 */
	public int getFlag()
	{
		return flag;
	}

	public void setFlag(int numero)
	{
		flag = numero;
	}

	/**
	 * Determina el estado del juego
	 * 1. Estado Meeple, le indica al jugador que relance un dado del los dados activos
	 */
	public void determinarJuego()
	{
		if(flag==0)
		{
			estado=0;
		}
	}

	/**
	 * Determina la cara del dado clickeado
	 */
	public void dadoClickeado(Dado dado)
	{
		if(dado.getCara()=="meeple")
		{
			flag=0;
		}
	}

	public String relanzarDado(Dado dado)
	{
		dado.setCara();
		return dado.getCara();
	}

	/**
	 * Establece un mensaje acorde al estado del juego
	 * @return estadoToString
	 */
	public String getEstadoToString()
	{
		switch (estado)
		{
			case 0:
							estadoToString = "Seleccionaste Meeple, ahora puedes volver a lanzar uno de los dados activos";
							break;
		}
		return estadoToString;
	}
}

