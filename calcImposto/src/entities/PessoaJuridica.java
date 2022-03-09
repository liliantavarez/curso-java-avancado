package entities;

public class PessoaJuridica extends Contribuinte {
	
	private Integer qntFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer qntFuncionarios) {
		super(nome, rendaAnual);
		this.qntFuncionarios = qntFuncionarios;
	}

	public Integer getQntFuncionarios() {
		return qntFuncionarios;
	}

	public void setQntFuncionarios(Integer qntFuncionarios) {
		this.qntFuncionarios = qntFuncionarios;
	}
	
	@Override
	public double calcImposto() {
		
		if(qntFuncionarios > 10) {
			return getRendaAnual() * 14/100;
		}else {			
			return getRendaAnual() * 16/100;
		}
	}
	
}
