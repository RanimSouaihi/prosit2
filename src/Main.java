public class Main {
    public static void main(String[] args) {

        Animal lion = new Animal("Félin", "Lion", 5, true);
        Animal tigre = new Animal("Félin", "Tigre", 4, true);
        Animal perroquet = new Animal("Oiseau", "Perroquet", 2, false);
        Animal lion2 = new Animal("Félin", "Lion", 6, true); // même nom que le premier

        Zoo zoo1 = new Zoo("Parc Zoologique", "Tunis", 5);
        Zoo zoo2 = new Zoo("Zoo de Sousse", "Sousse", 5);

        System.out.println("Ajout lion : " + zoo1.addAnimal(lion));
        System.out.println("Ajout tigre : " + zoo1.addAnimal(tigre));
        System.out.println("Ajout perroquet : " + zoo1.addAnimal(perroquet));
        System.out.println("Ajout lion2 (doublon) : " + zoo1.addAnimal(lion2));

        zoo1.displayAnimals();

        System.out.println("Recherche lion → index = " + zoo1.searchAnimal(lion));
        System.out.println("Recherche lion2 (même nom) → index = " + zoo1.searchAnimal(lion2));

        System.out.println("Suppression du tigre : " + zoo1.removeAnimal(tigre));
        zoo1.displayAnimals();

        System.out.println("Zoo plein ? " + zoo1.isZooFull());

        zoo2.addAnimal(new Animal("Félin", "Panthère", 3, true));

        Zoo biggerZoo = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("Le zoo avec le plus d’animaux est : " + biggerZoo.name);

        zoo1.displayZoo();
    }
}
