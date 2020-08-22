package com.bolsadeideas.springboot.app.springbootform.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.app.springbootform.domain.Pais;
import com.bolsadeideas.springboot.app.springbootform.domain.Role;
import com.bolsadeideas.springboot.app.springbootform.domain.Usuario;
import com.bolsadeideas.springboot.app.springbootform.editors.NombreMayusculaEditor;
import com.bolsadeideas.springboot.app.springbootform.editors.PaisPropertyEditor;
import com.bolsadeideas.springboot.app.springbootform.editors.RolesEditor;
import com.bolsadeideas.springboot.app.springbootform.services.PaisService;
import com.bolsadeideas.springboot.app.springbootform.services.RoleService;
import com.bolsadeideas.springboot.app.springbootform.validation.UsuarioValidador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RolesEditor roleEditor;

    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.addValidators(validador);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fechadenacimiento", new CustomDateEditor(dateFormat, true));

        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Role.class, "roles", roleEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Hombre","Mujer");
    }
    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return this.roleService.listar();
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap() {
        Map<String, String> roles = new HashMap<String, String>();
        roles.put("ROLES_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderador");
        return roles;
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Peru", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        Map<String, String> paises = new HashMap<String, String>();
        paises.put("ES", "España");
        paises.put("MX", "Mexico");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Peru");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");
        return paises;
    }

    @GetMapping("/form")
    public String form(final Model model) {
        final Usuario usuario = new Usuario();
        usuario.setNombre("nombre1");
        usuario.setApellido("apellido1");
        usuario.setIdentificador("12.456.789-K");
        usuario.setUsername("username");
        usuario.setEmail("mesa@mesa.cl");
        usuario.setPassword("mesa@mesa.cl");
        usuario.setHabilitar(true);
        usuario.setCuenta(6);
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid final Usuario usuario, final BindingResult result, final Model model,
            final SessionStatus status) {
        // validador.validate(usuario, result);
        model.addAttribute("titulo", "Resultado Form");

        if (result.hasErrors()) {
            // Map<String,String> errores = new HashMap<>();
            // result.getFieldErrors().forEach(err -> {
            // errores.put(err.getField(),"El campo ".concat(err.getField()).concat("
            // ").concat(err.getDefaultMessage()));
            // });
            // model.addAttribute("error", errores);
            return "form";
        }
        status.setComplete();
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}