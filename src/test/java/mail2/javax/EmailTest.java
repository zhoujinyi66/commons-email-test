package mail2.javax;

public class EmailTest {
    public static void main(String[] args) {
        try {
            Email email = new Email() {
                @Override
                public Email setMsg(String msg){
                    return null;
                }
            };
            email.setHostName("smtp.example.com");
            email.setSmtpPort(-1);
            email.addTo("test@example.com");
            email.setFrom("sender@example.com");
            email.setSubject("Test");
            email.setMsg("Hello World");
            email.send();
        } catch (mail2.core.EmailException e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}