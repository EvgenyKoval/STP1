package laba4;

import static java.lang.System.out;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *���������� ����� Matrix ����������� (n x n).
 *�������� ������ �� m ��������.
 *�������� ������� � �����, �������� ������� ������ � ������������ � ����������� ���������� k-�� �������.
 *������� ����� ������� � ������ �����.
 */
public class var14 
{
	//�����, �������� ������� ������ � ������������ � ����������� ���������� k-�� �������
    public static Matrix function(Matrix a,byte k)
    {    	
        byte min=a.mas[0][k];	
        byte minPosition=0;
        byte max=min;
        byte maxPosition=0;
        for (byte i = 0; i < a.mas.length; i++ )	//���������� maxPosition � minPosition
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
        for (byte i = 0; i <a.mas.length; i++)				//������ ������� ������
        {				
            byte c = a.mas[minPosition][i];					//
            a.mas[minPosition][i] = a.mas[maxPosition][i];	//
            a.mas[maxPosition][i] = c;
        }
        out.printf("maxPosition = %d, minPosition = %d\n",maxPosition, minPosition);	//����� maxPosition � minPosition
        return a;
    }
    
//�����, ��������� ������
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
    	
        private byte mas[][];			//���������� �������
        Matrix(byte n)
        {					//�����������
            mas = new byte[n][n];		//��������� ������ ��� ������ n �� n
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (byte i = 0; i < n; i++)
                for (byte j = 0; j < n; j++)
                {
                    try
                    {
                        out.printf("������� mas[%d][%d]\n", (i+1),(j+1));		//���� �������� � ������
                        mas[i][j]  = Byte.parseByte(reader.readLine());			//
                    } 
                    catch (Exception e)
                    {										//���� ���������� �������� ���
                        out.println("������ ����� " + e);						//������ �����
                        mas[i][j] = (byte) ( ( Math.random() * 1000 ) % 128);	//
                    }
                }
        }
    }
    
    
    public static void main(String[] args)
    {
    	
        byte n = 0, m = 0, k = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
//���� ����������� Matrix[n][n], ������� �������� Matrix[m] � ����� ������� ��� ������ min � max ��������
        try 
        {
            out.println("������� n:");
            n = (byte) abs(Byte.parseByte(reader.readLine()));		//���� n = |n| �.�. ����������� �� ����� ���� �������������
        } 
        catch (Exception e)
        {
            out.println("������ �����:" + e);
            n = (byte) ( ( Math.random() * 100 ) % 11);			//���� ���������� �������� ��� ������ �����
            out.printf("n = %d\n", n);
        }
        try 
        {
            out.println("������� m:");
            m = (byte) abs(Byte.parseByte(reader.readLine()));		//���� m = |m| �.�. ����������� �� ����� ���� �������������
        }
        catch (Exception e)
        {
            out.println("������ �����:" + e);
            m = (byte) ( ( Math.random() * 100 ) % 11);			//���� ���������� �������� ��� ������ ����� 
            out.printf("m = %d\n", m);
        }
        try 
        {
            out.println("������� ����� �������:");
            k = (byte) abs(Byte.parseByte(reader.readLine()));		//���� k = |k| �.�. ����������� �� ����� ���� �������������
            if (k >= n)												//�������� k ������ ���� � ��������� [0, n - 1]
                k = (byte) (n - 1); 								//
        } 
        catch (Exception e) 
        {
            out.println("������ �����:" + e);						//��� ������ ����� k = 0
            k = 0;      
        }
        
        if (n != 0 && m != 0)
        {
            Matrix[] mass = new Matrix[m]; //���������� ������� �������� ����������� m
            for (byte i = 0; i < m; i++)
            {
                mass[i] = new Matrix(n);	//������������� ������� ��������
            }

            for (byte i = 0; i < mass.length; i++)
            {
                print_mas(mass[i],"������ �",i); //����� ������� �� �������
                mass[i] = function(mass[i],k);	// ����� ������, (������ �� �������, ����� �������)
                out.println();					
                print_mas(mass[i],"����� ������ �",i);	//����� ������ ������� �� �������
                out.println("#########################");
            }

            out.printf("mass.length=%d, mass[0].mas.length=%d, mass[0].mas[0].length=%d\n"	//����� �����������
                       ,mass.length,    mass[0].mas.length,    mass[0].mas[0].length);
        }        
        else 
            out.println("m � n �� ����� ���� ����� 0");            
    }
    
}