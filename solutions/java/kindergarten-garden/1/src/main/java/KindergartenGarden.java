import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {
    private final String[] rows;
    private static final String[] STUDENTS = {
        "Alice", "Bob", "Charlie", "David", "Eve", "Fred", 
        "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"
    };

    KindergartenGarden(String garden) {
        this.rows = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = -1;
        for (int i = 0; i < STUDENTS.length; i++) {
            if (STUDENTS[i].equals(student)) {
                studentIndex = i;
                break;
            }
        }
        
        if (studentIndex == -1) {
            throw new IllegalArgumentException("Student not found: " + student);
        }
        
        List<Plant> plants = new ArrayList<>();
        
        int startPos = studentIndex * 2;
        
        for (String row : rows) {
            if (startPos < row.length()) {
                plants.add(Plant.getPlant(row.charAt(startPos)));
            }
            if (startPos + 1 < row.length()) {
                plants.add(Plant.getPlant(row.charAt(startPos + 1)));
            }
        }
        
        return plants;
    }
}
