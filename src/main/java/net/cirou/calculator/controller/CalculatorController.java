package net.cirou.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.cirou.calculator.database.SQLiteJDBCDriverConnection;

@Controller
public class CalculatorController{

	@Autowired
	SQLiteJDBCDriverConnection sql;
	
    @GetMapping("/calculator")
    @ResponseBody
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    	
    	sql.connect();
    	
        return "########\r\n########\r\n";
    }
    
}
