public interface Calculator {

    /**
     * Сумма двух чисел
     */
    double sum(double a, double b);


    /**
     * Разность двух чисел
     */
    double subtract(double a, double b);

    /**
     * Произведение двух чисел
     */
    double multiply(double a, double b);

    /**
     * Отношение числа а к числу b.
     */
    double divide(double a, double b);
}