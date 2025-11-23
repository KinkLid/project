import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testBuilderCreatesValidStudent() {
        Student student = new Student.Builder()
                .groupNumber(101)
                .averageGrade(8.5)
                .recordBookNumber("RB-123")
                .build();

        assertEquals(101, student.getGroupNumber());
        assertEquals(8.5, student.getAverageGrade());
        assertEquals("RB-123", student.getRecordBookNumber());
    }

    @Test
    public void testInvalidGroupNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student.Builder()
                    .groupNumber(0)
                    .averageGrade(7.5)
                    .recordBookNumber("RB101")
                    .build();
        });
    }

    @Test
    public void testInvalidAverageGrade() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student.Builder()
                    .groupNumber(101)
                    .averageGrade(15)
                    .recordBookNumber("RB101")
                    .build();
        });
    }

    @Test
    public void testInvalidRecordBook() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student.Builder()
                    .groupNumber(101)
                    .averageGrade(8)
                    .recordBookNumber("   ")
                    .build();
        });
    }

}
