
package com.ipuc.base.persona;

import com.ipuc.base.historialTarjeta.HistorialTarjeta;
import com.ipuc.base.congregacion.Congregacion;
import com.ipuc.base.trayectoria.Trayectoria;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate4.type.EncryptedStringType;

/**
 *
 * @author wilson-rivera
 */
@TypeDef(
    name = "encryptedPassword",
    typeClass = EncryptedStringType.class,
    parameters = {
        @Parameter(name = "encryptorRegisteredName",
        value = "jasyptEncryptor")
    })
@Entity
@PrimaryKeyJoinColumn(name="numeroIdentificacion")
public class Pastor extends Persona {

    private Date fechaNombramiento;

    private String rol;

    private String password;

    private String estado;

    private Congregacion congregacion;

    private List<Trayectoria> trayectoriaCongregacion;

    private List<HistorialTarjeta> tarjetas;

    @NotNull
    @Column(name = "fecha_nombramiento")
    @Temporal(TemporalType.DATE)
    public Date getFechaNombramiento() {
        return fechaNombramiento;
    }

    public void setFechaNombramiento(Date fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

    @NotNull
    @Column(name = "rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @NotNull
    @Column(name = "password")
    @Type(type = "encryptedPassword")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @OneToOne(mappedBy = "pastor")
    public Congregacion getCongregacion() {
        return congregacion;
    }

    public void setCongregacion(Congregacion congregacion) {
        this.congregacion = congregacion;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pastor")
    public List<Trayectoria> getTrayectoriaCongregacion() {
        return trayectoriaCongregacion;
    }

    public void setTrayectoriaCongregacion(List<Trayectoria> trayectoriaCongregacion) {
        this.trayectoriaCongregacion = trayectoriaCongregacion;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdentificacionPastor")
    public List<HistorialTarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<HistorialTarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
    
}
