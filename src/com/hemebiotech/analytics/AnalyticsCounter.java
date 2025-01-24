package com.hemebiotech.analytics;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	/**
	 * Constructeur pour initialiser le lecteur et l'écrivain
	 *
	 * @param reader une instance de ISymptomReader pour lire les symptômes
	 * @param writer une instance de ISymptomWriter pour écrire les résultats
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Récupère les symptômes depuis un fichier à l'aide de ISymptomReader.
	 *
	 * @return une liste de symptômes
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Compte les occurrences de chaque symptôme
	 *
	 * @param symptoms une liste de symptômes
	 * @return une Map contenant chaque symptôme et son nombre d'occurrences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new TreeMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	/**
	 * Trie les symptômes par ordre alphabétique
	 *
	 * @param symptoms une Map de symptômes avec leur nombre d'occurrences
	 * @return une Map triée par ordre alphabétique
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms); // TreeMap trie automatiquement
	}

	/**
	 * Écrit les symptômes et leurs occurrences dans un fichier à l'aide de ISymptomWriter
	 *
	 * @param symptoms une Map triée de symptômes avec leur nombre d'occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			writer.writeSymptoms(symptoms);
		} catch (Exception e) {
			System.err.println("Erreur lors de l'écriture des symptômes : " + e.getMessage());
		}
	}
}