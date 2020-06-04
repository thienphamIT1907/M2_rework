package services;

import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {
    @Override
    public float convertUSDToVND(float usd, float rate) {
        return usd * rate;
    }
}
