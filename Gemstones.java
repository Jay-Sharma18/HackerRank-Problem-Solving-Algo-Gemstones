package JavaAlgorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

	public class Gemstones
	{
    public static int gemstonesCount(List<String> arr) {
    // Write your code here
    
    //Logic: take the first string element of array. iterate through each character of       //this string and check if it is present in all other elements of the array. If it       //is present in every element, increment counter and add that character to another       //string  which would be used to make sure that the character being added is unique
    // which ensure that no character is added to the counter twice.
    
    String firstRock=arr.get(0);
    String duplicateCheck="";
    int count=0;
    
    for(int i=0;i<firstRock.length();i++)
    {
        for(int j=1;j<arr.size();j++)
        {
            if(arr.get(j).contains(new Character(firstRock.charAt(i)).toString()))
            {
                if(j==arr.size()-1)
                {
                    if(duplicateCheck.contains(new Character(firstRock.charAt(i)).toString()))
                    {
                        continue;
                    }
                    else
                    {   
                        duplicateCheck+=new Character(firstRock.charAt(i)).toString();
                        count++;
                    }
                }
            
            }
            else
            {
                break;
            }
        }
    }
    return count;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Jay\\Desktop\\Selenium,Drivers and Cucumber\\test.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Gemstones.gemstonesCount(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
	}



