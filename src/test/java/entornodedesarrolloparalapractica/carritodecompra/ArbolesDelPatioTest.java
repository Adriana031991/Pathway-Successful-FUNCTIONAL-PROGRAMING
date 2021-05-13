package entornodedesarrolloparalapractica.carritodecompra;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ArbolesDelPatioTest {

    private final int TOTAL_SIZE = 20000000;
    private final int NUMBER_ADD = 1000000;


    @Test
    public void shouldReturnTheCountOfAllItems() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(30);
        ArbolesDelPatio carritoDeLaCompra = builder.build();
        Assert.assertEquals(30, carritoDeLaCompra.contarNumeroArboles());
    }

    @Test
    public void shouldCalculateTotalTree() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60,5);
        ArbolesDelPatio carritoDeLaCompra = builder.build();
        Assert.assertEquals(300, carritoDeLaCompra.calcularTotalArboles());

    }

    @Test
    public void shouldCalculateTotalLambda() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(50,10);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertEquals(500,arbolesDelPatio.calcularTotalArbolesLambda());
    }

    @Test
    public void shouldCalculateTotalDesct() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(50,100);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertEquals(250,arbolesDelPatio.calcularADescontadosArboles(100));
    }

    @Test
    public void shouldCalculateTotalDesctlambda() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(50,100);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertEquals(250,arbolesDelPatio.calcularADescontadosArbolesLambda(100));
    }

    @Test
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNegative(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertTrue(arbolesDelPatio.detecError());
    }

    @Test
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNegativelambda(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertTrue(arbolesDelPatio.detectErrorLambda());
    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindFirst(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertTrue(arbolesDelPatio.detectErrorFindFirst());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindAny(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertTrue(arbolesDelPatio.detectErrorFindAny());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeAnyMatchParallel(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        arbolesDelPatio.detectarErrorAnyMatchParallel();
    }


    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindAnyParallel(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertTrue(arbolesDelPatio.detectarErrorFindAnyParallel());
    }


    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindFirstParallel(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        ArbolesDelPatio arbolesDelPatio = builder.build();
        Assert.assertTrue(arbolesDelPatio.detectarErrorFindFirstParallel());
    }


}