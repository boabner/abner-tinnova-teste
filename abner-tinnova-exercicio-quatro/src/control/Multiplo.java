/**
 * @author abner
 */
package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplo {

  public static void main(String[] args) throws IOException {
    Multiplo multiplo = new Multiplo();
    multiplo.somarMultiplos();
  }
  
  private void somarMultiplos() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Informe o número:");
    String sCount = br.readLine();
    //
    if (sCount == null || sCount.trim().equals("")) {
      System.out.println("Favor informar ao menos um número antes de prosseguir com a operação.");
      return;
    }
    int result = 0;
    int count = Integer.parseInt(sCount)-1;
    while (count > 1) {
      if (count % 3 == 0 || count % 5 == 0)
        result += count;
      count--;
    }
    System.out.println("A soma dos múltiplos de 3 ou 5 é: " + result);
  }
  
}
