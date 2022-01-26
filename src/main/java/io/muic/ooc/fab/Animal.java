package io.muic.ooc.fab;

public abstract class Animal {

    public int getAge() {
        return age;
    }

    private int age=0;

    protected abstract void setDead();

    protected abstract int getMaxAge();

    public void setAge(int age) {
        this.age = age;
    }



    protected void incrementAge(){
        age++;
        if(age > getMaxAge()){
            setDead();
        }
    }


}
