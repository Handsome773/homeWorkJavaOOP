import java.io.*;

public class FileHandler implements SaveLoad {

    public void saveTo(Object obj, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public Object loadFrom(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}