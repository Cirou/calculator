package net.cirou.calculator.service;

import java.util.List;

import net.cirou.calculator.model.DatiCalcoloRequest;
import net.cirou.calculator.model.DatiCalcoloResponse;

public interface CalculatorService  {

	String addizionaNumeri(String numero1, String numero2);
	
	String sottraiNumeri(String numero1, String numero2);
	
	String moltiplicaNumeri(String numero1, String numero2);
	
	String dividiNumeri(String numero1, String numero2);
	
	DatiCalcoloResponse addDatiCalcoloResponse(List<String> numeri);
	
	DatiCalcoloResponse subtractDatiCalcoloResponse(List<String> numeri);
	
	DatiCalcoloResponse multiplyDatiCalcoloResponse(List<String> numeri);
	
	DatiCalcoloResponse divideDatiCalcoloResponse(List<String> numeri);
}
