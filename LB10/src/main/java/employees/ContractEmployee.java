package employees;

public class ContractEmployee extends Employee {

    public ContractEmployee(String fio, String position, double oklad) throws Exception {
        super(fio, position, oklad);
    }

    @Override
    public double calculateSalary() {
        try {
            double salary = getOklad();
            System.out.println("Зарплата сотрудника по контракту " + getFio() + ": " + salary);
            return salary;

        } catch (Exception e) {
            System.out.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return 0;
        }
    }
}