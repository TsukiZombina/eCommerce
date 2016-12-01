
package mx.uam.azc.modelo.beans;

import java.io.Serializable;

/**
 *
 * @author ammy_
 * @version 
 */
public class Usuario implements Serializable{
    private Long idUsiario = null;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String nomUsuario;
    private String password;
    private String contactoTel;
    private String contactoCorreo;
    private double saldo;

    public Usuario() {
    }

    public Long getIdUsiario() {
        return idUsiario;
    }

    public void setIdUsiario(Long idUsiario) {
        this.idUsiario = idUsiario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactoTel() {
        return contactoTel;
    }

    public void setContactoTel(String contactoTel) {
        this.contactoTel = contactoTel;
    }

    public String getContactoCorreo() {
        return contactoCorreo;
    }

    public void setContactoCorreo(String contactoCorreo) {
        this.contactoCorreo = contactoCorreo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}