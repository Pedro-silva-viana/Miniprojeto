package simulador_de_campeonato_de_futebol;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		boolean jogo=true;
		int marcador;
		Scanner leitor = new Scanner(System.in);
		Campeonatos copa = new Campeonatos();
		clube clube_1 = new clube("Humaitá");
		clube clube_2 = new clube("Tuntum");
		clube clube_3 = new clube("Azuriz");
		clube clube_4 = new clube("Nova Venécia");
		clube clube_5 = new clube("Pouso Alegre");
		copa.add_clube(clube_1);
		copa.add_clube(clube_2);
		copa.add_clube(clube_3);
		copa.add_clube(clube_4);
		copa.add_clube(clube_5);
		while(jogo == true) {
			copa.limpar_dados();
			boolean partida = true;
			copa.jogar_campionato();
			while(partida == true) {
				System.out.println("1:Placar total");
				System.out.println("2:Vencedor");
				System.out.println("3:Recomesar copa");
				System.out.println("4:Sair");
				marcador=leitor.nextInt();
				switch (marcador) {
				case 1 : {
					copa.getClassificacao();
					break;
				}
				case 2 :{
					copa.getCampiao();
					break;
				}
				case 3 :{
					partida = false;
					break;
				}
				case 4 :{
					partida = false;
					jogo = false;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + marcador);
				}
			}
		}
	}

}
