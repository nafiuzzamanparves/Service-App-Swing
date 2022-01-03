package parves.demoproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderedServices extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String mail;
    String serviceName;

    public OrderedServices() {
        initComponents();
        addUser();
        addService();
        userLabel();
    }

    public OrderedServices(String sname, String mail) {
        initComponents();
        this.serviceName = sname;
        this.mail = mail;
        addUser();
        addService();
        userLabel();
    }

    public OrderedServices(String sname) {
        initComponents();
        this.serviceName = sname;
        addUser();
        addService();
        userLabel();
    }

    private void userLabel() {
        if (mail == null) {
            user.setVisible(false);
        }
    }

    private void addUser() {

        System.out.println("serviceName " + serviceName);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "nh123456");
            pst = con.prepareStatement("select name, email, phone, address from sign_up where email = ?");

            pst.setString(1, mail);

            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Yes");
                name.setText(rs.getString(1));
                email.setText(rs.getString(2));
                phone.setText(rs.getString(3));
                address.setText(rs.getString(4));
            } else {
                System.out.println("No");
            }

        } catch (SQLException e) {
            System.out.println("SQLException");
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Close SQLException");
            }
        }
    }

    private void addService() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "nh123456");
            pst = con.prepareStatement("select category, name, price from service where name = ?");

            pst.setString(1, serviceName);

            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Yes it has service name and category and price");
                category.setText(rs.getString(1));
                service.setText(rs.getString(2));
                price.setText(String.valueOf(rs.getDouble(3)));
            } else {
                System.out.println("No");
            }

        } catch (SQLException e) {
            System.out.println("SQLException");
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Close SQLException");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        get = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        datechoose = new com.toedter.calendar.JDateChooser();
        category = new javax.swing.JTextField();
        service = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        goHome = new javax.swing.JButton();
        user = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Phone");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Category");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Service");

        get.setText("Get Service");
        get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Price");

        goHome.setText("Home");
        goHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goHomeActionPerformed(evt);
            }
        });

        user.setText("User");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(get)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(email)
                            .addComponent(phone)
                            .addComponent(address)
                            .addComponent(datechoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(category)
                            .addComponent(service)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goHome)
                    .addComponent(user))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datechoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(get)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getActionPerformed
        // TODO add your handling code here:
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "nh123456");
            pst = con.prepareStatement("insert into demo.order(name, email, phone, address, date, service, category, price) values(?,?,?,?,?,?,?,?)");

            java.util.Date utilDate = datechoose.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            pst.setString(1, name.getText());
            pst.setString(2, email.getText());
            pst.setString(3, phone.getText());
            pst.setString(4, address.getText());
            pst.setDate(5, sqlDate);
            pst.setString(6, category.getText());
            pst.setString(7, service.getText());
            pst.setDouble(8, Double.parseDouble(price.getText()));

            int i = pst.executeUpdate();
            if (i > 0) {
                System.out.println("Insertion Successfull in order table");
                System.out.println(datechoose.getDate());
                if (mail != null) {
                    ServiceMassage sm = new ServiceMassage(mail);
                    sm.setVisible(true);
                    dispose();
                } else {
                    ServiceMassage sm = new ServiceMassage();
                    sm.setVisible(true);
                    dispose();
                }
            } else {
                System.out.println("Insertion is not Successfull in order table");
            }

        } catch (SQLException e) {
            System.out.println("Exception " + e);
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Close SQLException");
            }
        }
    }//GEN-LAST:event_getActionPerformed

    private void goHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goHomeActionPerformed
        // TODO add your handling code here:
        if (mail == null) {
            Home home = new Home();
            home.setVisible(true);
            dispose();
        } else {
            Home home = new Home(true, mail);
            home.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_goHomeActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
        if (mail != null) {
            UserDeails ud = new UserDeails(mail);
            ud.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_userActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderedServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OrderedServices().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField category;
    private com.toedter.calendar.JDateChooser datechoose;
    private javax.swing.JTextField email;
    private javax.swing.JButton get;
    private javax.swing.JButton goHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField price;
    private javax.swing.JTextField service;
    private javax.swing.JButton user;
    // End of variables declaration//GEN-END:variables

}
