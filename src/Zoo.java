package zoo;

public class Zoo {
    private Animal[] animals;
    private int nbrAnimals;
    private final int nbrCages;

    private String name;
    private String city;


    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        setCity(city);
        this.nbrCages = nbrCages > 0 ? nbrCages : 1;
        this.animals = new Animal[this.nbrCages];
        this.nbrAnimals = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : le nom du zoo ne doit pas être vide !");
            this.name = "Unknown Zoo";
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = city;
        } else {
            System.out.println("Erreur : la ville ne doit pas être vide !");
            this.city = "Unknown City";
        }
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public int getNbrCages() {
        return nbrCages;
    }


    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
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
                return i;
            }
        }
        return -1;
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

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.nbrAnimals >= z2.nbrAnimals) ? z1 : z2;
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d’animaux : " + nbrAnimals);
    }

    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city +
                ", nbrCages=" + nbrCages + ", nbrAnimals=" + nbrAnimals + "]";
    }
}
