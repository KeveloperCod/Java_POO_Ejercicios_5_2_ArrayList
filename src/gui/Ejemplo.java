package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloDocentes;
import clase.Docente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ejemplo extends JFrame {
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable tblTabla;
    private DefaultTableModel modelo;
    private JButton btnListar;
    private JButton btnReportar;
    private JButton btnLimpiar; 
    private JLabel lblReporte; 

    private ArregloDocentes arreglo; 

    public Ejemplo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        arreglo = new ArregloDocentes();

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 630, 320);
        contentPane.add(scrollPane);

        tblTabla = new JTable();
        tblTabla.setFillsViewportHeight(true);
        scrollPane.setViewportView(tblTabla);

        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Horas");
        modelo.addColumn("Tarifa");
        modelo.addColumn("Sueldo");
        tblTabla.setModel(modelo);

        
        btnListar = new JButton("Listar");
        btnListar.setBounds(10, 380, 100, 30);
        btnListar.addActionListener(e -> listarDocentes());
        contentPane.add(btnListar);

       
        btnReportar = new JButton("Reportar");
        btnReportar.setBounds(120, 380, 100, 30);
        btnReportar.addActionListener(e -> mostrarReporte());
        contentPane.add(btnReportar);
        
       
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(230, 380, 100, 30);
        btnLimpiar.addActionListener(e -> limpiarTablaYReporte());
        contentPane.add(btnLimpiar);

    
        lblReporte = new JLabel("Reporte:");
        lblReporte.setBounds(10, 420, 630, 30);
        contentPane.add(lblReporte);
    }
    
    private void listarDocentes() {
        modelo.setRowCount(0);
        for (int i = 0; i < arreglo.tamanio(); i++) {
            Docente docente = arreglo.obtener(i);
            Object[] fila = {
                docente.getCodigo(),
                docente.getNombre(),
                docente.getHoras(),
                docente.getTarifa(),
                docente.sueldo()
            };
            modelo.addRow(fila); 
        }
    }

 
    private void mostrarReporte() {
        double sumaSueldos = arreglo.sumarSueldos();
        double promedioSueldos = arreglo.calcularPromedio();
        lblReporte.setText(String.format("Reporte: Total Sueldos = %.2f, Sueldo Promedio = %.2f", sumaSueldos, promedioSueldos));
    }

   
    private void limpiarTablaYReporte() {
        modelo.setRowCount(0); 
        lblReporte.setText("Reporte:"); 
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ejemplo frame = new Ejemplo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
