package laba4;

import static java.lang.System.out;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *Определить класс Matrix размерности (n x n).
 *Объявить массив из m объектов.
 *Передать объекты в метод, меняющий местами строки с максимальным и минимальным элементами k-го столбца.
 *Вывести новые матрицы и номера строк.
 */
public class var14 
{
	//метод, меняющий местами строки с максимальным и минимальным элементами k-го столбца
    public static Matrix function(Matrix a,byte k)
    {    	
        byte min=a.mas[0][k];	
        byte minPosition=0;
        byte max=min;
        byte maxPosition=0;
        for (byte i = 0; i < a.mas.length; i++ )	//нахождение maxPosition и minPosition
        {	
            if (min>a.mas[i][k])
            {										//
                min = a.mas[i][k];					//
                minPosition = i;					//
            }
            if (max<a.mas[i][k])
            {										//	
                max = a.mas[i][k];					//
                maxPosition = i;					//
            }
        }
        if (maxPosition != minPosition)
        for (byte i = 0; i <a.mas.length; i++)				//меняем местами строки
        {				
            byte c = a.mas[minPosition][i];					//
            a.mas[minPosition][i] = a.mas[maxPosition][i];	//
            a.mas[maxPosition][i] = c;
        }
        out.printf("maxPosition = %d, minPosition = %d\n",maxPosition, minPosition);	//вывод maxPosition и minPosition
        return a;
    }
    
//метод, выводящий массив
    public static void print_mas(Matrix mass,String text,byte i)
    {
    	
            out.println(text + (i+1));
            for (byte j = 0; j < mass.mas.length; j++) 
            {
                for (byte k = 0; k < mass.mas[j].length; k++)
                {
                    out.print(mass.mas[j][k]);
                    if (k+1 !=mass.mas[j].length)
                        out.print("\t||\t");
                }
                out.println();
            }
            out.println();
    }
    
    public static class Matrix
    {
    	
        private byte mas[][];			//объявление массива
        Matrix(byte n)
        {					//конструктор
            mas = new byte[n][n];		//выделение памяти под массив n на n
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (byte i = 0; i < n; i++)
                for (byte j = 0; j < n; j++)
                {
                    try
                    {
                        out.printf("Введите mas[%d][%d]\n", (i+1),(j+1));		//ввод значение в массив
                        mas[i][j]  = Byte.parseByte(reader.readLine());			//
                    } 
                    catch (Exception e)
                    {										//ввод случайного значения при
                        out.println("Ошибка ввода " + e);						//ошибке ввода
                        mas[i][j] = (byte) ( ( Math.random() * 1000 ) % 128);	//
                    }
                }
        }
    }
    
    
    public static void main(String[] args)
    {
    	
        byte n = 0, m = 0, k = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
//ввод размерности Matrix[n][n], массива объектов Matrix[m] и номер столбца для поиска min и max значений
        try 
        {
            out.println("Введите n:");
            n = (byte) abs(Byte.parseByte(reader.readLine()));		//ввод n = |n| т.к. размерность не может быть отрицательной
        } 
        catch (Exception e)
        {
            out.println("Ошибка ввода:" + e);
            n = (byte) ( ( Math.random() * 100 ) % 11);			//ввод случайного значения при ошибке ввода
            out.printf("n = %d\n", n);
        }
        try 
        {
            out.println("Введите m:");
            m = (byte) abs(Byte.parseByte(reader.readLine()));		//ввод m = |m| т.к. размерность не может быть отрицательной
        }
        catch (Exception e)
        {
            out.println("Ошибка ввода:" + e);
            m = (byte) ( ( Math.random() * 100 ) % 11);			//ввод случайного значения при ошибке ввода 
            out.printf("m = %d\n", m);
        }
        try 
        {
            out.println("Введите номер столбца:");
            k = (byte) abs(Byte.parseByte(reader.readLine()));		//ввод k = |k| т.к. размерность не может быть отрицательной
            if (k >= n)												//значение k должно быть в интервале [0, n - 1]
                k = (byte) (n - 1); 								//
        } 
        catch (Exception e) 
        {
            out.println("Ошибка ввода:" + e);						//при ошибке ввода k = 0
            k = 0;      
        }
        
        if (n != 0 && m != 0)
        {
            Matrix[] mass = new Matrix[m]; //объявление массива объектов размерности m
            for (byte i = 0; i < m; i++)
            {
                mass[i] = new Matrix(n);	//инициализация массива объектов
            }

            for (byte i = 0; i < mass.length; i++)
            {
                print_mas(mass[i],"Массив №",i); //вывод объекта из массива
                mass[i] = function(mass[i],k);	// вызов матода, (объект из массива, номер столбца)
                out.println();					
                print_mas(mass[i],"Новый массив №",i);	//вывод нового объекта из массива
                out.println("#########################");
            }

            out.printf("mass.length=%d, mass[0].mas.length=%d, mass[0].mas[0].length=%d\n"	//вывод размерности
                       ,mass.length,    mass[0].mas.length,    mass[0].mas[0].length);
        }        
        else 
            out.println("m и n не могут быть равны 0");            
    }
    
}