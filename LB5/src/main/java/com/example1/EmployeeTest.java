package com.example1;

import com.example.domain.Employee;
import com.example.domain.Circle;
import com.example.domain.Triangle;
import com.example.domain.Rectangle;
import com.example.domain.GeometricFigure;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Jane Smith");
        emp.setSalary(120_345.27);
        emp.setSsn("012-34-5678");

        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Soc Sec # " + emp.getSsn());
        System.out.println("Employee salary: " + emp.getSalary());


        Circle circle = new Circle("Красный", 5.0);
        Rectangle rectangle = new Rectangle("Синий", 4.0, 6.0);
        Triangle triangle = new Triangle("Зеленый", 3.0, 4.0);
        circle.displayInfo();
        rectangle.displayInfo();
        triangle.displayInfo();


        GeometricFigure[] figures = {circle, rectangle, triangle};
        for (GeometricFigure figure : figures) {
            figure.displayInfo();
        }
    }
}