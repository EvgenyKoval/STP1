package laba3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 * Вариант 14.
 Ввести с консоли n целых чисел и поместить их в массив. Найти среди них указанные числа и вывести на консоль:
 вывести числа полиндромы, значения которых в прямом и обратном порядке совпадают.  
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
        out.println("Polindroms:");
        for (int i = 0; i < n; i++){
        	
            String str = revers1(mas[i]);
            String str1 = Integer.toString(mas[i]);
            if (str.equals(str1))
                out.println(mas[i]);
        }
    }
    
}