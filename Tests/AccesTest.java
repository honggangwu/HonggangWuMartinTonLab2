import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import prog2.model.*;

class AccesTest {

    private Allotjament allotjament;
    private Acces acces;
    private LlistaAllotjaments llistaAllotjaments;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        allotjament = new Allotjament("Allotjament Prova","1234",
                3,2,true,"100%");
        llistaAllotjaments =new LlistaAllotjaments();
        acces=new CarreteraAsfalt("Acc6",true, 13,200);
    }
    @Test
    void afegirAllotjamenttest() {
        llistaAllotjaments.afegirAllotjament(allotjament);

        Assertions.assertTrue(llistaAllotjaments.contains(allotjament));
    }

    @Test
    void tancarAccestest() {
        acces.tancarAcces();
        Assertions.assertFalse(acces.isOperatiu());
    }

    @Test
    void obrirAccestest() {
        acces.obrirAcces();
        Assertions.assertTrue(acces.isOperatiu());
    }
}