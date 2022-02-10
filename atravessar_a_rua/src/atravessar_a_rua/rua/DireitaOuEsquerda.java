package atravessar_a_rua.rua;

public enum DireitaOuEsquerda {
	
	DIREITA(1, "D"),
	ESQUERDA(2, "E"),
	AGUARDANDO(3, "A"),
	PASSO(4, "P");
	
	private Integer codigo;
	private String descricao;
	
	
	DireitaOuEsquerda(Integer codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

}
