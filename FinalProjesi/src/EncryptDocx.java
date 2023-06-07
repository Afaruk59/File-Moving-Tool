import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class EncryptDocx {

    String kaynak;

    public EncryptDocx(String kaynak) {
        super();
        this.kaynak = kaynak;
    }

    private static final String SECRET_KEY = "ThisIsASecretKey"; //SIFRELEME ANAHTARI
    private static final String ALGORITHM = "AES"; //SIFRELEME ALGORITMASI

    public void encryptDocx() {
        String directoryPath = kaynak; // Şifrelenmesi gereken docx dosyalarının bulunduğu dizin
        File directory = new File(directoryPath);

        // Dizin var mı kontrol et
        if (!directory.isDirectory()) {
            System.out.println("Belirtilen yol bir dizin değil.");
            return;
        }

        // Dizin içindeki dosyaları listele
        File[] files = directory.listFiles();

        // Dosyaları şifrele
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".docx")) {
                encryptDocxFile(file);
            }
        }

        System.out.println("Dosyalar basariyla sifrelendi.");
    }

    private static void encryptDocxFile(File file) {
        try {
            // Şifreleme anahtarını ve algoritmayı oluştur
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Dosya içeriğini oku
            byte[] fileContent = Files.readAllBytes(file.toPath());

            // Dosyayı şifrele
            byte[] encryptedContent = cipher.doFinal(fileContent);

            // Şifrelenmiş içeriği dosyaya yaz
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(encryptedContent);

            // Kaynakları temizle
            outputStream.close();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException | IOException e) {
            e.printStackTrace();
        }
    }
}