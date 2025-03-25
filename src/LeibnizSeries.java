public class LeibnizSeries {
    private static final double PI4 = 0.785398163; // valor de referencia para pi/4
    
    /**
     * Método público que inicia el cálculo de la serie de Leibniz.
     * @param errorPermitido Error máximo permitido para la aproximación de pi/4.
     * @return Cantidad mínima de términos necesarios para alcanzar la precisión deseada.
     * Sobrecarga del metodo calcularTerminos para no pasar todos los parametros
     */
    public int calcularTerminos(double errorPermitido) {
        double sumParcial = 1; // Primer termino de la seria de leibniz CASO BASE.
        // llamada al metodo recursivo con valores iniciales
        // el valor del error, la suma hasta el momento con un solo termino(1), variable bandera para que empiece restando
        // y el denominador del segundo termino (1/3, 1/5, 1/7, 1/8)
        int cantidadTerminos = calcularTerminos(errorPermitido, sumParcial, false, 3);
        return cantidadTerminos;
    } 
    /**
     * Método recursivo para calcular el número de términos necesarios en la serie de Leibniz.
     * @param errorPermitido Error máximo permitido para la aproximación de pi/4.
     * @param sumaParcial Acumulador de la suma de términos de la serie.
     * @param sumar Indica si el siguiente término se suma o se resta.
     * @param denominador Denominador del término actual en la serie.
     * @return Número de términos utilizados para alcanzar la precisión deseada.
     */
    private int calcularTerminos(double errorPermitido, double sumParcial, boolean sumar, int denominador){
        double diferencia = Math.abs(sumParcial - PI4);
        System.out.println("Suma-Parcial:   " + sumParcial + " - " + diferencia +" = " + diferencia + "\n");
        if (diferencia < errorPermitido) {
        System.out.println("Se alcanza la precisión deseada en esta iteración.");
            return 1;
        }
        else { // Alternar entre suma (True) y resta (False).
            if (sumar) {
                sumParcial = sumParcial + 1.0/denominador;
                System.out.println("Termino = 1/" + denominador);
            } else {
                sumParcial = sumParcial - 1.0/denominador;
                System.out.println("Termino = 1/" + denominador);

            }
        }
        // Llamada recursiva con el siguiente término (incrementa el denominador en 2 y cambia el signo)
        //  y al final sumamos +1 para que nos devuelva el numero total de terminos, porque sino siempre devolveria 1;
        return calcularTerminos(errorPermitido, sumParcial, !sumar, denominador + 2) + 1;
    }
    
    public void printTerms(double errorPermitido) {
        int terminos =  calcularTerminos(errorPermitido);
        System.out.println("El numero minimo de terminos para alcanzar la precision de: "+ errorPermitido + " es de: " + terminos +" terminos.");
    }
    public static void main(String[] args) throws Exception {
        LeibnizSeries prueba = new LeibnizSeries();
        prueba.printTerms(0.009);
    }
}
