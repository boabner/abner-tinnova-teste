/**
 * @author Abner Gonçalves
 */
package util;

import java.math.BigDecimal;

public class UtilBigDecimal {
 
  public static BigDecimal calcularPorcentagem(BigDecimal valorUm, BigDecimal valorDois) {
    BigDecimal calc = new BigDecimal("100").divide(valorDois).setScale(2, BigDecimal.ROUND_HALF_UP);
    return valorUm.multiply(calc).setScale(2, BigDecimal.ROUND_HALF_UP);
  }
  
}
