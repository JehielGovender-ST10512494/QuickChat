package quickchat;

import java.util.ArrayList;

public class StoredMessageManager {

    public static void displayStoredMessages(ArrayList<Message> storedMessages) {
    
    
        if (storedMessages.isEmpty()) {

            System.out.println("No stored messages.");
            return;

        }

        System.out.println("\n===== STORED MESSAGES =====");

        for (Message msg : storedMessages) {

            System.out.println("Recipient: " + msg.getRecipient());
            System.out.println("Message: " + msg.getMessage());
            System.out.println();

        }

    }
public static Message displayLongestMessage(ArrayList<Message> storedMessages) {

    if (storedMessages.isEmpty()) {
        System.out.println("No stored messages.");
        return null;
    }

    Message longest = storedMessages.get(0);

    for (Message msg : storedMessages) {

        if (msg.getMessage().length() > longest.getMessage().length()) {
            longest = msg;
        }

    }

    System.out.println("\n===== LONGEST STORED MESSAGE =====");
    System.out.println("Recipient: " + longest.getRecipient());
System.out.println("Message: " + longest.getMessage());

return longest;
}
public static Message searchByMessageID(ArrayList<Message> storedMessages, String messageID) {

    for (Message msg : storedMessages) {

        if (msg.getMessageID().equals(messageID)) {

            System.out.println("\n===== MESSAGE FOUND =====");
            System.out.println("Recipient: " + msg.getRecipient());
            System.out.println("Message: " + msg.getMessage());

            return msg;
        }
    }

    System.out.println("Message ID not found.");
return null;
}
public static ArrayList<Message> searchByRecipient(ArrayList<Message> storedMessages, String recipient) {
ArrayList<Message> results = new ArrayList<>();
    boolean found = false;

    for (Message msg : storedMessages) {

        if (msg.getRecipient().equals(recipient)) {
            results.add(msg);

            System.out.println("\n===== MESSAGES FOR RECIPIENT =====");
            System.out.println("Message: " + msg.getMessage());
            System.out.println();

            found = true;
        }
    }

    if (!found) {
        System.out.println("No messages found for this recipient.");
    }
    return results;
}
public static void deleteByMessageHash(ArrayList<Message> storedMessages, String hash) {

    for (int i = 0; i < storedMessages.size(); i++) {

        if (storedMessages.get(i).getMessageHash().equals(hash)) {

            System.out.println("Message: \"" +
                    storedMessages.get(i).getMessage() +
                    "\" successfully deleted.");

            storedMessages.remove(i);

            MessageStore.storeMessages(storedMessages);

            return;
        }
    }

    System.out.println("Message hash not found.");
}
public static void displayReport(ArrayList<Message> storedMessages) {

    if (storedMessages.isEmpty()) {

        System.out.println("No stored messages.");
        return;
    }

    System.out.println("\n========== STORED MESSAGE REPORT ==========");

    for (Message msg : storedMessages) {

        System.out.println("Message Hash: " + msg.getMessageHash());
        System.out.println("Recipient   : " + msg.getRecipient());
        System.out.println("Message     : " + msg.getMessage());
        System.out.println("-------------------------------------------");

    }
}
}