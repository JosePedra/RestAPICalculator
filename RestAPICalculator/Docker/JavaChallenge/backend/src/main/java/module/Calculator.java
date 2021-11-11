package module;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Operation> operations;

    public Calculator() {
        this.operations = new ArrayList<>();
        operations.add(new Sum());
        operations.add(new Subtraction());
        operations.add(new Multiplication());
        operations.add(new Division());
    }


    public BigDecimal calculate(BigDecimal a, BigDecimal b, int operation) throws Exception {
        if (a == null || b == null)
            throw new Exception("Insufficient data");

        return operations.get(operation).calculate(a, b);
    }
}
