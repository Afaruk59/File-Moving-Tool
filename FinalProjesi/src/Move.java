import java.io.*;
import java.nio.file.*;

public class Move {

    String kaynak;
    String hedef;

    public Move(String kaynak, String hedef) {
        super();
        this.kaynak = kaynak;
        this.hedef = hedef;
    }


    //Main classından çağırıldığında dizindeki txt dosyalarını taşıyan fonksiyon
    public void moveTxt() throws IOException{

        File file = new File(kaynak);
        File[] dosyalar = file.listFiles();

        for (File dosya : dosyalar) {
            if (dosya.isFile() && dosya.getName().toLowerCase().endsWith(".txt")) {

                Path kynk = dosya.toPath();
                Path hdf = new File(hedef + dosya.getName()).toPath();
                Files.move(kynk, hdf, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Dosya tasindi: " + dosya.getName());

            }
        }
    }

    //Main classından çağırıldığında dizindeki pdf dosyalarını taşıyan fonksiyon
    public void movePdf() throws IOException{

        File file = new File(kaynak);
        File[] dosyalar = file.listFiles();

        for (File dosya : dosyalar) {
            if (dosya.isFile() && dosya.getName().toLowerCase().endsWith(".pdf")) {

                Path kynk = dosya.toPath();
                Path hdf = new File(hedef + dosya.getName()).toPath();
                Files.move(kynk, hdf, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Dosya tasindi: " + dosya.getName());

            }
        }
    }

    //Main classından çağırıldığında dizindeki docx dosyalarını taşıyan fonksiyon
    public void moveDocx() throws IOException{

        File file = new File(kaynak);
        File[] dosyalar = file.listFiles();

        for (File dosya : dosyalar) {
            if (dosya.isFile() && dosya.getName().toLowerCase().endsWith(".docx")) {

                Path kynk = dosya.toPath();
                Path hdf = new File(hedef + dosya.getName()).toPath();
                Files.move(kynk, hdf, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Dosya tasindi: " + dosya.getName());

            }
        }
    }

    //Main classından çağırıldığında dizindeki tüm dosyaları taşıyan fonksiyon
    public void moveAll() throws IOException{

        File file = new File(kaynak);
        File[] dosyalar = file.listFiles();

        for (File dosya : dosyalar) {
            if (dosya.isFile()) {

                Path kynk = dosya.toPath();
                Path hdf = new File(hedef + dosya.getName()).toPath();
                Files.move(kynk, hdf, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Dosya tasindi: " + dosya.getName());

            }
        }
    }
}
