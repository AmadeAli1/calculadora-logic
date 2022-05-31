import calculate.Calculator;
import calculate.Logic;
import expression.Symbol;

public class Main {

    public static void main(String[] args) {
        Calculator cl = new Logic();
        try {
            cl.expression(Symbol.Plus, 5D)
                    .expression(Symbol.Div, -0D)
                    .expression(Symbol.Multiplication, 2D)
                    .expression(Symbol.Multiplication, 2D);
            var result = cl.result();

            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
