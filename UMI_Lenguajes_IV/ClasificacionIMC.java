
/**
 * Fecha: 1 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/
public enum ClasificacionIMC {
    BAJO_PESO("Bajo peso"),
    PESO_NORMAL("Peso normal"),
    SOBREPESO("Sobrepeso"),
    OBESIDAD_I("Obesidad I"),
    OBESIDAD_II("Obesidad II"),
    OBESIDAD_III("Obesidad III");

    private final String Tipo;

    // Constructor del enum
    ClasificacionIMC(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getTipo() {
        return Tipo;
    }


    public static ClasificacionIMC setIMC(double imc) {
        if (imc < 18.5) return BAJO_PESO;
        if (imc < 25)   return PESO_NORMAL;
        if (imc < 30)   return SOBREPESO;
        if (imc < 35)   return OBESIDAD_I;
        if (imc < 40)   return OBESIDAD_II;
        return OBESIDAD_III;
    }
}