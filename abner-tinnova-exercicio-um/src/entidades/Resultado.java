/**
 * @author abner
 */
package entidades;

public class Resultado {
  
  private Integer quantVotosBrancos;
  private Integer quantVotosNulos;
  private Integer quantEleitoresValidos;

  public Resultado(Integer quantVotosBrancos, Integer quantVotosNulos, Integer quantEleitoresValidos) {
    this.quantVotosBrancos = quantVotosBrancos;
    this.quantVotosNulos = quantVotosNulos;
    this.quantEleitoresValidos = quantEleitoresValidos;
  }
  
  public Integer getQuantVotosBrancos() {
    return quantVotosBrancos;
  }

  public void setQuantVotosBrancos(Integer quantVotosBrancos) {
    this.quantVotosBrancos = quantVotosBrancos;
  }

  public Integer getQuantVotosNulos() {
    return quantVotosNulos;
  }

  public void setQuantVotosNulos(Integer quantVotosNulos) {
    this.quantVotosNulos = quantVotosNulos;
  }

  public Integer getQuantEleitoresValidos() {
    return quantEleitoresValidos;
  }

  public void setQuantEleitoresValidos(Integer quantEleitoresValidos) {
    this.quantEleitoresValidos = quantEleitoresValidos;
  }
  
}