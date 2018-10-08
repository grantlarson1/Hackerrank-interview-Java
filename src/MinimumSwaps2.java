import java.util.*;
public class MinimumSwaps2 
{
	public static class Node 
	{
	    //public String name;
	    public int value;
	    Node end;
	    Node()
	    {
	    	
	    }
	    Node(int value, Node end)
	    {
	    	this.value = value;
	    	this.end = end;
	    }
	    Node(int value)
	    {
	    	this.value = value;
	    	this.end = new Node();
	    }
	}
	
	
	static int minimumSwaps(int[] arr) 
	{
		List<Node> nodes = new ArrayList<>();
		
		List<Integer> arr1 = new ArrayList<>();
		for (int i : arr)
			arr1.add(i);
		
		for (int i = 0; i < arr.length; i++)
		{
			Node n = new Node(arr[i]);
			nodes.add(n);	
		}
		Collections.sort(arr1);
		
		long start = System.nanoTime();
		for (Node n : nodes)
			n.end = nodes.get(arr1.indexOf(n.value));
		System.out.println((System.nanoTime()-start)/(float)1000000000);
		
		int total = 0;
		int count = 0;
		Set<Node> visited = new HashSet<>();
		
		for (Node i : nodes)
		{
			count = 0;
			if (visited.contains(i)) continue;
			Node iter = i;

			while(true) 
			{
				if (visited.contains(iter))
				{
					if (count == 0) break;
					total+=count-1;
					break;
				}
				visited.add(iter);
				iter = iter.end;
				count+=1;
			}
			if (visited.size() == nodes.size()) break;
		}

		return total;
    }
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = scan.nextInt();
		
		System.out.println(minimumSwaps(arr));
		
		scan.close();
	}
}
