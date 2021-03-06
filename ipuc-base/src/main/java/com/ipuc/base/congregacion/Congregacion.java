
package com.ipuc.base.congregacion;

import com.ipuc.base.persona.Creyente;
import com.ipuc.base.membresia.Membresia;
import com.ipuc.base.municipio.Municipio;
import com.ipuc.base.persona.Pastor;
import com.ipuc.base.trayectoria.Trayectoria;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.Length;

/**
 *
 * @author wilson-rivera
 */
@Entity
@Table(name = "congregacion")
public class Congregacion implements Serializable {

    private String codCongregacion;

    private String nombre;

    private String direccion;

    private String telefono;

    private String distrito;

    private Municipio municipio;

    private Date fechaApertura;

    private Pastor pastor;

    private List<Trayectoria> trayectoriaPastores;
    
    private List<Membresia> membresias;
    
    private List<Creyente> creyentes;

    public Congregacion() {
    }

    public Congregacion(String codCongregacion) {
        this.codCongregacion = codCongregacion;
    }

    public Congregacion(String codCongregacion, String nombre, String distrito, Date fechaApertura) {
        this.codCongregacion = codCongregacion;
        this.nombre = nombre;
        this.distrito = distrito;
        this.fechaApertura = fechaApertura;
    }

    @Id
    @NotNull
    @Length(max = 50)
    @Column(name = "cod_congregacion")
    public String getCodCongregacion() {
        return codCongregacion;
    }

    public void setCodCongregacion(String codCongregacion) {
        this.codCongregacion = codCongregacion;
    }

    @NotNull
    @Length(max = 50)
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Length(max = 200)
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Length(max = 50)
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @NotNull
    @Length(max = 10)
    @Column(name = "distrito")
    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @JoinColumn(name = "municipio", referencedColumnName = "idMunicipio")
    @ManyToOne(optional = false)
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @NotNull
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @JoinColumn(name = "pastor", referencedColumnName = "numero_identificacion")
    @OneToOne
    public Pastor getPastor() {
        return pastor;
    }

    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "congregacion")
    public List<Trayectoria> getTrayectoriaPastores() {
        return trayectoriaPastores;
    }

    public void setTrayectoriaPastores(List<Trayectoria> trayectoriaPastores) {
        this.trayectoriaPastores = trayectoriaPastores;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "congregacion")
    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "congregacion")
    public List<Creyente> getCreyentes() {
        return creyentes;
    }

    public void setCreyentes(List<Creyente> creyentes) {
        this.creyentes = creyentes;
    }
    
}
