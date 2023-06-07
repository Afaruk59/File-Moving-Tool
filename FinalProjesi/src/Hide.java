import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class Hide {

    String dizinYolu;

    public Hide(String dizinYolu) {
        super();
        this.dizinYolu = dizinYolu;
    }

    //Main classından çağırıldığında dizindeki txt dosyalarını gizleyen fonksiyon
    public void hideTxt() throws IOException{

        File dizin = new File(dizinYolu);
        if (dizin.isDirectory()) {
            File[] dosyalar = dizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().endsWith(".txt")) {

                    Path p = Paths.get(dizinYolu + dosya.getName());

                    Files.setAttribute(p, "dos:hidden", true);

                }
            }
            System.out.println("Tum txt dosyalari gizli hale getirildi.");
        } else {
            System.out.println("Belirtilen yol bir dizin değil.");
        }

    }

    //Main classından çağırıldığında dizindeki pdf dosyalarını gizleyen fonksiyon
    public void hidePdf() throws IOException{

        File dizin = new File(dizinYolu);
        if (dizin.isDirectory()) {
            File[] dosyalar = dizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().endsWith(".pdf")) {

                    Path p = Paths.get(dizinYolu + dosya.getName());

                    Files.setAttribute(p, "dos:hidden", true);

                }
            }
            System.out.println("Tum pdf dosyalari gizli hale getirildi.");
        } else {
            System.out.println("Belirtilen yol bir dizin değil.");
        }

    }

    //Main classından çağırıldığında dizindeki docx dosyalarını gizleyen fonksiyon
    public void hideDocx() throws IOException{

        File dizin = new File(dizinYolu);
        if (dizin.isDirectory()) {
            File[] dosyalar = dizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().endsWith(".docx")) {

                    Path p = Paths.get(dizinYolu + dosya.getName());

                    Files.setAttribute(p, "dos:hidden", true);

                }
            }
            System.out.println("Tum docx dosyalari gizli hale getirildi.");
        } else {
            System.out.println("Belirtilen yol bir dizin değil.");
        }

    }

    //Main classından çağırıldığında dizindeki tüm dosyaları gizleyen fonksiyon
    public void hideAll() throws IOException{

        File dizin = new File(dizinYolu);
        if (dizin.isDirectory()) {
            File[] dosyalar = dizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile()) {

                    Path p = Paths.get(dizinYolu + dosya.getName());

                    Files.setAttribute(p, "dos:hidden", true);

                }
            }
            System.out.println("Tum dosyalar gizli hale getirildi.");
        } else {
            System.out.println("Belirtilen yol bir dizin değil.");
        }

    }

}