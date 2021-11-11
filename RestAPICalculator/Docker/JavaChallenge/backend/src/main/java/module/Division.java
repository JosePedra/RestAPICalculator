package module;

import java.math.BigDecimal;

public class Division implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return a.divide(b);
    }
}
