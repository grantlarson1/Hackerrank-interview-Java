import java.util.Collections;
import java.util.PriorityQueue;

public class Array2D 
{

	static int hourglassSum(int[][] arr) 
	{
		PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());		//Max heap priority queue
		for (int i = 0; i < arr.length-2; i++)
		{
			for (int j = 0; j < arr[i].length-2; j++)
				pq.add(arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]);
			
		}
		return pq.peek();  //Max element

    }


}
