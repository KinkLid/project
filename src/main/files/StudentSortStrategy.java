package org.teamwork.sort;


import org.teamwork.model.Student;
import java.util.List;


public interface StudentSortStrategy {
    List<Student> sort(List<Student> students);
}