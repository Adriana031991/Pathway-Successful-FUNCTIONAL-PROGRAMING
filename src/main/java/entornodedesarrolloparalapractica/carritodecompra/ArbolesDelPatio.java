package entornodedesarrolloparalapractica.carritodecompra;

import java.util.Collection;

public class ArbolesDelPatio {
    private Collection<Integer> arboles;

    public ArbolesDelPatio(Collection<Integer> arboles) {
        this.arboles = arboles;
    }

    public int calcularTotalArboles() {

        int arbolesTotales = 0;

        for (Integer arbol : arboles) {
            arbolesTotales += arbol;
        }
        return arbolesTotales;
    }

    public int contarNumeroArboles() {
        return arboles.size();
    }


    public int calcularTotalArbolesLambda() {
        //int precioTotal = this.precios.stream()
        //        .mapToInt(precios-> precios.intValue()).sum();
        //return precioTotal;

//mejor forma:
        return this.arboles.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    //--------------------------------------------------------------------------------
    public long calcularADescontadosArboles(int arbolesConDescuento) {
        long descTotal = 0;

        for (Integer arbol : arboles) {
            if (arbol >= arbolesConDescuento) {
                descTotal += (arbolesConDescuento * 5) / 100;
            }
        }
        return descTotal;
    }

    public long calcularADescontadosArbolesLambda(int arbolesConDescuento) {
        Long numDesct = this.arboles.stream()
                .filter(arboles -> arboles.intValue() >= arbolesConDescuento)
                .count();
        return (arbolesConDescuento * 5) / 100 * numDesct;
    }

    //-------------------------------------------------------------------------------------------------
    //para encontrar errores, y una vez detectados devolver true.
    //Los valores erróneos serán todos aquellos valores que lleguen como un número
    //negativo.

    public boolean detecError() {
        boolean negativFind = false;
        for (Integer arbol : arboles) {
            if (arbol < 0) {
                negativFind = true;
            }
        }
        return negativFind;
    }

    //--usando anyMatch
    public boolean detectErrorLambda() {
        return this.arboles.stream().anyMatch(arboles -> arboles.intValue() < 0);
    }


    //---usando finAny
    public boolean detectErrorFindAny() {
        return this.arboles.stream().filter(arboles -> arboles.intValue() < 0)
                .findAny().isPresent();
    }

    //-- usando findFirst
    public boolean detectErrorFindFirst() {
        return this.arboles.stream().filter(arboles -> arboles.intValue() < 0)
                .findFirst().isPresent();
    }

    //---usando anyMath Parallel
    public boolean detectarErrorAnyMatchParallel() {
        return this.arboles.parallelStream().anyMatch(arbol -> arbol.intValue() < 0);
    }

    //---usando findAny Parallel
    public boolean detectarErrorFindAnyParallel() {
        return this.arboles.parallelStream().filter(arbol -> arbol.intValue() < 0)
                .findAny()
                .isPresent();
    }

    //---usando findFirst Parallel
    public boolean detectarErrorFindFirstParallel() {

        return this.arboles.parallelStream().filter(arbol -> arbol.intValue() < 0)
                .findFirst()
                .isPresent();
    }

}
