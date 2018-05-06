package telran.currency.controller;

import java.util.ArrayList;

import telran.view.*;

import telran.currency.items.ConvertCurrency;
import telran.currency.items.DisplayCodes;
import telran.currency.items.DisplayLatestDate;

public class CurrencyConverterAppl {

	public static void main(String[] args) {
		ArrayList<Item> items=new ArrayList<>();
		InputOutput inputOutput=new ConsoleInputOutput();
		items.add(new DisplayCodes(inputOutput));
		items.add(new DisplayLatestDate(inputOutput));
		items.add(new ConvertCurrency(inputOutput));
		
		Menu menu=new MenuWithExit(items, inputOutput);
		menu.runMenu();

	}

}
