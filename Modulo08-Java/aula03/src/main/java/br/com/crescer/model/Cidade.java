package br.com.crescer.model;

 // @author jabel.fontoura
 
public class Cidade {
  
  private Long id;
  private String nome;
  private Long idEstado;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Long getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(Long idEstado) {
    this.idEstado = idEstado;
  }
  
  
}
