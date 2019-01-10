package Main;

import java.io.*;

public class SaveLoad {

    public static void save(Serializable data) throws Exception{
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("save.bin"));
        save.writeObject(data);
    }

    public static SaveData load() throws Exception{
        ObjectInputStream load = new ObjectInputStream(new FileInputStream("save.bin"));
        SaveData loadedSave = (SaveData) load.readObject();
        return loadedSave;
    }
}
