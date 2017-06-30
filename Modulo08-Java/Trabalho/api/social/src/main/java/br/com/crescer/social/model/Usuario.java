package br.com.crescer.social.model;

 // @author Jabel

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


 
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
  , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
  , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
  , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
  , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
  , @NamedQuery(name = "Usuario.findByFoto", query = "SELECT u FROM Usuario u WHERE u.foto = :foto")
  , @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo")
  , @NamedQuery(name = "Usuario.findByDataNascimento", query = "SELECT u FROM Usuario u WHERE u.dataNascimento = :dataNascimento")})
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = true)
  //@NotNull
  @Column(name = "ID")
  private BigDecimal id;
  @Size(max = 50)
  @Column(name = "NOME")
  private String nome;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 50)
  @Column(name = "EMAIL")
  private String email;
  @Size(max = 200)
  @Column(name = "SENHA")
  private String senha;
  @Size(max = 200)
  @Column(name = "FOTO")
  private String foto;
  @Column(name = "SEXO")
  private Character sexo;
  @Column(name = "DATA_NASCIMENTO")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataNascimento;
  @OneToMany(mappedBy = "idUsuario")
  private Collection<Amigos> amigosCollection;
  @OneToMany(mappedBy = "idAmigo")
  private Collection<Amigos> amigosCollection1;
  @OneToMany(mappedBy = "idUsuario")
  private Collection<Post> postCollection;
  @OneToMany(mappedBy = "idUsuario")
  private Collection<Comentario> comentarioCollection;
  @OneToMany(mappedBy = "idUsuario")
  private Collection<Curtida> curtidaCollection;

  public Usuario() {
  }

  public Usuario(BigDecimal id) {
    this.id = id;
  }

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Character getSexo() {
    return sexo;
  }

  public void setSexo(Character sexo) {
    this.sexo = sexo;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  @XmlTransient
  public Collection<Amigos> getAmigosCollection() {
    return amigosCollection;
  }

  public void setAmigosCollection(Collection<Amigos> amigosCollection) {
    this.amigosCollection = amigosCollection;
  }

  @XmlTransient
  public Collection<Amigos> getAmigosCollection1() {
    return amigosCollection1;
  }

  public void setAmigosCollection1(Collection<Amigos> amigosCollection1) {
    this.amigosCollection1 = amigosCollection1;
  }

  @XmlTransient
  public Collection<Post> getPostCollection() {
    return postCollection;
  }

  public void setPostCollection(Collection<Post> postCollection) {
    this.postCollection = postCollection;
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
    if (!(object instanceof Usuario)) {
      return false;
    }
    Usuario other = (Usuario) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.crescer.social.model.Usuario[ id=" + id + " ]";
  }

}