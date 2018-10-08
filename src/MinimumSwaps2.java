import java.util.*;
public class MinimumSwaps2 
{
	public static class Node 
	{
	    //public String name;
	    public int value;
	    Node end;								//Each node points to at most one other node
	    Node()									//Node n points at node m if Node m occupies the index
	    										//of the unsorted array that n should occupy in the sorted array
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
			arr1.add(i);									//Java autoboxing sucks so I have to construct an Integer Arraylist
		
		Collections.sort(arr1);								//Sort array list
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++)
		{
			Node n = new Node(arr[i]);						
			nodes.add(n);									//Add node to my list of nodes
			map.put(arr1.get(i),i);							//Create a mapping from a value in the array, 
		}													//to its index in the sorted array
		
		for (Node n : nodes)
			n.end = nodes.get(map.get(n.value));			//Create the node that each node should point to
		
		int total = 0;
		int count = 0;
		Set<Node> visited = new HashSet<>();
		
		for (Node i : nodes)								//This counts the length of each cycle, subtracts 1 from it
		{													//and adds this number to total 
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

		return total;										//Minimum number of swaps
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
