package rental;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {
	private String name;
	private Collection<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String generateCustomerStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		for(Rental rental: rentals) {
			double thisAmount = 0;
			// determine amounts for each line
			thisAmount = calculateRentalAmount(rental);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private double calculateRentalAmount(Rental rental) {
		double amount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.NEW_RELEASE:
			amount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if (rental.getDaysRented() > 3)
				amount += (rental.getDaysRented() - 3) * 1.5;
			break;
		case Movie.REGULAR:
		default:
			amount += 2;
			if (rental.getDaysRented() > 2)
				amount += (rental.getDaysRented() - 2) * 1.5;
			break;
		}
		return amount;
	}

}
