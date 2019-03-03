/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * Библиотека функций для работы с квадратными матрицами.
 * Содержит следующие методы:
 * - <b>creatMatrix</b> — создание матрицы
 * - <b>addition</b> — сложение 2х матриц
 * - <b>multiplication</b> — умножение 2х матриц
 * - <b>swapLine</b> — смена местами 2х строк матрицы
 * - <b>transpose</b> — транспонирование матрицы
 * - <b>gauss</b>— нахождение определителя методом Гаусса
 * - <b>matArrayCreate</b> — создание массива матриц
 * - <b>kramer</b> — решение СЛАУ методом Крамера
 * - <b>matArrayCreate</b> — создание массива матриц
 * @author группа: АС-10и2 студенты: Курганов И.Д., Иванов И.А.
 */
public class MatrixCalculator{
    	private MatrixCalculator() {
}
/**
 * Функция создания матрицы по уже имеющимся значениям
 * @param rows количество строк в матрице. Тип <b>int</b>
 * @param columns количество столбцов в матрице. Тип <b>int</b>
 * @param data двумерный массив данных, элементы которого будут занесены элементы матрицы. Тип <b>double [][]</b>
 * @return матрицу mt.Тип <b>Matrix</b>
 */        
public static Matrix creatMatrix(int rows, int columns, double[][] data){
    Matrix mt = Matrix.createMatrix(rows, columns);
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data[i].length; j++){
        mt.setElem(i, j, data[i][j]);
            }
        }
    return mt;
  }
/**
 * Функция сложения 2х матриц.
 * @param mt1 первое слагаемое. Тип <b>Matrix</b>
 * @param mt2 второе слагаемое. Тип <b>Matrix</b>
 * @return Матрицу, элементы которой — суммы соответствующих элементов матриц <b>mt1</b> и <b>mt2</b>. Тип <b>Matrix</b>
 */
public static Matrix addition(Matrix mt1, Matrix mt2) {
    int rows = mt1.getSize().getRows();
    int cols = mt1.getSize().getColumns();
    int rows2 = mt2.getSize().getRows();
    int cols2 = mt2.getSize().getColumns();
        if ((rows == rows2) && (cols == cols2)) {
            Matrix mt = Matrix.createMatrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                mt.setElem(i, j, mt1.getElem(i, j) + mt2.getElem(i, j));
                }
            }
    return mt;
} else {
    return null;
    }
  }
/**
 * Функция умножения 2х матриц
 * @param mt1 первое умножаемое. Тип <b>Matrix</b>
 * @param mt2 первое умножаемое. Тип <b>Matrix</b>
 * @return Матрицу, элементы которой — произведения соответствующих элементов матриц <b>mt1</b> и <b>mt2</b>. Тип <b>Matrix</b>
 */
public static Matrix multiplication(Matrix mt1, Matrix mt2) {
    int rows = mt1.getSize().getRows();
    int cols = mt1.getSize().getColumns();
    int rows2 = mt2.getSize().getRows();
    int cols2 = mt2.getSize().getColumns();
        if (cols == rows2) {
            Matrix mt = Matrix.createMatrix(rows, cols2);
            double tmp = 0;
            for (int i = 0; i < rows; i++) {
                for (int c = 0; c < cols2; c++) {
                    for (int j = 0; j < cols; j++) {
                    tmp = mt1.getElem(i, j) * mt2.getElem(j, c);
                    }
                mt.setElem(i, c, tmp);
                tmp = 0;
                }
            }
    return mt;
} else {
    return null;
    }
  }
/**
 * Функция смены местами 2х строк матрицы
 * @param swopLine номер строки, которую необходимо заменить строкой <b>targetLine</b>. Тип <b>int</b>
 * @param targetLine номер целевой строки, которой необходимо заменить строку <b>swopLine</b>. Тип <b>int</b>
 * @param mt1 матрица, в которой проводится замена строк. Тип <b>Matrix</b>
 * @return матрицу, в которой строки <b>swopLine</b> и <b>targetLine</b>, изменены местами
 */
public static Matrix swapLine(int swopLine, int targetLine, Matrix mt1) {
    int rows = mt1.getSize().getRows();
    int cols = mt1.getSize().getColumns();
    double tmp;
    int secondLine = targetLine;
        for (int firstLine=swopLine; swopLine<rows; swopLine++) {
            for (int j=0; j<cols; j++) {
                tmp = mt1.getElem(firstLine, j);
                mt1.setElem(firstLine, j, mt1.getElem(secondLine, j));
                mt1.setElem(secondLine, j, tmp);
            }
        }
    return mt1;
}
/**
 * Функция транспонирования матрицы
 * @param mt1 тарнспонируемая матрица. Тип <b>Matrix</b>
 * @return тарнспонированную матрицу. Тип <b>Matrix</b>
 */
public static Matrix transpose (Matrix mt1) {
    int rows = mt1.getSize().getRows();
    int cols = mt1.getSize().getColumns();
    Matrix mt = Matrix.createMatrix(rows, cols);
    double tmp = 0;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                tmp = mt1.getElem(i, j);
                mt.setElem(j, i, tmp);
                tmp = 0;
            }
        }
    return mt;
} 
/**
 * Функция нахождения определителя матрицы методом Гаусса
 * @param mt1 матрица, определитель которой необходимо найти. Тип <b>Matrix</b>
 * @return result — значение определителя матрицы. Тип <b>double</b> 
 */
public static double gauss (Matrix mt1) {
    int rows = mt1.getSize().getRows();
    int cols = mt1.getSize().getColumns();
    double result = 1;
    int count;
    /*копируем полученную матрицу в "рабочую" матрицу mt (Она обрабатывается 
     в циклах)*/
    Matrix mt = new Matrix();
    mt.setSize(rows, cols);
    for (int i=0; i<rows; i++){
        for (int j=0; j<cols; j++){
            mt.setElem(i, j, mt1.getElem(i, j));
        }
    }
    /*копируем полученную матрицу в "статическую" матрицу mt2, в неё 
     копируется "рабочая матрица" mt, после зануления очередного столбца*/
    Matrix mt2 = new Matrix();
    mt2.setSize(rows, cols);
    for (int i=0; i<rows; i++){
        for (int j=0; j<cols; j++){
            mt2.setElem(i, j, mt1.getElem(i, j));
        }
    }
    /*Матрицы mt и mt2 необходимы, чтобы не испортить получаемую матрицу mt1,
    которая может быть использована в других областях программы
    строим треугольную матрицу*/
    for (int i=0; i<cols; i++){
        
        //проверка на НЕнулевой i-тый элемент строки
        if (mt.getElem(i, i)==0 && i<rows-1)
        {
        count = i;
            do{
            mt.getElem(count, 0);
            count++;
            }while(mt.getElem(count, 0) == 0);
        mt = MatrixCalculator.swapLine(i, count, mt);
        result = -result; // Если была совершена перестановка — 
        }                 // меняем знак определителя
        
        /*копирование "рабочей" матрицы в "статическую", необходимо 
        для корректного расчета коофициентов умножения строк перед вычитанием*/
        for (int x=0; x<rows; x++){
            for (int y=0; y<cols; y++){
                mt2.setElem(x, y, mt.getElem(x, y));
            }
        }
        
        //зануление i-того столбца         
        for (int j=i+1; j<rows; j++){
            for (int k=i; k<cols; k++){
                double tmp = mt.getElem(j, k)-((mt.getElem(i, k)*mt2.getElem(j, i))/mt.getElem(i, i));
                mt.setElem(j, k, tmp);
            }                
        }
        
    }
    //Вычисление определителя
    for (int x=0; x<rows; x++){
        result = result*mt.getElem(x, x);
    }
 
    return result;
}
/**
 * Функция решения СЛАУ методом Крамера
 * @param mt1 коофиценты СЛАУ. Тип <b>Matrix</b>
 * @param ans массив ответов СЛАУ. Тип <b>double []</b>
 * @return <b>xArr</b> — массив корней СЛАУ. Тип <b>double []</b>
 */
public static double [] kramer (Matrix mt1, double [] ans) {
    int rows = mt1.getSize().getRows();
    int cols = mt1.getSize().getColumns();
    double [] xArr = new double[rows];
    Matrix mtDet = new Matrix();
    mtDet.setSize(rows, cols);  
    for (int i=0; i<rows; i++){
        /*Копирование входной матрицы во временную, для нахождения определителя
         */
        for (int x=0; x<rows; x++){
            for (int y=0; y<cols; y++){
                mtDet.setElem(x, y, mt1.getElem(x, y));
            }
        }
        
    }
    //Нахождение Главного определителя
    double det = MatrixCalculator.gauss(mtDet);
    Matrix mt = new Matrix();
    mt.setSize(rows, cols);
    //Копирование входной матрицы mt1 в "рабочую" mt
    for (int i=0; i<rows; i++){
        for (int x=0; x<rows; x++){
            for (int y=0; y<cols; y++){
                mt.setElem(x, y, mt1.getElem(x, y));
            }
        }
        //замена j-того столбца, столбцом ответов
        for (int j=0; j<cols; j++){
            mt.setElem(j, i, ans[j]);
        }
        //Нахождение корней СЛАУ
        xArr[i] = MatrixCalculator.gauss(mt)/det;
    }
    return xArr;
}
/**
 * Функция создания массива матриц
 * @param qty количество элементов массива. Тип <b>int</b>
 * @return <b>matArray</b> — массив матриц. Тип <b>Matrix []</b>
 */
public static Matrix [] matArrayCreate (int qty) {
    Scanner scan = new Scanner(System.in);
    Matrix [] matArray = new Matrix[qty];
    Random rand = new Random();
    System.out.println("Массив будет наполнен случайными числами");
    //сделано для удобства, руками долго вбивать
        for (int i=0; i<qty; i++){
            int number = i+1;
            System.out.println("Введите размерность "+number+" матрицы — элемента массива:");
            int matSize = scan.nextInt();
            Matrix mat = new Matrix();
            mat.setSize(matSize, matSize);
                for (int j=0; j<matSize; j++){
                    for (int k=0; k<matSize; k++){                        
                        mat.setElem(j, k, rand.nextInt(30)-15);
                    }
                }
            matArray[i]=mat;
        }
    return matArray;
}

}
