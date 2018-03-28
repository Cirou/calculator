package net.cirou.calculator.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.cirou.calculator.database.SQLiteJDBCDriverConnection;
import net.cirou.calculator.model.DatiCalcoloRequest;
import net.cirou.calculator.model.DatiCalcoloResponse;
import net.cirou.calculator.service.CalculatorService;


@Controller
public class CalculatorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	SQLiteJDBCDriverConnection sql;
	@Autowired
	@Qualifier("calculatorserviceprovider")
	private CalculatorService calculatorService;


	@GetMapping("/calculator")
	@ResponseBody
	public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {

		sql.connect();

		return "########\r\n########\r\n";
	}

	@GetMapping("/calculator/add/{numero1}/{numero2}")
	@ResponseBody
	public String addiziona(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.addizionaNumeri(numero1, numero2);
	}

	@GetMapping("/calculator/add2")
	@ResponseBody
	public String addiziona2(@RequestParam("numero1") String numero1, @RequestParam("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return  this.calculatorService.addizionaNumeri(numero1, numero2);
	}

	
	@GetMapping("/calculator/multiply/{numero1}/{numero2}")
	@ResponseBody
	public String moltiplica(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.moltiplicaNumeri(numero1, numero2);
	}

	@GetMapping("/calculator/multiply2")
	@ResponseBody
	public String prodotto2(@RequestParam("numero1") String numero1, @RequestParam("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.moltiplicaNumeri(numero1, numero2);
	}


	@GetMapping("/calculator/numerator/{numero1}/{numero2}")
	@ResponseBody
	public String dividi(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.dividiNumeri(numero1, numero2);
	}

	@GetMapping("/calculator/numerator")
	@ResponseBody
	public String dividi2(@RequestParam("numero1") String numero1, @RequestParam("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.dividiNumeri(numero1, numero2);
	}
	
	@GetMapping("/calculator/subtraction/{numero1}/{numero2}")
	@ResponseBody
	public String sottrai(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.sottraiNumeri(numero1, numero2);
	}

	@GetMapping("/calculator/subtraction")
	@ResponseBody
	public String sottrai2(@RequestParam("numero1") String numero1, @RequestParam("numero2") String numero2) {

		try {
			validazione(numero1, numero2);
		} catch (ValidationException e) {
			LOGGER.error(e.getMessage());
			return e.getMessage();
		}

		return this.calculatorService.sottraiNumeri(numero1, numero2);
	}
	
	@PostMapping("/calculator/add3")
	@ResponseBody
	public DatiCalcoloResponse addiziona3(@RequestBody DatiCalcoloRequest datiCalcolo) {

		List<String> numeri = datiCalcolo.getNumeri();
		
		try {
				validazione(numeri);
		}catch (ValidationException e){
			LOGGER.error(e.getMessage());
		}
		return this.calculatorService.addDatiCalcoloResponse(numeri);
	}
	
	@PostMapping("/calculator/subtract3")
	@ResponseBody
	public DatiCalcoloResponse sottrai3(@RequestBody DatiCalcoloRequest datiCalcolo) {

		List<String> numeri = datiCalcolo.getNumeri();
		
		try {
				validazione(numeri);
		}catch (ValidationException e){
			LOGGER.error(e.getMessage());
		}
		return this.calculatorService.subtractDatiCalcoloResponse(numeri);
	}
	
	@PostMapping("/calculator/multiply3")
	@ResponseBody
	public DatiCalcoloResponse moltiplica3(@RequestBody DatiCalcoloRequest datiCalcolo) {

		List<String> numeri = datiCalcolo.getNumeri();
		
		try {
				validazione(numeri);
		}catch (ValidationException e){
			LOGGER.error(e.getMessage());
		}
		return this.calculatorService.multiplyDatiCalcoloResponse(numeri);
	}
	
	@PostMapping("/calculator/divide3")
	@ResponseBody
	public DatiCalcoloResponse dividi3(@RequestBody DatiCalcoloRequest datiCalcolo) {

		List<String> numeri = datiCalcolo.getNumeri();
		
		try {
				validazione(numeri);
		}catch (ValidationException e){
			LOGGER.error(e.getMessage());
		}
		return this.calculatorService.divideDatiCalcoloResponse(numeri);
	}



	private void validazione(String numero1, String numero2) throws ValidationException {

		if (StringUtils.isEmpty(numero1) || StringUtils.isEmpty(numero2) 
				&& !NumberUtils.isDigits(numero1) || !NumberUtils.isDigits(numero2)) {
			throw new ValidationException("formato non valido");
		}

	}

	private void validazione(List<String> numeri) throws ValidationException {
		
		if(numeri == null || numeri.isEmpty())
		{
			throw new ValidationException("inserisci dei valori");
		}
		for (String string : numeri) {
			if(StringUtils.isEmpty(string) || !NumberUtils.isDigits(string)) {
				throw new ValidationException("formato non valido");
			}
		}
	}
}
