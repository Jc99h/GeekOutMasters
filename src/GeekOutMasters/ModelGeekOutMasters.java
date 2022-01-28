package GeekOutMasters;

/**
 * @author Danny Lopez 1941453-2711 danny.cardenas@correounivalle.edu.co
 * @author Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 * @version v.1.0.0 date 09/01/2022
 */

public class ModelGeekOutMasters {
    public boolean juegoTerminado;
    private Dado[] dados;
    private String estadoToString;
    private int flag, estado, puntajeASumar, puntajeTotal, ronda;

    /**
     * Class constructor
     */
    public ModelGeekOutMasters() {
        dados = new Dado[10];

        for (int i = 0; i < dados.length; i++) {
            dados[i] = new Dado();
        }

        juegoTerminado = false;
        flag = 0;
        estado = 0;
        puntajeASumar = 0;
        puntajeTotal = 0;
        ronda = 1;
    }

    /**
     * Establece la cara del dado
     */
    public void initDados() {
        for (int cual = 0; cual < 10; cual++) {
            dados[cual].setCara();
        }
    }

    /**
     * Retorna el numero de la ronda
     * @return ronda
     */

    public int getRonda() {
        return ronda;
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

    /**
     * Cambia el valor del flag
     * @param numero
     */

    public void setFlag(int numero) {

        flag = numero;
        estado = numero;
    }

    /**
     * Retorna el valor del puntaje total
     * @return
     */

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    /**
     * Determina el estado del juego
     * 1. Estado Meeple, le indica al jugador que relance un dado de los dados activos
     * 2. Estado Super Heroe, le indica al jugador que puede voltear un dado a su cara opuesta
     * 3. Estado Corazon, le indica al jugador que relance un dados de los dados inactivos
     * 4. Estado Cohete, le indica al jugador que envie uno de los dados activos a panel inactivos
     * 5. Estado ronda terminada, le indica al jugador que ya se termino la ronda y se procede a calcular el puntaje
     */
    public void determinarJuego() {
        if (flag == 1) {
            estado = 1;
        }
        if (flag == 2) {
            estado = 2;
        }
        if (flag == 3) {
            estado = 3;
        }
        if (flag == 4) {
            estado = 4;
        }
        if (flag == 5) {
            estado = 5;
        }
    }

    /**
     * Determina la cara del dado clickeado
     */
    public void dadoClickeado(Dado dado) {
        if (dado.getCara() == "meeple") {
            flag = 1;
        } else if (dado.getCara() == "superHeroe") {
            flag = 2;
        } else if (dado.getCara() == "corazon") {
            flag = 3;
        } else if (dado.getCara() == "cohete") {
            flag = 4;
        }
    }

    /**
     * Relanza un dado
     *
     * @param dado
     * @return
     */

    public String relanzarDado(Dado dado) {
        dado.setCara();
        return dado.getCara();
    }

    /**
     * Clase que determina si la ronda ha finalizado
     * @return true or false
     */

    public boolean rondaFinalizada() {
        int controlDados = 0;
        int dadosDragon42 = 0;
        for (int i = 0; i < dados.length; i++) {
            if (dados[i].getPanel() == "activo") {
                if (dados[i].getCara() == "corazon") {
                    return false;
                }
                if (dados[i].getCara() == "meeple" || dados[i].getCara() == "superHeroe" || dados[i].getCara() == "cohete") {
                    controlDados++;
                }
                if (dados[i].getCara() == "dragon" || dados[i].getCara() == "42") {
                    dadosDragon42++;
                }
            }
        }
        if (controlDados == 0) {
            return true;
        } else if (controlDados == 1 && dadosDragon42 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Clase que calcula el puntaje
     */

    public void calcularPuntaje() {
        int dadosActivos = 0;
        int controlDragon = 0;
        int control42 = 0;
        for (int i = 0; i < dados.length; i++) {
            if (dados[i].getPanel() == "activo") {
                if (dados[i].getCara() == "meeple" || dados[i].getCara() == "superHeroe" || dados[i].getCara() == "cohete") {
                    estado = 5;
                    dadosActivos++;
                } else if (dados[i].getCara() == "dragon") {
                    controlDragon++;
                    dadosActivos++;
                } else if (dados[i].getCara() == "42") {
                    control42++;
                    dadosActivos++;
                }
            }
        }

        if (controlDragon > 0) {
            puntajeTotal = 0;
            estado = 7;
        } else if (controlDragon == 0 && control42 > 0) {
            puntajeASumar = 0;
            for (int i = 0; i < control42; i++) {
                puntajeASumar += i + 1;
            }

            puntajeTotal += puntajeASumar;
            estado = 8;
        } else if (dadosActivos == 0) {
            estado = 9;
        }

        if (ronda >= 5) {
            juegoTerminado = true;
            return;
        }

        ronda++;
    }

    /**
     * Inicia un nuevo juego
     */
    public void jugarNuevamente()
    {
        dados = new Dado[10];

        for (int i = 0; i < dados.length; i++) {
            dados[i] = new Dado();
        }

        juegoTerminado = false;
        flag = 0;
        estado = 0;
        puntajeASumar = 0;
        puntajeTotal = 0;
        ronda = 1;
    }

    /**
     * Establece un mensaje acorde al estado del juego
     *
     * @return estadoToString
     */
    public String getEstadoToString() {
        System.out.println(estado);
        switch (estado) {
            case 1:
                estadoToString = "Seleccionaste Meeple, ahora puedes volver a lanzar uno de los dados activos";
                break;
            case 2:
                estadoToString = "Seleccionaste Super Heroe, ahora puedes voltear un dado de la seccion de activos \n" + "y colocarlo en su cara opuesta";
                break;
            case 3:
                estadoToString = "Seleccionaste Corazon, ahora puedes lanzar uno de los dados del panel inactivos";
                break;
            case 4:
                estadoToString = "Seleccionaste Cohete, ahora puedes enviar un dado no usado de la seccion de \n" + "activos a la seccion de inactivos";
                break;
            case 5:
                estadoToString = "Ronda terminada, finalizaste con un super heroe, cohete, o meeple. \n" + "En esta ronda no ganas puntos y conservas los ya acumulados";
                break;
            case 6:
                estadoToString = "No se sabe.";
                break;
            case 7:
                estadoToString = "Terminaste solo con cara Dragon, pierdes todos tus puntos acumulados";
                break;
            case 8:
                estadoToString = "Felicitaciones, terminaste solo con caras 42, sumaste " + puntajeASumar + " puntos\n" + "En total tienes " + puntajeTotal + " puntos.";
                puntajeASumar = 0;
                break;
            case 9:
                estadoToString = "Ronda terminada, no quedan dados activos.\n" + "En esta ronda no ganas puntos y conservas los ya acumulados";
                break;
            case 10:
                estadoToString = "Partida terminada, has terminado con " + puntajeTotal + " puntos. \n";
                if (puntajeTotal >= 30) {
                    estadoToString += "Has ganado.";
                } else {
                    estadoToString += "Has perdido.";
                }
                break;

            default:
                estadoToString = "no setteado" + estado;
                break;
        }
        return estadoToString;
    }
}

