package hello;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class CalcServiceImpl implements CalcService {

    public Double execute(int number) {
        BigDecimal pi = new BigDecimal(0);

        for (int i = 0; i < number; i++) {
            pi = pi.add(BigDecimal.valueOf(Math.pow(-1, i) / (2 * i + 1)));
        }
        pi = pi.multiply(BigDecimal.valueOf(4));

        return pi.doubleValue();
    }

}
