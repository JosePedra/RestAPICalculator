package module;

import java.math.BigDecimal;

public class Multiplication implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}
