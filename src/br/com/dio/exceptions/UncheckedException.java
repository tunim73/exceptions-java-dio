package br.com.dio.exceptions;

import javax.swing.*;

//Fazer a divisão de 2 valores inteiros
public class UncheckedException { /* Unchecked = não marcado, não verificado  */
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {

                /*
                O nome é auto explicativo, mas foi lançado o erro por que não foi possível converter uma 
                string para um integer, visto que a string não era um numero, então aqui pegou o erro e mostoru ao usuário
                */
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage());
            } catch (ArithmeticException e) {

                /*
                Esse erro foi pego por que foi tentado realizar uma operação aritmética inválida, como dividir por zero.
                */
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0.");
            }
            finally {
                /*
                Este, finally, é realizado, quase sempre pelo que entendi, independente o código executou corretamente
                ou se foi pego uma exception 
                */

                System.out.println("Chegou no finally!");
            }
        } while(continueLooping);


        System.out.println("O código continua...");
    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}
