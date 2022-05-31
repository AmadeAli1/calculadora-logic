package expression;

public interface Priority {

    default Double multiplicationPriority(Double number, PriorityExpression priorityExpression, Double lastvalue) {
        var vs = 0D;
        switch (priorityExpression.symbol) {
            case Minus -> {
                vs = lastvalue + (priorityExpression.input);
                vs = vs - (priorityExpression.input * number);
            }
            case Plus -> {
                vs = lastvalue - priorityExpression.input;
                vs = vs + (priorityExpression.input * number);
            }
            default -> vs = lastvalue * number;
        }
        return vs;
    }

    default Double divisionPriority(Double number, PriorityExpression priorityExpression, Double lastvalue) {
        if (number == 0) throw new IllegalArgumentException("Impossivel dividir por 0");
        var vs = 0D;
        switch (priorityExpression.symbol) {
            case Minus -> {
                vs = lastvalue + (priorityExpression.input);
                vs = vs - (priorityExpression.input / number);
            }
            case Plus -> {
                vs = lastvalue - priorityExpression.input;
                vs = vs + (priorityExpression.input / number);
            }
            default -> vs = lastvalue / number;
        }
        return vs;
    }

}
