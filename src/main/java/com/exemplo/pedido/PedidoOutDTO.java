package com.exemplo.pedido;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pedido")
public class PedidoOutDTO {

	private Integer nrPedido;
	private Date dtPedido;
	private Integer codCliente;

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

	@Override
	public String toString() {
		return "PedidoOutDTO [nrPedido=" + nrPedido + ", dtPedido=" + dtPedido + ", codCliente=" + codCliente + "]";
	}
	
}
