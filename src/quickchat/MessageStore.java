package quickchat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MessageStore {

    private static final String FILE_NAME = "messages.json";

    // Save messages
    public static void storeMessages(ArrayList<Message> messages) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            gson.toJson(messages, writer);

        } catch (IOException e) {

            System.out.println("Error storing messages.");
        }
    }

    // Load messages
    public static ArrayList<Message> loadMessages() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(FILE_NAME)) {

            Type listType = new TypeToken<ArrayList<Message>>(){}.getType();

            ArrayList<Message> messages =
                    gson.fromJson(reader, listType);

            if (messages == null) {
                return new ArrayList<>();
            }

            return messages;

        } catch (IOException e) {

            return new ArrayList<>();

        }
    }

}