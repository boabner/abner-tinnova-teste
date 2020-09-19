/**
 * @author Abner Gonçalves
 */
package entidades;

public class Eleitor {
  
  private boolean valido;

  public Eleitor(boolean valido) {
    this.valido = valido;
  }
  
  public boolean isValido() {
    return valido;
  }

  public void setValido(boolean valido) {
    this.valido = valido;
  }
  
}