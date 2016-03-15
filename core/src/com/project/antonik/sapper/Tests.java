package com.project.antonik.sapper;


public class Tests {
	//Вывод в консоль значений массивов
	public static void printArray(int[][] array) {
		for (int j=GameField.getInstance().HEIGHT-1; j > -1; j--){	
				for (int i=0; i < GameField.getInstance().WIDTH; i++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
