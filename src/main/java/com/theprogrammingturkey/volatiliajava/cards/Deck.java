package com.theprogrammingturkey.volatiliajava.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.theprogrammingturkey.volatiliajava.cards.Card.Suit;

public class Deck
{
	private List<Card> availableDeck;
	private List<Card> usedDeck;

	public Deck()
	{
		availableDeck = new ArrayList<Card>();
		usedDeck = new ArrayList<Card>();
		for (Suit s : Suit.values())
			for (int i = 1; i < 14; i++)
				availableDeck.add(new Card(i, s));
	}

	public void reset()
	{
		availableDeck.addAll(usedDeck);
		usedDeck.clear();
	}

	public int getNumCardsLeft()
	{
		return this.availableDeck.size();
	}

	public void shuffle()
	{
		Random rand = new Random();
		for (int i = 0; i < 1000; i++)
		{
			int index1 = rand.nextInt(availableDeck.size());
			int index2 = rand.nextInt(availableDeck.size());
			Card tempCard = availableDeck.get(index2);
			availableDeck.set(index2, availableDeck.get(index1));
			availableDeck.set(index1, tempCard);
		}
	}

	public Card drawCard()
	{
		Card card = availableDeck.remove(0);
		usedDeck.add(card);
		return card;
	}
}
