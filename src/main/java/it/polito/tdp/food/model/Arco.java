package it.polito.tdp.food.model;

public class Arco {

	String tipoDiPorzione1;
	String tipoDiPorzione2;
	int NfoodCode;
	
	public Arco(String tipoDiPorzione1, String tipoDiPorzione2, int nfoodCode) {
		this.tipoDiPorzione1 = tipoDiPorzione1;
		this.tipoDiPorzione2 = tipoDiPorzione2;
		NfoodCode = nfoodCode;  }

	public String getTipoDiPorzione1() {
		return tipoDiPorzione1;
	}

	public void setTipoDiPorzione1(String tipoDiPorzione1) {
		this.tipoDiPorzione1 = tipoDiPorzione1;
	}

	public String getTipoDiPorzione2() {
		return tipoDiPorzione2;
	}

	public void setTipoDiPorzione2(String tipoDiPorzione2) {
		this.tipoDiPorzione2 = tipoDiPorzione2;
	}

	public int getNfoodCode() {
		return NfoodCode;
	}

	public void setNfoodCode(int nfoodCode) {
		NfoodCode = nfoodCode;
	}
	
	
}
