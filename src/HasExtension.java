public class HasExtension {
    // Метод, который возвращает true, если у файла в названии прописано расширение
    public static boolean hasExtension(String fileName) {
        // Ищем последнюю точку в имени файла
        int dotIndex = fileName.lastIndexOf(".");

        // Проверяем, что точка есть и не является последним символом в имени файла
        return dotIndex > 0 && dotIndex < fileName.length() - 1;
    }

}
