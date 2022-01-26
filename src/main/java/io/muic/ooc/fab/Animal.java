package io.muic.ooc.fab;

import java.util.Random;

public abstract class Animal {

    //Constructor TODO
    private int age=0;
    private boolean alive=true;
    private static final Random RANDOM = new Random();

    protected abstract void setDead();
    protected abstract int getMaxAge();
    protected abstract int getBreedingAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();

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

}