package quickchat;

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
}