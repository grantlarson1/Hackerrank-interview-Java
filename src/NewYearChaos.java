import java.util.*;
public class NewYearChaos 
{
	static void minimumBribes(int[] q) 
	{
		for (int i = 1; i < q.length+1; i++)
		{
			if (q[i-1] - i >2)						//If a number is more than 2 from its original spot
			{
				System.out.println("Too chaotic");	//Too chaotic
				return;
			}
		}
		int count = 0;
		boolean notDone = true;
		while (notDone)								//Kinda like bubblesort
		{
			notDone = false;
//			for(int i : q) System.out.println(i);
			for (int i = 0; i < q.length-1; i++)	
			{
				
				if (q[i]>q[i+1])					//Swap if out of order
				{
					int temp = q[i+1];
					q[i+1] = q[i];
					q[i] = temp;
					count+=1;						//Keep track of #swaps
					notDone = true;
				}
			}
//			System.out.println(done);
//			for(int i : q) System.out.println(i);
			if (!notDone) break;					//We're done if we didn't swap
		}
		System.out.println(count);
	}

		public static void main(String args[])
		{
			Scanner scan = new Scanner(System.in);
			int size = scan.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++)
				arr[i] = scan.nextInt();
			minimumBribes(arr);
			scan.close();
		}
}
