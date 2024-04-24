package br.com.itauseguros.application.constants;

import java.util.List;
import java.util.Map;

public class CategoryConstants {
    public static final List<String> CATEGORY = List.of("VIDA", "AUTO", "VIAGEM", "RESIDENCIAL", "PATRIMONIAL");

    public static final Map<String, Map<String, Double>> CATEGORY_TAXES = Map.of(
            "VIDA", Map.of("IOF", 0.01, "PIS", 0.022, "COFINS", 0.00),
            "AUTO", Map.of("IOF", 0.055, "PIS", 0.04, "COFINS", 0.01),
            "VIAGEM", Map.of("IOF", 0.02, "PIS", 0.04, "COFINS", 0.01),
            "RESIDENCIAL", Map.of("IOF", 0.04, "PIS", 0.00, "COFINS", 0.03),
            "PATRIMONIAL", Map.of("IOF", 0.05, "PIS", 0.03, "COFINS", 0.00)
    );
}
