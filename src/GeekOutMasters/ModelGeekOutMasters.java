package GeekOutMasters;

/**
 * @author Camilo Ordoñez
 * @version v.1.0.0 date 09/01/2022
 */

public class ModelGeekOutMasters {
	private Dado dado0, dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9;
	private String[] caras;

	/**
	 * Class constructor
	 */
	public ModelGeekOutMasters()
	{
		dado0 = new Dado();
		dado1 = new Dado();
		dado2 = new Dado();
		dado3 = new Dado();
		dado4 = new Dado();
		dado5 = new Dado();
		dado6 = new Dado();
		dado7 = new Dado();
		dado8 = new Dado();
		dado9 = new Dado();
		caras = new String[10];
	}

	/**
	 * Establece la cara del dado
	 */
	public void lanzarDado()
	{
		caras[0] = dado0.getCara();
		caras[1] = dado1.getCara();
		caras[2] = dado2.getCara();
		caras[3] = dado3.getCara();
		caras[4] = dado4.getCara();
		caras[5] = dado5.getCara();
		caras[6] = dado6.getCara();
		caras[7] = dado7.getCara();
		caras[8] = dado8.getCara();
		caras[9] = dado9.getCara();
	}

	public String[] getCaras()
	{
		return caras;
	}
}

