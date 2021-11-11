package module;

import java.math.BigDecimal;

public class Subtraction implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }
}
