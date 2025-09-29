package zoo;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;


    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); // utilise le setter pour éviter un âge négatif
        this.isMammal = isMammal;
    }


    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : le nom de l’animal ne peut pas être vide !");
            this.name = "Unknown";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Erreur : âge négatif → valeur par défaut = 0");
            this.age = 0;
        }
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }


    @Override
    public String toString() {
        return "Animal [family=" + family + ", name=" + name +
                ", age=" + age + ", isMammal=" + isMammal + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal other = (Animal) obj;
        return this.name.equalsIgnoreCase(other.name) &&
                this.family.equalsIgnoreCase(other.family);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode() + family.toLowerCase().hashCode();
    }
}
