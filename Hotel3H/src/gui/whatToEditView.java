package gui;

import hotel3h.Hotel;
import hotel3h.Room;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Soley
 */
public class whatToEditView extends javax.swing.JDialog {
    String[] sHotels;
    String[] sRooms;
    static ArrayList<Hotel> alHotel;
    static String user;
    static Hotel hotel;
    static Hotel[] hotelListi;
    static int openEdit = 0;
    static int openRoomEdit = 0;
    static Room room;
    static int n;

    /**
     * Creates new form whatToEditView
     * @param parent
     * @param modal
     * @param h
     * @param u
     */
    public whatToEditView(java.awt.Frame parent, boolean modal, ArrayList<Hotel> h, String u) {
        super(parent, modal);
        initComponents();
        alHotel = h;
        int fjoldi = alHotel.size();
        Hotel[] hList = new Hotel[fjoldi];
        sHotels = new String[fjoldi];
        int i = 0;
        for(Hotel hl:alHotel){
            hList[i] = hl;
            sHotels[i] = hList[i].getName();
            i++;
        }

        jComboBox1.setModel(new DefaultComboBoxModel(sHotels));
        user = u;
        jWelcome.setText("Welcome " + user);
        n = alHotel.size();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jNewHotel = new javax.swing.JButton();
        jNewRoom = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jEditHotel = new javax.swing.JButton();
        jEditRoom = new javax.swing.JButton();
        jWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Please choose what you want to do");

        jNewHotel.setText("Add New Hotel");
        jNewHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewHotelActionPerformed(evt);
            }
        });

        jNewRoom.setText("Add New Room");
        jNewRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewRoomActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Choose hotel");

        jLabel3.setText("Choose room");

        jEditHotel.setText("Edit Selected Hotel");
        jEditHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditHotelActionPerformed(evt);
            }
        });

        jEditRoom.setText("Edit Selected Room");
        jEditRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditRoomActionPerformed(evt);
            }
        });

        jWelcome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jWelcome.setText("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jEditHotel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEditRoom))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNewHotel)
                            .addComponent(jNewRoom)
                            .addComponent(jLabel1)
                            .addComponent(jWelcome))
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEditHotel))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEditRoom))
                .addGap(16, 16, 16)
                .addComponent(jNewHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jNewRoom)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEditHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditHotelActionPerformed
        // TODO add your handling code here:
        openEdit = 1;
        this.setVisible(false);
    }//GEN-LAST:event_jEditHotelActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selected = jComboBox1.getSelectedItem().toString();
        int i = jComboBox1.getSelectedIndex();
        System.out.print(selected);
        Hotel h1 = alHotel.get(i+1);
        String[] rooms = new String[h1.getRooms().size()];
        int j = 0;
        for(Room r: h1.getRooms()){
            rooms[j] = "" + r.getNr();
            j++;
        }
        jComboBox2.setModel(new DefaultComboBoxModel(rooms));
        hotel = alHotel.get(jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jNewHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewHotelActionPerformed
        // TODO add your handling code here:
        jNewHotel.setText("You need higher priority");
        /*
        hotel = null;
        openEdit = 1;
        this.setVisible(false);
        */
    }//GEN-LAST:event_jNewHotelActionPerformed

    private void jEditRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditRoomActionPerformed
        // TODO add your handling code here:
        jEditRoom.setText("You need higher priority");
        /*
        int i = jComboBox2.getSelectedIndex();
        int j = 0;
        Room[] rFylki = new Room[hotel.getRooms().size()];
        for(Room r: hotel.getRooms()){
            rFylki[j] = r;
            j++;
        }
        if(i>=0){
            room = rFylki[i];
            openRoomEdit = 1;
            this.setVisible(false);
        }
        */
    }//GEN-LAST:event_jEditRoomActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jNewRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewRoomActionPerformed
        // TODO add your handling code here:
        jNewRoom.setText("You need higher priority");
        /*
        openRoomEdit = 1;
        this.setVisible(false);
        */
    }//GEN-LAST:event_jNewRoomActionPerformed

    public static int getN(){
        return n;
    }
    
    public static int getOpenEdit(){
        return openEdit;
    }
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
            java.util.logging.Logger.getLogger(whatToEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(whatToEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(whatToEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(whatToEditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                whatToEditView dialog = new whatToEditView(new javax.swing.JFrame(), true, alHotel, user);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JButton jEditHotel;
    private javax.swing.JButton jEditRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jNewHotel;
    private javax.swing.JButton jNewRoom;
    private javax.swing.JLabel jWelcome;
    // End of variables declaration//GEN-END:variables
}
