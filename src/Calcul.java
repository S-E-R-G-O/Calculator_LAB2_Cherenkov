import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

public class Calcul implements Calculator, CalculatorView
{

    private double firstNum;
    private double secondNum;

    private static Calcul instance; //singleton

    private Calcul(){}

    public static Calcul getInstance()
    {
        if( instance == null) {
            instance = new Calcul();
            return instance;
        }
        else
            return instance;
    }


    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public static String valueOf(double a)
    {
        String temp = Double.toString(a);
        return temp;
    }
    public void startWork()
    {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите первое число: ");
            setFirstNum(Double.parseDouble(reader.readLine()));
            System.out.print("Введите первое число: ");
            setSecondNum(Double.parseDouble(reader.readLine()));
            System.out.println("Введите знак операции: " + "+,-,*,/: " );
            String command = reader.readLine();
            double temp = 0;
            switch (command)
            {
                case "+":
                    temp = sum(getFirstNum(), getSecondNum());
                    printResult(temp);
                    break;

                case "-":
                    temp = subtract(getFirstNum(), getSecondNum());
                    printResult(temp);
                    break;
                case "*":
                    temp = multiply(getFirstNum() , getSecondNum());
                    printResult(temp);
                    break;
                case "/":
                    try {
                        temp = divide(getFirstNum(), getSecondNum());
                        printResult(temp);
                    }catch (ArithmeticException e)
                    {
                        displayError(e.getStackTrace().toString());
                    }
                    break;
                default:
                    System.out.println("Число неверно введенно");
                    break;

            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException{
        if(a == 0 || b == 0 || b < pow(10, -8))
            throw new ArithmeticException();
        else
            return a/b;
    }



    @Override
    public void printResult(double result) {
        System.out.println("Ответ: " + result + "\n");
    }

    @Override
    public void displayError(String message) {
        System.out.println("Возникла ошибка  " + message+ "\n");
    }

    @Override
    public String getFirstArgumentAsString() {
        return valueOf(getFirstNum());
    }

    @Override
    public String getSecondArgumentAsString() {
        return valueOf(getSecondNum());
    }

    public boolean isAvailable() {
        if(Calcul.getInstance() instanceof Calcul)
            return true;
        else
            return false;
    }
}