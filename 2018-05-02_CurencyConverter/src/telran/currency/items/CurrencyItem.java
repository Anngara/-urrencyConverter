package telran.currency.items;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.view.*;
import telran.currency.entities.CurrencyRates;
public abstract class  CurrencyItem extends AbstractItem{
	protected static final String LATEST = "latest";
	public CurrencyItem(InputOutput inputOutput) {
		super(inputOutput);
	}
	static protected String url="http://api.fixer.io/";
	static protected RestTemplate restTemplate=new RestTemplate();
	static protected HttpHeaders headers=new HttpHeaders();
	static protected CurrencyRates currencyRates=
			getRates(LATEST);
	
	
	protected static CurrencyRates getRates(String date) {
		ResponseEntity<CurrencyRates> response=
		restTemplate.exchange(url+date,
		HttpMethod.GET, new HttpEntity<String>(headers),
		CurrencyRates.class);
		CurrencyRates rates=response.getBody();
		rates.rates.put("EUR", 1.0);
		return rates;
	}
}
