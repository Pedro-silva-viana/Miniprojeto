package simulador_de_campeonato_de_futebol;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Campeonatos {
	Random random = new Random();
	private List<clube> clubes_escalados;
	public Campeonatos() {
        clubes_escalados = new ArrayList<>();
    }
	public void add_clube(clube c) {
		clubes_escalados.add(c);
	}
	private void jogarpartida(clube a,clube b) {
		System.out.println("Inisiando a partida do "+a.nome+" vs "+b.nome);
		System.out.println(" ");
		int limiteInferior = 0;
        int limiteSuperior = 5;
		int Gols_a = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
		int Gols_b = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
		int resultado = Gols_a-Gols_b;
		if(resultado<0) {
			resultado=resultado*-1;
			a.derota(resultado);
			b.vitoria(resultado);
			System.out.println(Gols_b+" a "+Gols_a);
			System.out.println(" ");
		}else if(resultado==0) {
			System.out.println("Empate");
			System.out.println(Gols_a+" a "+Gols_b);
			System.out.println(" ");
			a.empate();
			b.empate();
		}else {
			a.vitoria(resultado);
			b.derota(resultado);
			System.out.println(Gols_a+" a "+Gols_b);
			System.out.println(" ");
		}
	}
	void jogar_campionato() {
		for(int i=0;i<clubes_escalados.size();i++) {
			clube jogando_em_casa = clubes_escalados.get(i);
			for(int j=0;j<clubes_escalados.size();j++) {
				if(i!=j) {
					clube visitante=clubes_escalados.get(j);
					jogarpartida(jogando_em_casa, visitante);
				}
			}
		}
	}
	void getClassificacao() {
		for(int i=0;i<clubes_escalados.size();i++) {
			clube jogando_em_casa = clubes_escalados.get(i);
			for(int j=i+1;j<clubes_escalados.size();j++) {
				if(i!=j) {
					clube visitante=clubes_escalados.get(j);
					if(jogando_em_casa.pontos<visitante.pontos) {
						Collections.swap(clubes_escalados, i, j);
						jogando_em_casa = clubes_escalados.get(i);
					}else if(jogando_em_casa.pontos==visitante.pontos) {
						if(jogando_em_casa.saldo_de_gols<visitante.saldo_de_gols) {
							Collections.swap(clubes_escalados, i, j);
							jogando_em_casa = clubes_escalados.get(i);
						}
					}
				}
			}
		}
		for(int i=0;i<clubes_escalados.size();i++) {
			clube clasifica = clubes_escalados.get(i);
			int k=i+1;
			System.out.println(" "+k+":"+clasifica.nome+" pontos:"+clasifica.pontos+" Saldo de Gols:"+clasifica.saldo_de_gols);
		}
		
	}
	void getCampiao() {
		clube campeao = clubes_escalados.get(0);
		for(int i=1;i<clubes_escalados.size();i++) {
			clube competidores = clubes_escalados.get(i);
			if(competidores.pontos>campeao.pontos) {
				Collections.swap(clubes_escalados, 0, i);
				campeao = clubes_escalados.get(0);
			}else if(competidores.pontos==campeao.pontos) {
				if(competidores.saldo_de_gols>campeao.saldo_de_gols) {
					Collections.swap(clubes_escalados, 0, i);
					campeao = clubes_escalados.get(0);
				}
			}
		}
		System.out.println("Vitorioso"+":"+campeao.nome+" pontos:"+campeao.pontos+" Saldo de Gols:"+campeao.saldo_de_gols);
	}
	void limpar_dados() {
		for(int i=0;i<clubes_escalados.size();i++) {
			clube competidores = clubes_escalados.get(i);
			competidores.limpa();
		}
	}
}
