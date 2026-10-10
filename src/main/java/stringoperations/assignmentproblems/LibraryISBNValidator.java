
package stringoperations.assignmentproblems;

public class LibraryISBNValidator {

    String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        return code.substring(0, 3).toUpperCase()
                + code.substring(3);
    }

    String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();
        result.append("[")
                .append(code.substring(0, 3))
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        LibraryISBNValidator obj = new LibraryISBNValidator();

        String code1 = obj.normalizeCode(" pen2026004251 ");
        System.out.println(obj.validateAndFormat(code1));

        String code2 = obj.normalizeCode("12N2026004251");
        System.out.println(obj.validateAndFormat(code2));
    }
}