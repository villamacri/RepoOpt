package ejercicio02;

public class TemperaturaLimitException extends RuntimeException {
    public TemperaturaLimitException() { super("Error, la temperatura no puede ser menor a 273º Celsius.");}
}
