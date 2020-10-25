package com.softeng306.validation;

import com.softeng306.enums.Department;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class DepartmentValidator {
    private static Scanner scanner = new Scanner(System.in);
    private static PrintStream originalStream = System.out;
    private static PrintStream dummyStream = new PrintStream(new OutputStream() {
        public void write(int b) {
            // NO-OP
        }
    });

    /**
     * Checks whether the inputted department is valid.
     *
     * @param department The inputted department.
     * @return boolean indicates whether the inputted department is valid.
     */
    public static boolean checkDepartmentValidation(String department) {
        if (Department.getAllDepartment().contains(department)) {
            return true;
        }
        System.out.println("The department is invalid. Please re-enter.");
        return false;
    }

}
