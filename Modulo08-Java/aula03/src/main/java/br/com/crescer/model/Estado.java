package br.com.crescer.model;

 // @author jabel.fontoura
 
public class Estado {
  
  private Long id;
  private String nome;
  private String uf;
  private Long idPais;

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

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public Long getIdPais() {
    return idPais;
  }

  public void setIdPais(Long idPais) {
    this.idPais = idPais;
  }
  
  
}
