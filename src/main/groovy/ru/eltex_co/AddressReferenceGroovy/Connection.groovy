package ru.eltex_co.AddressReferenceGroovy

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class Connection {

    private static final String URI = "https://eltex-co.ru/test/users.php";
    private static final String FILE = "Users.csv";

    static void main(String[] args) throws IOException, InterruptedException, URISyntaxException{

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        List<User> users = gson.fromJson(response.body(), new TypeToken<List<User>>() {
        }.getType());

        List<User> filteredUsers = users.stream()
                .filter(user -> user.getSalary() > 3500)
                .sorted(Comparator.comparing(User::getName))
                .toList();

        try (FileWriter fileWriter = new FileWriter(FILE);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("Id", "Name", "Email", "Salary"))) {

            for (User u : filteredUsers) {
                csvPrinter.printRecord(u.getId(), u.getName(), u.getEmail(), u.getSalary());
            }
        } catch (IOException e) {
            System.out.println("Error creating CSV file: " + e.getMessage());
        }




    }



}
