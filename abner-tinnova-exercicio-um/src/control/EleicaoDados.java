/**
 * @author Abner Gonçalves
 */
package control;

import entidades.Eleitor;
import entidades.Resultado;
import entidades.Voto;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import util.UtilBigDecimal;

public class EleicaoDados {

  private static final Integer QUANT_ELEITORES = 1000;
  private static final Integer QUANT_ELEITORES_VALIDOS = 800;
  private static final Integer VOTOS_BRANCOS = 150;
  private static final Integer VOTOS_NULOS = 50;
  
  public EleicaoDados() {
    //
  }
  
  public static void main(final String[] args) {
    EleicaoDados eleicao = new EleicaoDados();
    eleicao.iniciar();
  }
  
  private void iniciar() {
    Set<Voto> votos = alimentarDados();
    String resultado = contabilizar(votos);
    System.out.println(resultado);
  }
   
  
  private static Set<Voto> alimentarDados() {
    int count = 0;
    Set<Voto> votos = new HashSet<>();
    while (count < 1000) {
      //----------------------------------------------------------------------------------------------------------------
      Eleitor eleitor = new Eleitor(count < QUANT_ELEITORES_VALIDOS);
      //----------------------------------------------------------------------------------------------------------------
      int tipoVoto = count < 50 ? Voto.TIPO_VOTO_NULO : count < 150 ? Voto.TIPO_VOTO_BRANCO : Voto.TIPO_VOTO_VALIDO;
      //----------------------------------------------------------------------------------------------------------------
      Voto voto = new Voto(eleitor, tipoVoto);
      //----------------------------------------------------------------------------------------------------------------
      votos.add(voto);
      count ++;
    }
    return votos;
  }
  
  private String contabilizar(Set<Voto> votos) {
    Resultado resultado = getResultado(votos);
    //------------------------------------------------------------------------------------------------------------------
    BigDecimal porcVotosValidos = calcularVotosValidos(resultado.getQuantEleitoresValidos(), QUANT_ELEITORES),
        porcVotosBranco = calcularVotosNulos(resultado.getQuantVotosNulos(), QUANT_ELEITORES),
        porcVotosNulo = calcularVotosBrancos(resultado.getQuantVotosBrancos(), QUANT_ELEITORES);
    //------------------------------------------------------------------------------------------------------------------
    StringBuilder msg = new StringBuilder();
    msg.append("Resultado da eleição:\n")
       .append("\nQuantidade de eleitores: ").append(QUANT_ELEITORES)
       .append("\n.. Porcentagem de eleitores válidos: %").append(porcVotosValidos)
       .append("\n.. Porcentagem de votos em branco: %").append(porcVotosBranco)
       .append("\n.. Porcentagem de votos nulos: %").append(porcVotosNulo)
       .append("\n\n Fim.");
    //------------------------------------------------------------------------------------------------------------------
    return msg.toString();
  }

  private Resultado getResultado(Set<Voto> votos) {
    Resultado resultado = new Resultado(0, 0, 0);
    for (Voto voto : votos) {
      //------------------------------------------------------------------------------------------------------------------
      resultado.setQuantVotosBrancos(
          resultado.getQuantVotosBrancos() + (voto.getTipoVoto().equals(Voto.TIPO_VOTO_BRANCO) ? 1 : 0)
      );
      //------------------------------------------------------------------------------------------------------------------
      resultado.setQuantVotosNulos(
          resultado.getQuantVotosNulos() + (voto.getTipoVoto().equals(Voto.TIPO_VOTO_NULO) ? 1 : 0)
      );
      //------------------------------------------------------------------------------------------------------------------
      Eleitor eleitor = voto.getEleitor();
      resultado.setQuantEleitoresValidos(
          resultado.getQuantEleitoresValidos() + (eleitor.isValido() ? 1 : 0)
      );
    }
    return resultado;
  }
  
  private static BigDecimal calcularVotosValidos(Integer valorUm, Integer valorDois) {
    return UtilBigDecimal.calcularPorcentagem(
        new BigDecimal(valorUm.toString()),
        new BigDecimal(valorDois.toString())
    );
  }

  private static BigDecimal calcularVotosBrancos(Integer valorUm, Integer valorDois) {
    return UtilBigDecimal.calcularPorcentagem(
        new BigDecimal(VOTOS_BRANCOS.toString()),
        new BigDecimal(QUANT_ELEITORES.toString())
    );
  }
  
  private static BigDecimal calcularVotosNulos(Integer valorUm, Integer valorDois) {
    return UtilBigDecimal.calcularPorcentagem(
        new BigDecimal(VOTOS_NULOS.toString()),
        new BigDecimal(QUANT_ELEITORES.toString())
    );
  }

}