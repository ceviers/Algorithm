package com.cevier.algorithm.HashTable;

public class Animal implements Comparable{
    private int amount;
    private String species;

    public Animal(int amount, String species){
        this.amount = amount;
        this.species = species;
    }

    @Override
    public int hashCode(){
        int hash = amount;
        hash += species.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Animal animal = (Animal)o;
        return amount == animal.amount && species.equals(animal.species);
    }

    @Override
    public int compareTo(Object o) {
        if(o == null || getClass() != o.getClass())
            throw new IllegalArgumentException("not the same class");
        return amount - ((Animal)o).amount;
    }

    @Override
    public String toString(){
        return species + "[" + amount + "]";
    }
}
