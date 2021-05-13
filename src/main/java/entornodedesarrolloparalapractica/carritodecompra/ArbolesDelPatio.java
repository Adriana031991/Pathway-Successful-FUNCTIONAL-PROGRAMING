package entornodedesarrolloparalapractica.carritodecompra;

import java.util.Collection;

public class ArbolesDelPatio {
    private Collection<Integer> arboles;

    public ArbolesDelPatio(Collection<Integer> arboles) {
        this.arboles = arboles;
    }
    public int calcularTotalArboles() {

        int arbolesTotales = 0;

        for(Integer arbol : arboles){

            arbolesTotales += arbol;

        }
        return arbolesTotales;
    }

    public int contarNumeroArboles() {

        return arboles.size();
    }


    public int calcularTotalArbolesLambda(){
        //int precioTotal = this.precios.stream()
        //        .mapToInt(precios-> precios.intValue()).sum();
        //return precioTotal;
        /*
        hacemos uso del stream, el cual nos recogerá cada objeto de la Collection precios (this.precios.stream())
        y lo mapeará a Integers (mapToInt()).
         */

//mejor forma:
        return this.arboles.stream()
                .mapToInt(Integer::intValue)
                .sum();

        /*
         (Integer::intValue) hacemos uso del método a través de una referencia (incluidas en Java 8).
         Si tuviera que decantarme por una forma, quizás la más clara sea i -> i.intValue(),
         pero sin duda la más correcta es Integer::intValue.
         */
    }

    public long calcularADescontadosArboles(int arbolesConDescuento){
        long descTotal = 0;

        for (Integer arbol: arboles) {
            if (arbol >= arbolesConDescuento){
                descTotal += (arbolesConDescuento*5)/100;
            }
        }
        return descTotal;
    /*
     detector de descuentos que comprueba si algún precio es mayor o igual que el que pasamos por
     parámetro y, por cada coincidencia, descuenta un 5% (aplicado en arboles)
     */

    }

    public long calcularADescontadosArbolesLambda (int arbolesConDescuento){
        Long numDesct = this.arboles.stream()
                .filter(arboles -> arboles.intValue() >= arbolesConDescuento )
                .count();
        return (arbolesConDescuento*5)/100*numDesct;
        //Dicho método recibe como parámetro un predicado. Para entenderlo, no hay más que traducirlo al español: filtro.
    }

    public boolean detecError(){
        boolean negativFind = false;
        for (Integer arbol: arboles) {
            if (arbol < 0){
                negativFind = true;
            }
        }
        return negativFind;
    }

    public boolean detectErrorLambda(){
        return this.arboles.stream().anyMatch(arboles->arboles.intValue()<0);
        //uevo método: anyMatch(), al igual que filter(), recibe un predicado. En este caso devuelve
        // true si encuentra algún precio negativo.
    }

    public boolean detectErrorFindAny() {
        return this.arboles.stream().filter(arboles -> arboles.intValue() < 0)
                .findAny().isPresent();

    /*
    En este ejemplo hacemos uso de los métodos findAny() e isPresent().
    Si traducimos al español quedaría como «…y encuentra alguno. ¿Está presente?». Es decir,
    findAny() nos devuelve un Optional cuando se cumple la condición de filter().
    Este Optional tiene como método isPresent() el cual si encuentra una coincidencia devolverá true.
    Hay que aclarar que esta forma recorre todo el stream.
     */
    }
    public boolean detectErrorFindFirst() {
        return this.arboles.stream().filter(arboles -> arboles.intValue() < 0)
                .findFirst().isPresent();}


    public boolean detectarErrorAnyMatchParallel() {
        return this.arboles.parallelStream().anyMatch(arbol -> arbol.intValue() < 0);
    }

    public boolean detectarErrorFindAnyParallel() {
        return this.arboles.parallelStream().filter(arbol -> arbol.intValue() < 0)
                .findAny()
                .isPresent();
    }

    public boolean detectarErrorFindFirstParallel() {

        return this.arboles.parallelStream().filter(arbol -> arbol.intValue() < 0)
                .findFirst()
                .isPresent();
    }

}
