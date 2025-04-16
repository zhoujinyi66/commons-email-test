package mail2.javax;

import mail2.core.EmailException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailUnitTest {
    private Email email;

    @BeforeEach
    void setUp() {
        email = new Email() {
            @Override
            public Email setMsg(String msg) throws EmailException {
                return null;
            }
        };
        email.setHostName("smtp.example.com");
    }

    @AfterEach
    void tearDown() {
        email = null;
    }

    @Test
    void testInvalidPort() {
        assertThrows(IllegalArgumentException.class, () -> email.setSmtpPort(-1));
    }

    @Test
    void testEmailConfiguration() throws EmailException {
        email.setSmtpPort(587);
        email.addTo("test@example.com");
        email.setFrom("sender@example.com");
        email.setSubject("Test Email");

        assertEquals(1, email.getToAddresses().size());
        assertEquals("sender@example.com", email.getFromAddress().toString());
        assertEquals("Test Email", email.getSubject());
    }

    @Test
    void testRecipientList() throws EmailException {
        email.addTo("test1@example.com");
        email.addTo("test2@example.com");
        assertEquals(2, email.getToAddresses().size());
    }
}
