package Polimorphism;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Karabaş","Kangal"); // Karabaş isminde kangal türüne ait bir köpek üretildi.
        Animal cat = new Cat("Tekir"); // Tekir isminde bir kedi üretildi.

        Animal[] animals = {dog, cat};
        Animal.runAnimal(animals);
    }
}
