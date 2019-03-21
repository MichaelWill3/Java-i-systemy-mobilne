import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Matrix<T> implements Iterable<T> {
    private T[][] matrix;
    private int rows;
    private int columns;
    int iteratorRows = 0;
    int iteratorColumns = 0;



    Matrix(T[][] _matrix, int _sizeC, int _sizeR)
    {
        matrix = _matrix;
        rows = _sizeR;
        columns = _sizeC;
    }

    public boolean hasNext() {

        return false;
    }

    public T next() {

        return null;
    }
    public void add(Matrix<T> _matrix)
    {
        for(T element : _matrix)
        {

        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
