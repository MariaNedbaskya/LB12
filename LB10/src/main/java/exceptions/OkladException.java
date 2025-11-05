package exceptions;

public class OkladException extends Exception {
    private double invalidOklad;

    public OkladException(String message, double oklad) {
        super(message);
        this.invalidOklad = oklad;
    }

    public double getInvalidOklad() {
        return invalidOklad;
    }
}
