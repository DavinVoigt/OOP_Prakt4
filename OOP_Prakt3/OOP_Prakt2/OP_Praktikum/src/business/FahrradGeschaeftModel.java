package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import observer.Observable;
import observer.Observer;
import readers.*;

public class FahrradGeschaeftModel implements Observable{
	
	private static FahrradGeschaeftModel fahrradModel;
	private ArrayList<Fahrrad> fahrraeder = new ArrayList<Fahrrad>();
	private Vector<Observer> observers  = new Vector<Observer>();
	
	private FahrradGeschaeftModel() {
		
	}
	
	public static FahrradGeschaeftModel getInstance() {
		if (fahrradModel == null) {
			fahrradModel = new FahrradGeschaeftModel();
		}
		return fahrradModel;
	}

	public ArrayList<Fahrrad> getFahrrad() {
		return this.fahrraeder;
	}

	public void addFahrrad(Fahrrad fahrrad) {
		this.fahrraeder.add(fahrrad);
	}

	public void schreibeFahrradInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("Fahrrad.csv", true));
		aus.write(this.fahrraeder.toString());
		aus.close();
	}

	public void leseFahrradAusDatei() throws IOException{
			Creator creator = new ConcreteCsvCreator();
			Product reader = creator.factoryMethod();
			String[] zeile = reader.leseAusDatei();
			addFahrrad(new Fahrrad(zeile[0], Integer.parseInt(zeile[1]), zeile[2], zeile[3], zeile[4].split("_")));
			notifyObservers();
		}
	
	
	public void leseFahrradAusDateiTxt() throws IOException {
		Creator creator = new ConcreteTxtCreator();
		Product reader = creator.factoryMethod();
		String[] zeile = reader.leseAusDatei();
		addFahrrad(new Fahrrad(zeile[0], Integer.parseInt(zeile[1]), zeile[2], zeile[3], zeile[4].split("_")));
		notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.removeElement(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			this.observers.elementAt(i).update();
		}
		
	}
}

