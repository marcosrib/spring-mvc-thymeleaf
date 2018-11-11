package com.estudo.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudo.boot.web.domain.Departamento;
import com.estudo.boot.web.service.DepartamentoService;

@Controller
@RequestMapping("departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	 
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", service.buscarTodos());
		return "/departamento/lista";
	}
	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento,BindingResult bindingResult ) {
		  if (bindingResult.hasErrors()) {
	            return "redirect:/departamentos/cadastrar";
	        }	
		service.salvar(departamento);
		return  "redirect:/departamentos/cadastrar";
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "/departamento/cadastro";
	}
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		service.editar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String preExcluir(@PathVariable("id") Long id, ModelMap model) {
		if(!service.departamentoTemCargos(id)) {
			service.excluir(id);
		}
		return listar(model);
	}
}
