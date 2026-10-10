
package stringoperations.practiceproblems;

public class CSVStudentRecordParser {

    void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0].trim()
                + " | Roll No: " + fields[1].trim()
                + " | Dept: " + fields[2].trim());
    }

    public static void main(String[] args) {
        CSVStudentRecordParser obj = new CSVStudentRecordParser();
        obj.parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        obj.parseStudentRecord("Ananya Verma,CSE");
    }
}