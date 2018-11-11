/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

//increase speed
public class Apple implements Consumable{
    public void gainHealth(Person p)
    {
        p.health += 10;
    }
    public void foodImp(Person p)
    {
        p.health += (int)(Math.random()*5+1);
    }
}
