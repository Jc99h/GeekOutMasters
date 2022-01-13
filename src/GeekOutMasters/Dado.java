package GeekOutMasters;

import java.util.Random;

/**
 * Clase dado genera un dado aleatorio entre (meeple, dragon, corazon, cohete, super heroe, 42)
 * 1. meeple
 * 2. dragon
 * 3. corazon
 * 4. cohete
 * 5. superHeroe
 * 6. 42
 *
 * @author Camilo Ordoñez 1827625-2711 juan.ordonez.hurtado@correounivalle.edu.co
 * @author Danny Lopez 1941453-2711 danny.cardenas@correounivalle.edu.co
 * @version v.1.0.0 date 09/01/2022
 */

public class Dado {
    private String cara;
    private int numeroCara;
    private String panel;

    public static String getCaraPorIndex(int index) {
        switch (index) {
            case 1:
                return "meeple";

            case 2:
                return "dragon";

            case 3:
                return "corazon";

            case 4:
                return "cohete";

            case 5:
                return "superHeroe";

            case 6:
                return "42";

            default:
                System.out.println("error");
                return "failed";
        }
    }

    /**
     * Method that generate an random value to cara
     *
     * @return number between (1,6)
     */
    public String getCara() {
        switch (numeroCara) {
            case 1:
                return "meeple";

            case 2:
                return "dragon";

            case 3:
                return "corazon";

            case 4:
                return "cohete";

            case 5:
                return "superHeroe";

            case 6:
                return "42";

            default:
                System.out.println("error");
                return "failed";
        }
    }

    public void setCara(int cara) {
        numeroCara = cara;
    }

    public void setCara(String cara) {
        switch (cara) {
            case "meeple":
                numeroCara = 1;
                break;
            case "dragon":
                numeroCara = 2;
                break;
            case "corazon":
                numeroCara = 3;
                break;
            case "cohete":
                numeroCara = 4;
                break;
            case "superHeroe":
                numeroCara = 5;
                break;
            case "42":
                numeroCara = 6;
                break;
            default:
                System.out.println("fallo set cara por string");
                break;
        }
    }

    public void setCara() {
        Random aleatorio = new Random();
        numeroCara = aleatorio.nextInt(6) + 1;
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }
}
