package simulador_de_campeonato_de_futebol;

public class clube {
	String nome;
	int saldo_de_gols;
	int pontos;
	clube(String c) {
		this.nome=c;
		this.saldo_de_gols=0;
		this.pontos=0;
	}
	void vitoria(int saldoGols) {
		System.out.println("VITORIA:"+nome);
		saldo_de_gols+=saldoGols;
		pontos+=3;
	}
	void empate() {
		pontos++;
	}
	void derota(int saldoGols) {
		saldo_de_gols-=saldoGols;
	}
	void limpa() {
		pontos=0;
		saldo_de_gols=0;
	}
}
