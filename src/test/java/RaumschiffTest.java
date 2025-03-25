package test.java;

import main.Raumschiffe.Jaeger;
import main.Raumschiffe.Kreuzer;
import main.Raumschiffe.Raumschiff;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;


public class RaumschiffTest {


        private Raumschiff angreifer;
        private Raumschiff ziel;

        @BeforeEach
        void setUp(){
        angreifer = new Kreuzer("Hornet");
        ziel = new Kreuzer("Biene");
        }

        @Disabled
        @Test
        void testAngriffReduziertSchilde(){
            angreifer.attack(ziel);
            assertTrue(ziel.getShieldPower() == 500);
        }


        @Test
        void testAngriffZerstörtZiel(){
                angreifer.attack(ziel);
                angreifer.attack(ziel);
                assertTrue(ziel.getShieldPower() == 0);
        }

        @Test
        void testRefernzIdentität(){
                Raumschiff copy = angreifer;
                assertSame(angreifer, copy,"Beide Referenzen zeigen auf das selbe Objekt");
        }

        @Test
        void testReferenzUngleichheit(){
                assertNotSame(angreifer, ziel,"Angreifer und Ziel sind unterschiedliche Objekte");
        }


}
