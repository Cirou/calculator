package net.cirou.calculator.controller;

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
public class CalculatorController{

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	SQLiteJDBCDriverConnection sql;

	@GetMapping("/calculator")
	@ResponseBody
	public String sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {

		sql.connect();

		return "########\r\n########\r\n";
	}

	@GetMapping("/calculator/add/{numero1}/{numero2}")
	@ResponseBody
	public String addiziona(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) {

		sql.connect();
		
		return "risultato"; 


	}
}

