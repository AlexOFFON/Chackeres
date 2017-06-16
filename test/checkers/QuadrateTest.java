/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OleksandrZderko
 */
public class QuadrateTest {
    
    public QuadrateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setColor method, of class Quadrate.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color c = null;
        Quadrate instance = null;
        instance.setColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFigure method, of class Quadrate.
     */
    @Test
    public void testRemoveFigure() {
        System.out.println("removeFigure");
        Quadrate instance = null;
        instance.removeFigure();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFigure method, of class Quadrate.
     */
    @Test
    public void testSetFigure() {
        System.out.println("setFigure");
        Figure obj = null;
        Quadrate instance = null;
        instance.setFigure(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFigureQ method, of class Quadrate.
     */
    @Test
    public void testSetFigureQ() {
        System.out.println("setFigureQ");
        Quadrate instance = null;
        instance.setFigureQ();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFigureQ method, of class Quadrate.
     */
    @Test
    public void testGetFigureQ() {
        System.out.println("getFigureQ");
        Quadrate instance = null;
        boolean expResult = false;
        boolean result = instance.getFigureQ();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFigure method, of class Quadrate.
     */
    @Test
    public void testGetFigure() {
        System.out.println("getFigure");
        Quadrate instance = null;
        Figure expResult = null;
        Figure result = instance.getFigure();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoint method, of class Quadrate.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        Quadrate instance = null;
        Point expResult = null;
        Point result = instance.getPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Quadrate.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Quadrate instance = null;
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clickIn method, of class Quadrate.
     */
    @Test
    public void testClickIn() {
        System.out.println("clickIn");
        Point obj = null;
        Quadrate instance = null;
        boolean expResult = false;
        boolean result = instance.clickIn(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getA method, of class Quadrate.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        int expResult = 0;
        int result = Quadrate.getA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawQuadrate method, of class Quadrate.
     */
    @Test
    public void testDrawQuadrate() {
        System.out.println("drawQuadrate");
        Graphics g = null;
        Quadrate instance = null;
        instance.drawQuadrate(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
