package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Instanciation des objets nécessaires
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        // Étapes successives
        List<String> symptoms = analytics.getSymptoms(); // Lecture des symptômes
        Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms); // Comptage des occurrences
        Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms); // Tri des symptômes
        analytics.writeSymptoms(sortedSymptoms); // Écriture des résultats

        System.out.println("Traitement terminé avec succès !");
    }
}