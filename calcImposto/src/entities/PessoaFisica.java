package entities;

public class PessoaFisica extends Contribuinte {
	
	private Double gastoSauda;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSauda) {
		super(nome, rendaAnual);
		this.gastoSauda = gastoSauda;
	}

	public Double getGastoSauda() {
		return gastoSauda;
	}

	public void setGastoSauda(Double gastoSauda) {
		this.gastoSauda = gastoSauda;
	}
	
	@Override
	public double calcImposto() {
		
		double valorImpostos = 0.0;
		if(getRendaAnual() < 20000.00 && gastoSauda > 0) {
			valorImpostos = getRendaAnual() * 15/100 - gastoSauda * 50/100;
		}else if(gastoSauda <= 0) {
			valorImpostos = getRendaAnual() * 15/100;
		}else if (getRendaAnual() >20000.00 && gastoSauda > 0) {
			valorImpostos = getRendaAnual() * 25/100 - gastoSauda * 50/100;
		}else if (gastoSauda <= 0) {
			valorImpostos = getRendaAnual() * 25/100;
		}
		
		return valorImpostos;
	}
	
	

}
