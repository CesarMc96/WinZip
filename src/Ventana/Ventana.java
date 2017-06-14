package Ventana;

import Archivos.AgregarZip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.jar.JarInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Ventana extends JFrame {

    private final JButton btnArchivo;
    private final JButton btnComprimir;
    private final JButton btnDescomprimir;
    private final JPanel pnlArriba;
    private final JLabel lblArchivo;
    private final JLabel lblNombreArchivo;
    private final JPanel pnlAA;
    private final JPanel pnlAB;
    private final JPanel pnlAbajo;
    private final JLabel lblPregunta;
    private final JTextField txtPregunta;
    private final JButton btnAceptar;
    private final JPanel pnlAC;
    private final JPanel pnlAD;
    private Integer numeroArchivos;
    ArrayList archivosAgregar = new ArrayList();
    private final JPanel pnlContraseña;
    private final JLabel lblContraseña;
    private final String[] Opciones = {"", "Si", "No"};
    private final JComboBox ListaOpcion;
    private final JButton btnOpcion;
    ArrayList nombreArchivos = new ArrayList();
    private JLabel lblEscribeContraseña;
    private JTextField txtEscribeContraseña;
    private String contrasena;
    private final JMenuBar barraMenu;
    private final JMenu menuSistema;
    private final JMenu menuAyuda;
    private final JMenuItem itmSalir;
    private final JMenuItem itmAcerca;
    private final JMenuItem itmInformacion;
    private boolean bandera = false;
    private final JMenuItem itmDescomprimir;
    private final JMenuItem itmComprimir;
    private final JPanel pnlDescomprimirArriba;
    private final JPanel pnlDescomprimirAbajo;
    private final JPanel pnlDA;
    private final JPanel pnlDB;
    private final JButton btnArchivoDescomprimir;
    private final JLabel lblArchivoDescomprimir;
    private final JLabel lblNombreArchivoDescomprimir;
    private String rutaFicheroDescomprimir;

    public Ventana() {
        super.setSize(500, 200);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setTitle("Compresor de Archivos");
        super.getContentPane().setBackground(Color.WHITE);

        //***************************************
        pnlArriba = new JPanel();
        pnlArriba.setLayout(new BorderLayout());
        pnlAA = new JPanel();
        pnlAB = new JPanel();
        pnlAA.setBackground(Color.WHITE);
        pnlAB.setBackground(Color.WHITE);

        lblPregunta = new JLabel("¿Cuantos archivos deseas comprimir?");
        txtPregunta = new JTextField(2);
        btnAceptar = new JButton("Aceptar");

        pnlAB.add(btnAceptar);
        pnlAA.add(lblPregunta);
        pnlAA.add(txtPregunta);

        pnlArriba.add(pnlAA, BorderLayout.PAGE_START);
        pnlArriba.add(pnlAB, BorderLayout.PAGE_END);

        //***************************************
        pnlAC = new JPanel();
        pnlAD = new JPanel();
        btnArchivo = new JButton("Seleccionar Archivo.");
        lblArchivo = new JLabel("Archivos: ");
        lblNombreArchivo = new JLabel();
        pnlAC.setBackground(Color.WHITE);
        pnlAD.setBackground(Color.WHITE);

        btnComprimir = new JButton("Comprimir");
        btnDescomprimir = new JButton("Descomprimir");

        pnlAbajo = new JPanel();
        pnlAbajo.setBackground(Color.WHITE);
        pnlAbajo.add(btnComprimir);
        pnlAbajo.setVisible(false);

        //***************************************
        pnlContraseña = new JPanel();
        pnlContraseña.setBackground(Color.WHITE);

        lblContraseña = new JLabel("¿Deseas agregarle contraseña a los archivos?");
        ListaOpcion = new JComboBox(Opciones);
        ListaOpcion.setBackground(Color.white);
        btnOpcion = new JButton("Aceptar");

        pnlContraseña.add(lblContraseña);
        pnlContraseña.add(ListaOpcion);
        pnlContraseña.add(btnOpcion);

        //***************************************
        btnAceptar.addActionListener((ActionEvent ae) -> {
            pnlAC.add(lblArchivo);
            pnlAC.add(lblNombreArchivo);
            pnlAD.add(btnArchivo);

            pnlArriba.add(pnlAC, BorderLayout.PAGE_START);
            pnlArriba.add(pnlAD, BorderLayout.PAGE_END);
            pnlAA.setVisible(false);
            pnlAB.setVisible(false);

            numeroArchivos = Integer.parseInt(txtPregunta.getText());
        });

        //***************************************
        btnArchivo.addActionListener((ActionEvent ae) -> {

            if (numeroArchivos > 1) {
                for (int i = 0; i < numeroArchivos; i++) {
                    JFileChooser fc = new JFileChooser();
                    int seleccion = fc.showOpenDialog(fc);

                    if (seleccion == JFileChooser.APPROVE_OPTION) {
                        //Seleccionamos el fichero
                        File fichero = fc.getSelectedFile();

                        //Escribe el nombre del fichero
                        nombreArchivos.add(fichero.getName());
                        archivosAgregar.add(new File(fichero.getAbsolutePath()));
                    }

                }

                String nombree = (String) nombreArchivos.get(0);

                for (int i = 1; i < numeroArchivos; i++) {
                    nombree = nombree + "   ||   " + nombreArchivos.get(i);
                    lblNombreArchivo.setText(nombree);
                }

            } else if (numeroArchivos == 1) {
                JFileChooser fc = new JFileChooser();
                int seleccion = fc.showOpenDialog(fc);

                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    //Seleccionamos el fichero
                    File fichero = fc.getSelectedFile();

                    //Escribe el nombre del fichero
                    nombreArchivos.add(fichero.getName());
                    archivosAgregar.add(new File(fichero.getAbsolutePath()));
                }

                lblNombreArchivo.setText((String) nombreArchivos.get(0));
            }

            pnlContraseña.setVisible(true);
            super.add(pnlContraseña, BorderLayout.CENTER);

        });

        //***************************************
        btnComprimir.addActionListener((ActionEvent ae) -> {
            if (bandera == true) {
                contrasena = txtEscribeContraseña.getText();
                AgregarZip agregarZip = new AgregarZip(archivosAgregar, contrasena);
                JOptionPane.showMessageDialog(this, "Archivo Comprimido");
            } else if (bandera == false) {
                AgregarZip agregarZip = new AgregarZip(archivosAgregar);
                JOptionPane.showMessageDialog(this, "Archivo Comprimido");
            }
        });

        //***************************************
        btnDescomprimir.addActionListener((ActionEvent ae) -> {
            String directorioZip = "C:\\Users\\cesar_000\\Documents\\NetBeansProjects\\Estructura de Datos\\Ordinario\\Archivos Comprimidos";

            try {
                FileInputStream fis = new FileInputStream(rutaFicheroDescomprimir);
                ZipInputStream zis = new ZipInputStream(fis);
                
                ZipEntry entrada;
                
                while(null != (entrada = zis.getNextEntry())){
                    System.out.println(entrada.toString());
                    FileOutputStream fos = new FileOutputStream(entrada.getName());
                    int leido;
                    byte[] buffer = new byte[1024];
                    while (0 < (leido = zis.read(buffer))) {
                        fos.write(buffer, 0, leido);
                    }
                    fos.close();
                    zis.closeEntry();
                }
                    
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Directorio de salida: " + directorioZip);

        });

        //***************************************
        btnOpcion.addActionListener((ActionEvent ae) -> {
            if (ListaOpcion.getSelectedItem() == "Si") {
                lblEscribeContraseña = new JLabel("Contraseña: ");
                txtEscribeContraseña = new JTextField(8);

                pnlContraseña.add(lblEscribeContraseña);
                pnlContraseña.add(txtEscribeContraseña);
                lblContraseña.setVisible(false);
                ListaOpcion.setVisible(false);
                btnOpcion.setVisible(false);
                pnlAbajo.setVisible(true);
                bandera = true;

            } else if (ListaOpcion.getSelectedItem() == "No") {
                pnlAbajo.setVisible(true);
                lblContraseña.setVisible(false);
                ListaOpcion.setVisible(false);
                btnOpcion.setVisible(false);
                bandera = false;

            }
        });

        super.add(pnlArriba, BorderLayout.PAGE_START);
        super.add(pnlAbajo, BorderLayout.PAGE_END);

        //***************************************
        pnlDescomprimirArriba = new JPanel();
        pnlDescomprimirArriba.setLayout(new BorderLayout());
        pnlDescomprimirAbajo = new JPanel();
        pnlDescomprimirAbajo.setBackground(Color.WHITE);

        pnlDA = new JPanel();
        pnlDB = new JPanel();
        pnlDA.setBackground(Color.WHITE);
        pnlDB.setBackground(Color.WHITE);

        btnArchivoDescomprimir = new JButton("Seleccionar Archivo.");
        lblArchivoDescomprimir = new JLabel("Archivo: ");
        lblNombreArchivoDescomprimir = new JLabel();

        pnlDB.add(btnArchivoDescomprimir);
        pnlDA.add(lblArchivoDescomprimir);
        pnlDA.add(lblNombreArchivoDescomprimir);

        pnlDescomprimirArriba.add(pnlDA, BorderLayout.PAGE_START);
        pnlDescomprimirArriba.add(pnlDB, BorderLayout.PAGE_END);

        pnlDescomprimirAbajo.add(btnDescomprimir);

        //***************************************
        barraMenu = new JMenuBar();

        menuSistema = new JMenu("Sistema   ");
        menuAyuda = new JMenu("Ayuda   ");

        itmSalir = new JMenuItem("Salir");
        itmAcerca = new JMenuItem("Acerca de");
        itmInformacion = new JMenuItem("Informacion   ");
        itmDescomprimir = new JMenuItem("Descomprimir   ");
        itmComprimir = new JMenuItem("Comprimir   ");

        barraMenu.add(menuSistema);
        menuSistema.add(itmComprimir);
        menuSistema.add(itmDescomprimir);
        menuSistema.addSeparator();
        menuSistema.add(itmSalir);

        barraMenu.add(menuAyuda);
        menuAyuda.add(itmInformacion);
        menuAyuda.addSeparator();
        menuAyuda.add(itmAcerca);

        itmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        itmInformacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        itmAcerca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));
        itmDescomprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        itmComprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

        setJMenuBar(this.barraMenu);

        itmSalir.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        itmAcerca.addActionListener((ActionEvent ae) -> {
            AcercaDe ac = new AcercaDe(this);
            ac.setVisible(true);
        });

        itmDescomprimir.addActionListener((ActionEvent ae) -> {
            pnlAbajo.setVisible(false);
            pnlArriba.setVisible(false);

            pnlDescomprimirAbajo.setVisible(true);
            pnlDescomprimirArriba.setVisible(true);
            super.add(pnlDescomprimirArriba, BorderLayout.PAGE_START);
            super.add(pnlDescomprimirAbajo, BorderLayout.PAGE_END);
        });

        //***************************************
        btnArchivoDescomprimir.addActionListener((ActionEvent ae) -> {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("ZIP & RAR", "zip", "rar");
            fc.setFileFilter(filtro);
            fc.setCurrentDirectory(new File("C:\\Users\\cesar_000\\Documents\\NetBeansProjects\\Estructura de Datos\\Ordinario\\Archivos Comprimidos"));
            int seleccion = fc.showOpenDialog(fc);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                //Seleccionamos el fichero
                File fichero = fc.getSelectedFile();

                //Escribe el nombre del fichero
                nombreArchivos.add(fichero.getName());
                archivosAgregar.add(new File(fichero.getAbsolutePath()));
                rutaFicheroDescomprimir = fichero.getAbsolutePath();
            }

            lblNombreArchivoDescomprimir.setText((String) nombreArchivos.get(0));
        });

        itmComprimir.addActionListener((ActionEvent ae) -> {
            pnlDescomprimirAbajo.setVisible(false);
            pnlDescomprimirArriba.setVisible(false);
            pnlAbajo.setVisible(true);
            pnlArriba.setVisible(true);
        });
        //***************************************
        super.setVisible(true);
    }

}
