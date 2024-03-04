/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task11;

import java.util.Scanner;

/**
 *
 * @author kuros
 */
public class Task11 {

    private static int platform = 1;
    private static EmployeeModel employeeModel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getDefaultEmployeeModel();
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("***********************************************");
        System.out.println("        Motor PH Main Menu      ");
        System.out.println("***********************************************");
        System.out.println("1: Data to read from     ");
        System.out.println("2: List of Employee Records     ");
        System.out.println("3: Calculate Net Salary         ");
        System.out.println("4: Calculate Salary based on Hours Worked ");
        System.out.println("************************************************");
        /**
         * Creates an object of Scanner Resource from Camu:
         * https://www.programiz.com/java-programming/scanner
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Pleas choose the screen you would like to view: ");
        // takes input from the keyboard
        String option = input.nextLine();
        // prints the option
        // System.out.println("You entered option number: " + option);
        processOption(option);
        // closes the scanner
        input.close();
    }

    private static void processOption(String option) {
        //Used conditional branch "switch" statement
        switch (option) {
            case "1":
                choosePlatform();
                break;
            case "2":
                processListOfEmployees();
                break;
            case "3":
                calculateNetSalary();
                break;
            case "4":
                salaryOnHoursWorked();
                break;
            default:
                break;
        }
    }

    private static void choosePlatform() {
        System.out.println("**********************************************************");
        System.out.println("    You have chosen option #1");
        System.out.println("    Which platform you would like the data to be read?   ");
        System.out.println("    Option 1: Text File   ");
        System.out.println("    Option 2: Class File  ");
        System.out.println("**********************************************************");
        Scanner inputPlatform = new Scanner(System.in);
        String optionPlatform = inputPlatform.nextLine();
        switch (optionPlatform) {
            case "1":
                platform = 1;
                break;
            case "2":
                platform = 2;
                break;
            default:
                break;
        }

        System.out.println("**********************************************************");
        System.out.println("    You have chosen option: " + optionPlatform);
        System.out.println("    Would you like to go back to main menu?   ");
        System.out.println("    Option 1: Yes   ");
        System.out.println("    Option 2: No  ");
        System.out.println("**********************************************************");
        Scanner inputToMainMenu = new Scanner(System.in);
        String optionToMainMenu = inputToMainMenu.nextLine();
        switch (optionToMainMenu) {
            case "1":
                displayMainMenu();
                break;
            default:
                break;
        }
        inputToMainMenu.close();
        inputPlatform.close();
    }

    private static void getDefaultEmployeeModel() {
        if (platform == 1) {
            employeeModel = new EmployeeModelFromFile();
        } else {
            employeeModel = new EmployeeModelFromClass();
        }
    }

    //method that has "void" signature doesn't return a data type
    private static void processListOfEmployees() {
        //Instanciating new object
        //Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #2");
        System.out.println("             List of employees        ");
        System.out.println("***********************************************");
        //used for loop statement to iterate thru the list of employees
        for (int a = 0; a < employeeList.length; a++) {
            Employee employee = employeeList[a];
            System.out.print("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Position: " + employee.getPosition() + "\n");
        }
    }

    private static void calculateNetSalary() {
        //Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #3    ");
        System.out.println("          Employee Net Salaries      ");
        System.out.println("***********************************************");
        //used for loop statement to iterate thru the list of employees
        for (int i = 0; i < employeeList.length; i++) {
            Employee employee = employeeList[i];
            System.out.print("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Basic Salary: " + employee.getBasicSalary()
                    + ", Net Salary: " + (employee.getBasicSalary() - salaryDeductions.getTotalDeductions(employee.getBasicSalary())) + "\n");
        }
    }

    private static void salaryOnHoursWorked() {
        //Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryOnHoursWorked hoursWOrked = new SalaryOnHoursWorked();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #4        ");
        System.out.println("     Salaries based on hours worked      ");
        System.out.println("***********************************************");
        //used for loop statement to iterate thru the list of employees
        for (int i = 0; i < employeeList.length; i++) {
            Employee employee = employeeList[i];
            System.out.print("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Basic Salary: " + employee.getBasicSalary()
                    + ", Salary Based on Hours Worked: " + hoursWOrked.getSalaryOnHoursWorked(employee.getHourlyRate()) + "\n");
        }
    }
}
    

