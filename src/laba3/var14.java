package laba3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 * ������� 14.
 ������ � ������� n ����� ����� � ��������� �� � ������. ����� ����� ��� ��������� ����� � ������� �� �������:
 ������� ����� ����������, �������� ������� � ������ � �������� ������� ���������.  
 */
public class var14 {
    public static String revers1(Integer number)
    {
        StringBuilder temp = new StringBuilder(number.toString());
        return temp.reverse().toString();
    }
    public static void main(String[] args) throws Exception {

    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	out.print("Enter N: ");
        int n = Integer.parseInt(reader.readLine());
        int[] mas = new int[n];
        
        for (int i = 0; i < n; i++){
        	
            mas[i] = Integer.parseInt(reader.readLine());
        
        }
        out.println("����������:");
        for (int i = 0; i < n; i++){
        	
            String str = revers1(mas[i]);
            String str1 = Integer.toString(mas[i]);
            if (str.equals(str1))
                out.println(mas[i]);
        }
    }
    
}