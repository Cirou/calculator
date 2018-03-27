package net.cirou.calculator.controller;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.cirou.calculator.database.SQLiteJDBCDriverConnection;

@Controller
public class CalculatorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	SQLiteJDBCDriverConnection sql;

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
		
		return addizionaNumeri(numero1, numero2);
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
		
		return addizionaNumeri(numero1, numero2);
	}

	private String addizionaNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa + numerob);

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
		
		return moltiplicaNumeri(numero1, numero2);
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
		
		return moltiplicaNumeri(numero1, numero2);
	}

	private String moltiplicaNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa * numerob);

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
		
		return dividiNumeri(numero1, numero2);
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
		
		return dividiNumeri(numero1, numero2);
	}

	private String dividiNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa / numerob);

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
		
		return sottraiNumeri(numero1, numero2);
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
		
		return sottraiNumeri(numero1, numero2);
	}

	private String sottraiNumeri(String numero1, String numero2) {

		int numeroa = Integer.parseInt(numero1);
		int numerob = Integer.parseInt(numero2);

		return "risultato =" + (numeroa - numerob);

	}


	private void validazione(String numero1, String numero2) throws ValidationException {

		if (StringUtils.isEmpty(numero1) || StringUtils.isEmpty(numero2) 
				&& !NumberUtils.isDigits(numero1) || !NumberUtils.isDigits(numero2)) {
			throw new ValidationException("formato non valido");
		}

	}
}
