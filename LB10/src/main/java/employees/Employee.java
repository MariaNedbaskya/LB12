package employees;

import exceptions.OkladException;

public abstract class Employee {
    private String fio;
    private String position;
    private double oklad;

    public Employee(String fio, String position, double oklad) throws OkladException {

        this.fio = fio;
        this.position = position;
        setOklad(oklad);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getOklad() {
        return oklad;
    }

    public void setOklad(double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException("Нельзя установить отрицательный оклад: " + oklad, oklad);
        }
        this.oklad = oklad;
    }

    public abstract double calculateSalary();
}