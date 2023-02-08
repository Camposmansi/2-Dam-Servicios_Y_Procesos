package Trimestre2.Socket_Chat_Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import static javax.swing.SwingUtilities.invokeLater;

public class Chat1 extends JFrame implements Observer {

    private JButton btnEnviar;
    private JTextArea txtTexto;
    private JTextField txtTextoEnviar;

    public Chat1() {
        initComponents();
        this.getRootPane().setDefaultButton(this.btnEnviar);
        Servidor s = new Servidor(5000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                new Chat1().setVisible(true);
            }
        });
    }

    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        txtTexto = new JTextArea();
        btnEnviar = new JButton();
        txtTextoEnviar = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat 1");

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTextoEnviar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEnviar, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                        .addComponent(txtTextoEnviar))
                                .addContainerGap())
        );

        pack();
    }

    private void btnEnviarActionPerformed(ActionEvent evt) {

        String mensaje = "1: " + this.txtTextoEnviar.getText() + "\n";

        this.txtTexto.append(mensaje);
        this.txtTextoEnviar.setText("");

        Cliente c = new Cliente(6000, mensaje);
        Thread t = new Thread(c);
        t.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.txtTexto.append((String) arg);
    }
}
