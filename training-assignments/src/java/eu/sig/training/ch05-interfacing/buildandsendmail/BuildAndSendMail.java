package eu.sig.training.ch05.buildandsendmail;

public class MailMan {
    public void send(EmailPackage emailPackage) {
        // Implementation details...
    }
}

public class EmailPackage {
    private final String recipientId;
    private final String subject;
    private final MailMessage message;

    private EmailPackage(Builder builder) {
        this.recipientId = builder.recipientId;
        this.subject = builder.subject;
        this.message = builder.message;
    }

    // Getters...

    public static class Builder {
        private String recipientId;
        private String subject;
        private MailMessage message;

        public Builder recipientId(String recipientId) {
            this.recipientId = recipientId;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder message(MailMessage message) {
            this.message = message;
            return this;
        }

        public EmailPackage build() {
            // You can add validation here
            if (recipientId == null || subject == null || message == null) {
                throw new IllegalStateException("All fields must be set");
            }
            return new EmailPackage(this);
        }
    }
}
