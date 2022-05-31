package state;

public record CalculatorState(String expression, Double result) {

    @Override
    public String toString() {
        return "Restore{" +
                "expression: " + expression + '\'' +
                ",result:" + result +
                '}';
    }
}
