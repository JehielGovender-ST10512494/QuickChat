package quickchat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MessageStore {
// Store messages into JSON file
    public static void storeMessages(ArrayList<Message> messages) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter("messages.json")) {

            gson.toJson(messages, writer);

            System.out.println("Messages stored successfully.");

        } catch (IOException e) {

            System.out.println("Error storing messages.");
        }
    }
}