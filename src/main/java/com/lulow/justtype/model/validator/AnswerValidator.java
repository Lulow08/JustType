package com.lulow.justtype.model.validator;

public class AnswerValidator extends ValidatorAdapter {
    @Override
    public boolean validateAnswer(String answer, String expected) {
        return answer != null && answer.equals(expected);
    }
}
