package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Abner Gonçalves
 */
public class Fatorial {

  public static void main(String[] args) throws IOException {
    Fatorial fatorial = new Fatorial();
    fatorial.calcular();
  }
  
  private void calcular() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(".. Calculo fatorial ..\n");
    System.out.print("Informe o número:");
    String sx = br.readLine();
    //
    if (sx == null || sx.trim().equals("")) {
      System.out.println("Favor informar ao menos um número antes de prosseguir com a operação.");
      return;
    }
    int fat = 1, x = Integer.parseInt(sx.trim());
    //
   for (int i = 1; i <= x; i++) {
      fat *= i;
      System.out.println(i + "! = " + fat);
    }
    System.out.println("O resultado do calculo fatorial é: " + fat);
  }

}
