package z1;
public class Matrix {
    private int width;
    private int height;
    private double[] matrix;

    public double[] values() {return matrix;}
    Matrix(){}
    public void add(double[] _matrix)
    {
        for(int i = 0; i < width*height; i++)
        {
            matrix[i] = matrix[i] + _matrix[i];
        }
    }

    public Matrix(int _width, int _height, double[] _matrix) {
        width = _width;
        height = _height;
        matrix = _matrix;
    }
}
