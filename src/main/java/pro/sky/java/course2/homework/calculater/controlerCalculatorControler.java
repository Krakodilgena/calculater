package pro.sky.java.course2.homework.calculater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class controlerCalculatorControler {

    private final CalculatorService service;

    public controlerCalculatorControler(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String printGreetings() {
        return "Добро пожаловать!";
    }

    @GetMapping("/plus")
    public String sumNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = service.sum(num1,num2);
        return generateResultMessage(num1, num2, "+", result);
    }

    @GetMapping("/minus")
    public String subtractNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = service.subtract(num1,num2);
        return generateResultMessage(num1, num2, "-", result);
    }

    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Деление на 0 невозможно";
        }
        int result = service.multiply(num1,num2);
        return generateResultMessage(num1, num2, "*", result);
    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = service.divide(num1,num2);
        return generateResultMessage(num1, num2, "/", result);
    }

    private String generateResultMessage(int num1, int num2, String action, int result) {
        return num1 + " " + action + " " + num2 + " = " + result;
    }
}
