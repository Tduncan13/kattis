import java.util.*;
import java.io.*;

public class Relay
{
	public static void main(String[] args)
	{
		int i, j;
		Scanner stdin = new Scanner(System.in);
		int numRunners = stdin.nextInt();
		Runner[] runners = new Runner[numRunners];
		double bestTime = 10000, temp = 0;
		PriorityQueue<Runner> pq = new PriorityQueue<Runner>();
		Runner[] team = new Runner[4];
		Runner[] bestTeam = new Runner[4];
		
		for(i = 0; i < numRunners; i++)
			runners[i] = new Runner(stdin.next(), stdin.nextDouble(), stdin.nextDouble()); 

		for(i = 0; i < numRunners; i++)
		{
			for(j = i + 1; j % numRunners != i; j++)
				pq.add(runners[j % numRunners]);
			

			team[0] = runners[i];
			team[1] = pq.poll();
			team[2] = pq.poll();
			team[3] = pq.poll();
			temp = team[0].getLeg1() + team[1].getLeg2() + team[2].getLeg2() + team[3].getLeg2();
			
			if(bestTime > temp)
			{
				bestTime = temp;
				bestTeam[0] = team[0];
				bestTeam[1] = team[1];
				bestTeam[2] = team[2];
				bestTeam[3] = team[3];
			}
			
			pq.clear();
		}

		System.out.println(bestTime);
		System.out.println(bestTeam[0].getName());
		System.out.println(bestTeam[1].getName());
		System.out.println(bestTeam[2].getName());
		System.out.println(bestTeam[3].getName());
	}
}

class Runner implements Comparable<Runner>
{
	private String name;
	private double leg1, leg2;

	public Runner(String n, double l1, double l2)
	{
		name = n;
		leg1 = l1;
		leg2 = l2;
	}

	public int compareTo(Runner other)
	{
		if(this.getLeg2() < other.getLeg2())
			return -1;
		else
			return 1;
	}

	public double getLeg1()
	{
		return this.leg1;
	}

	public double getLeg2()
	{
		return this.leg2;
	}
	
	public String getName()
	{
		return this.name;
	}
}
