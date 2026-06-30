package quickchat;

import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L +
                (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }
// Recipient validation method
   public String checkRecipientCell() {

    if (recipient.startsWith("+27") && recipient.length() == 12) {

        return "Cell phone number successfully captured.";
    }

    return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
}
   // Message length validation
    public String validateMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";
        }

        int excess = message.length() - 250;

        return "Message exceeds 250 characters by "
                + excess
                + ", please reduce the size.";
    }
// Message hash generation
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();

        String lastWord = words[words.length - 1].toUpperCase();

        String firstTwoDigits = messageID.substring(0, 2);

        return firstTwoDigits
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }

    public String sentMessage(int choice) {

        switch (choice) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }
// Display message details
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    public int returnTotalMessages() {

        return messageNumber;
    }

    public String getMessageID() {

        return messageID;
    }

    public String getMessageHash() {

        return messageHash;
    }

    public String getRecipient() {

        return recipient;
    }

    public String getMessage() {

        return message;
    }
}