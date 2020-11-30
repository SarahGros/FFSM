/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sarah
 */
public class FFSSMTest {

    Moniteur m, m1;
    Plongeur p, p1;
    Club c, c1, c2;
    LocalDate d = LocalDate.now();

    @BeforeEach
    public void setUp() {
        m = new Moniteur("12345678", "Untel", "Georges", "rue", "123456789", d.minusYears(55), "L2", GroupeSanguin.AMOINS, 3456);
        m1 = new Moniteur("0987654", "Deuxtel", "Georgette", "Firmin", "09876543", d.minusYears(53), "L2", GroupeSanguin.APLUS, 2);
        p = new Plongeur("9876543", "Troistel", "Jeanette", "Oulès", "98765432", d.minusYears(50), "P5", GroupeSanguin.BMOINS);
        p1 = new Plongeur("987654321", "Quatretel", "Jeane", "chemin", "9876543210", d.minusYears(20), "P3", GroupeSanguin.BPLUS);
        c = new Club(m, "club1", "01");
        c1 = new Club(m1, "club2", "02");
    }

    @Test
    public void testAjoutLicence() {
        assertTrue(p1.getLicences().isEmpty());
        p.ajouteLicence("53", d);
        p.ajouteLicence("50", d.minusYears(2));
        assertEquals(2, p.getLicences().size());
    }

    @Test
    public void testLicenceEstValide() {
        Licence l = new Licence(p, "53", d, c1);
        assertTrue(l.estValide(d.plusDays(1)));
        assertTrue(l.estValide(d.plusYears(1)));
        assertFalse(l.estValide(d.plusYears(1).plusDays(1)));
    }

    @Test
    public void testAjouterParticipantPlongee() {
        Site s = new Site("Marseille", "Les calanques");
        Plongee plo = new Plongee(s, m, d, 10, 110);
        assertEquals(0, plo.getParticipants().size());
        Licence l = new Licence(p, "53", d, c);
        plo.ajouteParticipant(l);
        assertEquals(1, plo.getParticipants().size());
        
    }

    @Test
    public void testEstConformePlongee() {
        Site s = new Site("Marseille", "Les calanques");
        Plongee plo = new Plongee(s, m, d, 10, 110);
        Licence l1 = new Licence(p, "53", d.minusMonths(2), c);
        Licence l2 = new Licence(p1, "50", d.minusYears(2), c1);
        plo.ajouteParticipant(l1);
        assertTrue(plo.estConforme());
        plo.ajouteParticipant(l2);
        assertFalse(plo.estConforme());
    }

    @Test
    public void testOrganisePlongeeClub() {
        Site s = new Site("Marseille", "Les calanques");
        Plongee plo = new Plongee(s, m, d, 10, 110);
        Licence l1 = new Licence(p, "53", d.minusMonths(2), c);
        plo.ajouteParticipant(l1);
        assertEquals(0, c.getPlongees().size());
        c.organisePlongee(plo);
        assertEquals(1, c.getPlongees().size());
    }

    @Test
    public void testEmbauche() throws Exception {
        Embauche e = new Embauche(d, m, c);
        assertFalse(e.estTerminee());
        assertFalse(e.estTerminee());
        e.terminer(d.plusMonths(2));
        assertEquals(d.plusMonths(2), e.getFin());
    }

    @Test
    public void testPlongeeNonConforme() throws Exception {
        Site s = new Site("Marseille", "Les calanques");
        Plongee plo1 = new Plongee(s, m, d, 10, 110);
        Plongee plo2 = new Plongee(s, m, d, 10, 110);
        Licence l1 = new Licence(p, "53", d.minusMonths(2), c);
        Licence l2 = new Licence(p1, "50", d.minusYears(3), c);
        plo1.ajouteParticipant(l1);
        plo2.ajouteParticipant(l2);
        c.organisePlongee(plo1);
        c.organisePlongee(plo2);
        assertEquals(1, c.plongeesNonConformes().size());
        assertEquals(plo2, c.plongeesNonConformes().toArray()[0]);
    }

    
}
