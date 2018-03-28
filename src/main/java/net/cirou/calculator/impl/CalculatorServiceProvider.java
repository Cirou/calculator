package net.cirou.calculator.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import net.cirou.calculator.model.DatiCalcoloRequest;
import net.cirou.calculator.model.DatiCalcoloResponse;
import net.cirou.calculator.service.CalculatorService;

@Service("calculatorserviceprovider")
public class CalculatorServiceProvider implements CalculatorService {


	public String addizionaNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa + numerob);

	}

	public String sottraiNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa - numerob);

	}

	public String moltiplicaNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa * numerob);

	}

	public String dividiNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa / numerob);

	}

	@Override
	public DatiCalcoloResponse addDatiCalcoloResponse(List<String> numeri) {
		DatiCalcoloResponse response = new DatiCalcoloResponse();
		int somma = 0;
		for (String string: numeri) {
			int addendi = Integer.parseInt(string);
			somma += addendi;
			response.setRisultato(String.valueOf(somma)); 
		}
		return response;
	}

	@Override
	public DatiCalcoloResponse subtractDatiCalcoloResponse(List<String> numeri) {
		DatiCalcoloResponse response = new DatiCalcoloResponse();
		int sottrazione = 0;

		for (int i=0; i<numeri.size(); i++) {
			int sottraendi = Integer.parseInt(numeri.get(i));
			if(i != 0) {
				sottrazione = sottrazione - sottraendi;
			}
			else {
				sottrazione = sottraendi;
			}
			response.setRisultato(String.valueOf(sottrazione)); 
		}
		return response;
	}

	@Override
	public DatiCalcoloResponse multiplyDatiCalcoloResponse(List<String> numeri) {
		DatiCalcoloResponse response = new DatiCalcoloResponse();
		int moltiplicazione = 1;
		for (String string: numeri) {
			int moltiplicatori = Integer.parseInt(string);
			moltiplicazione *= moltiplicatori;
			response.setRisultato(String.valueOf(moltiplicazione)); 
		}
		return response;
	}

	@Override
	public DatiCalcoloResponse divideDatiCalcoloResponse(List<String> numeri) {
		DatiCalcoloResponse response = new DatiCalcoloResponse();
		int divisione = 0;

		for(int y=0; y<numeri.size(); y++) {
			int divisori=Integer.parseInt(numeri.get(y));
			if(y!=0) {
				divisione= divisione/divisori;
			}
			else {
				divisione=divisori;
			}
			response.setRisultato(String.valueOf(divisione)); 		 
		}
		return response;
	}	
}
