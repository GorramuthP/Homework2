package io.muic.ooc.fab;

public abstract class Animal {

    private int age=0;

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
}
