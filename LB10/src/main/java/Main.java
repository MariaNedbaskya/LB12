import employees.Employee;
import employees.StaffEmployee;
import employees.ContractEmployee;
import exceptions.OkladException;
import exceptions.PremiyaException;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company;

    public static void main(String[] args) {

        createCompany();

        boolean running = true;
        while (running) {
            running = showMainMenu();
        }

        System.out.println("\nПрограмма завершена. До свидания!");
    }

    private static void createCompany() {
        System.out.println("\nСОЗДАНИЕ КОМПАНИИ");

        String companyName = readCompanyName();
        company = new Company(companyName);
        System.out.println(" Компания создана: " + companyName);

        createDepartmentsInteractive();
    }

    private static String readCompanyName() {
        while (true) {
            System.out.print("Введите название компании: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println(" Название компании не может быть пустым!");
                continue;
            }

            if (name.length() < 2) {
                System.out.println(" Название компании слишком короткое!");
                continue;
            }

            if (name.length() > 100) {
                System.out.println(" Название компании слишком длинное!");
                continue;
            }

            if (!name.matches("^[a-zA-Zа-яА-Я0-9\\s\\\"'«»-]+$")) {
                System.out.println(" Название содержит недопустимые символы!");
                continue;
            }

            System.out.print("Вы уверены, что хотите назвать компанию \"" + name + "\"? (y/n): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                return name;
            }
        }
    }

    private static void createDepartmentsInteractive() {
        System.out.println("\nСОЗДАНИЕ ОТДЕЛОВ");

        boolean addingDepartments = true;
        while (addingDepartments) {
            System.out.println("\nТекущие отделы (" + company.getDepartments().size() + "):");
            List<Department> departments = company.getDepartments();
            for (int i = 0; i < departments.size(); i++) {
                System.out.println((i + 1) + ". " + departments.get(i).getName());
            }

            System.out.println("\n1 - Добавить новый отдел");
            System.out.println("2 - Закончить создание отделов");
            System.out.print("Выберите действие: ");

            int choice = readIntInput();

            switch (choice) {
                case 1:
                    addNewDepartment();
                    break;
                case 2:
                    if (company.getDepartments().isEmpty()) {
                        System.out.println(" В компании должен быть хотя бы один отдел!");
                    } else {
                        addingDepartments = false;
                    }
                    break;
                default:
                    System.out.println(" Неверный выбор!");
            }
        }
    }

    private static void addNewDepartment() {
        String departmentName = readDepartmentName();

        if (isDepartmentNameDuplicate(departmentName)) {
            System.out.println(" Отдел с таким названием уже существует!");
            return;
        }

        Department department = new Department(departmentName);
        company.addDepartment(department);
        System.out.println(" Отдел создан: " + departmentName);
    }

    private static String readDepartmentName() {
        while (true) {
            System.out.print("Введите название отдела: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println(" Название отдела не может быть пустым!");
                continue;
            }

            if (name.length() < 2) {
                System.out.println(" Название отдела слишком короткое!");
                continue;
            }

            if (name.length() > 50) {
                System.out.println(" Название отдела слишком длинное!");
                continue;
            }

            if (!name.matches("^[a-zA-Zа-яА-Я0-9\\s\\-\\.]+$")) {
                System.out.println("❌ Название содержит недопустимые символы!");
                continue;
            }

            return name;
        }
    }

    private static boolean isDepartmentNameDuplicate(String name) {
        List<Department> departments = company.getDepartments();
        for (Department dept : departments) {
            if (dept.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean showMainMenu() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("Компания: " + company.getName());
        System.out.println("Отделов: " + company.getDepartments().size());
        System.out.println("Сотрудников: " + company.getTotalEmployees());
        System.out.println("\n1 - Добавить сотрудника");
        System.out.println("2 - Добавить отдел");
        System.out.println("3 - Показать всех сотрудников");
        System.out.println("4 - Рассчитать зарплаты");
        System.out.println("5 - Информация о компании");
        System.out.println("6 - Тестирование исключений");
        System.out.println("0 - Выход");
        System.out.print("Выберите действие: ");

        int choice = readIntInput();

        switch (choice) {
            case 1:
                addEmployeeInteractive();
                break;
            case 2:
                addNewDepartment();
                break;
            case 3:
                showAllEmployees();
                break;
            case 4:
                calculateAllSalaries();
                break;
            case 5:
                showCompanyInfo();
                break;
            case 6:
                testExceptions();
                break;
            case 0:
                return false;
            default:
                System.out.println(" Неверный выбор! Попробуйте снова.");
        }
        return true;
    }

    private static void addEmployeeInteractive() {
        if (company.getDepartments().isEmpty()) {
            System.out.println(" В компании нет отделов! Сначала создайте отдел.");
            return;
        }

        System.out.println("\nДОБАВЛЕНИЕ НОВОГО СОТРУДНИКА");

        Department department = selectDepartment();
        if (department == null) return;

        String fio = readFioInput();

        String position = readPositionInput();

        double oklad = readOkladInput();

        System.out.println("\nВыберите тип сотрудника:");
        System.out.println("1 - Штатный сотрудник (оклад + премия)");
        System.out.println("2 - Сотрудник по контракту (только оклад)");
        System.out.print("Ваш выбор: ");

        int typeChoice = readIntInput();

        try {
            Employee employee;

            if (typeChoice == 1) {
                double premija = readPremijaInput();
                employee = new StaffEmployee(fio, position, oklad, premija);
            } else if (typeChoice == 2) {
                employee = new ContractEmployee(fio, position, oklad);
            } else {
                System.out.println(" Неверный выбор типа сотрудника!");
                return;
            }

            department.addEmployee(employee);
            System.out.println("Сотрудник успешно добавлен в отдел: " + department.getName());

        } catch (OkladException e) {
            System.out.println(" Ошибка оклада: " + e.getMessage());
            System.out.println("Некорректное значение: " + e.getInvalidOklad());
        } catch (PremiyaException e) {
            System.out.println(" Ошибка премии: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Общая ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String readFioInput() {
        while (true) {
            System.out.print("Введите ФИО сотрудника: ");
            String fio = scanner.nextLine().trim();

            if (fio.isEmpty()) {
                System.out.println(" ФИО не может быть пустым!");
                continue;
            }

            if (fio.length() < 5) {
                System.out.println(" ФИО слишком короткое! Минимум 5 символов.");
                continue;
            }

            if (fio.length() > 100) {
                System.out.println(" ФИО слишком длинное! Максимум 100 символов.");
                continue;
            }

            if (!fio.contains(" ")) {
                System.out.println(" ФИО должно содержать имя и фамилию (через пробел)!");
                continue;
            }

            if (!fio.matches("^[a-zA-Zа-яА-ЯёЁ\\s\\-]+$")) {
                System.out.println(" ФИО содержит недопустимые символы!");
                continue;
            }

            if (fio.contains("  ")) {
                System.out.println(" Уберите лишние пробелы в ФИО!");
                continue;
            }

            return fio;
        }
    }

    private static String readPositionInput() {
        while (true) {
            System.out.print("Введите должность: ");
            String position = scanner.nextLine().trim();

            if (position.isEmpty()) {
                System.out.println(" Должность не может быть пустой!");
                continue;
            }

            if (position.length() < 2) {
                System.out.println(" Название должности слишком короткое!");
                continue;
            }

            if (position.length() > 50) {
                System.out.println(" Название должности слишком длинное!");
                continue;
            }

            if (!position.matches("^[a-zA-Zа-яА-Я0-9\\s\\-\\/\\.]+$")) {
                System.out.println("❌ Должность содержит недопустимые символы!");
                continue;
            }

            return position;
        }
    }

    private static double readOkladInput() {
        while (true) {
            try {
                System.out.print("Введите оклад (руб.): ");
                double oklad = readDoubleInput();

                if (oklad < 0) {
                    throw new OkladException("Оклад не может быть отрицательным!", oklad);
                }

                if (oklad == 0) {
                    System.out.println("⚠  Внимание: оклад равен нулю!");
                    System.out.print("Вы уверены? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (!confirm.equalsIgnoreCase("y")) {
                        continue;
                    }
                }

                if (oklad > 1000000) {
                    System.out.println("⚠️  Внимание: оклад превышает 1 млн рублей!");
                    System.out.print("Вы уверены? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (!confirm.equalsIgnoreCase("y")) {
                        continue;
                    }
                }

                return oklad;

            } catch (OkladException e) {
                System.out.println(" " + e.getMessage());
                System.out.println("Пожалуйста, введите положительное значение.");
            }
        }
    }

    private static double readPremijaInput() {
        while (true) {
            try {
                System.out.print("Введите размер премии (руб.): ");
                double premija = readDoubleInput();

                if (premija < 0) {
                    throw new PremiyaException("Премия не может быть отрицательной: " + premija);
                }

                if (premija > 500000) {
                    System.out.println("  Внимание: премия превышает 500 тыс. рублей!");
                    System.out.print("Вы уверены? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (!confirm.equalsIgnoreCase("y")) {
                        continue;
                    }
                }

                return premija;

            } catch (PremiyaException e) {
                System.out.println(" " + e.getMessage());
                System.out.println("Пожалуйста, введите неотрицательное значение.");
            }
        }
    }

    private static Department selectDepartment() {
        System.out.println("\nВыберите отдел:");
        List<Department> departments = company.getDepartments();
        for (int i = 0; i < departments.size(); i++) {
            Department dept = departments.get(i);
            System.out.println((i + 1) + " - " + dept.getName() + " (" + dept.getEmployeeCount() + " сотрудников)");
        }
        System.out.print("Ваш выбор: ");

        int choice = readIntInput();
        if (choice < 1 || choice > departments.size()) {
            System.out.println(" Неверный выбор отдела!");
            return null;
        }
        return departments.get(choice - 1);
    }

    private static int readIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print(" Неверный формат числа. Введите целое число: ");
            }
        }
    }

    private static double readDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim().replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print(" Неверный формат числа. Введите число: ");
            }
        }
    }

    private static void showAllEmployees() {
        System.out.println("\nВСЕ СОТРУДНИКИ КОМПАНИИ");

        if (company.getTotalEmployees() == 0) {
            System.out.println("В компании пока нет сотрудников.");
            return;
        }

        List<Department> departments = company.getDepartments();
        for (Department department : departments) {
            if (department.getEmployeeCount() > 0) {
                System.out.println("\n " + department.getName() + " (" + department.getEmployeeCount() + " сотрудников) ");
                List<Employee> employees = department.getEmployees();
                for (Employee employee : employees) {
                    String type = (employee instanceof StaffEmployee) ? "Штатный" : "Контракт";
                    double premija = (employee instanceof StaffEmployee) ? ((StaffEmployee) employee).getPremija() : 0;

                    System.out.printf("• %s (%s)%n", employee.getFio(), type);
                    System.out.printf("  Должность: %s, Оклад: %.2f руб.",
                            employee.getPosition(), employee.getOklad());
                    if (premija > 0) {
                        System.out.printf(", Премия: %.2f руб.", premija);
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void calculateAllSalaries() {
        System.out.println("\nРАСЧЕТ ЗАРПЛАТ");

        if (company.getTotalEmployees() == 0) {
            System.out.println("В компании пока нет сотрудников для расчета зарплат.");
            return;
        }

        double totalCompanySalary = 0;
        List<Department> departments = company.getDepartments();

        for (Department department : departments) {
            if (department.getEmployeeCount() > 0) {
                double totalDepartmentSalary = 0;

                System.out.println("\n--- " + department.getName() + " ---");
                List<Employee> employees = department.getEmployees();
                for (Employee employee : employees) {
                    double salary = employee.calculateSalary();
                    totalDepartmentSalary += salary;
                    totalCompanySalary += salary;
                }

                System.out.printf("Итого по отделу: %.2f руб.%n", totalDepartmentSalary);
            }
        }

        System.out.printf("\n💵 ОБЩИЙ ФОНД ЗАРПЛАТ КОМПАНИИ: %.2f руб.%n", totalCompanySalary);
    }

    private static void showCompanyInfo() {
        System.out.println("\nИНФОРМАЦИЯ О КОМПАНИИ");
        System.out.println("Название: " + company.getName());
        System.out.println("Общее количество сотрудников: " + company.getTotalEmployees());
        System.out.println("\nОтделы:");

        List<Department> departments = company.getDepartments();
        for (Department department : departments) {
            System.out.printf("\n%s: %d сотрудник(ов)%n",
                    department.getName(), department.getEmployeeCount());

            List<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                String type = (employee instanceof StaffEmployee) ? "Штатный" : "Контракт";
                System.out.printf("  └─ %s (%s) - %s - %.2f руб.%n",
                        employee.getFio(), type, employee.getPosition(), employee.getOklad());
            }
        }
    }

    private static void testExceptions() {
        System.out.println("\nТЕСТИРОВАНИЕ ИСКЛЮЧЕНИЙ");

        System.out.println("\n1. Тест OkladException с отрицательным окладом:");
        try {
            Employee invalid = new StaffEmployee("Тестовый Сотрудник", "Тестер", -10000, 5000);
        } catch (OkladException e) {
            System.out.println("✅ OkladException поймано: " + e.getMessage());
            System.out.println("   Некорректное значение: " + e.getInvalidOklad());
        } catch (Exception e) {
            System.out.println("❌ Неожиданная ошибка: " + e.getMessage());
        }

        System.out.println("\n2. Тест с пустым ФИО:");
        try {
            Employee emptyFio = new ContractEmployee("  ", "Тестер", 50000);
        } catch (IllegalArgumentException e) {
            System.out.println("✅ IllegalArgumentException поймано: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Другая ошибка: " + e.getMessage());
        }

        System.out.println("\n3. Тест PremiyaException через расчет зарплаты:");
        try {

            StaffEmployee testEmployee = new StaffEmployee("Тест Премия", "Тестер", 50000, -1000);

            testEmployee.calculateSalary();
        } catch (PremiyaException e) {
            System.out.println("✅ PremiyaException поймано: " + e.getMessage());
        } catch (OkladException e) {
            System.out.println("✅ OkladException поймано: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Неожиданная ошибка: " + e.getMessage());
        }
    }
}