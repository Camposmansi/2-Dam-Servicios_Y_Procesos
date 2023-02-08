package Trimestre2.Socket_Chat_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Chat2 extends JFrame implements Observer {

    private JButton btnEnviar;
    private JScrollPane jScrollPane1;
    private JTextArea txtTexto;
    private JTextField txtTextoEnviar;

    public Chat2() {
        initComponents();
        this.getRootPane().setDefaultButton(this.btnEnviar);
        Servidor s = new Servidor(6000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat2().setVisible(true);
            }
        });
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        txtTexto = new JTextArea();
        btnEnviar = new JButton();
        txtTextoEnviar = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat 2");

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

        String mensaje = "2: " + this.txtTextoEnviar.getText() + "\n";

        this.txtTexto.append(mensaje);
        this.txtTextoEnviar.setText("");

        Cliente c = new Cliente(5000, mensaje);
        Thread t = new Thread(c);
        t.start();

    }

    @Override
    public void update(Observable o, Object arg) {

        this.txtTexto.append((String) arg);
    }

}
