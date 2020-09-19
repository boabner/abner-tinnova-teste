/**
 * @author abner
 */
package control;

import java.util.Arrays;

public class Ordenacao {

  public static void main(String[] args) {
    Ordenacao ordenacao = new Ordenacao();
    ordenacao.ordenar();
  }
  
  private void ordenar() {
    Integer[] valores = new Integer[]{5, 3, 2, 4, 7, 1, 0, 6};
    System.out.println("Lista não ordenada: " + Arrays.toString(valores));
    //------------------------------------------------------------------------------------------------------------------
    int length = valores.length, aux;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length-1; j++) {
        if (valores[j] > valores[j + 1]) {
          aux = valores[j];
          valores[j] = valores[j + 1];
          valores[j + 1] = aux;
        }
      }
    }
	System.out.println("Lista ordenada: " + Arrays.toString(valores));
    //------------------------------------------------------------------------------------------------------------------
  }
  
}
