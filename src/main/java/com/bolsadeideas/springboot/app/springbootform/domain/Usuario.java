package com.bolsadeideas.springboot.app.springbootform.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bolsadeideas.springboot.app.springbootform.validation.Requerido;
import com.bolsadeideas.springboot.app.springbootform.validation.identificadorRegex;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
    // @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    @identificadorRegex
    private String identificador;

    // @NotEmpty(message = "el nombre no puede ser vacio")
    private String nombre;

    // @NotEmpty
    @Requerido
    private String apellido;

    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    // @NotEmpty
    @Requerido
    @Email(message = "correo con formato incorrecto")
    private String email;

    @NotNull // para objetos: Integer es objeto, int es primitivo
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    private Pais pais;

    @NotEmpty
    private List<Role> roles;

    private Boolean habilitar;

    @NotEmpty
    private String genero;

    private String valorSecreto;

    @NotNull // para objetos: Date es objeto
    // @Past(message = "debe ser fecha actual o anterior") //solo fechas pasadas o
    // actual
    @Future(message = "debe ser fecha posterior") // solo fechas a futuro
    // @FutureOrPresent //solo fechas a futuro o actual
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechadenacimiento;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechadenacimiento() {
        return this.fechadenacimiento;
    }

    public void setFechadenacimiento(Date fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public Boolean isHabilitar() {
        return this.habilitar;
    }

    public Boolean getHabilitar() {
        return this.habilitar;
    }

    public void setHabilitar(Boolean habilitar) {
        this.habilitar = habilitar;
    }


    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getValorSecreto() {
        return this.valorSecreto;
    }

    public void setValorSecreto(String valorSecreto) {
        this.valorSecreto = valorSecreto;
    }

}
