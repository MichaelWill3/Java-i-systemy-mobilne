class InvalidInputException extends Exception {
    String msg;

    public InvalidInputException(String _s){ msg = _s; }

    public String toString() {
        return msg;
    }
}
