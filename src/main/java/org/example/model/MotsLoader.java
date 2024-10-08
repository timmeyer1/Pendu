package org.exemple.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MotsLoader {
    private List<String> mots;

    public MotsLoader(String cheminFichier) {
        mots = new ArrayList<>();
        chargerMots(cheminFichier);
    }

    private void chargerMots(String cheminFichier) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("files.json/mots.json")))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                jsonBuilder.append(ligne);
            }
            String jsonString = jsonBuilder.toString();
            // Extraire les mots du JSON
            jsonString = jsonString.substring(jsonString.indexOf("[") + 1, jsonString.indexOf("]"));
            String[] motsArray = jsonString.replaceAll("\"", "").split(",");
            for (String mot : motsArray) {
                mots.add(mot.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getMotAleatoire() {
        if (mots.isEmpty()) {
            return null; // Ou une gestion d'erreur appropriée
        }
        Random random = new Random();
        return mots.get(random.nextInt(mots.size()));
    }
}
