
package inheritenceandpolymorphism.practiceproblems;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowingDays();

    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(borrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    @Override
    int borrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    @Override
    int borrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    @Override
    int borrowingDays() {
        return 3;
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher =
                    Pattern.compile("^(\\S+)\\s+\"(.*)\"$")
                            .matcher(line);

            if (!matcher.matches()) {
                throw new IllegalArgumentException(
                        "Invalid item input: " + line);
            }

            String type = matcher.group(1);
            String title = matcher.group(2);

            switch (type) {
                case "BOOK":
                    items.add(new Book(title));
                    break;
                case "DVD":
                    items.add(new DVD(title));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unknown item type: " + type);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": "
                    + item.calculateDueDate(currentDate));
        }

        sc.close();
    }
}
