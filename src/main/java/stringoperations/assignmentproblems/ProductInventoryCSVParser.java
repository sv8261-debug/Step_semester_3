
package stringoperations.assignmentproblems;

public class ProductInventoryCSVParser {

    void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0].trim()
                + " | SKU: " + fields[1].trim()
                + " | Qty: " + fields[2].trim());
    }

    public static void main(String[] args) {
        ProductInventoryCSVParser obj =
                new ProductInventoryCSVParser();

        obj.parseInventoryRecord("Wireless Mouse,WM-2201,150");
        obj.parseInventoryRecord("Wireless Mouse,150");
    }
}