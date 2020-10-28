package com.softeng306.fileprocessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeng306.domain.mark.Mark;
import com.softeng306.domain.student.Student;
import com.softeng306.managers.StudentMgr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFileProcessor extends FileProcessor {

    private static final String STUDENT_FILE_PATH = "data/studentFile.json";

    /**
     * Write a new student information into the file.
     *
     * @param student a student to be added into the file
     */
    public void writeStudentsIntoFile(Student student) {
        try {
            List<Student> students = loadStudents();
            students.add(student);

            writeToFile(STUDENT_FILE_PATH, students);
        } catch (IOException e) {
            System.out.println("Error in adding a student to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Load all the students' information from file into the system.
     *
     * @return a list of all the students.
     */
    public List<Student> loadStudents() {
        ObjectMapper objectMapper = new ObjectMapper();
        File studentFile = Paths.get(STUDENT_FILE_PATH).toFile();
        ArrayList<Student> allStudents = new ArrayList<>();

        try {
            allStudents = new ArrayList<>(Arrays.asList(objectMapper.readValue(studentFile, Student[].class)));
            updateStudentIDs(allStudents);
        } catch (IOException e) {
            System.out.println("Error occurs when loading students.");
            e.printStackTrace();
        }

        return allStudents;
    }

    /**
     * Set the recent student ID, let the newly added student have the ID onwards.
     * If there is no student in DB, set recentStudentID to 1800000 (2018 into Uni)
     *
     * @param students The students to update.
     */
    private void updateStudentIDs(List<Student> students) {
        int recentStudentID = 0;
        for (Student student : students) {
            recentStudentID = Math.max(recentStudentID, Integer.parseInt(student.getStudentID().substring(1, 8)));
        }
        StudentMgr.setIdNumber(recentStudentID > 0 ? recentStudentID : 1800000);
    }


}
