package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите назавание города: ");
        String city = scanner.nextLine();
        String jsonResponse = WeatherApiClient.sendRequest(city);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = mapper.readValue(jsonResponse, WeatherResponse.class);
        float temperature = weatherResponse.getCurrent().getTemp_c();
        String cloudiness = weatherResponse.getCurrent().getCondition().getText();
        System.out.println(city + ": " + "температура: " + temperature + "°C," + " облачность: " + cloudiness);
    }


}
