/**
 * 算法名称：矩阵内部的某些算法
 * 算法思想：   
 *     矩阵相乘，矩阵a的列数和矩阵b的行数必须一样
 * @version 1.0 2015-03-04
 * @author Gin
 */
package com.xujin.fundamentals;

public class matrixAlgorithms {
	public static void main(String...args){
		matrixAlgorithms ma = new matrixAlgorithms();
		double[][] a = {{1,2,3},{3,4,5},{5,6,7},{1,2,3},{4,5,6}};//4*3
		double[][] b = {{3,2,1},{5,4,3},{7,6,5}};//3*3 
		Matrix bMatrix = ma.new Matrix(b);
		Matrix aMatrix = ma.new Matrix(a);
		System.out.printf("相乘：\n%s",aMatrix.mul(bMatrix).toString());
	}
	
	public class Matrix{
		public double[][] value;
		public int row;
		public int col;
		
		
		public double[][] getValue() {
			return value;
		}

		public void setValue(double[][] value) {
			this.value = value;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		public Matrix(double[][] value){
			this.value = value;
			this.row = value.length;
			this.col = value.length == 0 ? 0 : value[0].length;
		}
		
		public String toString(){
			String res = "";
			for(int i=0; i <this.row; i++){
				for(int j=0; j<this.col; j++){
					res += this.value[i][j] + " ";
				}
				res += "\n";
			}
			return res;
		}
		
		public Matrix mul(Matrix other){
			if(this.getCol() != other.getRow()){
				System.out.print("两个矩阵无法相乘！");
				System.exit(0);
			}
			
			double[][] res = new double[this.getRow()][other.getCol()];
			for(int i=0; i <this.getRow(); i++){
				for(int j=0; j<other.getCol(); j++){
					double item = 0;
					for(int m=0; m<this.getCol(); m++){
						item += this.getValue()[i][m] * other.getValue()[m][j];
					}
					res[i][j] = item;
				}
			}
			
			return new Matrix(res);
		}
	}
	
	
}

