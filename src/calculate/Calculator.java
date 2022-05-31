package calculate;

import expression.Symbol;

public interface Calculator {
    Calculator expression(Symbol symbol, Double number);
    Double result();

}
