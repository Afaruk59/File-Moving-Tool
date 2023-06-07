import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decryption{

    String hedef;

    public Decryption(String hedef) {
        super();
        this.hedef = hedef;
    }

    public void decryptor() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException,
            IllegalBlockSizeException, BadPaddingException {
        File file = new File(hedef);
        File[] dosyalar = file.listFiles();

        for (File dosya : dosyalar) {
            if (dosya.isFile()) {

                String secretKey= "ThisIsASecretKey";
                String fileInputPath= hedef + dosya.getName();
                String fileOutPath= hedef + dosya.getName();

                var key = new SecretKeySpec(secretKey.getBytes(), "AES");
                var cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, key);

                var fileInput = new File(fileInputPath);
                var inputStream = new FileInputStream(fileInput);
                var inputBytes = new byte[(int) fileInput.length()];
                inputStream.read(inputBytes);

                byte[] outputBytes = cipher.doFinal(inputBytes);

                var fileEncryptOut = new File(fileOutPath);
                var outputStream = new FileOutputStream(fileEncryptOut);
                outputStream.write(outputBytes);

                inputStream.close();
                outputStream.close();

                System.out.println("Dosya Basariyla Cozuldu: " + dosya.getName());
            }

        }
    }

}