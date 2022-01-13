package GeekOutMasters;

/**
 * @author Danny Lopez 1941453-2711 danny.cardenas@correounivalle.edu.co
 * @version v.1.0.0 date 09/01/2022
 * @autor Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 */

public class ModelGeekOutMasters {
    private Dado[] dados;
    private String estadoToString;
    private int flag, estado;

    /**
     * Class constructor
     */
    public ModelGeekOutMasters() {
        dados = new Dado[10];

        for (int i = 0; i < dados.length; i++) {
            dados[i] = new Dado();
        }

        flag = 5;
        estado = 5;
    }

    /**
     * Establece la cara del dado
     */
    public void initDados() {
        for (int cual = 0; cual < 10; cual++) {
            dados[cual].setCara();
        }

        dados[0].setCara(1);
    }

    /**
     * Retorna la lista de dados
     *
     * @return dados
     */
    public Dado[] getListaDados() {
        return dados;
    }

    /**
     * Retorna el valor de flag
     *
     * @return flag
     */
    public int getFlag() {
        return flag;
    }

    public void setFlag(int numero) {

        flag = numero;
        estado = numero;
    }

    /**
     * Determina el estado del juego
     * 1. Estado Meeple, le indica al jugador que relance un dado del los dados activos
     */
    public void determinarJuego() {
        if (flag == 0) {
            estado = 0;
        }
        if (flag == 3) {
            estado = 3;
        }
        if (flag == 4) {
            estado = 4;
        }
    }

    /**
     * Determina la cara del dado clickeado
     */
    public void dadoClickeado(Dado dado) {
        if (dado.getCara() == "meeple") {
            flag = 0;
        } else if (dado.getCara() == "corazon") {
            flag = 3;
        } else if (dado.getCara() == "cohete") {
            flag = 4;
        }
    }

    public String relanzarDado(Dado dado) {
        dado.setCara();
        return dado.getCara();
    }

    /**
     * Establece un mensaje acorde al estado del juego
     *
     * @return estadoToString
     */
    public String getEstadoToString() {
        switch (estado) {
            case 0:
                estadoToString = "Seleccionaste Meeple, ahora puedes volver a lanzar uno de los dados activos";
                break;
            case 3:
                estadoToString = "Seleccionaste Corazon, ahora puedes lanzar uno de los dados del panel inactivos";
                break;
            case 4:
                estadoToString = "Seleccionaste Cohete, ahora puedes enviar un dado no usado de la seccion de \n" + "activos a la seccion de inactivos";
                break;
            default:
                estadoToString = "no setteado";
                break;
        }
        return estadoToString;
    }
}

