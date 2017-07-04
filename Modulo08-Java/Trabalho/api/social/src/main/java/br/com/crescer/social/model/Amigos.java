package br.com.crescer.social.model;

 // @author Jabel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
 
@Entity
@Table(name = "AMIGOS")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Amigos.findAll", query = "SELECT a FROM Amigos a")
  , @NamedQuery(name = "Amigos.findById", query = "SELECT a FROM Amigos a WHERE a.id = :id")
  , @NamedQuery(name = "Amigos.findByAceito", query = "SELECT a FROM Amigos a WHERE a.aceito = :aceito")})
public class Amigos implements Serializable {

  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(strategy = SEQUENCE, generator = "AMIGOS_SEQ")
  @SequenceGenerator(name = "AMIGOS_SEQ", sequenceName = "AMIGOS_SEQ", allocationSize = 1)
  @Column(name = "ID")
  private BigDecimal id;
  @Column(name = "ACEITO")
  private Character aceito;
  @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
  @ManyToOne
  private Usuario idUsuario;
  @JoinColumn(name = "ID_AMIGO", referencedColumnName = "ID")
  @ManyToOne
  private Usuario idAmigo;

  public Amigos() {
  }

  public Amigos(BigDecimal id) {
    this.id = id;
  }

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Character getAceito() {
    return aceito;
  }

  public void setAceito(Character aceito) {
    this.aceito = aceito;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Usuario getIdAmigo() {
    return idAmigo;
  }

  public void setIdAmigo(Usuario idAmigo) {
    this.idAmigo = idAmigo;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Amigos)) {
      return false;
    }
    Amigos other = (Amigos) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.crescer.social.model.Amigos[ id=" + id + " ]";
  }

}