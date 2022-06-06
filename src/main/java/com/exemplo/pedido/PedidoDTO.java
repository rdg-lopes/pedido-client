package com.exemplo.pedido;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pedido")
public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer nrPedido;
	private Date dtPedido;
	private Integer codCliente;
	private List<ItemPedidoDTO> itens;

	public Integer getNrPedido() {
		return nrPedido;
	}

	public void setNrPedido(Integer nrPedido) {
		this.nrPedido = nrPedido;
	}

	public Date getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

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

	@Override
	public String toString() {
		return "PedidoDTO [nrPedido=" + nrPedido + ", dtPedido=" + dtPedido + ", codCliente=" + codCliente + ", itens="
				+ itens + "]";
	}
	
}
