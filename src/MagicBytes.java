
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MagicBytes {
    // Создаем HashMap для хранения сигнатур файлов
    private static final HashMap<String, String> signatures = new HashMap<>();

    // Добавляем сигнатуры для каждого типа файла в словарь
    static {
        signatures.put("gif", "47 49 46 38");
        signatures.put("exr", "76 2f 31 1");
        signatures.put("exe", "4d 5a");
        signatures.put("png", "89 50 4e 47");
        signatures.put("pdf", "25 50 44 46 2d");
        signatures.put("jpg", "ff d8 ff e0");
        signatures.put("rar", "52 61 72 21");
    }

    // Создаем метод, с помощью которого читаем сигнатуру из содердержимого байт-кода файла
    public static StringBuilder readSignature(FileInputStream fileInputStream) throws IOException {

        // Создаем переменную для записи сигнатуры
        StringBuilder signature = new StringBuilder(" ");

        // Считываем первые 8 байт из файла
        for (int i = 0; i < 8; i++) {
            int bit = fileInputStream.read();

            // Преобразуем каждый байт в шестнадцатеричную строку и добавляем к магическому числу(сигнатуры)
            assert false;
            signature.append(Integer.toHexString(bit));
            if (i < 7) {

                // добавляем пробел между каждым байтом в сигнатуре
                signature.append(" ");
            }
        }
        return signature; // возвращаем сигнатуру в виде объекта StringBuilder
    }

    // Для определения типа файла по его сигнатуре, передаем сигнатуру в метод
    // Возвращается тип файла или null, если сигнатура не найдена в словаре
    public static String detectFileType(String signature) {
        for (Map.Entry<String, String> entry : signatures.entrySet()) {
            // Проверяем, есть ли в сигнатуре нашего файла сигнатура расширений, прописанных в словаре
            if (signature.contains(entry.getValue())) {

                return entry.getKey(); // Возвращаем тип файла
            }
        }
        return null; // Сигнатура не найдена
    }

}
