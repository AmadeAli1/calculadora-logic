package expression;

public enum Symbol{
    Plus("+"),
    Minus("-"),
    Div("/"),
    Multiplication("*");
    public final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

}
