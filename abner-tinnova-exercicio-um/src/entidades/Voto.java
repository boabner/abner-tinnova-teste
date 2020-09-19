/**
 * @author Abner Gonçalves
 */
package entidades;

public class Voto {
  
  public static final int TIPO_VOTO_BRANCO = 0;
  public static final int TIPO_VOTO_NULO = 1;
  public static final int TIPO_VOTO_VALIDO = 2;
  
  private Integer tipoVoto;
  private Eleitor eleitor;
  
  public Voto(Eleitor eleitor, Integer tipoVoto) {
    this.eleitor = eleitor;
    this.tipoVoto = tipoVoto;
  }

  public Integer getTipoVoto() {
    return tipoVoto;
  }

  public void setTipoVoto(Eleitor eleitor, Integer tipoVoto) {
    this.eleitor = eleitor;
    this.tipoVoto = tipoVoto;
  }

  public Eleitor getEleitor() {
    return eleitor;
  }

  public void setEleitor(Eleitor eleitor) {
    this.eleitor = eleitor;
  }
 
}