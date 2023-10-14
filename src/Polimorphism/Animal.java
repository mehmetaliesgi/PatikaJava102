package Polimorphism;

public class Animal {
    private String name,sound,info,infoText;

    public Animal() {this("Bulunmuyor","Bulunmuyor");}
    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
        this.info = null;
        setInfoText(info);
    }
    public Animal(String name, String sound, String info) {
        this.name = name;
        this.sound = sound;
        this.info = info;
        setInfoText(info);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoText() {
        return infoText;
    }
    public void setInfoText(String info) {
        this.infoText = "-> Benim İsmim: "+getName()+"\n-> Çıkardığım Ses: "+getSound()+"\n-> Türüm: "+info;
    }

    public String animalInfo(){
        return "< Hayvan Bilgileri >\n-------------------\n"+getInfoText();
    }

    public static void runAnimal(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println(animal.animalInfo());
        }
    }
}
