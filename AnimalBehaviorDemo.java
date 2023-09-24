class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

class DomesticAnimal extends Animal {
    public void bark() {
        System.out.println("Domestic animal is barking");
    }
}

class WildAnimal extends Animal {
    public void roam() {
        System.out.println("Wild animal is roaming");
    }
}

class Bird extends Animal {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Carnivore extends Animal {
    public void hunt() {
        System.out.println("Carnivore is hunting");
    }
}

class Herbivore extends Animal {
    public void graze() {
        System.out.println("Herbivore is grazing");
    }
}

class Omnivore extends Animal {
    public Animal eat(Animal animal) {
        System.out.println("Omnivore is eating " + animal.getClass().getSimpleName());
        return animal;
    }
}

public class AnimalBehaviorDemo {
    public static void main(String[] args) {
        DomesticAnimal dog = new DomesticAnimal();
        WildAnimal lion = new WildAnimal();
        Bird eagle = new Bird();
        Carnivore tiger = new Carnivore();
        Herbivore deer = new Herbivore();
        Omnivore bear = new Omnivore();

        dog.eat();
        dog.bark();

        lion.eat();
        lion.roam();

        eagle.eat();
        eagle.fly();

        tiger.eat();
        tiger.hunt();

        deer.eat();
        deer.graze();

        // Animal eatenAnimal1 = bear.eat(new DomesticAnimal());
        // Animal eatenAnimal2 = bear.eat(new Herbivore());
        // Animal eatenAnimal3 = bear.eat(new Carnivore());
        // Animal eatenAnimal4 = bear.eat(new Bird());

        // System.out.println("Bear ate a " + eatenAnimal1.getClass().getSimpleName());
        // System.out.println("Bear ate a " + eatenAnimal2.getClass().getSimpleName());
        // System.out.println("Bear ate a " + eatenAnimal3.getClass().getSimpleName());
        // System.out.println("Bear ate a " + eatenAnimal4.getClass().getSimpleName());
    }
}
