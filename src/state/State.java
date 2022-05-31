package state;

import calculate.Calculator;

public interface State {
    Calculator onRestoreState();
    CalculatorState lastState();
}
