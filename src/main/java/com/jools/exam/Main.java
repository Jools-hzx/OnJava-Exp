package main.java.com.jools.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @Test
    public void testStr() {
        System.out.println(10 + 5 + " :str");
        System.out.println("str:" + 10 + 5);
        System.out.println("str:" + (10 + 5));
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        //write your code here......
        Employee ming = new Employee("小明", 2500.0);
        Employee jun = new Employee("小军", 8000.0);
        Employee hong = new Employee("小红", 123241247.0);

        employees.add(ming);
        employees.add(jun);
        employees.add(hong);

        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            String tax = getTax(e.getSalary(), getTaxRate(e.getSalary()));
            System.out.printf("%s应该缴纳的个人所得税是: %s", e.getName(), tax);
            if (i != employees.size() - 1) {
                System.out.println();
            }
        }
    }

    // 计算税款
    private static String getTax(double sal, double[] map) {
        if (sal < 3500) return "0.0";
        double tax = (sal - 3500) * map[0] - map[1];
        return String.format("%.1f", tax);
    }

    private static double[] getTaxRate(double salary) {
        salary -= 3500;
        if (salary <= 1500) return new double[]{0.03, 0};
        if (salary > 1500 && salary <= 4500) return new double[]{0.1, 105};
        if (salary > 4500 && salary <= 9000) return new double[]{0.2, 555};
        if (salary > 9000 && salary <= 35000) return new double[]{0.25, 1005};
        if (salary > 35000 && salary <= 55000) return new double[]{0.3, 2755};
        if (salary > 55000 && salary <= 80000) return new double[]{0.35, 5505};
        else {
            return new double[]{0.45, 13505};
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
