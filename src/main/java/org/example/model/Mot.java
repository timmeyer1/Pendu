package org.exemple.model;

public class Mot {
    private String mot;
    private boolean[] lettresDevinees;

    public Mot(String mot) {
        this.mot = mot;
        this.lettresDevinees = new boolean[mot.length()];
    }

    public boolean devinerLettre(char lettre) {
        boolean trouve = false;
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == lettre) {
                lettresDevinees[i] = true;
                trouve = true;
            }
        }
        return trouve;
    }

    public boolean estDevine() {
        for (boolean devinee : lettresDevinees) {
            if (!devinee) {
                return false;
            }
        }
        return true;
    }

    public String afficherMotActuel() {
        StringBuilder motAffiche = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            if (lettresDevinees[i]) {
                motAffiche.append(mot.charAt(i));
            } else {
                motAffiche.append("_");
            }
            motAffiche.append(" ");
        }
        return motAffiche.toString().trim();
    }

    public String getMot() {
        return mot;
    }
}
