package eu.sig.training.ch04;

public class Transfer {
    private final TransferDetails details;

    public Transfer(TransferDetails details) {
        this.details = details;
    }

    public Account getSourceAccount() {
        return details.getSourceAccount();
    }

    public CheckingAccount getDestinationAccount() {
        return details.getDestinationAccount();
    }

    public Money getAmount() {
        return details.getAmount();
    }
}

public class TransferDetails {
    private final Account sourceAccount;
    private final CheckingAccount destinationAccount;
    private final Money amount;

    private TransferDetails(Builder builder) {
        this.sourceAccount = builder.sourceAccount;
        this.destinationAccount = builder.destinationAccount;
        this.amount = builder.amount;
    }

    // Getters...

    public static class Builder {
        private Account sourceAccount;
        private CheckingAccount destinationAccount;
        private Money amount;

        public Builder sourceAccount(Account sourceAccount) {
            this.sourceAccount = sourceAccount;
            return this;
        }

        public Builder destinationAccount(CheckingAccount destinationAccount) {
            this.destinationAccount = destinationAccount;
            return this;
        }

        public Builder amount(Money amount) {
            this.amount = amount;
            return this;
        }

        public TransferDetails build() {
            return new TransferDetails(this);
        }
    }
}

interface Account {
    // Common account methods
}

class CheckingAccount implements Account {
    // CheckingAccount specific implementations
}

class SavingsAccount implements Account {
    // SavingsAccount specific implementations
}
