package br.com.crescer.social.model;

 // @author Jabel

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


 
@Entity
@Table(name = "POST")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
  , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
  , @NamedQuery(name = "Post.findByTexto", query = "SELECT p FROM Post p WHERE p.texto = :texto")
  , @NamedQuery(name = "Post.findByFoto", query = "SELECT p FROM Post p WHERE p.foto = :foto")})
public class Post implements Serializable {

  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private BigDecimal id;
  @Size(max = 400)
  @Column(name = "TEXTO")
  private String texto;
  @Size(max = 200)
  @Column(name = "FOTO")
  private String foto;
  @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
  @ManyToOne
  private Usuario idUsuario;
  @OneToMany(mappedBy = "idPost")
  private Collection<Comentario> comentarioCollection;
  @OneToMany(mappedBy = "idPost")
  private Collection<Curtida> curtidaCollection;

  public Post() {
  }

  public Post(BigDecimal id) {
    this.id = id;
  }

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
  }

  @XmlTransient
  public Collection<Comentario> getComentarioCollection() {
    return comentarioCollection;
  }

  public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
    this.comentarioCollection = comentarioCollection;
  }

  @XmlTransient
  public Collection<Curtida> getCurtidaCollection() {
    return curtidaCollection;
  }

  public void setCurtidaCollection(Collection<Curtida> curtidaCollection) {
    this.curtidaCollection = curtidaCollection;
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
    if (!(object instanceof Post)) {
      return false;
    }
    Post other = (Post) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.crescer.social.model.Post[ id=" + id + " ]";
  }

}