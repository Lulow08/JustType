package com.lulow.justtype.model;

import com.lulow.justtype.model.validator.AnswerValidator;

public class GameLogic {

    private final WordBank        wordBank        = new WordBank();
    private final WordSplitter    wordSplitter    = new WordSplitter();
    private final AnswerValidator answerValidator = new AnswerValidator();
    private final WordTransformer wordTransformer = new WordTransformer();

    private int    currentLevel = 1;
    private String currentWord  = "";
    private char[] currentChars;

    public char[] getCurrentChars() { return currentChars; }
    public String getCurrentWord()  { return currentWord; }
    public int    getCurrentLevel() { return currentLevel; }
    public boolean hasWon()         { return currentLevel > LevelConfig.WIN_LEVEL; }

    public void nextWord() {
        String raw   = wordBank.getRandomWord(currentLevel);
        currentWord  = applyTransform(raw);
        currentChars = wordSplitter.split(currentWord);
    }

    public boolean processAnswer(String input) {
        if (answerValidator.validateAnswer(input, currentWord)) {
            currentLevel++;
            return true;
        }
        return false;
    }

    public int getMaxTimeForCurrentLevel() {
        return LevelConfig.getMaxTimeForLevel(currentLevel);
    }

    private String applyTransform(String word) {
        if (LevelConfig.getTierForLevel(currentLevel) == LevelConfig.Tier.T5) {
            return wordTransformer.applyTier5Casing(word);
        }
        return word;
    }
}