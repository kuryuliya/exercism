class CircularBuffer<T> {
    private final T[] buffer;
    private final int capacity;
    private int size;
    private int readIndex;
    private int writeIndex;

    @SuppressWarnings("unchecked")
    CircularBuffer(final int size) {
        this.capacity = size;
        this.buffer = (T[]) new Object[size];
        this.size = 0;
        this.readIndex = 0;
        this.writeIndex = 0;
    }

    T read() throws BufferIOException {
        if (size == 0) {
            throw new BufferIOException("Tried to read from empty buffer");
        }
        
        T data = buffer[readIndex];
        buffer[readIndex] = null;
        readIndex = (readIndex + 1) % capacity;
        size--;
        return data;
    }

    void write(T data) throws BufferIOException {
        if (size == capacity) {
            throw new BufferIOException("Tried to write to full buffer");
        }
        
        buffer[writeIndex] = data;
        writeIndex = (writeIndex + 1) % capacity;
        size++;
    }

    void overwrite(T data) {
        if (size < capacity) {
            buffer[writeIndex] = data;
            writeIndex = (writeIndex + 1) % capacity;
            size++;
        } else {
            buffer[writeIndex] = data;
            writeIndex = (writeIndex + 1) % capacity;
            readIndex = (readIndex + 1) % capacity;
        }
    }

    void clear() {
        for (int i = 0; i < capacity; i++) {
            buffer[i] = null;
        }
        size = 0;
        readIndex = 0;
        writeIndex = 0;
    }
}