package com.rodolfoxp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historia_usuario")
public class HistoriaUsuario {
  /**
   * 
   */
  private static final long serialVersionUID = 5136811965237617923L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 50)
  private String titulo;

  @Column(nullable = false, length = 1000)
  private String descripcion;

  @Column(length = 100)
  private String rol;

  @Column(length = 1000)
  private String para;

  public HistoriaUsuario() {

  }

  public HistoriaUsuario(String titulo, String descripcion, String rol,
          String para) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.rol = rol;
    this.para = para;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  public String getPara() {
    return para;
  }

  public void setPara(String para) {
    this.para = para;
  }

  @Override
  public String toString() {
    return "HistoriaUsuario [id=" + id + ", titulo=" + titulo
            + ", descripcion=" + descripcion + ", rol=" + rol + ", para="
            + para + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
            + ((descripcion == null) ? 0 : descripcion.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((para == null) ? 0 : para.hashCode());
    result = prime * result + ((rol == null) ? 0 : rol.hashCode());
    result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HistoriaUsuario other = (HistoriaUsuario) obj;
    if (descripcion == null) {
      if (other.descripcion != null)
        return false;
    } else if (!descripcion.equals(other.descripcion))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (para == null) {
      if (other.para != null)
        return false;
    } else if (!para.equals(other.para))
      return false;
    if (rol == null) {
      if (other.rol != null)
        return false;
    } else if (!rol.equals(other.rol))
      return false;
    if (titulo == null) {
      if (other.titulo != null)
        return false;
    } else if (!titulo.equals(other.titulo))
      return false;
    return true;
  }

}
