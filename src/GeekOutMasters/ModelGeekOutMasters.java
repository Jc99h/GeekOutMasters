package GeekOutMasters;

/**
 * @author Camilo Ordoñez
 * @version v.1.0.0 date 09/01/2022
 */

public class ModelGeekOutMasters {
	private Dado[] dados;
	private String[] caras;
	private String estadoToString;
	private int flag, estado;

	/**
	 * Class constructor
	 */
	public ModelGeekOutMasters()
	{
		dados = new Dado[10];
		dados[0]= new Dado();
		dados[1]= new Dado();
		dados[2]= new Dado();
		dados[3]= new Dado();
		dados[4]= new Dado();
		dados[5]= new Dado();
		dados[6]= new Dado();
		dados[7]= new Dado();
		dados[8]= new Dado();
		dados[9]= new Dado();
		caras = new String[10];
		flag=5;
		estado=5;
	}

	/**
	 * Establece la cara del dado
	 */
	public void lanzarDado()
	{
		for(int cual=0; cual<10; cual++)
		{
			caras[cual] = dados[cual].getCara();
		}
		caras[0] = "meeple";
	}

	/**
	 * Retorna el valor de las caras de los dados
	 * @return caras
	 */

	public String[] getCaras()
	{
		return caras;
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
	public void dadoClickeado(String cara)
	{
		if(cara=="meeple")
		{
			flag=0;
		}
	}

	public String relanzarDado(Dado dado, int cual)
	{
		caras[cual] = dado.getCara();
		return caras[cual];
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

