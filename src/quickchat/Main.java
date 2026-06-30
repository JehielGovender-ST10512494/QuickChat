package quickchat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<Message> sentMessages = new ArrayList<>();
        ArrayList<Message> storedMessages = new ArrayList<>();
        ArrayList<Message> disregardedMessages = new ArrayList<>();

        ArrayList<String> messageHashes = new ArrayList<>();
        ArrayList<String> messageIDs = new ArrayList<>();

        System.out.println("Welcome to QuickChat");

        System.out.print("How many messages would you like to send? ");
        int totalMessages = input.nextInt();
        input.nextLine();

        int option;

        do {

            System.out.println("\n===== QUICKCHAT =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Stored Messages");
            System.out.println("4. Quit");

            System.out.print("Choose an option: ");
            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:

                    for (int i = 0; i < totalMessages; i++) {

                        System.out.println("\nMessage " + (i + 1));

                        System.out.print("Recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter message: ");
                        String text = input.nextLine();

                        Message msg = new Message(i + 1, recipient, text);

                        System.out.println(msg.checkRecipientCell());
                        System.out.println(msg.validateMessageLength());

                        System.out.println();
                        System.out.println("1. Send Message");
                        System.out.println("2. Discard Message");
                        System.out.println("3. Store Message");

                        System.out.print("Choose option: ");
                        int sendChoice = input.nextInt();
                        input.nextLine();

                        System.out.println(msg.sentMessage(sendChoice));

                        switch (sendChoice) {

                            case 1:

                                messages.add(msg);
                                sentMessages.add(msg);

                                messageIDs.add(msg.getMessageID());
                                messageHashes.add(msg.getMessageHash());

                                break;

                            case 2:

                                disregardedMessages.add(msg);

                                break;

                            case 3:

                                messages.add(msg);
                                storedMessages.add(msg);

                                messageIDs.add(msg.getMessageID());
                                messageHashes.add(msg.getMessageHash());

                                MessageStore.storeMessages(storedMessages);

                                break;

                            default:

                                System.out.println("Invalid option.");
                        }

                        System.out.println("\n===== MESSAGE DETAILS =====");
                        System.out.println(msg.printMessages());

                    }

                    System.out.println("\nTotal messages sent: " + messages.size());

                    break;
                                    case 2:

                    if (sentMessages.isEmpty()) {

                        System.out.println("No messages have been sent.");

                    } else {

                        System.out.println("\n===== RECENTLY SENT MESSAGES =====");

                        for (Message m : sentMessages) {

                            System.out.println(m.printMessages());
                            System.out.println();

                        }

                    }

                    break;

                case 3:

                    System.out.println("\n===== STORED MESSAGES =====");
                    System.out.println("1. Display stored messages");
                    System.out.println("2. Display longest stored message");
                    System.out.println("3. Search by Message ID");
                    System.out.println("4. Search by Recipient");
                    System.out.println("5. Delete by Message Hash");
                    System.out.println("6. Display Report");

                    System.out.print("Choose option: ");
                    int storedChoice = input.nextInt();
                    input.nextLine();

                    switch (storedChoice) {

                        case 1:

                            StoredMessageManager.displayStoredMessages(storedMessages);

                            break;

                        case 2:

                            StoredMessageManager.displayLongestMessage(storedMessages);

                            break;

                        case 3:

                            System.out.print("Enter Message ID: ");
                            String id = input.nextLine();

                            StoredMessageManager.searchByMessageID(storedMessages, id);

                            break;

                        case 4:

                            System.out.print("Enter recipient: ");
                            String searchRecipient = input.nextLine();

                            StoredMessageManager.searchByRecipient(storedMessages, searchRecipient);

                            break;

                        case 5:


    System.out.print("Enter Message Hash: ");
    String hash = input.nextLine();

    StoredMessageManager.deleteByMessageHash(storedMessages, hash);

    break;

                        case 6:

    StoredMessageManager.displayReport(storedMessages);

    break;

                        default:

                            System.out.println("Invalid option.");

                    }

                    break;

                case 4:

                    System.out.println("Thank you for using QuickChat.");
                    break;

                default:

                    System.out.println("Invalid option.");

            }

        } while (option != 4);

        input.close();

    }
}