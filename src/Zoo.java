public class Zoo {
    private Animal[] animals;
    private int nbrAnimals;   // compteur d’animaux
    private final int nbrCages;

    String name;
    String city;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.nbrAnimals = 0;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) return false;

        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].equals(animal)) {
                return false;
            }
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].equals(animal)) {
                return i; // trouvé
            }
        }
        return -1; // non trouvé
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) return false;

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        } else {
            return z2;
        }
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d’animaux : " + nbrAnimals);
    }

    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", nbrCages=" + nbrCages + ", nbrAnimals=" + nbrAnimals + "]";
    }
}
