package com.softeng306.io;

import com.softeng306.managers.ProfessorMgr;

import java.util.List;

/**
 * Takes care of all the Input/Output processing needed by the
 * ProfessorMgr.
 */
public class ProfessorMgrIO {

    /**
     * Displays all the professors in the inputted department.
     *
     * @param professors The list of professor names.
     * @return A list of all the names of professors in the inputted department or else null.
     */
    public static void printAllProfIDsInDepartment(List<String> professors) {
        if (professors == null || professors.isEmpty()) {
            System.out.println("None.");
        } else {
            professors.forEach(System.out::println);
        }
    }
}