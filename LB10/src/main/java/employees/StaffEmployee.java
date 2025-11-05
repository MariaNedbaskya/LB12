package employees;

import exceptions.PremiyaException;

public class StaffEmployee extends Employee {
    private double premija;

    public StaffEmployee(String fio, String position, double oklad, double premija) throws Exception {
        super(fio, position, oklad);
        this.premija = premija;
    }

    public double getPremija() {
        return premija;
    }

    public void setPremija(double premija) {
        this.premija = premija;
    }

    @Override
    public double calculateSalary() {
        try {
            if (premija < 0) {
                throw new PremiyaException("Премия не может быть отрицательной: " + premija);
            }

            double salary = getOklad() + premija;
            System.out.println("Зарплата штатного сотрудника " + getFio() + ": " + salary);
            return salary;

        } catch (PremiyaException e) {
            System.out.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return getOklad();
        } catch (Exception e) {
            System.out.println("Общая ошибка при расчете зарплаты: " + e.getMessage());
            return 0;
        }
    }
}