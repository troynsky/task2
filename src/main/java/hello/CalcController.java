package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@RestController
public class CalcController {

    @Autowired
    private CalcService calcService;

    @RequestMapping("/pi")
    public DeferredResult<Double> calculatePi(@RequestParam(value = "number") Integer number) {
        DeferredResult<Double> pi = new DeferredResult<>();
        new Thread(() -> {
            Double res = calcService.execute(number);
            pi.setResult(res);
        }).start();

        return pi;
    }
}
