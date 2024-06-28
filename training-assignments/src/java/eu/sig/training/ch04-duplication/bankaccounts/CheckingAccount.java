package eu.sig.training.ch04;

public class CheckingAccount {
    private static final float INTEREST_PERCENTAGE = 0.01f;
    private Money balance = new Money();
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount) throws BusinessException {
        validateTransferAmount(amount);
        validateAccountNumber(counterAccount);
        return createTransfer(counterAccount, amount);
    }

    private void validateTransferAmount(Money amount) throws BusinessException {
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
    }

    private void validateAccountNumber(String accountNumber) throws BusinessException {
        if (!AccountValidator.isValid(accountNumber)) {
            throw new BusinessException("Invalid account number!");
        }
    }

    private Transfer createTransfer(String counterAccount, Money amount) {
        CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
        return new Transfer(this, acct, amount);
    }

    public void addInterest() {
        Money interest = calculateInterest();
        updateBalance(interest);
    }

    private Money calculateInterest() {
        return balance.multiply(INTEREST_PERCENTAGE);
    }

    private void updateBalance(Money interest) {
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }
}

class AccountValidator {
    public static boolean isValid(String accountNumber) {
        int sum = 0;
        for (int i = 0; i < accountNumber.length(); i++) {
            int digitValue = Character.getNumericValue(accountNumber.charAt(i));
            sum += (9 - i) * digitValue;
        }
        return sum % 11 == 0;
    }
}
