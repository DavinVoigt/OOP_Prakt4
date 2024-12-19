package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvProduct extends Product{
	
	private BufferedReader br;
	
	public ConcreteCsvProduct() throws FileNotFoundException {
		this.br = new BufferedReader(new FileReader("OOP_Prakt3//OOP_Prakt2//OP_Praktikum//Fahrrad.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] zeile = br.readLine().split(";");
		return zeile;
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
