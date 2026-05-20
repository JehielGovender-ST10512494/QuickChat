package quickchat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Message> messages = new ArrayList<>();

        System.out.println("Welcome to QuickChat");

        System.out.print("How many messages would you like to send? ");
        int totalMessages = input.nextInt();
        input.nextLine();

        int option;

        do {

            System.out.println("\n1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Choose option: ");
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

                        System.out.println("\n1) Send Message");
                        System.out.println("2) Discard Message");
                        System.out.println("3) Store Message");

                        int sendChoice = input.nextInt();
                        input.nextLine();

                        System.out.println(msg.sentMessage(sendChoice));

                        if (sendChoice == 1 || sendChoice == 3) {

                           messages.add(msg);
                        }

                        if (sendChoice == 3) {

                        MessageStore.storeMessages(messages);
                        }

                        System.out.println("\n===== MESSAGE DETAILS =====");
                        System.out.println(msg.printMessages());
                    }

                    System.out.println("\nTotal messages sent: "
                            + messages.size());

                    break;

                case 2:

                    System.out.println("Coming Soon.");
                    break;

                case 3:

                    System.out.println("Goodbye.");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (option != 3);

        input.close();
    }
}

// Menu system completed 