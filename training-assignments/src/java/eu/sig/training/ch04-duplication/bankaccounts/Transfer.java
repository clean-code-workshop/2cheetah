package eu.sig.training.ch04;

public class Transfer {
    private final Account sourceAccount;
    private final CheckingAccount destinationAccount;
    private final Money amount;

    public Transfer(Account sourceAccount, CheckingAccount destinationAccount, Money amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public CheckingAccount getDestinationAccount() {
        return destinationAccount;
    }

    public Money getAmount() {
        return amount;
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
