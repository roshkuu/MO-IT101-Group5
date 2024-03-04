/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task11;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeeModelFromFile extends EmployeeModel {

//    public static void main(String[] args) {
//        EmployeeModelFromFile emp = new EmployeeModelFromFile();
//    }
    public EmployeeModelFromFile() {
        String textFile = "C:\\Users\\kuros\\OneDrive\\Desktop\\MotorPH\\EmployeeData.txt";
        employees = new Employee[34];
        getDataFromFile(textFile);

    }

    @Override
    public Employee[] getEmployeeModelList() {
        return employees;
    }

    private void getDataFromFile(String textFile) {
        try {
            Scanner scannerToGetFile = new Scanner(new File(textFile));
            int counter = 0;
            while (scannerToGetFile.hasNextLine()) {
                String data = scannerToGetFile.nextLine();
                Scanner scannerForParsing = new Scanner(data);
                parseDataFromScanner(scannerForParsing, counter);
                counter++;
            }
            scannerToGetFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeModelFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void parseDataFromScanner(Scanner scanner, int counter) {
        scanner.useDelimiter("[|]");
        while (scanner.hasNext()) {
            Employee employee = new Employee();
            employee.setEmpNo(scanner.next());
            employee.setLastName(scanner.next());
            employee.setFirstName(scanner.next());
            employee.setBirthday(scanner.next());
            employee.setAddress(scanner.next());
            employee.setPhoneNo(scanner.next());
            employee.setSssNo(scanner.next());
            employee.setPhilHealthNo(scanner.next());
            employee.setTinNo(scanner.next());
            employee.setPagibigNo(scanner.next());
            employee.setStatus(scanner.next());
            employee.setPosition(scanner.next());
            employee.setSupervisor(scanner.next());
            employee.setBasicSalary(Double.parseDouble(scanner.next()));
            employee.setRiceSubsidy(Double.parseDouble(scanner.next()));
            employee.setPhoneAllowance(Double.parseDouble(scanner.next()));
            employee.setClothingAllowance(Double.parseDouble(scanner.next()));
            employee.setSemiMonthlyRate(Double.parseDouble(scanner.next()));
            employee.setHourlyRate(Double.parseDouble(scanner.next()));
            employees[counter] = employee;
//            System.out.println(employees[counter].getEmpNo() + ", " + employees[counter].getLastName());
        }
        scanner.close();
    }

}
