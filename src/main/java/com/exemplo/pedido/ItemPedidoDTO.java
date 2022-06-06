package com.exemplo.pedido;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("itemPedido")
public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codProduto;
	private BigDecimal qtde;
	private BigDecimal vlUnitario;

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public BigDecimal getQtde() {
		return qtde;
	}

	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(BigDecimal vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	@Override
	public String toString() {
		return "ItemPedidoDTO [codProduto=" + codProduto + ", qtde=" + qtde + ", vlUnitario=" + vlUnitario + "]";
	}

}
