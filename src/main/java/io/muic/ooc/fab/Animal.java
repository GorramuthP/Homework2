package io.muic.ooc.fab;

public abstract class Animal {

    //Constructor TODO
    private int age=0;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    private boolean alive=true;

    protected abstract void setDead();

    protected abstract int getMaxAge();

    protected abstract int getBreedingAge();

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

    /**
     * Check whether the fox is alive or not.
     *
     * @return True if the fox is still alive.
     */
    //Basically the getter
    public boolean isAlive() {
        return alive;
    }
}
