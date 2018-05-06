package telran.currency.items;

import telran.view.InputOutput;

public class DisplayLatestDate extends CurrencyItem {

	public DisplayLatestDate(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Display latest date";
	}

	@Override
	public void action() {
		inputOutput.displayLine("Latest date: "+currencyRates.date);

	}

}
