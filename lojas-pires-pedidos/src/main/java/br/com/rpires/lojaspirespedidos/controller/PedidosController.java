/**
 * 
 */
package br.com.rpires.lojaspirespedidos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author digao
 *
 */
@RestController
@RequestMapping("/pedidos")
public class PedidosController {

	@GetMapping
	public String listar() {
		return "teste de listar pedidos";
	}
}
