package prog2.model.allotjament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.LlistaAllotjaments;

class LlistaAllotjamentsTest {

    @Test
    void afegirAllotjament() {
        Allotjament allotjament = new Allotjament("Allotjament Prova","1234",
                3,2,true,"100%");
    }

    @Test
    void buidar() {
        LlistaAllotjaments lListaProva= new LlistaAllotjaments();
        lListaProva.buidar();

        Assertions.assertNull(lListaProva[0]);
    }

    @Test
    void llistarAllotjaments() {
    }

    @Test
    void containsAllotjamentOperatiu() {
    }

    @Test
    void contains() {
    }

    @Test
    void getAllotjament() {
    }
}