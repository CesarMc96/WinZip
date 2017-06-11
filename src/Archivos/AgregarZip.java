package Archivos;

import java.io.*;
import java.util.ArrayList;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class AgregarZip {

    public AgregarZip(String rutaArchivo) {

        try {

            ZipFile zipFile = new ZipFile("C:\\Users\\cesar_000\\Documents\\NetBeansProjects\\Estructura de Datos\\Ordinario//Comprimido.zip");

            ArrayList archivosAgregar = new ArrayList();
            //Archivo a agregar
            archivosAgregar.add(new File(rutaArchivo));

            ZipParameters parametros = new ZipParameters();

            parametros.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression

            parametros.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            parametros.setEncryptFiles(true);

            parametros.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

            parametros.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

            parametros.setPassword("123");

            zipFile.addFiles(archivosAgregar, parametros);
        } catch (ZipException e) {
        }
    }

}
