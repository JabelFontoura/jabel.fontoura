package br.com.crescer.aula07.model;

 // @author Jabel
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table(name = "VIDEO")
public class Video {
  
  @Id
  @Basic(optional = false)
  @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")
  @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
  private Long id;
  
  @Column(name = "NOME")
  private String nome;
  
  @Column(name = "VALOR")
  @Basic(optional = false)
  private double valor;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ID_GENERO")
  private Genero genero;
  
  @Column(name = "QUANTIDADE_ESTOQUE")
  private int quantidadeEstoque;
  
  @Column(name = "DATA_LANCAMENTO")
  private Date dataLancamento;
  
  @Column(name = "DURACAO")
  private String duracao;

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

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public int getQuantidadeEstoque() {
    return quantidadeEstoque;
  }

  public void setQuantidadeEstoque(int quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }

  public Date getDataLancamento() {
    return dataLancamento;
  }

  public void setDataLancamento(Date dataLancamento) {
    this.dataLancamento = dataLancamento;
  }

  public String getDuracao() {
    return duracao;
  }

  public void setDuracao(String duracao) {
    this.duracao = duracao;
  }
}