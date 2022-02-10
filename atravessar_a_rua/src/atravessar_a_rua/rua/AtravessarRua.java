package atravessar_a_rua.rua;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AtravessarRua {
	
	private DireitaOuEsquerda direitaOuEsquerda = DireitaOuEsquerda.AGUARDANDO;
	private static final List<String> POSSIVEISENTRADAUSUARIOCONTINUA = new ArrayList<>();
	private static final List<String> POSSIVEISENTRADAUSUARIONAO = new ArrayList<>();
	
	
	static {
		POSSIVEISENTRADAUSUARIOCONTINUA.add("sim");
		POSSIVEISENTRADAUSUARIOCONTINUA.add("s");
		POSSIVEISENTRADAUSUARIONAO.add("n�o");
		POSSIVEISENTRADAUSUARIONAO.add("nao");
		POSSIVEISENTRADAUSUARIONAO.add("n");
		
	}
	
	public void prosseguirOuEsperar() {
		
	}
	
	public DireitaOuEsquerda getDireitaOuEsquerda() {
		return this.direitaOuEsquerda;
	}
	
	public void setDireitaOuEsquerda(DireitaOuEsquerda direitaOuEsquerda) {
		this.direitaOuEsquerda = direitaOuEsquerda;
	}
	
	public static void main(String[] args) {
		AtravessarRua atravessarRua = new AtravessarRua();
		Boolean olharDireita = Boolean.FALSE;
		Boolean olharEsquerda = Boolean.FALSE;
		String iniciar = "";
		String passo = "";
		String olharDouE = "";
		Boolean continua = Boolean.FALSE;
		Scanner in = new Scanner(System.in);
		Random aleatorio = new Random();
		Integer carro = 0;
		Boolean continuaPasso = Boolean.FALSE;
		
		do {
			
			Boolean jaFoiDireita = Boolean.FALSE;
			Boolean jaFoiEsquerda = Boolean.FALSE;
		
			System.out.print("Deseja atravessar a rua?: ");
			iniciar = in.next();
			iniciar = iniciar.toLowerCase();
			if(POSSIVEISENTRADAUSUARIOCONTINUA.contains(iniciar)) {
				continua = Boolean.TRUE;
			} else if(POSSIVEISENTRADAUSUARIONAO.contains(iniciar)) {
				System.out.println("FIM DA EXECU��O");
				continua = Boolean.FALSE;
				break;
			}
			
			System.out.println("Andando para frente....");
			System.out.print("Olhar para direita ou para esquerda primeiro? digite D(Direita) ou E(Esquerda): ");
			olharDouE = in.next();
			
			if (olharDouE.equalsIgnoreCase("D")) {
				atravessarRua.setDireitaOuEsquerda(DireitaOuEsquerda.DIREITA);
				olharDireita = Boolean.TRUE;
				
			} else if (olharDouE.equalsIgnoreCase("E")){
				atravessarRua.setDireitaOuEsquerda(DireitaOuEsquerda.ESQUERDA);
				olharEsquerda = Boolean.TRUE;
			} else {
				atravessarRua.setDireitaOuEsquerda(DireitaOuEsquerda.AGUARDANDO);
			}
			
			do {
				
				if (jaFoiDireita && jaFoiEsquerda) {
					System.out.println("VOC� CONSEGUIU ATRAVESSAR A RUA COM SUCESSO !!!!");
					continuaPasso = Boolean.FALSE;
					break;
				}
				
				carro = aleatorio.nextInt(2);
				switch (atravessarRua.getDireitaOuEsquerda()){
					case DIREITA: 
						if(olharDireita) {
							if(carro > 0) {
								System.out.println("Esta vindo carro!");
								
								System.out.print("Deseja dar mais um passo? Digite A(aguardar) ou P(para dar um passo)");
								passo = in.next();
								
								if(passo.equalsIgnoreCase("P")) {
									System.out.println("Andando para frente....");
									System.out.println("Voc� andou no momento que o carro estava vindo");
								} else {
									System.out.println("Aguardando....");
									continuaPasso = Boolean.TRUE;
								}
								
								
							} else {
								System.out.println("N�o esta vindo carro ");
								System.out.print("Deseja dar mais um passo? Digite A(aguardar) ou P(para dar um passo)");
								passo = in.next();
								
								if(passo.equalsIgnoreCase("P")) {
									if(jaFoiEsquerda) {
										System.out.println("Andando para frente....");
										jaFoiDireita = Boolean.TRUE;
									} else {
										System.out.println("Andando para frente....");
										System.out.println("Olhando para a Esquerda...");
										atravessarRua.setDireitaOuEsquerda(DireitaOuEsquerda.ESQUERDA);
										olharDireita = Boolean.FALSE;
										olharEsquerda = Boolean.TRUE;
										continuaPasso = Boolean.TRUE;
										jaFoiDireita = Boolean.TRUE;
									}
								} else {
									System.out.println("Voc� ficou parado na faixa e um carro te atropelou");
								}
							}
						}
					break;
					
					case ESQUERDA:
						if(olharEsquerda) {
							if(carro > 0) {
								System.out.println("Esta vindo carro ");
								
								System.out.print("Deseja dar mais um passo? Digite A(aguardar) ou P(para dar um passo): ");
								passo = in.next();
								
								if(passo.equalsIgnoreCase("P")) {
									System.out.println("Andando para frente....");
									System.out.println("Voc� andou no momento que o carro estava vindo");
								} else {
									System.out.println("Aguardando....");
									continuaPasso = Boolean.TRUE;
								}
								
								
							} else {
								System.out.println("N�o esta vindo carro ");
								System.out.print("Deseja dar mais um passo? Digite A(aguardar) ou P(para dar um passo): ");
								passo = in.next();
								
								if(passo.equalsIgnoreCase("P")) {
									if(jaFoiDireita) {
										System.out.println("Andando para frente....");
										jaFoiEsquerda = Boolean.TRUE;
									} else {
										System.out.println("Andando para frente....");
										System.out.println("Olhando para a Direita...");
										atravessarRua.setDireitaOuEsquerda(DireitaOuEsquerda.DIREITA);
										continuaPasso = Boolean.TRUE;
										olharDireita = Boolean.TRUE;
										olharEsquerda = Boolean.FALSE;
										continuaPasso = Boolean.TRUE;
										jaFoiEsquerda = Boolean.TRUE;
									}
								} else {
									System.out.println("Voc� ficou parado na faixa e um carro te atropelou");
								}
							}
						}
						
					break;
						
					default:
						System.out.println("Valor n�o localizado e voc� foi atropelado");
					break;
				}
				
				
			}while(continuaPasso.equals(Boolean.TRUE));
			
			System.out.println("====================================");
			System.out.print("Deseja continuar jogando? S(Sim) e (N)N�o: ");
			
			iniciar = in.next();
			iniciar = iniciar.toLowerCase();
			if(POSSIVEISENTRADAUSUARIOCONTINUA.contains(iniciar)) {
				continua = Boolean.TRUE;
			} else if(POSSIVEISENTRADAUSUARIONAO.contains(iniciar)) {
				System.out.println("FIM DA EXECU��O");
				continua = Boolean.FALSE;
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			
			
		}while(continua.equals(Boolean.TRUE));
		
	}

}
