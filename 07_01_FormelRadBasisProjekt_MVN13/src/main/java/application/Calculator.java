package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
		calculate();
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		if(leistung <= 0&& spannung <= 0){
			calculatePueberU();
			calculateU2ueberP();
		}
		else if (leistung <= 0 && strom <= 0){
			calculatePueberI2();
			calculatePueberI();
		}
		else if (leistung <= 0 && widerstand <= 0){
			calculateWurzelPmalR();
			calculateWurzelPueberR();
		}
		else if (spannung <= 0 && strom <= 0){
			calculateUueberI();
			calculateUmalI();
		}
		else if (spannung <= 0 && widerstand <= 0){
			calculateU2ueberR();
			calculateUueberR();
		}
		else if (strom <= 0 && widerstand <= 0){
			calculateRmalI2();
			calculateRmalI();
		}
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	//Leistung
	public void calculateUmalI() {
		this.leistung = (getSpannung()*getStrom());
	}
	public void calculateU2ueberR() {
		this.leistung = (Math.pow(getSpannung(), 2)) / getWiderstand();
	}
	public void calculateRmalI2() {

		this.leistung = (getWiderstand() * Math.pow(getStrom(), 2));
	}
	//Spannung
	public void calculateRmalI(){
		this.spannung = getWiderstand()*getStrom();
	}
	public void calculatePueberI(){
		this.spannung = getLeistung()/getStrom();
	}
	public void calculateWurzelPmalR(){
		this.spannung = Math.sqrt(getLeistung()*getWiderstand());
	}
}
