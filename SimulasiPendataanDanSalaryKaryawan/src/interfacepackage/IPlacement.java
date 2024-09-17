package interfacepackage;

import java.util.HashMap;
import java.util.Map;

public interface IPlacement {

    Map<String, Double> CITY_UMK_MAP = createCityUMKMap();

    default double getUMK(String city) {
        return CITY_UMK_MAP.getOrDefault(city, 0.0);
    }
    
    private static Map<String, Double> createCityUMKMap() {
        Map<String, Double> cityUMKMap = new HashMap<>();
        cityUMKMap.put("Garut", 1961085.0);
        cityUMKMap.put("Bandung", 3742276.0);
        cityUMKMap.put("Jakarta", 4453935.0);
        cityUMKMap.put("Bekasi", 4782935.0);
        cityUMKMap.put("Bogor", 4330249.0);
        return cityUMKMap;
    }
}

