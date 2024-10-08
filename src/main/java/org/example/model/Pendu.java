package org.exemple.model;

import org.exemple.model.Mot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pendu {
    private Mot motADeviner;
    private int essaisRestants;
    private List<String> mots; // Liste de mots possibles

    public Pendu() {
        // Initialisation de la liste des mots à deviner
        this.mots = new ArrayList<>();
        mots.add("chien");
        mots.add("java");
        mots.add("meteorite");
        mots.add("pomme");
        mots.add("avion");
        mots.add("oiseau");
        mots.add("tigre");
        mots.add("souris");
        mots.add("fraise");
        mots.add("bouteille");
        mots.add("boutique");
        mots.add("bibliotheque");
        mots.add("ardoise");
        mots.add("arbalete");
        mots.add("montagne");

        this.motADeviner = new Mot(choisirMotAleatoire());
        this.essaisRestants = 6; // Nombre d'essais autorisés
    }

    // Méthode pour choisir un mot aléatoire dans la liste
    private String choisirMotAleatoire() {
        Random random = new Random();
        int index = random.nextInt(mots.size()); // Choisit un index aléatoire dans la liste
        return mots.get(index);
    }

    public void lancerJeu() {
        Scanner scanner = new Scanner(System.in);

        while (essaisRestants > 0 && !motADeviner.estDevine()) {
            System.out.println("Mot à deviner: " + motADeviner.afficherMotActuel());
            System.out.println("Il ne vous reste plus que " + essaisRestants + " essais.");
            System.out.print("Devinez une lettre : ");
            String lettre = scanner.nextLine().toLowerCase();

            if (lettre.length() != 1) {
                System.out.println("Veuillez entrer une seule lettre.");
                continue;
            }

            if (!motADeviner.devinerLettre(lettre.charAt(0))) {
                essaisRestants--;
                System.out.println("Lettre incorrecte.");
            }

            if (motADeviner.estDevine()) {
                System.out.println("Félicitations ! Le mot à deviner était : " + motADeviner.getMot());
            }
        }

        if (essaisRestants == 0) {
            System.out.println("Perdu ! Le mot à deviner était : " + motADeviner.getMot());
        }

        scanner.close();
    }
}
