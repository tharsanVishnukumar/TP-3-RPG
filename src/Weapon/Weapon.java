package Weapon;

import Drawable.Drawable;
import Entity.Attaquable;

public abstract class Weapon implements Drawable {
    protected String name;
    protected int damage;
    // protected int defense;
    protected float price;

    public Weapon() {}

    public Weapon(String name, int power, float price) {
        this.name = name;
        this.damage = power;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void attaque(Attaquable attaquable) {
        attaquable.hit(damage);
    }
}
