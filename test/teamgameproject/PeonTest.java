/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgameproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ShiFan
 */
public class PeonTest {
    
    public PeonTest() {
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

    @Test
    public void testAttackPeonMethod() {
        Peon attackerPea = new Peon();
        Peon weakPea = new Peon();
        attackerPea.attackPeon(attackerPea, weakPea);
        int checkAttack = attackerPea.getAttack();
        int doubleAttack = 2;
        assertEquals(checkAttack, doubleAttack);
        
    }
    
}
