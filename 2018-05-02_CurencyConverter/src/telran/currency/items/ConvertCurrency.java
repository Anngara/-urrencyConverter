package telran.currency.items;

import telran.view.InputOutput;
import telran.currency.entities.CurrencyRates;

import java.time.LocalDate;
import java.util.*;
public class ConvertCurrency extends CurrencyItem {

	public ConvertCurrency(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Convert currency";
	}

	@Override
	public void action() {
		String isNotLatest=inputOutput.getString
				("Do you want to specify date yes/no");
		CurrencyRates rates;
		if(isNotLatest.equalsIgnoreCase("yes"))
			rates=specifyDate();
		else
			rates=getLatest();
		
		Set<String> codes=rates.rates.keySet();
		List<String> codesList=new ArrayList<>(codes);
		String currencyFrom=inputOutput.getString
				("Enter currency from",codesList);
		String currencyTo=inputOutput.getString
				("Enter currency to",codesList);
		int amount=inputOutput.getInteger("Enter amount");
		inputOutput.displayLine(convert(rates,currencyFrom,currencyTo,amount)+"\n");
	}

	private double convert(CurrencyRates rates, String currencyFrom, String currencyTo, int amount) {
		return amount/rates.rates.get(currencyFrom)*
				rates.rates.get(currencyTo);
	}

	private CurrencyRates getLatest() {
		if(LocalDate.parse(currencyRates.date)
		.isBefore(LocalDate.now()))
			currencyRates=getRates(LATEST);
		return currencyRates;
	}

	private CurrencyRates specifyDate() {
		LocalDate date=inputOutput.getDate
				("Enter date", "dd/MM/yyyy");
		CurrencyRates rates=getRates(date.toString());
		return rates;
		
	}

}
