/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 * Класс <b>Matrix</b> содержит реализацию основных действий с матрицами
 * @author группа: АС-10и2 студенты: Курганов И.Д., Иванов И.А.
 */
public class Matrix implements Comparable<Matrix> {
    private double[][] matrix;
    
    /**
     * Конструктор по умолчанию
     */
    public Matrix(){
  }
/**
 * Функция установки размера матрицы
 * @param rows количество строк в матрице. Тип <b>int</b>
 * @param columns количество столбцов в матрице. Тип <b>int</b>
 */
public void setSize(int rows, int columns){
    matrix = new double[rows][columns];
  }
/**
 * Функция получения размера матрицы, необходима, например, при создании
 * новой матрицы, для установления размера
 * @return размер матрицы. Тип <b>MatrixSize</b>
 */
public MatrixSize getSize(){
    int rows = matrix.length;
    int columns = matrix[0].length;
    return new MatrixSize(rows, columns);
  }
/**
 * Функция для установления значения элемента матрицы
 * @param rowNum номер строки в матрице. Тип <b>int</b>
 * @param colNum номер столбца в матрице. Тип <b>int</b>
 * @param value новое значение элемента массива с указанными координатами. Тип <b>double</b>
 */
public void setElem(int rowNum, int colNum, double value){
    matrix[rowNum][colNum] = value;
  }
/**
 * Функция получения значения элемента матрицы
 * @param rowNum номер строки в матрице. Тип <b>int</b>
 * @param colNum номер столбца в матрице. Тип <b>int</b>
 * @return значение элемента массива с указанными координатами. Тип <b>double</b>
 */
public double getElem(int rowNum, int colNum){
    return matrix[rowNum][colNum];
  }
/**
 * Функция получения определителя матрицы. Основана на методе <b>Gauss</b>, класса <b>MatrixCalculator</b>.
 * Сделана для удобства
 * @param mt1 матрица, опредеелитель которой необходимо вычислить. Тип <b>Matrix</b>
 * @return det - значение определителя матрицы. Тип <b>double</b>
 */
public double getDet(Matrix mt1){
    double det = MatrixCalculator.gauss(mt1);
    return det;
}
/**
 * Функция создания  новой матрицы (конструктор с параметрами). 
 * @param rows количество строк в матрице. Тип <b>int</b>
 * @param columns количество столбцов в матрице. Тип <b>int</b>
 * @return mt - матрицу, с указанными размерами. Тип <b>Matrix</b>
 */
public static Matrix createMatrix(int rows, int columns){
    Matrix mt = new Matrix();
    mt.setSize(rows, columns);
    return mt;
  }
/**
 * Функция приведения матрицы к строке.
 * @return Представленную в виде строки матрицу.
 */
    @Override
public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<matrix.length; i++){
    for(int j=0; j<matrix[i].length; j++){
    sb.append(matrix[i][j] + "   ");
  }
    
    sb.append("\n");
  }
    
return sb.toString();
}
/**
 * Функция сравнения объектов
 * Необходима для метода <b>Array.sort</b>, который сортирует по возрастанию
 * элементы массива матриц.
 * @param mat матрица сравниваемая с текущей матрицей — элементом массива
 * @return -1 — текущая матрица меньше полученной, 0 — равна, 1 — больше
 */
    @Override
public int compareTo(Matrix mat) {
   Matrix tmp = (Matrix)mat;
    if(this.getDet(this) < tmp.getDet(tmp))
      {
        /* текущее меньше полученного */
        return -1;
      }   
        else if(this.getDet(this) > tmp.getDet(tmp))
      {
        /* текущее больше полученного */
        return 1;
      }
        /* текущее равно полученному */
        return 0;  
   }
/**
 * Класс для работы с размерами матриц
 */
public class MatrixSize{
    private int rows, columns;
/**
 * Конструктор с парамерами
 * @param rows количество строк в матрице. Тип <b>int</b>
 * @param columns количество столбцов в матрице. Тип <b>int</b>
 */    
public MatrixSize(int rows, int columns){
    this.rows = rows;
    this.columns = columns;
}
/**
 * Функция для получения значения количества строк в матрице
 * @return Количество строк. Тип <b>int</b>
 */
public int getRows(){
    return this.rows;
}
/**
 * Функция для получения значения количества столбцов в матрице
 * @return Количество столбцов. Тип <b>int</b>
 */
public int getColumns(){
    return this.columns;
}
}
}
