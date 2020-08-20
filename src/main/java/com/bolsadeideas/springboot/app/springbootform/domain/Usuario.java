package com.bolsadeideas.springboot.app.springbootform.domain;

import java.util.Date;

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

    @NotEmpty
    private String pais;

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

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
