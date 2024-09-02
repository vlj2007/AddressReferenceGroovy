package ru.eltex_co.AddressReferenceGroovy;

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


class Connection {

    static final String URI = "https://eltex-co.ru/test/users.php"

    static final String FILE = "Users.csv"

    static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient()
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI))
                .GET()
                .build()

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString())

        Gson gson = new Gson()
        List<User> users = gson.fromJson(response.body(), new TypeToken<List<User>>() {}.getType())

        List<User> filteredUsers = users.stream()
                .filter { user -> user.salary > 3500 }
                .sorted(Comparator.comparing { User.name })
                .toList()

        FileWriter fileWriter = new FileWriter(FILE)
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.builder().setHeader("Id", "Name", "Email", "Salary").build())

        try {
            filteredUsers.each { User user ->
                csvPrinter.printRecord(user.id, user.name, user.email, user.salary)
            }
        } finally {
            fileWriter.close()
            csvPrinter.close()
        }
    }
}


