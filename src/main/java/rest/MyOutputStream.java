package rest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyOutputStream extends ObjectOutputStream {

    public MyOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MyOutputStream() throws IOException, SecurityException {
    }

    @Override
    public void writeStreamHeader() throws IOException{
        return;
    }
}
