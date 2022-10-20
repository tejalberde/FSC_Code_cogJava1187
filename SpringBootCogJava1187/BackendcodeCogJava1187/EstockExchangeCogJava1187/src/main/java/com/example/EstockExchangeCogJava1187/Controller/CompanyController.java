package com.example.EstockExchangeCogJava1187.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EstockExchangeCogJava1187.entity.CompanyStock;
import com.example.EstockExchangeCogJava1187.entity.ResponseData;
import com.example.EstockExchangeCogJava1187.service.CompanyService;;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	ResponseData responseData;

	@PostMapping("/addCompany")
	public ResponseData addCompany(@RequestBody CompanyStock companyStock) {
		String result=null;
		if (companyStock.getCompany().getTurnover() > 100000000) {
			result = companyService.addCompany(companyStock);
			responseData.setCode(HttpStatus.ACCEPTED.value());
		} else {
			result = "Turnover should be greater than 10Cr";
			responseData.setCode(HttpStatus.PRECONDITION_FAILED.value());
		}
		responseData.setMessage(result);
		return responseData;

	}

	@DeleteMapping("/RemoveCompany/{companyCode}")
	public ResponseData deleteCompanyAndStock(@PathVariable int companyCode) {
		String result = null;
		result = companyService.deleteCompanyAndStock(companyCode);
		responseData.setMessage(result);
		responseData.setCode(HttpStatus.ACCEPTED.value());
		if(result.equalsIgnoreCase("Company not found!!"))
		{
			responseData.setCode(HttpStatus.NOT_FOUND.value());
		}
		return responseData;
	}

}
