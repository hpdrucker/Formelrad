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
		else if (leistung <= 0 && strom <= 0){
			calculateWurzelPmalR();
			calculateWurzelPueberR();
		}
		
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	public void calculateUmalI() {
		double ui;
		ui = (getSpannung()*getStrom());
	}
	public void calculateUh2ueberR() {
		double uh2r;
		uh2r = (Math.pow(getSpannung(), 2)) / getWiderstand();
	}
	public void calculateRmalIh2() {
		double rih2;
		rih2 = (getWiderstand() * Math.pow(getStrom(), 2));
	}

}
