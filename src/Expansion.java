import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Expansion {
    public static void expansion() throws IOException {
        do {
            // Создаем объект класса Scanner для чтения данных с клавиатуры
            Scanner scanner = new Scanner(System.in);

            // Выводим сообщение с просьбой ввести путь к файлу
            System.out.println("Введите путь к файлу, для которого хотите определить расширение: ");

            // Считываем введенную строку с помощью метода nextLine()
            String filePath = scanner.nextLine();

            // Создаем объект класса File с указанным путем
            File file = new File(filePath);

            // Проверяем, не является ли введенный пользователем путь папкой
            if (file.isDirectory()) {
                System.out.println("Вы ввели путь к папке. Пожалуйста, введите путь к файлу вновь.");
                return;
            }

            // Убеждаемся, что файл существует
            if (!file.exists()) {
                System.out.println("Файл не найден. Проверьте правильность написания названия файла.");
                return;
            }

            // Открываем файл для чтения
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // Создаем строковую переменную для хранения магического числа (сигнатуры) и записываем ее туда с помощью readSignature
            String signature = String.valueOf(MagicBytes.readSignature(fileInputStream));

            // Закрываем файл
            fileInputStream.close();

            //Записываем в переменную итог выполнения метода detectFileType из класса MagicBytes
            String fileType = MagicBytes.detectFileType(signature);

            // Определяем, удалось ли определить тип файла
            if (fileType == null) {
                System.out.println("Тип файла не определен. Напоминание! Программа работает со следующими расширениями: " +
                        "gif, exr, exe, png, pdf, jpg, rar.");
                return;
            }

            // Выводим тип файла на экран
            System.out.println("Тип файла: " + fileType);

            // Записываем имя файла в новую переменную
            String fileName = file.getName();

            // Проверяем, есть ли у файла уже расширение в имени
            if (HasExtension.hasExtension(fileName)) {
                System.out.println("У файла в названии уже было расширение, поэтому изменений не производилось.");
                return;
            }

            // Получаем путь к директории файла
            String parentDirectory = file.getParent();

            // Добавляем к названию файла его расширение
            fileName = fileName + "." + fileType;

            // Создаем объект класса File для нового имени файла с тем же путем к директории
            File newFile = new File(parentDirectory + File.separator + fileName);

            // Переименовываем файл с использованием метода renameTo()
            boolean renamed = file.renameTo(newFile);

            // Проверяем, успешно ли прошло переименование
            if (renamed) {
                System.out.println("Файл успешно переименован. Теперь он записан со своим расширением. ");
            } else {
                System.out.println("Не удалось переименовать файл.");
                break;
            }
        } while (true);
    }

    // Определяем работу программы после ввода пользователем своего ответа
    public static boolean yesOrNo(String continuationOfWork) throws IOException {
        if (Objects.equals(continuationOfWork, "Да")) {
            Expansion.expansion();
            return true;
        } else if (Objects.equals(continuationOfWork, "Нет")) {
            System.out.println("Работа программы завершена.");
            return false;
        } else {
            System.out.println("Некорректный ввод. Попробуйте еще раз.");
            return true;
        }
    }
}