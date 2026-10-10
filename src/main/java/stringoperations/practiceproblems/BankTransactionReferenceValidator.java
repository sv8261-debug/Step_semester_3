
package stringoperations.practiceproblems;

public class BankTransactionReferenceValidator {

    String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        return reference.substring(0, 3).toUpperCase()
                + reference.substring(3);
    }

    String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String date = reference.substring(3, 9);
        String formattedDate = date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/"
                + date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(reference.substring(0, 3))
                .append("] DATE: ").append(formattedDate)
                .append(" | SEQ: ").append(reference.substring(9));

        return result.toString();
    }

    public static void main(String[] args) {
        BankTransactionReferenceValidator obj =
                new BankTransactionReferenceValidator();

        String ref1 = obj.normalizeReference(" hdf03022600042 ");
        System.out.println(obj.validateAndFormat(ref1));

        String ref2 = obj.normalizeReference("12F03022600042");
        System.out.println(obj.validateAndFormat(ref2));
    }
}