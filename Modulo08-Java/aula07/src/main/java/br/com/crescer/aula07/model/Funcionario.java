package br.com.crescer.aula07.model;

 // @author Jabel
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
  
  @Id
  @Basic(optional = false)
  @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO")
  @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FUNCIONARIO")
  private Long id;
  
  @Column(name = "NOME")
  @Basic(optional = false)
  private String nome;
  
  @Column(name = "BAIRRO")
  private String bairro;
  
  @Column(name = "CIDADE")
  private String cidade;
  
  @Column(name = "NUMERO_CASA")
  private String numeroCasa;
  
  @Column(name = "RUA")
  private String rua;
  
  @Column(name = "RG")
  @Basic(optional = false)
  private String rg;
  
  @Column(name = "EMAIL")
  private String email;
  
  @Column(name = "TELEFONE")
  private String telefone;
  
  @Column(name = "CELULAR")
  private String celular;
  
  @Column(name = "SALARIO")
  private double salario;
  
  @Column(name = "FUNCAO")
  private String funcao;
  
  @Column(name = "CPF")
  private String cpf;
  
  @Column(name = "NASCIMENTO")
  private Date nascimento;

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

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getNumeroCasa() {
    return numeroCasa;
  }

  public void setNumeroCasa(String numeroCasa) {
    this.numeroCasa = numeroCasa;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }
}