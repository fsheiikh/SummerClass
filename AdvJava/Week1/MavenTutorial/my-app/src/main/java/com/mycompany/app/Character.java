package com.mycompany.app;

/**
 * A Character class that provides the basic elements of for a character in a game
 *
 * @author Farhan Sheikh
 */
public class Character
{   
    //Charcter properties
    private String name;
    private double health;
    private int attackPower;
    private boolean alive;
    
     /**
     * this constructor creates a new Character with the following 
     * @param name - a string for the name of the character
     * @param health - a value for the health of the character
     * @param attackPower - a value for the character's attack power
     * @param alive - a boolean for setting whether the character is alive
     */
    public Character(String name, double health, int attackPower, boolean alive)
    {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.alive = alive;
    }
    
    /**
     * Returns characters name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns characters health
     */
    public double getHealth()
    {
        return health;
    }
    
    public int getAttackPower()
    {
        return attackPower;
    }
    
    /**
     * Returns characters living status
     */
    public boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Subtracts the enemyAttackPower from the health
     * Returns false if health is at or below 0
     */
    
    public void takeDamage(int enemyAttackPower)
    {
        health -= enemyAttackPower;
        
        if(health <= 0)
        {
            alive = false; //sets alive property to false if health falls below 1
        }
            
    }
    
    /**
     * Decreases Enemy health and return true if enemies alive property is true
     * Returns false if enemies alive property is false
     */
    public boolean attackOpponent(Character enemy)
    {   
        if(enemy.isAlive())
        {
            enemy.takeDamage(attackPower); //enemy takes damage
            return true;
        }
        else
        {
            return false;
        }
            
    }
  
   
}
