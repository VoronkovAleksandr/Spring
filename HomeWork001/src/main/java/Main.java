import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Person;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String FILE_NAME = "ivan.json";
        Person ivan = new Person("Ivan", "Ivanov", 22);
        File file = new File(FILE_NAME);
        Gson gsonToWrite = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(gsonToWrite.toJson(ivan).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)){
            InputStreamReader streamReader = new InputStreamReader(fileInputStream);
            Gson gsonToRead = new Gson();

            Person readPerson = gsonToRead.fromJson(streamReader, Person.class);
            System.out.println(readPerson);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
