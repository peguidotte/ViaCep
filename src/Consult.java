import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Consult {

    public String validCep(String cep){

        while (cep.length() != 8) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CEP deve possuir 8 números. 'sair' para sair ou digite novamente: ");
            cep = scanner.nextLine();
            if (cep == "sair"){
                return null;
            }
        }

        return cep;
    }

    public Adress consultAdressCep (String cep){

        cep = validCep(cep);
        URI adress = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(adress)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Adress.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
