package laba3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class var11 {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		try{
			System.out.println("Введите n:");
			n =  Integer.parseInt(reader.readLine());
		}catch (Exception e){
			n = (int) (Math.random() * 100);
			System.out.printf("n = %d\n", n);
		}
		ArrayList<Integer> simpleNumber = new ArrayList<Integer>();
		int [] mas = new int[n];		
		for (int i = 0; i < mas.length; i++) {
			try{
				System.out.printf("Введите число №%d\n", (i + 1));
				mas[i] = Integer.parseInt(reader.readLine());			
			}catch(Exception e){
				mas[i] = (int) (Math.random() * 1000);
			}
		}
		System.out.print("Не простые числа:");
		for (int i = 0; i < mas.length; i++) {
			for (int j = 2; j < mas[i]; j++) {
				if (mas[i] % j == 0) {
					System.out.printf(" %d", mas[i]);
					break;
				}
				if (mas[i] == j + 1) simpleNumber.add(mas[i]);
			}
		}
		System.out.print("\nПростые числа:");
		for (int i = 0; i < simpleNumber.size(); i++) {
			System.out.printf(" %d", simpleNumber.get(i));
		}
	}

}
