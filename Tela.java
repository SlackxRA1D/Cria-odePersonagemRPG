package Personagem;

import java.util.ArrayList;

/**
 *
 * @author cg3003124
 */
public class Tela extends javax.swing.JFrame {
    Personagem p;
    int parte = 0;
    int criando = 0;
    ArrayList<Personagem> personagens = new ArrayList<>();
    ArrayList<String> tempArray = new ArrayList<String>();

    public Tela() {
        initComponents();
        Thread t = new Thread(new QualTela());
        t.start();
    }
    
    public String infoPerso(int p){
        Personagem atual = new Personagem();
        atual = personagens.get(p);
        String artigo;
        
        if (atual.getSexo().equalsIgnoreCase("masculino")){ artigo = "o";
        } else { artigo = "a"; }
        String isso = " < " + atual.getNome() +" > " + artigo.toUpperCase() +
                " personagem" + atual.getNome() + "é da classe" + atual.getClasse();
        return isso;
    }
    
    public void meusPersonagens(){
        int quantos = personagens.size();
        if (quantos < 1){
            textos.setText("\tTu não tem personagem nenhum ainda, oh, criaturinha... \n\tVolte e Crie.");
        } else {
            textos.setText("");
            for (int i = 0; i < quantos; i++){
                textos.append(infoPerso(i) + "\n");
            }
        }
    }
    
    public void qualOp1(){
        switch(parte){
            case 0:  
                parte = 1; //Muda para a tela de criação
                break; 
            case 1:
                if (criando == 0){ // Pede nome
                    if (!msg.equals("")){
                        tempArray.add(msg.getText());
                    }
                } else if (criando == 1){ //pede idade
                    if (!msg.equals("")){
                        tempArray.add(msg.getText());
                    }
                } else if (criando == 2){ // pergunta sexo
                    if (!msg.equals("")){
                        tempArray.add(msg.getText());
                    }
                } else if (criando == 3) { // pergunta classe
                    String temp = "";
                    for (int i = 0; i < 2; i++){
                        
                    }
                    p = new Arqueiro(temp, temp, temp);
                    
                } else if (criando == 4) { // mostra dados e pede confirmação
                    
                    
                    
                    criando = 0; //zera a variavel criando após conclusão do personagem
                }

                                    //Arqueiro
                parte = 0;
                break;
            case 2: //modificar
                
        }
    }
    
    public void qualOp2(){
        switch(parte){
            case 1: criando++;//Guerreiro
                break;
            case 2: // Deletar
        }
    }
    
    public void qualOp3(){
        switch(parte){
            case 0: parte = 2; meusPersonagens(); break; //Exibe
            case 1: criando++; //Mago
                break;
            case 2: parte = 0; //Voltar
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        op1 = new javax.swing.JButton();
        op2 = new javax.swing.JButton();
        op3 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        textos = new javax.swing.JTextArea();
        tittle = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        forca = new javax.swing.JLabel();
        intel = new javax.swing.JLabel();
        agili = new javax.swing.JLabel();
        HP = new javax.swing.JLabel();
        MP = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        i = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        lvl = new javax.swing.JLabel();
        xp = new javax.swing.JLabel();
        vida = new javax.swing.JLabel();
        mana = new javax.swing.JLabel();
        scrollTexto = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextPane();
        info = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(640, 360, 360, 360));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 360));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setOpaque(true);

        op1.setText("Criar Personagem");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1ActionPerformed(evt);
            }
        });

        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2ActionPerformed(evt);
            }
        });

        op3.setText("Exibir Personagem(s)");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3ActionPerformed(evt);
            }
        });

        textos.setEditable(false);
        textos.setColumns(20);
        textos.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        textos.setLineWrap(true);
        textos.setRows(5);
        textos.setText("You are a jerk that know nothing.");
        textos.setWrapStyleWord(true);
        scroll.setViewportView(textos);

        tittle.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tittle.setText("That stuff, ya know");

        nome.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nome.setText("nome");

        level.setFont(new java.awt.Font("BankGothic Lt BT", 0, 18)); // NOI18N
        level.setLabelFor(lvl);
        level.setText("Level:");

        exp.setFont(new java.awt.Font("BankGothic Lt BT", 0, 18)); // NOI18N
        exp.setLabelFor(xp);
        exp.setText("Exp:");

        forca.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        forca.setLabelFor(f);
        forca.setText("For");

        intel.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        intel.setLabelFor(i);
        intel.setText("Int");

        agili.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        agili.setLabelFor(a);
        agili.setText("Agi");

        HP.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        HP.setLabelFor(vida);
        HP.setText("HP:");

        MP.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        MP.setLabelFor(mana);
        MP.setText("MP:");

        f.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        f.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        f.setText("0");

        i.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        i.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        i.setText("0");

        a.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        a.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        a.setText("0");

        lvl.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        lvl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lvl.setText("0");

        xp.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        xp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xp.setText("0");

        vida.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        vida.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vida.setText("0");

        mana.setFont(new java.awt.Font("BankGothic Lt BT", 0, 16)); // NOI18N
        mana.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mana.setText("0");

        scrollTexto.setViewportView(msg);

        info.setFont(new java.awt.Font("BankGothic Lt BT", 0, 14)); // NOI18N
        info.setLabelFor(lvl);
        info.setText("info dos guri");
        info.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(exp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(intel)
                            .addComponent(agili))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(i, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(HP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mana, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                    .addComponent(vida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(op1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(op2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(op3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scroll)
                        .addGap(10, 10, 10)
                        .addComponent(scrollTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(op1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(op2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(op3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level)
                    .addComponent(lvl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exp)
                    .addComponent(xp))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HP)
                    .addComponent(vida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MP)
                    .addComponent(mana))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forca)
                    .addComponent(f))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intel)
                    .addComponent(i))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agili)
                    .addComponent(a))
                .addGap(49, 49, 49))
        );

        tittle.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void op2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op2ActionPerformed
        qualOp2();
    }//GEN-LAST:event_op2ActionPerformed

    private void op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1ActionPerformed
        qualOp1();
    }//GEN-LAST:event_op1ActionPerformed

    private void op3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op3ActionPerformed
        qualOp3();
    }//GEN-LAST:event_op3ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HP;
    private javax.swing.JLabel MP;
    private javax.swing.JLabel a;
    private javax.swing.JLabel agili;
    private javax.swing.JLabel exp;
    private javax.swing.JLabel f;
    private javax.swing.JLabel forca;
    private javax.swing.JLabel i;
    private javax.swing.JLabel info;
    private javax.swing.JLabel intel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel level;
    private javax.swing.JLabel lvl;
    private javax.swing.JLabel mana;
    private javax.swing.JTextPane msg;
    private javax.swing.JLabel nome;
    private javax.swing.JButton op1;
    private javax.swing.JButton op2;
    private javax.swing.JButton op3;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollTexto;
    private javax.swing.JTextArea textos;
    private javax.swing.JLabel tittle;
    private javax.swing.JLabel vida;
    private javax.swing.JLabel xp;
    // End of variables declaration//GEN-END:variables

    public class QualTela implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (parte == 0) {
                    //Tela Inicial
                    textos.setText("\tPágina inicial, vá e faça algo.");
                    op1.setText("Cadastrar");
                    op2.setVisible(false);
                    op3.setText("Exibir");
                } else if (parte == 1) {
                    //Tela de Criação
                    if (criando == 0){
                        op1.setText("Arqueiro");
                        op2.setText("Guerreiro");
                        op2.setVisible(true);
                        op3.setText("Mago");
                    } else if (criando == 1){
                        
                    }
                    
                } else if (parte == 2) {
                    //Tela de Visualização Personagens
                    op1.setText("Modificar");
                    op2.setText("Excluir");
                    op2.setVisible(true);
                    op3.setText("Voltar");
                } else if (parte == 3) {

                }
            }
        }
    }
}
