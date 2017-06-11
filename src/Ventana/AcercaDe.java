
package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AcercaDe extends JDialog{

    private final JLabel lblNombre;
    private final JLabel lblCarrera;
    private final JLabel lblEscuela;
    private final JPanel pnlimagen;
    private final JPanel pnlInfo;
    private final JPanel pnlInfo1;
    private final JPanel pnlInfo2;
    private final JPanel pnlInfo3;
    private final JPanel pnlAbajo;
    private final JButton btnSalir;
    private final JPanel pnlImagenAdentro;
    private final JLabel lblImagen;
    
    public AcercaDe(Frame f) {
        super(f, true);
        super.setSize(550, 165);
        super.setTitle("Acerca de...");
        super.getContentPane().setBackground(Color.WHITE);        
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        pnlimagen = new JPanel();
        pnlimagen.setBackground(Color.WHITE);
        
        pnlImagenAdentro = new JPanel();
        lblImagen = new JLabel(new ImageIcon(getClass().getResource("/Icono/LaSalle.png")));
        lblImagen.setBackground(Color.white);
        pnlImagenAdentro.add(lblImagen);
        pnlImagenAdentro.setBackground(Color.white);
        pnlimagen.add(pnlImagenAdentro);
        
        pnlInfo = new JPanel();
        pnlInfo.setBackground(Color.WHITE);
        pnlInfo.setLayout(new BorderLayout());
        pnlInfo1 = new JPanel();
        pnlInfo1.setBackground(Color.WHITE);
        pnlInfo2 = new JPanel();
        pnlInfo2.setBackground(Color.WHITE);
        pnlInfo3 = new JPanel();
        pnlInfo3.setBackground(Color.WHITE);
        
        lblEscuela = new JLabel("Universidad La Salle Oaxaca");
        lblEscuela.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
        
        lblNombre = new JLabel("César Alejandro Montaño Cortés");
        lblNombre.setFont(new java.awt.Font("Tahoma", Font.CENTER_BASELINE, 16));
        
        lblCarrera = new JLabel("Ingenieria en Software y Sistemas");
        lblCarrera.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));        
       
        pnlInfo1.add(lblEscuela);
        pnlInfo2.add(lblNombre);
        pnlInfo3.add(lblCarrera);
                
        pnlInfo.add(pnlInfo1, BorderLayout.NORTH);
        pnlInfo.add(pnlInfo2, BorderLayout.CENTER);
        pnlInfo.add(pnlInfo3, BorderLayout.SOUTH);
        
        pnlAbajo = new JPanel();
        btnSalir = new JButton("Aceptar");
        pnlAbajo.setBackground(Color.white);
        pnlAbajo.add(btnSalir);
        
        btnSalir.addActionListener((ActionEvent ae) -> {
            this.setVisible(false);  
        });
        
        super.add(pnlimagen, BorderLayout.CENTER);
        super.add(pnlInfo, BorderLayout.EAST);
        super.add(pnlAbajo, BorderLayout.PAGE_END);
        super.setResizable(false);
    }
    
}
