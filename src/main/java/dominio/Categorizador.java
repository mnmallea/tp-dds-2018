package dominio;

import constantes.MontosCategorias;

import java.util.Arrays;
import java.util.List;

public class Categorizador {

    public static Categorizador instancia = new Categorizador();
    // Tipos de categoria que puede adoptar un cliente
    private Categoria r1 = new Categoria(MontosCategorias.cargoFijoR1, MontosCategorias.cargoVariableR1, MontosCategorias.topeInferiorR1, MontosCategorias.topeSuperiorR1);
    private Categoria r2 = new Categoria(MontosCategorias.cargoFijoR2, MontosCategorias.cargoVariableR2, MontosCategorias.topeInferiorR2, MontosCategorias.topeSuperiorR2);
    private Categoria r3 = new Categoria(MontosCategorias.cargoFijoR3, MontosCategorias.cargoVariableR3, MontosCategorias.topeInferiorR3, MontosCategorias.topeSuperiorR3);
    private Categoria r4 = new Categoria(MontosCategorias.cargoFijoR4, MontosCategorias.cargoVariableR4, MontosCategorias.topeInferiorR4, MontosCategorias.topeSuperiorR4);
    private Categoria r5 = new Categoria(MontosCategorias.cargoFijoR5, MontosCategorias.cargoVariableR5, MontosCategorias.topeInferiorR5, MontosCategorias.topeSuperiorR5);
    private Categoria r6 = new Categoria(MontosCategorias.cargoFijoR6, MontosCategorias.cargoVariableR6, MontosCategorias.topeInferiorR6, MontosCategorias.topeSuperiorR6);
    private Categoria r7 = new Categoria(MontosCategorias.cargoFijoR7, MontosCategorias.cargoVariableR7, MontosCategorias.topeInferiorR7, MontosCategorias.topeSuperiorR7);
    private Categoria r8 = new Categoria(MontosCategorias.cargoFijoR8, MontosCategorias.cargoVariableR8, MontosCategorias.topeInferiorR8, MontosCategorias.topeSuperiorR8);
    // -----------------------------------------------
    private Categoria r9 = new Categoria(MontosCategorias.cargoFijoR9, MontosCategorias.cargoVariableR9, MontosCategorias.topeInferiorR9, MontosCategorias.topeSuperiorR9);
    private List<Categoria> categorias;

    private Categorizador() {
        categorias = Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public Categoria getCategoriaSegunRango(Float unConsumo) {
        return this.categorias.stream().filter(categoria -> categoria.perteneceACategoria(unConsumo)).findFirst().get();
    }

    public Categoria getR1() {
        return r1;
    }

    public Categoria getR2() {
        return r2;
    }

    public Categoria getR3() {
        return r3;
    }

    public Categoria getR4() {
        return r4;
    }

    public Categoria getR5() {
        return r5;
    }

    public Categoria getR6() {
        return r6;
    }

    public Categoria getR7() {
        return r7;
    }

    public Categoria getR8() {
        return r8;
    }

    public Categoria getR9() {
        return r9;
    }

}
