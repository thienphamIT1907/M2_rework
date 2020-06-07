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
    public float division(float num1, float num2) {
        try {
            if(num1 != 0 || num2 != 0) {
                return num1 / num2;
            }
        } catch (IllegalArgumentException ex) {
            ex.getMessage();
        }
        return 0;
    }
}
