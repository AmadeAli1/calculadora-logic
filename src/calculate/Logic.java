package calculate;

import expression.Priority;
import expression.PriorityExpression;
import expression.Symbol;
import state.CalculatorState;
import state.State;

import java.util.Deque;
import java.util.LinkedList;

public class Logic implements Calculator, State, Priority {
    private Double lastvalue = 0D;
    private final Deque<CalculatorState> state;
    private PriorityExpression priorityExpression;
    private CalculatorState _state;

    public Logic() {
        state = new LinkedList<>();
    }

    @Override
    public Calculator expression(Symbol symbol, Double number) {
        var expression = lastvalue + symbol.symbol + number;
        var result = switch (symbol) {
            case Plus -> lastvalue += number;
            case Minus -> lastvalue -= number;
            case Div -> divisionPriority(number, priorityExpression, lastvalue);
            case Multiplication -> multiplicationPriority(number, priorityExpression, lastvalue);
        };
        lastvalue = result;
        CalculatorState e = new CalculatorState(expression, result);
        state.add(e);
        priorityExpression = new PriorityExpression(symbol, number);
        return this;
    }

    @Override
    public Double result() {
        return lastvalue;
    }

    @Override
    public Calculator onRestoreState() {
        state.removeLast();
        _state = state.removeLast();
        lastvalue = _state.result();
        return this;
    }

    @Override
    public CalculatorState lastState() {
        return _state;
    }
}
