import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 
{
    public static void main(String[] args) throws Exception 
    {
        String[] data = readData("Data.txt");
        for (String string : data) 
        {
           System.out.println(string); 
        }
        int finalNumber = returnNumber(data);
        System.out.println(finalNumber);
    }

    public static String[] readData (String dataFile) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));

        int numberOfLines = 0;
        String synonymLine = reader.readLine();

        while (synonymLine != null)
        {
        numberOfLines++;
        synonymLine = reader.readLine();
        }
        reader.close();

        String[] data = new String[numberOfLines];
        reader = new BufferedReader(new FileReader(dataFile));

        for (int i = 0; i < numberOfLines; i++)
        {
        data[i] = reader.readLine();
        }
        reader.close();
        return data;
    }

    public static int returnNumber (String[] data)
    {
        int number = 0;
        for (String string : data) 
        {
            int i = 0;
            char[] charA = string.toCharArray();
            for (char c : charA) 
            {
                if (c>='1'&&c<='9')
                {
                    i++;
                }
            }
            if (i>=1)
            {
                char[] numbers = new char[i];
                int b = 0;
                String number1 = "";
                for (char c : charA) 
                {
                    if (c>='1'&&c<='9')
                    {
                        numbers[b]= c;
                        b++;
                    }
                }
                if (i>=2)
                {
                    number1+=""+numbers[0]+numbers[i-1];
                }
                else if (i==1)
                {
                    number1+=""+numbers[0] + numbers[0];
                }
                number += Integer.parseInt(number1);
            }
        }
        return number;
    }
}
