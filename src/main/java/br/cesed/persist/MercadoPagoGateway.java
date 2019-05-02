package br.cesed.persist;

import br.cesed.reso.DadosCartao;
import br.cesed.reso.GatewayPagamento;
import br.cesed.reso.StatusTransacao;
import br.cesed.reso.ValidaCPF;

public class MercadoPagoGateway implements GatewayPagamento {


	public StatusTransacao realizarPagamento(DadosCartao dados, double valor) {
		if (ValidaCPF.isCPF(dados.getCpf()) && dados.getSaldo() >= valor) {
			System.out.println("APROVADO");
			return StatusTransacao.APROVADO;
		} else if (ValidaCPF.isCPF(dados.getCpf()) && dados.getSaldo() < valor) {
			System.out.println("SALDO INSUFICIENTE");
			return StatusTransacao.SALDO_INSUFICIENTE;

		}
		System.out.println("RECUSADO");
		return StatusTransacao.RECUSADO;
	}

}
