package com.carlosmillan.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carlosmillan.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		// model.addAttribute("titulo", "Hola Spring Framework");
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();

		usuario.setNombre("Carlos");
		usuario.setApellido("Millán");
		usuario.setEmail("carlos@prueba.com");
		model.addAttribute("usuario", usuario);
		// model.addAttribute("titulo", "Perfil de usuario:
		// ".concat(usuario.getNombre()));
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Carlos", "Millan", "carlos.millan@prueba.com"));
		usuarios.add(new Usuario("Ana", "Sarakova", "ana.sarakova@prueba.com"));
		usuarios.add(new Usuario("Pedro", "Medina", "pedro.medina@prueba.com"));
		usuarios.add(new Usuario("Camila", "polanco", "camila.polanco@prueba.com"));

		/*
		 * List<Usuario> usuarios = Arrays.asList(
		 * new Usuario("Carlos", "Millan", "carlos.millan@prueba.com"),
		 * new Usuario("Ana", "Sarakova", "ana.sarakova@prueba.com"),
		 * new Usuario("Pedro", "Medina", "pedro.medina@prueba.com"),
		 * new Usuario("Roxana", "polanco", "roxana.polanco@prueba.com"));
		 */

		// model.addAttribute("usuarios", usuarios);
		// model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Carlos", "Millan", "carlos.millan@prueba.com"));
		usuarios.add(new Usuario("Ana", "Sarakova", "ana.sarakova@prueba.com"));
		usuarios.add(new Usuario("Pedro", "Medina", "pedro.medina@prueba.com"));
		usuarios.add(new Usuario("Camila", "polanco", "camila.polanco@prueba.com"));

		return usuarios;
	}

}
