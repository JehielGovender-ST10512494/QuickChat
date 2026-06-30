package quickchat;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
// JUnit test cases for QuickChat
public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hi Mike can you join us for dinner tonight?"
        );

        assertEquals(
                "Message ready to send.",
                msg.validateMessageLength()
        );
    }

    @Test
    public void testRecipientSuccess() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testRecipientFailure() {

        Message msg = new Message(
                1,
                "08575975889",
                "Hello"
        );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testMessageID() {

        Message msg = new Message(
                1,
                "+27718693002",
                "Hello there"
        );

        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testMessageHash() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hi Mike"
        );

        assertNotNull(msg.getMessageHash());
    }
    @Test
public void testSearchByMessageID() {

    ArrayList<Message> storedMessages = new ArrayList<>();

    Message msg = new Message(
            1,
            "+27718693002",
            "Hello there");

    storedMessages.add(msg);

    Message result =
            StoredMessageManager.searchByMessageID(
                    storedMessages,
                    msg.getMessageID());

    assertNotNull(result);
    assertEquals(msg.getMessageID(), result.getMessageID());
}
@Test
public void testDisplayLongestMessage() {

    ArrayList<Message> storedMessages = new ArrayList<>();

    Message msg1 = new Message(
            1,
            "+27834557896",
            "Did you get the cake?");

    Message msg2 = new Message(
            2,
            "+27838884567",
            "Where are you? You are late! I have asked you to be on time.");

    storedMessages.add(msg1);
    storedMessages.add(msg2);

    Message longest =
            StoredMessageManager.displayLongestMessage(storedMessages);

    assertEquals(msg2.getMessage(), longest.getMessage());
}
@Test
public void testSearchByRecipient() {

    ArrayList<Message> storedMessages = new ArrayList<>();

    Message msg1 = new Message(
            1,
            "+27838884567",
            "Where are you? You are late!");

    Message msg2 = new Message(
            2,
            "+27838884567",
            "Ok, I am leaving without you.");

    storedMessages.add(msg1);
    storedMessages.add(msg2);

    ArrayList<Message> results =
            StoredMessageManager.searchByRecipient(
                    storedMessages,
                    "+27838884567");

    assertEquals(2, results.size());
}
@Test
public void testDeleteMessageHash() {

    ArrayList<Message> storedMessages = new ArrayList<>();

    Message msg = new Message(
            1,
            "+27838884567",
            "Where are you? You are late!");

    storedMessages.add(msg);

    StoredMessageManager.deleteByMessageHash(
            storedMessages,
            msg.getMessageHash());

    assertEquals(0, storedMessages.size());
}
@Test
public void testDisplayReport() {

    ArrayList<Message> storedMessages = new ArrayList<>();

    storedMessages.add(new Message(
            1,
            "+27834557896",
            "Did you get the cake?"));

    StoredMessageManager.displayReport(storedMessages);

    assertEquals(1, storedMessages.size());
}
@Test
public void testSentMessagesArray() {

    ArrayList<Message> sentMessages = new ArrayList<>();

    sentMessages.add(new Message(
            1,
            "+27834557896",
            "Did you get the cake?"));

    sentMessages.add(new Message(
            2,
            "0838884567",
            "It is dinner time!"));

    assertEquals(2, sentMessages.size());
}
}