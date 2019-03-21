class InvalidArraySizeException extends Exception {
    int id;

    public InvalidArraySizeException(int _id){ id = _id; }

    public String toString() {
        return "Exception " + id + ". Array is invalid.";
    }
}

class InvalidArrayElementException extends Exception {
    int id;

    public InvalidArrayElementException(int _id){ id = _id; }

    public String toString() {
        return "Exception " + id + ". Element of array is invalid.";
    }
}

class NoSuchPairInArrayException extends Exception {
    int id;

    public NoSuchPairInArrayException(){ }

    public String toString() {
        return "No such pair in array.";
    }
}

