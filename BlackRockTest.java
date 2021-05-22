package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class BlackRockTest {

	static int countHoldings(String input) {

		int count = 0;
		count = readPortFolio(input, count);
		return count;
	}

	private static int readPortFolio(String input, int count) {
		if (!Objects.isNull(input) && input.length() > 0) {
			String[] portFolioArray = input.split("\\|");
			for (String details : portFolioArray) {
				String[] portFolioDetails = details.split(",");
				Portfolio port = new Portfolio();

				String portCode = (!Objects.isNull(portFolioDetails[0]) && portFolioDetails[0].length() > 0)
						? portFolioDetails[0]
						: "";
				String portName = (!Objects.isNull(portFolioDetails[1]) && portFolioDetails[1].length() > 0)
						? portFolioDetails[1]
						: "";
				double share = (!Objects.isNull(portFolioDetails[2]) && portFolioDetails[2].length() > 0)
						? Double.parseDouble(portFolioDetails[2])
						: 0;

				port.setPortCode(portCode);
				port.setPortfolioName(portName);
				port.setNoOfShare(share);

				count++;
			}
		}
		return count;
	}

	static String printHoldings(String portfolioString) {
		StringBuilder builder = new StringBuilder();
		if (!Objects.isNull(portfolioString) && portfolioString.length() > 0) {
			String[] portFolioArray = portfolioString.split("\\|");
			List<Portfolio> listOfPortFolio = new ArrayList<>();

			for (String str : portFolioArray) {
				listOfPortFolio.add(readPortFolio1(str));
			}

			Collections.sort(listOfPortFolio, new Portfolio());

			for (Portfolio str : listOfPortFolio) {
				builder.append(str.toString()).append(", ");
			}
		}

		String result = builder.toString().substring(0, builder.toString().length() - 2);
		return result;

	}

	private static Map<String, Portfolio> readPortFolio(String input) {

		Map<String, Portfolio> mapOfPortFolio = new HashMap<>();

		if (!Objects.isNull(input) && input.length() > 0) {
			String[] portFolioArray = input.split("\\|");
			for (String details : portFolioArray) {
				String[] portFolioDetails = details.split(",");
				Portfolio port = new Portfolio();

				String portCode = (!Objects.isNull(portFolioDetails[0]) && portFolioDetails[0].length() > 0)
						? portFolioDetails[0]
						: "";
				String portName = (!Objects.isNull(portFolioDetails[1]) && portFolioDetails[1].length() > 0)
						? portFolioDetails[1]
						: "";
				double share = (!Objects.isNull(portFolioDetails[2]) && portFolioDetails[2].length() > 0)
						? Double.parseDouble(portFolioDetails[2])
						: 0;

				port.setPortCode(portCode);
				port.setPortfolioName(portName);
				port.setNoOfShare(share);

				mapOfPortFolio.put(portCode, port);
			}
		}

		return mapOfPortFolio;
	}

	public static Portfolio readPortFolio1(String input) {
		Portfolio port = new Portfolio();

		if (!Objects.isNull(input) && input.length() > 0) {
			String[] portFolioDetails = input.split(",");

			String portCode = (!Objects.isNull(portFolioDetails[0]) && portFolioDetails[0].length() > 0)
					? portFolioDetails[0]
					: "";
			String portName = (!Objects.isNull(portFolioDetails[1]) && portFolioDetails[1].length() > 0)
					? portFolioDetails[1]
					: "";
			double share = (!Objects.isNull(portFolioDetails[2]) && portFolioDetails[2].length() > 0)
					? Double.parseDouble(portFolioDetails[2])
					: 0;

			port.setPortCode(portCode);
			port.setPortfolioName(portName);
			port.setNoOfShare(share);
		}

		return port;
	}

	static String generateTransactions(String input) {
		StringBuilder builder = new StringBuilder();
		ArrayList<Transaction> listOfTicker = new ArrayList<>();

		if (!Objects.isNull(input) && input.length() > 0) {
			String[] portFolioArray = input.split(":");
			Map<String, Portfolio> portObjectMap = readPortFolio(portFolioArray[0]);
			Map<String, Portfolio> benchMarkMap = readPortFolio(portFolioArray[1]);

			for (Entry<String, Portfolio> portEntrySet : portObjectMap.entrySet()) {
				Portfolio benchMark = benchMarkMap.get(portEntrySet.getKey());
				Portfolio portObject = portEntrySet.getValue();

				if (!Objects.isNull(benchMark)) {
					if (portObject.getNoOfShare() > benchMark.getNoOfShare()) {
						listOfTicker.add(new Transaction("SELL", portObject.getPortCode(),
								portObject.getNoOfShare() - benchMark.getNoOfShare()));
					} else if (portObject.getNoOfShare() < benchMark.getNoOfShare()) {
						listOfTicker.add(new Transaction("BUY", portObject.getPortCode(),
								benchMark.getNoOfShare() - portObject.getNoOfShare()));
					}
				}
			}

			if (listOfTicker.size() > 0) {
				Collections.sort(listOfTicker, new Transaction());

				for (Transaction code : listOfTicker) {
					builder.append(code.toString()).append(", ");
				}
			}
		}

		String result = builder.toString().substring(0, builder.toString().length() - 2);
		return result;
	}

	public static class Transaction implements Comparator<Transaction> {
		private String buyOrSell;
		private String ticker;
		private double noOfShare;

		public Transaction() {

		}

		public Transaction(String buyOrSell, String ticker, double quat) {
			this.buyOrSell = buyOrSell;
			this.ticker = ticker;
			this.noOfShare = quat;
		}

		public String getBuyOrSell() {
			return buyOrSell;
		}

		public void setBuyOrSell(String buyOrSell) {
			this.buyOrSell = buyOrSell;
		}

		public String getTicker() {
			return ticker;
		}

		public void setTicker(String ticker) {
			this.ticker = ticker;
		}

		public double getNoOfShare() {
			return noOfShare;
		}

		public void setNoOfShare(double noOfShare) {
			this.noOfShare = noOfShare;
		}

		@Override
		public String toString() {
			return "[" + buyOrSell + ", " + ticker + ", " + String.format("%.2f", noOfShare) + "]";
		}

		@Override
		public int compare(Transaction o1, Transaction o2) {
			return o1.getTicker().compareTo(o2.getTicker());
		}

	}

	public static class Portfolio implements Comparator<Portfolio> {
		private String portCode;
		private String portFolio;
		private double noOfShare;

		public String getPortCode() {
			return portCode;
		}

		public void setPortCode(String portCode) {
			this.portCode = portCode;
		}

		public String getPortfolioName() {
			return portFolio;
		}

		public void setPortfolioName(String portfolioName) {
			this.portFolio = portfolioName;
		}

		public double getNoOfShare() {
			return noOfShare;
		}

		public void setNoOfShare(double noOfShare) {
			this.noOfShare = noOfShare;
		}

		@Override
		public String toString() {
			return "[" + this.portCode + ", " + this.portFolio + ", " + this.noOfShare + "]";
		}

		@Override
		public int compare(Portfolio o1, Portfolio o2) {
			return o1.getPortCode().compareTo(o2.getPortCode());
		}
	}

	public static void main(String[] args) {
		System.out.println(BlackRockTest.countHoldings("VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"));

		System.out.println(BlackRockTest.printHoldings("VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"));

		System.out.println(BlackRockTest.generateTransactions(
				"VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12:VOD,Vodafone,16|GOOG,Google,10|MSFT,Microsoft,25"));
	}
}
