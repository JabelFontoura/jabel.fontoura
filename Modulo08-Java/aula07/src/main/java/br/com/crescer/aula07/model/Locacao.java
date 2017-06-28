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
@Table(name = "LOCACAO")
public class Locacao {

  @Id
  @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")
  @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
  @Basic(optional = false)
  private Long id;
  
  @Column(name = "VALOR_TOTAL")
  private double valorTotal;
  
  @Column(name = "DATA_DEVOLUCAO")
  private Date dataDevolucao;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ID_FUNCIONARIO")
  private Funcionario funcionario;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ID_CLIENTE")
  private Cliente cliente;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ID_VIDEO")
  private Video video;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(Date dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }
}