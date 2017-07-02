package br.com.crescer.social.model;

 // @author Jabel

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
 
@Entity
@Table(name = "COMENTARIO")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
  , @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.id = :id")
  , @NamedQuery(name = "Comentario.findByTexto", query = "SELECT c FROM Comentario c WHERE c.texto = :texto")
  , @NamedQuery(name = "Comentario.findByFoto", query = "SELECT c FROM Comentario c WHERE c.foto = :foto")})
public class Comentario implements Serializable {

  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(strategy = SEQUENCE, generator = "COMENTARIO_SEQ")
  @SequenceGenerator(name = "COMENTARIO_SEQ", sequenceName = "COMENTARIO_SEQ")
  @Column(name = "ID")
  private BigDecimal id;
  @Size(max = 400)
  @Column(name = "TEXTO")
  private String texto;
  @Size(max = 200)
  @Column(name = "FOTO")
  private String foto;
  @JoinColumn(name = "ID_POST", referencedColumnName = "ID")
  @ManyToOne
  private Post idPost;
  @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
  @ManyToOne
  private Usuario idUsuario;

  public Comentario() {
  }

  public Comentario(BigDecimal id) {
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
    if (!(object instanceof Comentario)) {
      return false;
    }
    Comentario other = (Comentario) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.crescer.social.model.Comentario[ id=" + id + " ]";
  }

}