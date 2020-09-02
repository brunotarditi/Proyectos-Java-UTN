package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Bruno Tarditi
 */
public class MenuVista extends javax.swing.JFrame {

    //Getters y Setters de cada botón de la clase
    public JButton getBtnAlumno() {
        return btnAlumno;
    }

    public void setBtnAlumno(JButton btnAlumno) {
        this.btnAlumno = btnAlumno;
    }

    public JButton getBtnCarrera() {
        return btnCarrera;
    }

    public void setBtnCarrera(JButton btnCarrera) {
        this.btnCarrera = btnCarrera;
    }

    public JButton getBtnCursado() {
        return btnCursado;
    }

    public void setBtnCursado(JButton btnCursado) {
        this.btnCursado = btnCursado;
    }

    public JButton getBtnInscripcion() {
        return btnInscripcion;
    }

    public void setBtnInscripcion(JButton btnInscripcion) {
        this.btnInscripcion = btnInscripcion;
    }

    public JButton getBtnMateria() {
        return btnMateria;
    }

    public void setBtnMateria(JButton btnMateria) {
        this.btnMateria = btnMateria;
    }

    public JButton getBtnProfesor() {
        return btnProfesor;
    }

    public void setBtnProfesor(JButton btnProfesor) {
        this.btnProfesor = btnProfesor;
    }

    public MenuVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        btnAlumno = new javax.swing.JButton();
        btnInscripcion = new javax.swing.JButton();
        btnCursado = new javax.swing.JButton();
        btnMateria = new javax.swing.JButton();
        btnProfesor = new javax.swing.JButton();
        btnCarrera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(23, 27, 31));

        btnAlumno.setBackground(new java.awt.Color(255, 255, 255));
        btnAlumno.setForeground(new java.awt.Color(0, 0, 0));
        btnAlumno.setText("ALUMNO");

        btnInscripcion.setBackground(new java.awt.Color(255, 255, 255));
        btnInscripcion.setForeground(new java.awt.Color(0, 0, 0));
        btnInscripcion.setText("INSCRIPCION");

        btnCursado.setBackground(new java.awt.Color(255, 255, 255));
        btnCursado.setForeground(new java.awt.Color(0, 0, 0));
        btnCursado.setText("CURSADO");

        btnMateria.setBackground(new java.awt.Color(255, 255, 255));
        btnMateria.setForeground(new java.awt.Color(0, 0, 0));
        btnMateria.setText("MATERIA");

        btnProfesor.setBackground(new java.awt.Color(255, 255, 255));
        btnProfesor.setForeground(new java.awt.Color(0, 0, 0));
        btnProfesor.setText("PROFESOR");

        btnCarrera.setBackground(new java.awt.Color(255, 255, 255));
        btnCarrera.setForeground(new java.awt.Color(0, 0, 0));
        btnCarrera.setText("CARRERA");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 56)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumno;
    private javax.swing.JButton btnCarrera;
    private javax.swing.JButton btnCursado;
    private javax.swing.JButton btnInscripcion;
    private javax.swing.JButton btnMateria;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables

}
