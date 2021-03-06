package gui;

import hotel3h.Hotel;
import hotel3h.Room;
import hotel3h.RoomListaStyring;
import hotel3h.RoomListaVinnsla;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * @author Soley
 * 
 * Window for viewing information and photos for a selected hotel
 */
public class hotelView extends javax.swing.JDialog {
    ArrayList<Room> rListi;
    static Hotel hotel;
    int book;
    static Room valinn = null;
    static Room other;
    static int selected = 0;
    
    /**
     * Creates new form NewJDialog
     * @param parent
     * @param modal
     * @param val
     */
    public hotelView(java.awt.Frame parent, boolean modal, Hotel val) {        
        super(parent, modal);
        initComponents();
        hotel = val; //the chosen Hotel to work with
        book = 0; //tells hotel_gui whether the user wants to book the Hotel or not
        //sets all labels
        setAll();
        //creates the list of rooms.
        setNewList();
    }
    
    //Sets all labels
    private void setAll(){
        jLabel1.setText("Stars: " + hotel.getStars());
        jLabel2.setText("Address: " + hotel.getAddress());
        jHotelName.setText(hotel.getName());
        jLabel3.setText("Website: " + hotel.getWebsite());
        jBar.setText("Bar: " + getBar());
        jBreakfast.setText("Breakfast included: " + getBreakfast());
        jConferenceRooms.setText("Conference Rooms: " + getConferenceRoom());
        jFlybus.setText("Flybus: " + getFlybus());
        jFreeWifi.setText("Free Wifi: " + getWifi());
        jGym.setText("Gym: " + getGym());
        jPool.setText("Pool: " + getPool());
        jRestaurant.setText("Restaurant: " + getRestaurant());
        jSpa.setText("Spa: " + getSpa());
        jWheelchair.setText("Wheelchair access: " + getWheelchair());
    }
    
    //creates the list of rooms
    public final void setNewList(){
        rListi = hotel.getRooms();
        RoomListaVinnsla hlisti = new RoomListaVinnsla(rListi);
        jListi.setModel(hlisti);
        jListi.addListSelectionListener(new RoomListaStyring(this,rListi));
    }
    
    //Getters
    public static Room getValinn(){
        if(valinn.getHnr()== hotel.getNr()){
            return valinn;
        }
        else{
            System.out.print("No room chosen.");
            return null;
        }
    }
    
    public void setValinn(Room h){
        if(selected == 0){
            valinn = h;
        }
        else{
            other = h;
        }
    }
    
    public ArrayList<Room> getRooms(){
        return hotel.getRooms();
    }
    
    public static String getHotelName(){
        return hotel.getName();
    }
    
    public static int getSelected(){
        return selected;
    }
    
    //getters which change 1 and 0 to "Yes" and "No"
    private String getGym(){
        if(hotel.getGym()>0){
            return "Yes";
        }
        return "No";
    }

    private String getSpa(){
        if(hotel.getSpa()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getPool(){
        if(hotel.getPool()>0){
            return "Yes";
        }
        return "No";
    }

    private String getHottub(){
        if(hotel.getHottub()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getWifi(){
        if(hotel.getWifi()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getConferenceRoom(){
        if(hotel.getConference()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getRestaurant(){
        if(hotel.getRestaurant()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getBar(){
        if(hotel.getBar()>0){
            return "Yes";
        }
        return "No";
    }

    private String getInclusive(){
        if(hotel.getInclusive()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getBreakfast(){
        if(hotel.getBreakfast()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getCancellation(){
        if(hotel.getCancellation()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getRoomService(){
        if(hotel.getRoomservice()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getElevator(){
        if(hotel.getElevator()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getFlybus(){
        if(hotel.getFlybus()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getWheelchair(){
        if(hotel.getWheelchair()>0){
            return "Yes";
        }
        return "No";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMyndir = new javax.swing.JLabel();
        jHotelName = new javax.swing.JLabel();
        jBookNow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListi = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jBar = new javax.swing.JLabel();
        jHottub = new javax.swing.JLabel();
        jGym = new javax.swing.JLabel();
        jSpa = new javax.swing.JLabel();
        jRestaurant = new javax.swing.JLabel();
        jBreakfast = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jWheelchair = new javax.swing.JLabel();
        jFreeWifi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFlybus = new javax.swing.JLabel();
        jPool = new javax.swing.JLabel();
        jConferenceRooms = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bookingPopup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(4, 4));

        jHotelName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jHotelName.setText("HotelName");

        jBookNow.setText("Book now");
        jBookNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookNowActionPerformed(evt);
            }
        });

        jListi.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListi);

        jBar.setText("Bar");

        jHottub.setText("Hottub:");

        jGym.setText("Gym:");

        jSpa.setText("Spa:");

        jRestaurant.setText("Restaurant");

        jBreakfast.setText("Breakfast:");

        jLabel1.setText("Stars:");

        jWheelchair.setText("Wheelchair access:");

        jFreeWifi.setText("Free Wifi");

        jLabel3.setText("Website");

        jFlybus.setText("Flybus:");

        jPool.setText("Pool:");

        jConferenceRooms.setText("Conference Rooms");

        jLabel2.setText("Address:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRestaurant)
                    .addComponent(jBreakfast)
                    .addComponent(jGym)
                    .addComponent(jSpa)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jFreeWifi)
                    .addComponent(jPool)
                    .addComponent(jHottub)
                    .addComponent(jConferenceRooms)
                    .addComponent(jBar)
                    .addComponent(jWheelchair)
                    .addComponent(jFlybus))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFreeWifi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRestaurant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBreakfast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGym)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPool)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHottub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConferenceRooms)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWheelchair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFlybus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHotelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBookNow)
                        .addGap(18, 18, 18)
                        .addComponent(bookingPopup, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jMyndir, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHotelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBookNow)
                    .addComponent(bookingPopup, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jMyndir, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Opens BookingView
    private void jBookNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookNowActionPerformed
        // TODO add your handling code here:
        //if there is a Room selected
        if (valinn != null){
            selected = 1;            
            //if there is only one room selected
            if(other==null){
                String[] tmp = {"Yes","No"};
                int j = JOptionPane.showOptionDialog(null, "Do you want to book adjacent rooms?", "Booking multiple rooms?", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, tmp, tmp);
                if(j==1){
                    book = 1;
                    this.setVisible(false);
                }
            }
            else{
                book = 1;
                this.setVisible(false);
            }
        }
        //if no room is selected.
        else {
            bookingPopup.setText("Please select a room");
        }
    }//GEN-LAST:event_jBookNowActionPerformed

     
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
            java.util.logging.Logger.getLogger(hotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                hotelView dialog = new hotelView(new javax.swing.JFrame(), true, hotel);
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
    private javax.swing.JLabel bookingPopup;
    private javax.swing.JLabel jBar;
    private javax.swing.JButton jBookNow;
    private javax.swing.JLabel jBreakfast;
    private javax.swing.JLabel jConferenceRooms;
    private javax.swing.JLabel jFlybus;
    private javax.swing.JLabel jFreeWifi;
    private javax.swing.JLabel jGym;
    private javax.swing.JLabel jHotelName;
    private javax.swing.JLabel jHottub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListi;
    private javax.swing.JLabel jMyndir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPool;
    private javax.swing.JLabel jRestaurant;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSpa;
    private javax.swing.JLabel jWheelchair;
    // End of variables declaration//GEN-END:variables
}
