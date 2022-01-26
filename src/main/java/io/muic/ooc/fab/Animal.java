package io.muic.ooc.fab;

import java.util.Random;

public abstract class Animal {

    //Constructor TODO
    private int age=0;
    private boolean alive=true;
    private static final Random RANDOM = new Random();

    protected abstract int getMaxAge();
    protected abstract int getBreedingAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();
    protected Location location;
    protected Field field;

    public Animal(boolean randomAge, Field field, Location location) {
        setAlive(true);
        this.field = field;
        setLocation(location);
        if (randomAge) {
            setAge(RANDOM.nextInt(getMaxAge()));
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    protected void incrementAge(){
        age++;
        if(age > getMaxAge()){
            setDead();
        }
    }

    protected boolean canBreed() {
        return getAge() >= getBreedingAge();
    }
    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProbability()) {
            births = RANDOM.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }



    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive() {
        return alive;
    }

    /**
     * Return the fox's location.
     *
     * @return The fox's location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Place the fox at the new location in the given field.
     *
     * @param newLocation The fox's new location.
     */
    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public Field getField() {
        return field;
    }

    protected void setDead() {
        setAlive(false);
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
}