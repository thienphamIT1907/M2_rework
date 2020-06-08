package services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public float addition(float num1, float num2) {
        return num1 + num2;
    }

    @Override
    public float subtraction(float num1, float num2) {
        return num1 - num2;
    }

    @Override
    public float multiplication(float num1, float num2) {
        return num1 * num2;
    }

    @Override
    public String division(float num1, float num2) {
        try {
            if(num2 != 0) {
                float result = num1 / num2;
                return String.valueOf(result);
            }
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
        return "Cannot divison by 0";
    }
}
