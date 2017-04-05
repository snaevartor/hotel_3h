package gui;

import hotel3h.BookingManager;
import hotel3h.Room;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Soley
 */
public class BookingView extends javax.swing.JDialog {

    /**
     * Creates new form Booking
     */
    private String name;
    private String address;
    private String email;
    private int phonenr;
    private int cardnr;
    private Room r;
    private int[] dateFrom;
    private int[] dateTo;
    private hotel_gui gui;

    private int bookingNr;
    private BookingManager bm = new BookingManager();

    
    public BookingView(java.awt.Frame parent, boolean modal, Room rm, hotel_gui gui) {
        super(parent, modal);
        initComponents();
        this.gui = gui;
        dateFrom = gui.getDateFrom();
        dateTo = gui.getDateTo();
        r = rm;
        //Set texts for labels
        jHotelName.setText(hotel_gui.getChosenHotel().getName());
        jDateFrom.setText(dateFrom[0] + "/" + dateFrom[1] + "/" + dateFrom[2]);
        jDateTo.setText(dateTo[0] + "/" + dateTo[1] + "/" + dateTo[2]);
        if(other==null){
            jPeople.setText("" + r.getCount());
            jPrice.setText(r.getPrice() + " USD per night.");
        }
        else{
            int ipeople = r.getCount() + other.getCount();
            int iprice = r.getPrice() + other.getPrice();
            jPeople.setText(r.getCount() + " + " + other.getCount() + " = " + ipeople);
            jPrice.setText(r.getPrice() + " + " + other.getPrice() + " = " + iprice + " USD per night");

        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jChange = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jBook = new javax.swing.JButton();
        jFullName = new javax.swing.JTextField();
        jCardnr = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jPhonenr = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jHotelName = new javax.swing.JLabel();
        jPeople = new javax.swing.JLabel();
        jPrice = new javax.swing.JLabel();
        jDateFrom = new javax.swing.JLabel();
        jDateTo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Your order");

        jLabel2.setText("Hotel:");

        jLabel3.setText("People:");

        jLabel4.setText("Price:");

        jLabel5.setText("Date from:");

        jLabel6.setText("Date to:");

        jChange.setText("Change order");
        jChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeActionPerformed(evt);
            }
        });

        jLabel7.setText("Full name:");

        jLabel8.setText("Card nr:");

        jLabel9.setText("Address:");

        jLabel10.setText("Phone number:");

        jLabel11.setText("email:");

        jBook.setText("Book");
        jBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookActionPerformed(evt);
            }
        });

        jFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFullNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(78, 78, 78)
                        .addComponent(jHotelName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(78, 78, 78)
                        .addComponent(jPeople))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPrice))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFrom))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateTo))
                    .addComponent(jChange)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCardnr))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAddress))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPhonenr))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEmail))
                    .addComponent(jBook))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jHotelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPeople))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jDateFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jDateTo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jChange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCardnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jPhonenr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Closes the Dialog
    private void jChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jChangeActionPerformed

    //Reads from the textfields
    private void jBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookActionPerformed
        try {
            // TODO add your handling code here:
            name = jFullName.getText();
            address = jAddress.getText();
            email = jEmail.getText();
            cardnr = Integer.valueOf(jCardnr.getText());
            phonenr = Integer.valueOf(jPhonenr.getText());
            System.out.println(dateFrom[0] + " " + dateFrom[1] + " " + dateFrom[2]);
            if(bm.isAvailable(r.getHnr(), r.getNr(), getDateFrom(), getDateTo())){
              bookingNr =  bm.book(getName(), bm.getSqlDate(dateFrom), bm.getSqlDate(dateTo), getCardnr(), r.getNr(), r.getHnr());
             String[] tmp = {"OK"};
int i = JOptionPane.showOptionDialog(null, new JLabel("Your booking is complete. Your booking number is: " + bookingNr, null, JLabel.LEFT), "Thank you for your order.", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, tmp, tmp);
            }
            else{
                 String[] tmp = {"OK"};
              int k = JOptionPane.showOptionDialog(null, new JLabel("That room is not available for the dates selected", null, JLabel.LEFT), "Error", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, tmp, tmp);
            }
            
//        setGuestHlutur(name, address, 1, cardnr, phonenr, email);

//A JOptionPane shows that the booking is complete.

this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(BookingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBookActionPerformed

    private void jFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFullNameActionPerformed
    
    //Getters
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getEmail(){
        return email;
    }
    public int getPhonenr(){
        return phonenr;
    }
    public int getCardnr(){
        return cardnr;
    }
    public int[] getDateTo(){
        return dateTo;
    }
    public int[] getDateFrom(){
        return dateFrom;
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
            java.util.logging.Logger.getLogger(BookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Room r = null;
                hotel_gui gui = null;
                BookingView dialog = new BookingView(new javax.swing.JFrame(), true, r, gui,other);
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
    private javax.swing.JTextField jAddress;
    private javax.swing.JButton jBook;
    private javax.swing.JTextField jCardnr;
    private javax.swing.JButton jChange;
    private javax.swing.JLabel jDateFrom;
    private javax.swing.JLabel jDateTo;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFullName;
    private javax.swing.JLabel jHotelName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jPeople;
    private javax.swing.JTextField jPhonenr;
    private javax.swing.JLabel jPrice;
    // End of variables declaration//GEN-END:variables
}
