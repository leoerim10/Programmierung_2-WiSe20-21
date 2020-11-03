import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ComponentManagerUnitTest {

    private static UsedPart p1, p5, p6, p7, p8, p9, p10;
    private static NewPart p2, p3, p4;

    @BeforeClass
    public static void setUp() {
        p1 = new UsedPart("transistor", 5.0, true, 5);
        p2 = new NewPart("monitor", 199.0, false, true);
        p3 = new NewPart("keyboard", 25.99, true, true);
        p4 = new NewPart("mouse", 15.0, true, true);
        p5 = new UsedPart("RAM",5, false, 1);
        p6 = new UsedPart("CPU",45, true, 24);
        p7 = new UsedPart("mainboard", 130, true, 0);
        p8 = new UsedPart("SSD", 88, true, 66);
        p9 = new UsedPart("power supply", 19.99, false, 7);
        p10 = new UsedPart("case", 105, true, 9);
    }

    @Test
    public void testGetTotalNumberNormal() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        assertEquals(2, comp.getTotalNumber());
    }

    @Test
    public void testGetTotalNumberEmpty() {
        ComponentManager comp = new ComponentManager();
        assertEquals(0, comp.getTotalNumber());
    }

    @Test
    public void testGetTotalNumberLimit() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        comp.buyComponent(p5);
        comp.buyComponent(p6);
        comp.buyComponent(p7);
        comp.buyComponent(p8);
        comp.buyComponent(p9);
        comp.buyComponent(p10);
        assertEquals(10, comp.getTotalNumber());
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testGetTotalNumberError() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        comp.buyComponent(p5);
        comp.buyComponent(p6);
        comp.buyComponent(p7);
        comp.buyComponent(p8);
        comp.buyComponent(p9);
        comp.buyComponent(p10);
        comp.buyComponent(p10);
    }

    @Test
    public void testSearchNotFound() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p7);
        comp.buyComponent(p8);
        comp.buyComponent(p9);
        assertEquals(null, comp.searchComponent("SSd"));
    }

    @Test
    public void testSearchFoundNormal() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p7);
        comp.buyComponent(p8);
        comp.buyComponent(p9);
        assertEquals(p8, comp.searchComponent("SSD"));
    }


    @Test
    public void testSearchFoundLast() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p8);
        comp.buyComponent(p9);
        comp.buyComponent(p10);
        assertEquals(p10, comp.searchComponent("case"));
    }

    @Test
    public void testCalculatePriceNormal() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        assertEquals(244.99, comp.calculatePrice(), 0);
    }

    @Test
    public void testCalculatePriceOne() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p2);
        assertEquals(199, comp.calculatePrice(), 0);
    }

    @Test
    public void testCalculatePriceActive() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        assertEquals(45.989, comp.calculatePrice(true), 0.001);
    }

    @Test
    public void testCalculatePriceNotActive() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        comp.buyComponent(p5);
        assertEquals(204.0, comp.calculatePrice(false), 0.001);
    }

    @Test
    public void testCalculateOpHours() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p1);
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        comp.buyComponent(p5);
        assertEquals(6, comp.calculateOperatingHours());
    }

    @Test
    public void testCalculateOpHoursNew() {
        ComponentManager comp = new ComponentManager();
        comp.buyComponent(p2);
        comp.buyComponent(p3);
        comp.buyComponent(p4);
        assertEquals(0, comp.calculateOperatingHours());
    }



}
