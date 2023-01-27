package h06;

import static h06.EvaluationResult.Type.*;

public class BracketExpression {

    private final char[] expression;

    public BracketExpression(String expression) {
        this.expression = expression.toCharArray();
    }

    public final EvaluationResult evaluate() {

        return evaluate(0);
    }


    public final EvaluationResult evaluate(int i) {

        // case 1
        if ((expression[i] != '(') && (expression[i] != ')') && (expression[i] != '[') && (expression[i] != ']') && (expression[i] != '{') && (expression[i] != '}') )
        {
            return new EvaluationResult(INVALID_CHARACTER, i);
        }

        // case 2
        if ((expression[i] == ')') || (expression[i] == ']') || (expression[i] == '}'))
        {
            return new EvaluationResult(NO_OPENING_BRACKET, i);
        }

        // case 3
        if (i == expression.length - 1)
        {
            return new EvaluationResult(NO_CLOSING_BRACKET, i);
        }

        // case 4
        if ((expression[i + 1] == ')' && expression[i] == '(') || (expression[i + 1] == ']' && expression[i] == '[') || (expression[i + 1] == '}' && expression[i] == '{'))
        {
            return new EvaluationResult(CORRECT, i + 2);
        }

        // case 5
        if ((expression[i + 1] == ')' && expression[i] != '(') || (expression[i + 1] == ']' && expression[i] != '[') || (expression[i + 1] == '}' && expression [i] != '{'))
        {
            return new EvaluationResult(INVALID_CLOSING_BRACKET, i + 1);
        }

        // case 6
        EvaluationResult r = evaluate(i + 1);
        if (r.type() != CORRECT)
        {
            return r;
        }

        // case 7
        if (r.nextIndex() >= expression.length)
        {
            return new EvaluationResult(NO_CLOSING_BRACKET, r.nextIndex());
        }

        // case 8
        if ((expression[r.nextIndex()] == ')' && expression[i] == '(') || (expression[r.nextIndex()] == ']' && expression[i] == '[') || (expression[r.nextIndex()] == '}' && expression[i] == '{')){
            return new EvaluationResult(CORRECT, r.nextIndex() + 1);
        }

        // case 9
        if ((expression[r.nextIndex()] == ')' && expression[i] != '(') || (expression[r.nextIndex()] == ']' && expression[i] != '[') || (expression[r.nextIndex()] == '}' && expression [i] != '{'))

        {
            return new EvaluationResult(INVALID_CLOSING_BRACKET, r.nextIndex());
        }

        // case 10
        if ((expression[r.nextIndex()] == '(') || (expression[r.nextIndex()] == '[') || (expression[r.nextIndex()] == '{')){
            return new EvaluationResult(NO_CLOSING_BRACKET, r.nextIndex());
        }

        // case 11
        else {
            return new EvaluationResult(INVALID_CHARACTER, r.nextIndex());
        }
    }
}
