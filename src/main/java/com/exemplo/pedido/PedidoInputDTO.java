package com.exemplo.pedido;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pedidoInput")
public class PedidoInputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codCliente;
	private List<ItemPedidoDTO> itens;

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public List<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}

}
