
class Matrix<T>{
    private T[][] matrix;
    private int columns;
    private int rows;

    public Matrix(T[][] _matrix)
    {
        matrix = _matrix;
        columns = matrix.length;
        rows = matrix[0].length;
    }

    public T get(int column, int row)
    {
        return matrix[column][row];
    }

    public int columns(){
        return columns;
    }
    public int rows(){
        return rows;
    }

    public void add(Matrix<T> _matrix)
    {
        T type =_matrix.get(0,0);
        if(type  instanceof String ) {
            if(_matrix.rows() != this.rows || _matrix.columns() != this.columns) {
                System.out.println("you cant do that ):");
                return;
            }
            //System.out.println("to je string");
            for(int i = 0; i < _matrix.columns(); i++)
            {
                for(int j = 0; j < _matrix.columns(); j++)
                {
                    //this.matrix[i][j] = matrix[i][j] + _matrix[i][j];
                }
            }
        }
        else
        {
            for(int i = 0; i < _matrix.columns(); i++)
            {
                for(int j = 0; j < _matrix.columns(); j++)
                {
                    //this.matrix[i][j] = Double.parseDouble(matrix[i][j] ) + _matrix[i][j];
                }
            }
        }
    }
}
public class main1 {

    public static void main(String[] args){
        String[][] string1 = {{"a", "b"}};
        String[][] string2 = {{"k", "c"}};
        Matrix<String> M1 = new Matrix<String>(string1);
        Matrix<String> M2 = new Matrix<String>(string2);
        M1.add(M2);
    }

}
