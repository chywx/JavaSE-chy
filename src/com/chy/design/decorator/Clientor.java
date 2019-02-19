package com.chy.design.decorator;

public class Clientor {
	public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();
        
        md1.setPerson(man);
        md2.setPerson(md1);
        md2.eat();
    }
}
