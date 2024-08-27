package com.dahl.currencywebapp.service;

import com.dahl.currencywebapp.pojo.CurrencyInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Dahl
 */
@Service
public class ApiService {

    private final RestTemplate restTemplate;
    private final String baseURL = "https://dolarapi.com/v1/dolares";

    public ApiService() {
        this.restTemplate = new RestTemplate();
    }

    public List<CurrencyInfo> get(String name) {
        var ret = new ArrayList<CurrencyInfo>();
        if (!name.equals("all")) {
            ret.add(getFor(name));
        } else {
            ret.addAll(getAll());
        }
        return ret;
    }

    private List<CurrencyInfo> getAll() {
        // Aquí deberías proporcionar la URL del endpoint que devuelve todos los datos
        ResponseEntity<CurrencyInfo[]> response = restTemplate.getForEntity(baseURL, CurrencyInfo[].class);
        return Arrays.asList(response.getBody());
    }

    private CurrencyInfo getFor(String name) {
        return restTemplate.getForObject(baseURL + "/" + name.toLowerCase(), CurrencyInfo.class);
    }
}
