package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * A Character Unit test class that tests the functionality of the Character class
 *
 * @author Farhan Sheikh
 */
public class CharacterTest 
{
    private Character hero;
    private Character villain;
    
     /**
     * Have a base hero and villain Character created before Tests are run to be used in Tests
     */
    @Before
    public void setup() {
        hero = new Character("Naruto", 100.0, 20, true);
        villain = new Character("Sasuke", 90.0, 25, true);
    }
    /**
     * Positive Test of getName method, of class Character.
     */
    @Test
    public void testGetNamePositive() {
        Character instance = hero;
        String expected = "Naruto";
        String result = instance.getName();
        assertEquals("getName positive",expected, result);
    }
    
    /**
     * Negative Test of getName method, of class Character.
     */
    @Test
    public void testGetNameNegative() {
        Character instance = hero;
        String expected = "Batman"; //a String that is not equal to the hero's name
        String result = instance.getName();
        assertFalse("getName negative", expected == result);
    }

    /**
     * Positive Test of getHealth method, of class Character.
     */
    @Test
    public void testGetHealthPositive() {
        Character instance = hero;
        double expected = 100.0; //is equal to hero's health
        double result = instance.getHealth();
        assertEquals("getHealth Positive", expected, result);
    }
    
     /**
     * Negative Test of getHealth method, of class Character.
     */
    @Test
    public void testGetHealthNegative() {
        Character instance = hero;
        double expected = 0.0; //is not equal to hero's health
        double result = instance.getHealth();
        assertFalse("getHealth ", expected == result);
    }

    /**
     * Positive Test of getAttackPower method, of class Character.
     */
    @Test
    public void testGetAttackPowerPositive() {
        Character instance = hero;
        int expected = 20; //is equal to hero's attack power
        int result = instance.getAttackPower();
        assertEquals("testGetAttackPower Positive", expected, result);
    }
    
     /**
     * Negative Test of getAttackPower method, of class Character.
     */
    @Test
    public void testGetAttackPowerNegative() {
        Character instance = hero;
        int expected = 0; //is not equal to hero's attack power
        int result = instance.getAttackPower();
        assertFalse("testGetAttackPower Negative", expected == result);
    }

    /**
     * Positive Test of isAlive method, of class Character.
     */
    @Test
    public void testIsAlivePositive() {
        Character instance = hero;
        boolean expected = true;
        boolean result = instance.isAlive();
        assertEquals("testIsAlive Positive", expected, result);
    }
    
     /**
     * Negative Test of isAlive method, of class Character.
     */
    @Test
    public void testIsAliveNegative() {
        Character instance = hero;
        boolean expected = false;
        boolean result = instance.isAlive();
        assertFalse("testIsAlive Negative", expected == result);
    }

    /**
     * Positive Test of takeDamage method, of class Character.
     */
    @Test
    public void testTakeDamagePositive() {
        int enemyAttackPower = villain.getAttackPower();
        Character instance = hero;
        double difference = hero.getHealth() - villain.getAttackPower(); //gets the difference based on hero's health and villain attack
        instance.takeDamage(enemyAttackPower);
        assertEquals("testTakeDamage Positive", instance.getHealth(), difference);
    }
    
    /**
     * Negative Test of takeDamage method, of class Character.
     */
    @Test
    public void testTakeDamageNegative() {
        int enemyAttackPower = villain.getAttackPower();
        Character instance = hero;
        double difference = hero.getHealth() - 1; //difference is not going to hero's health minus villain's attack power
        instance.takeDamage(enemyAttackPower);
        assertFalse("testTakeDamage Negative", instance.getHealth() ==  difference);
    }
    
      /**
     * Second Positive Test of takeDamage method, of class Character. Checks the case when health falls below 0
     */
    @Test
    public void testTakeDamagePositive2() {
        int enemyAttackPower = villain.getAttackPower();
        Character instance = new Character("Sakura", 0.0, 20, true); //health in set to 0.0 so, takeDamage will change alive property
        instance.takeDamage(enemyAttackPower);
        assertEquals("testTakeDamage Positive2", instance.isAlive(), false);
    }
    
      /**
     * Second Negative Test of takeDamage method, of class Character. Checks the case when health falls below 0
     */
    @Test
    public void testTakeDamageNegative2() {
        int enemyAttackPower = villain.getAttackPower();
        Character instance = new Character("Sakura", 0.0, 20, true); //health in set to 0.0 so, takeDamage will change alive property
        instance.takeDamage(enemyAttackPower);
        assertFalse("testTakeDamage Negative2", instance.isAlive() == true);
    }

    /**
     * Positive Test of attackOpponent method, of class Character.
     */
    @Test
    public void testAttackOpponentPositive() {
        Character enemy = villain;
        Character instance = hero;
        boolean expected = true;
        double enemyHealth = villain.getHealth() - hero.getAttackPower(); //when enemy is attaked it substacts its health by heros attackpower, this variable gets that value
        boolean result = instance.attackOpponent(enemy); //hero is alive, so method is expected to return true
        assertEquals("attackOpponent Positive", expected, result);
        assertEquals("attackOpponent Positive - enemy health", enemyHealth, enemy.getHealth());
    }
    
     /**
     * Negative Test of attackOpponent method, of class Character.
     */
    @Test
    public void testAttackOpponentNegative() {
        Character enemy = villain;
        Character instance = new Character("Sakura", 0.0, 20, true);
        boolean expected = false;
        double enemyHealth = villain.getHealth() - hero.getAttackPower() -1; //gets value other than what would occur 
        boolean result = instance.attackOpponent(enemy); //hero is alive, so method is expected to return true
        assertFalse("attackOpponent Negative", expected == result);
        assertFalse("attackOpponent Negative - enemy health", enemyHealth == enemy.getHealth());
    }
    
}
