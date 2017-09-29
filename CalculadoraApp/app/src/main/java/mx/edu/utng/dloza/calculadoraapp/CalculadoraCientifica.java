package mx.edu.utng.dloza.calculadoraapp;

/**
 * Created by Daniel on 25/09/2017.
 */

public class CalculadoraCientifica implements AbstractCalculadora{
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

    public int factorial(int num) {
        int resul=0;
        if(num==1||num==0){
            return 1;
        }else{
            resultado=num*factorial(num-1);
        }
        return resul;
    }
}
