package GeekOutMasters;

/**
 * @author Danny Lopez 1941453-2711 danny.cardenas@correounivalle.edu.co
 * @version v.1.0.0 date 09/01/2022
 * @author Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 */

public class ModelGeekOutMasters {
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

        flag = 0;
        estado = 0;
        puntajeASumar = 0;
        puntajeTotal = 0;
        ronda = 0;
    }

    /**
     * Establece la cara del dado
     */
    public void initDados() {
        for (int cual = 0; cual < 10; cual++) {
            dados[cual].setCara();
        }
    }

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

    public void setFlag(int numero) {

        flag = numero;
        estado = numero;
    }

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
     * @param dado
     * @return
     */

    public String relanzarDado(Dado dado) {
        dado.setCara();
        return dado.getCara();
    }

    public boolean rondaFinalizada() {
        int controlDados=0;
        int dadosDragon42=0;
        for(int i = 0; i < dados.length; i++)
        {
            if(dados[i].getPanel()=="activo") {
                if(dados[i].getCara()=="corazon") {
                    return false;
                }
                if(dados[i].getCara()=="meeple" || dados[i].getCara()=="superHeroe" || dados[i].getCara()=="cohete") {
                    controlDados++;
                }
                if(dados[i].getCara()=="dragon" || dados[i].getCara()=="42") {
                    dadosDragon42++;
                }
            }
        }
        if(controlDados==0) {
            return true;
        } else if (controlDados==1 && dadosDragon42==0) {
            return true;
        }
        return false;
    }

    public void calcularPuntaje() {
        int dadosActivos=0;
        int controlDragon=0;
        int control42=0;
        for(int i = 0; i < dados.length; i++) {
            if(dados[i].getPanel()=="activo") {
                if(dados[i].getCara()=="meeple" || dados[i].getCara()=="superHeroe" || dados[i].getCara()=="cohete") {
                    estado = 5;
                    dadosActivos++;
                } else if(dados[i].getCara()=="dragon") {
                    controlDragon++;
                    dadosActivos++;
                } else if(dados[i].getCara()=="42") {
                    control42++;
                    dadosActivos++;
                }
            }
        }
        if(controlDragon>0 && control42>0) {
            estado = 6;
        }
        if(controlDragon>0 && control42==0) {
            puntajeTotal = 0;
            estado = 7;
        }
        if(controlDragon==0 && control42>0) {
            switch (control42) {
                case 1:
                    puntajeASumar = 1;
                    break;
                case 2:
                    puntajeASumar = 3;
                    break;
                case 3:
                    puntajeASumar = 6;
                    break;
                case 4:
                    puntajeASumar = 10;
                    break;
                case 5:
                    puntajeASumar = 15;
                    break;
                case 6:
                    puntajeASumar = 21;
                    break;
                case 7:
                    puntajeASumar = 28;
                    break;
                case 8:
                    puntajeASumar = 36;
                    break;
                case 9:
                    puntajeASumar = 45;
                    break;
                case 10:
                    puntajeASumar = 55;
                    break;
            }
            puntajeTotal+=puntajeASumar;
            estado = 8;
        }
        if(dadosActivos==0) {
            estado = 9;
        }
        ronda++;
    }

    /**
     * Establece un mensaje acorde al estado del juego
     *
     * @return estadoToString
     */
    public String getEstadoToString() {
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
                estadoToString = "Ronda terminada, finalizaste con un superHeroe, cohete, o meeple. \n" + "En esta ronda no ganas puntos y conservas los ya acumulados";
                break;
            case 6:
                estadoToString = "No se sabe.";
                break;
            case 7:
                estadoToString = "Terminaste solo con cara Dragon, pierdes todos tus puntos acumulados";
                break;
            case 8:
                estadoToString = "Felicitaciones, terminaste solo con caras 42, sumaste "+puntajeASumar+" puntos\n"+"En total tienes "+puntajeTotal+" puntos.";
                puntajeASumar=0;
                break;
            case 9:
                estadoToString = "Ronda terminada, no quedan dados activos.\n"+"En esta ronda no ganas puntos y conservas los ya acumulados";
                break;

            default:
                estadoToString = "no setteado";
                break;
        }
        return estadoToString;
    }
}

