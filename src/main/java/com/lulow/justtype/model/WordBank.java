package com.lulow.justtype.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WordBank {

    private final Random random = new Random();
    private final Set<String> used = new HashSet<>();

    private String[] TIER_1 = {
            "class", "git", "run", "bool", "IDEA",
            "star", "java", "fast", "game", "cast",
            "Type", "tree", "zip", "model", "word",
            "bug", "View", "main", "virus", "root"
    };

    private final String[] TIER_2 = {
            "integer", "commit", "Controller", "buffer", "Syntax",
            "module", "compile", "pointer", "interface", "console",
            "binary", "directory", "Source", "PACKAGE", "virtual",
            "Lambda", "String", "TERMINAL", "deploy", "Library"
    };

    private final String[] TIER_3 = {
            "framework", "Algorithm", "database", "endpoint", "CallBack",
            "recursion", "INSTANCE", "MetaData", "argument", "protocol",
            "middleware", "BreakPoint", "container", "gradient", "Heritage",
            "UNIVERSE", "velocity", "frontend", "Backend", "operator"
    };

    private final String[] TIER_4 = {
            "asynchronous", "polymorphism", "abstraction", "inheritance", "repository",
            "microservices", "concurrency", "deployment", "dependency", "environment",
            "performance", "transaction", "encryption", "throughput", "redundancy",
            "javascript", "reflection", "serialized", "immutable", "validation"
    };

    private final String[] TIER_5 = {
            "authentication", "infrastructure", "multithreading", "implementation", "uninterrupted",
            "synchronization", "decentralized", "encapsulation", "orchestration", "compatibility",
            "cryptography", "standardization", "maintainability", "vulnerability", "instantaneous",
            "metaprogramming", "parallelization", "functionality", "troubleshooting", "superstructure"
    };

    public String getRandomWord(int level) {
        String[] tier = tierForLevel(level);
        String word;
        int attempts = 0;
        do {
            word = tier[random.nextInt(tier.length)];
            attempts++;
        } while (used.contains(word) && attempts < tier.length);

        if (attempts >= tier.length) {
            clearTierUsed(tier);
        }

        used.add(word);
        return word;
    }

    private void clearTierUsed(String[] tier) {
        for (String w : tier) {
            used.remove(w);
        }
    }

    private String[] tierForLevel(int level) {
        if (level <= 5)  return TIER_1;
        if (level <= 10) return TIER_2;
        if (level <= 20) return TIER_3;
        if (level <= 35) return TIER_4;
        return TIER_5;
    }
}
