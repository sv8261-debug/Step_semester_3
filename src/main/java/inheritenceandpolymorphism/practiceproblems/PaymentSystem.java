
package inheritenceandpolymorphism.practiceproblems;

import java.util.*;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.02;
    }

    @Override
    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.01;
    }

    @Override
    String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }

    @Override
    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Payment> payments = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0];
            double amount = Double.parseDouble(data[1]);

            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransfer(amount));
                    break;
            }
        }

        for (Payment payment : payments) {
            double adjusted = payment.calculateAmount();
            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
