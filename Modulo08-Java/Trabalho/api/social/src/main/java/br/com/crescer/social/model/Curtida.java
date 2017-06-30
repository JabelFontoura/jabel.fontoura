package br.com.crescer.social.model;

 // @author Jabel

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


 
@Entity
@Table(name = "CURTIDA")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Curtida.findAll", query = "SELECT c FROM Curtida c")
  , @NamedQuery(name = "Curtida.findById", query = "SELECT c FROM Curtida c WHERE c.id = :id")})
public class Curtida implements Serializable {

  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private BigDecimal id;
  @JoinColumn(name = "ID_POST", referencedColumnName = "ID")
  @ManyToOne
  private Post idPost;
  @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
  @ManyToOne
  private Usuario idUsuario;

  public Curtida() {
  }

  public Curtida(BigDecimal id) {
    this.id = id;
  }

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Post getIdPost() {
    return idPost;
  }

  public void setIdPost(Post idPost) {
    this.idPost = idPost;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
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
    if (!(object instanceof Curtida)) {
      return false;
    }
    Curtida other = (Curtida) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.crescer.social.model.Curtida[ id=" + id + " ]";
  }

}