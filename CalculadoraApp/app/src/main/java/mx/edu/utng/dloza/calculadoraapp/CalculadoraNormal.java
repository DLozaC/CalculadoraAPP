package mx.edu.utng.dloza.calculadoraapp;

/**
 * Created by Daniel on 25/09/2017.
 */

public class CalculadoraNormal implements AbstractCalculadora{
    double resultado=0.0;
    @Override
    public double sumar(double num1, double num2) {
        resultado=num1+num2;
        return resultado;
    }

    @Override
    public double restar(double num1, double num2) {
        resultado=num1-num2;
        return resultado;
    }

    public double multiplicar(double num1, double num2){
        resultado=num1*num2;
        return resultado;
    }

    public double dividir(double num1, double num2){
        resultado=num1/num2;
        return resultado;
    }
}
