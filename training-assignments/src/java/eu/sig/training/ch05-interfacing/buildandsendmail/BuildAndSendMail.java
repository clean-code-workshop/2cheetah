package eu.sig.training.ch05.buildandsendmail;

public class EmailService {
    private final MailMan mailMan;

    public EmailService(MailMan mailMan) {
        this.mailMan = mailMan;
    }

    public void sendEmail(EmailDetails details, EmailContent content) {
        String emailAddress = generateEmailAddress(details);
        MailMessage formattedMessage = formatMessage(content);
        mailMan.send(emailAddress, details.getSubject(), formattedMessage);
    }

    private String generateEmailAddress(EmailDetails details) {
        return String.format("%c.%s@%.5s.compa.ny",
            details.getFirstName().charAt(0),
            details.getLastName().substring(0, Math.min(7, details.getLastName().length())),
            details.getDivision());
    }

    private MailMessage formatMessage(EmailContent content) {
        return new MailMessage(content.getFont(), content.getCombinedMessage());
    }
}

class EmailDetails {
    private final String firstName;
    private final String lastName;
    private final String division;
    private final String subject;

    // Constructor, getters...
}

class EmailContent {
    private final MailFont font;
    private final String message1;
    private final String message2;

    // Constructor, getters...

    public String getCombinedMessage() {
        return message1 + message2;
    }
}

    @SuppressWarnings("unused")
    private MailMessage formatMessage(MailFont font, String string) {
        return null;
    }

    private class MailMan {

        @SuppressWarnings("unused")
        public void send(String mId, String subject, MailMessage mMessage) {}

    }

    private class MailFont {

    }

    private class MailMessage {

    }

}
