import java.util.*;

public class LeftRotation 
{
	static int[] rotLeft(int[] a, int d) 
	{
			int[] first = Arrays.copyOfRange(a, 0, d%a.length);					//Create subarray that gets rotated to end of list
			int[] second = Arrays.copyOfRange(a, d%a.length, a.length);			//second[0] will be the new first element of the new list
			int[] answer = new int[a.length];
			for (int i = 0; i < second.length; i++)
				answer[i]= second[i];
			for (int i = second.length; i < second.length+first.length; i++)
				answer[i] = first[i-second.length];
			return answer;
    }
}
