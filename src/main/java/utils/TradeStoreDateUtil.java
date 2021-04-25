package utils;

import java.util.Date;

import common.TradeStoreConstant;
import tradeException.InvalidMaturityDate;

public class TradeStoreDateUtil {

	private TradeStoreDateUtil() {

	}

	public static boolean isValidDate(String maturityDate) {

		try {
			String[] dateTimesParts = maturityDate.split(" ");

			/*
			 * for (String string : dateTimesParts) {
			 * System.out.println(string); }
			 */

			// dd-mm-yyyy hh:mm:ss AM/PM
			// 21-01-2021 06:07:10 AM
			String[] dateParts = dateTimesParts[0].split("-");

			int datePart = Integer.parseInt(dateParts[0]);
			int monthPart = Integer.parseInt(dateParts[1]);
			int yearPart = Integer.parseInt(dateParts[2]);

			if (datePart < 0 || datePart > 31 || monthPart < 0 || monthPart > 12 || yearPart < 0) {
				throw new InvalidMaturityDate(TradeStoreConstant.INVALID_MATURITY_DATE);
			}

			Date dateNow = new Date();

			@SuppressWarnings("deprecation")
			int currentYear = dateNow.getYear() + 1900;

			@SuppressWarnings("deprecation")
			int currentMonth = dateNow.getMonth() + 1;

			@SuppressWarnings("deprecation")
			int currentDate = dateNow.getDate();

			if (currentYear == yearPart) {
				if (currentMonth == monthPart) {
					if (datePart > currentDate) {
						return true;
					} else {
						return false;
					}
				} else if (monthPart > currentMonth) {
					return true;
				} else if (monthPart < currentMonth) {
					return false;
				}
			} else if (yearPart > currentYear) {
				return true;
			} else if (yearPart < currentYear) {
				return false;
			}
		} catch (Exception e) {
			throw new InvalidMaturityDate(TradeStoreConstant.INVALID_MATURITY_DATE);
		}

		return false;
	}

}
