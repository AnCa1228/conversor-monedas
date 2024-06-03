package model;

import java.util.Map;

public record MonedaER(String result,
                       String base_code,
                       Map<String, Double> conversion_rates) {
}
