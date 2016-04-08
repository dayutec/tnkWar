package fk0888;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowHand {

	private final int PLAY_NUM =5;
	private String[] types = {"Fk","HX","CH","HT"};
	private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	private List<String> cards = new LinkedList<String>();
	
	private String[] players = new String[PLAY_NUM];
	
	private List<String>[] playerCards = new List[PLAY_NUM];
	
	public void initCards()
	{
		for(int i=0;i<types.length;i++)
		{
			for(int j=0;j<types.length;j++)	
			{
				cards.add(types[i]+values[j]);
			}
		}
		
		Collections.shuffle(cards);
	}
	
	public void initPlayer(String... names)
	{
		if(names.length>PLAY_NUM || names.length<2){
			
			System.out.println("NUM of player do not meet requriment");
			return;
		}
		else{
			for(int i=0; i< names.length;i++)
			{
				players[i] = names[i];
			}
		}

	}
	
	public void initPlayerCards()
	{
		for(int i=0; i <players.length ; i++)
		{
			
			 if(players[i]!= null && !players[i].equals(""))
			 {
				playerCards[i] = new LinkedList<String>();
			 }
			
		}
	}
	
	public void showAllCards()
	{
		for(String card: cards)
		{
			System.out.println(card);
		}
	}
	
	public void deliveryCard(String first)
	{
		
		int firstPos =10;// ArrayUtils.search(players,first);
		for(int i= firstPos ; i < PLAY_NUM ;i++)
		{
			if(players[i]!= null)
			{
				playerCards[i].add(cards.get(0));
				cards.remove(0);
			}
			
		}
		
		for(int i=0 ;i<firstPos ; i++)
		{
			if(players[i]!= null)
			{
				playerCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		
	
	}
	
	
	public void showPlayerCards()
	{
		for(int i= 0 ; i < PLAY_NUM ;i++)
		{
			if(players[i]!= null)
			{
				System.out.print(players[i]+" : ");
				for(String card : playerCards[i])
				{
					System.out.print(card + "\t");
				}
			}
			
		}
	}
	
}
