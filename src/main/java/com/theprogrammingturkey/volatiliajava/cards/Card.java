package com.theprogrammingturkey.volatiliajava.cards;

public class Card
{
	private int faceValue;
	private Suit suit;

	public Card(int faceValue, Suit suit)
	{
		this.faceValue = faceValue;
		this.suit = suit;
	}

	public boolean isFaceCard()
	{
		return faceValue == 1 || faceValue > 10;
	}

	public String getCardName()
	{
		if (faceValue == 1) return "Ace";
		else if (faceValue == 11) return "Jack";
		else if (faceValue == 12) return "Queen";
		else if (faceValue == 13) return "King";
		else return "" + faceValue;
	}

	public int getCardValue()
	{
		return this.faceValue;
	}

	public String toString()
	{
		return this.getCardName() + " of " + this.suit.getName() + "s";
	}

	public enum Suit
	{
		Heart("Heart"), Diamond("Diamond"), Spade("Spade"), Club("Club");

		private String name;

		Suit(String name)
		{
			this.name = name;
		}

		public String getName()
		{
			return name;
		}
	}
}
