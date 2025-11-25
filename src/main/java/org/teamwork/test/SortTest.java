package org.teamwork.test;

import org.teamwork.model.Student;
import org.teamwork.sort.*;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        testAverageGradeSort();
        testGroupNumberSort();
        testRecordBookNumberSort();
        testAllSort();
        testEvenNumbered();
    }
    static void testAverageGradeSort(){
        Student[] result = new Student[]{
                new Student(105,36.80, "006600"),
                new Student(105,31.35, "006600"),
                new Student(105,36.44, "006600"),
                new Student(105,82.35, "006600"),
                new Student(105,99.99, "006600"),
                new Student(105,73.56, "006600"),
                new Student(105,68.23, "006600"),
                new Student(105,55.44, "006600"),
        };

        result = new StudentSort(result, new ByAllStrategy()).getStudents();

        check(result,new Student[]{
                new Student(105,31.35, "006600"),
                new Student(105,36.44, "006600"),
                new Student(105,36.80, "006600"),
                new Student(105,55.44, "006600"),
                new Student(105,68.23, "006600"),
                new Student(105,73.56, "006600"),
                new Student(105,82.35, "006600"),
                new Student(105,99.99, "006600")
        },"testAverageGrade");
    }

    static void testGroupNumberSort(){
        Student[] result = new Student[]{
                new Student(444,66.00, "006600"),
                new Student(777,66.00, "006600"),
                new Student(666,66.00, "006600"),
                new Student(999,66.00, "006600"),
                new Student(555,66.00, "006600"),
                new Student(222,66.00, "006600"),
                new Student(333,66.00, "006600"),
                new Student(111,66.00, "006600")
        };

        result = new StudentSort(result, new ByAllStrategy()).getStudents();

        check(result,new Student[]{
                new Student(111,66.00, "006600"),
                new Student(222,66.00, "006600"),
                new Student(333,66.00, "006600"),
                new Student(444,66.00, "006600"),
                new Student(555,66.00, "006600"),
                new Student(666,66.00, "006600"),
                new Student(777,66.00, "006600"),
                new Student(999,66.00, "006600")
        },"testGroupNumber");
    }
    static void testRecordBookNumberSort(){
        Student[] result = new Student[]{
                new Student(105,99.00, "2040289"),
                new Student(105,99.00, "2040499"),
                new Student(105,99.00, "2040122"),
                new Student(105,99.00, "2040447"),
                new Student(105,99.00, "2040321"),
                new Student(105,99.00, "1940321"),
                new Student(105,99.00, "2040111А"),
                new Student(105,99.00, "2040111Б"),
        };

        result = new StudentSort(result, new ByAllStrategy()).getStudents();

        check(result,new Student[]{
                new Student(105,99.00, "1940321"),
                new Student(105,99.00, "2040111А"),
                new Student(105,99.00, "2040111Б"),
                new Student(105,99.00, "2040122"),
                new Student(105,99.00, "2040289"),
                new Student(105,99.00, "2040321"),
                new Student(105,99.00, "2040447"),
                new Student(105,99.00, "2040499"),
        },"testRecordBookNumber");
    }

    static void testAllSort(){
        Student[] result = new Student[]{
                new Student(234,66.66, "222222Б"),
                new Student(345,99.99, "2040479"),
                new Student(234,66.66, "333333В"),
                new Student(345,64.74, "2040122"),
                new Student(123,44.44, "006Б600"),
                new Student(123,55.55, "00В6600"),
                new Student(345,64.75, "2040644"),
                new Student(234,66.66, "111111А"),
                new Student(123,33.33, "0066А00")
        };

        result = new StudentSort(result, new ByAllStrategy()).getStudents();

        check(result,new Student[]{
                new Student(123,33.33, "0066А00"),
                new Student(123,44.44, "006Б600"),
                new Student(123,55.55, "00В6600"),
                new Student(234,66.66, "111111А"),
                new Student(234,66.66, "222222Б"),
                new Student(234,66.66, "333333В"),
                new Student(345,64.74, "2040122"),
                new Student(345,64.75, "2040644"),
                new Student(345,99.99, "2040479")
        },"testAllSort");
    }

    static void testEvenNumbered(){
        Student[] result = new Student[]{
                new Student(111,4.66, "222222Б"),
                new Student(555,3.99, "2040479"),
                new Student(333,2.86, "333333В"),
                new Student(666,4.74, "2040122"),
                new Student(888,4.55, "2222222"),
                new Student(888,4.55, "1111111"),
                new Student(444,4.75, "2040644"),
                new Student(666,3.66, "111111А"),
                new Student(777,2.33, "0066А00")
        };

        result = new StudentSort(result, new ByEvenNumberedStrategy()).getStudents();

        check(result,new Student[]{
                new Student(111,4.66,"222222Б"),
                new Student(555,3.99,"2040479"),
                new Student(333,2.86,"333333В"),
                new Student(444,4.75,"2040644"),
                new Student(666,3.66,"111111А"),
                new Student(666,4.74,"2040122"),
                new Student(888,4.55,"1111111"),
                new Student(888,4.55,"2222222"),
                new Student(777,2.33,"0066А00")
        },"testEvenNumbered");
    }



    static void check(Student[] result, Student[] expected, String testName){
        if(Arrays.equals(result,expected)) System.out.println(testName + " PASSED! :)");
        else System.out.println(testName+" FAILED... :(");
    }
}
