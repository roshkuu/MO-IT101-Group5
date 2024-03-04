/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task11;

/**
 *
 * @author kuros
 */
public class SalaryDeductions {
    
    private double salary;

    private double getSSSdeduction() {
        final int constant = 25000;
        if ((int) Math.round(salary) < constant) {
            return salary * 0.045;
        }
        return constant * 0.045;
    }

    private double getWithholdingTax() {
        double withHoldingTax = 0;
        if (salary > 20833 && salary <= 33333) {
            withHoldingTax = (salary - 20833) * 0.15;
        } else if (salary >= 33333 && salary <= 66667) {
            withHoldingTax = 1875 + (salary - 33333) * 0.2;
        } else if (salary >= 66667 && salary <= 166667) {
            withHoldingTax = 8541 + (salary - 66667) * 0.25;
        } else if (salary >= 166667 && salary <= 666667) {
            withHoldingTax = 33541 + (salary - 166667) * 0.3;
        } else if (salary > 666667) {
            withHoldingTax = 183541 + (salary - 666667) * 0.35;
        }
        return withHoldingTax;
    }

    private double getPagibigDeduction() {
        final double minimunCompensation = 1500;
        if (salary > minimunCompensation) {
            return salary * 0.02;
        }
        return salary * 0.01;
    }

    private double getPhilHealthDeduction() {
        return salary * 0.05;
    }

    public double getTotalDeductions(double salary) {
        this.salary = salary;
        return getSSSdeduction() + getPagibigDeduction() + getPhilHealthDeduction() + getWithholdingTax();
    }

}
