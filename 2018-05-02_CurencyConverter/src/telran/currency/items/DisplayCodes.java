package telran.currency.items;

import telran.view.InputOutput;

public class DisplayCodes extends CurrencyItem {

	private static final int DEFAULT_CODES_PER_LINE = 10;
	private int codesPerLine=DEFAULT_CODES_PER_LINE;

	public int getCodesPerLine() {
		return codesPerLine;
	}

	public void setCodesPerLine(int codesPerLine) {
		this.codesPerLine = codesPerLine;
	}

	public DisplayCodes(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Display all the currency codes";
	}

	@Override
	public void action() {
		Iterable<String> codes=currencyRates.rates.keySet();
		int ind=0;
		for(String code:codes){
			if(ind%codesPerLine==0)
				inputOutput.display("\n");
			inputOutput.display(code+' ');
			ind++;
		}
		inputOutput.displayLine("");
		
	}

}
