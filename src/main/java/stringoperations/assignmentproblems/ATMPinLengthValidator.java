
package stringoperations.assignmentproblems;

public class ATMPinLengthValidator {

    void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        ATMPinLengthValidator obj = new ATMPinLengthValidator();

        obj.checkPinLength("482");
        obj.checkPinLength("4820");
    }
}