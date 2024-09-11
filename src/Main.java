import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Consult consultCep = new Consult();

        System.out.println("Digite seu cep para encontrarmos sua localização: ");
        String cep = scanner.nextLine();

        try {
            Adress adress = consultCep.consultAdressCep(cep);
            System.out.println(adress);
            ArchiveGenerator jsonGenerator = new ArchiveGenerator();
            jsonGenerator.saveJson(adress);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
        }


    }
}