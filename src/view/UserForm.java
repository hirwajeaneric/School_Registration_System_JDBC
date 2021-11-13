package view;

import controller.UserDao;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.RegistrantType;
import model.Users;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utils.ConnectionToDatabase;

/**
 *
 * @author hirwa
 */
public class UserForm extends javax.swing.JInternalFrame {
    
    //I instantiated the ConnectionToDatabase so we could use it again in our database transactions.
    ConnectionToDatabase connect = new ConnectionToDatabase();
    
    public UserForm() {
        initComponents();
        displayInTable();
    }

    //Method to clean what was writen in the input fields
    public void resetFields(){
        fnameTxtField.setText(null);
        lastNameTextField.setText(null);
        PhoneNumberTextField.setText(null);
        dateOfBirthDateChooser.setDate(null);
        RegistrantTypeComboBox.setSelectedIndex(0);
        imagePathTextField.setText(null);
    }

    //Method to display data in the table
    private void displayInTable(){
        int i,q;
        try {
            connect.getConnection();
            
            connect.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaProjects?","root","");
            
            String selectQuerry = "SELECT * FROM schoolUsers";            
            connect.s = connect.con.createStatement();
            connect.rs = connect.s.executeQuery(selectQuerry);
                        
            DefaultTableModel model = (DefaultTableModel) userTable.getModel();
            model.setRowCount(0);
            
            while (connect.rs.next()) {
                String firstName = connect.rs.getString(1);
                String lastName = connect.rs.getString(2);
                String phoneNumber = connect.rs.getString(3);
                String dateOfBirth = connect.rs.getString(4);
                String registrantType = connect.rs.getString(5);
                byte[] photo = connect.rs.getBytes(6);
    
                model.addRow(new Object[]{firstName, lastName, phoneNumber, dateOfBirth,registrantType, photo});
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        } connect.getDisconnection();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BrowseImageButton = new javax.swing.JButton();
        RegistrantTypeComboBox = new javax.swing.JComboBox<>();
        fnameTxtField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        PhoneNumberTextField = new javax.swing.JTextField();
        dateOfBirthDateChooser = new com.toedter.calendar.JDateChooser();
        ImageContentPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        imagePathTextField = new javax.swing.JTextField();
        TitleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        CommandPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        importExcelButton = new javax.swing.JButton();
        dataPreviewPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        SearchLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        filterByTypeTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("User Data Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Entry"));

        jLabel2.setText("First name");

        jLabel3.setText("Last name");

        jLabel4.setText("Phone number");

        jLabel5.setText("Date of birth");

        jLabel6.setText("Registrant type");

        BrowseImageButton.setText("Browse Image");
        BrowseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseImageButtonActionPerformed(evt);
            }
        });

        RegistrantTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Staff", "Stakeholder" }));

        ImageContentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("User image"));

        javax.swing.GroupLayout ImageContentPanelLayout = new javax.swing.GroupLayout(ImageContentPanel);
        ImageContentPanel.setLayout(ImageContentPanelLayout);
        ImageContentPanelLayout.setHorizontalGroup(
            ImageContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        ImageContentPanelLayout.setVerticalGroup(
            ImageContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BrowseImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagePathTextField))
                        .addGap(18, 18, 18)
                        .addComponent(ImageContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegistrantTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fnameTxtField)
                            .addComponent(lastNameTextField)
                            .addComponent(PhoneNumberTextField)
                            .addComponent(dateOfBirthDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fnameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dateOfBirthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(RegistrantTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BrowseImageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ImageContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TitleLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TitleLabel.setText("USER DATA");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data View"));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First name", "Last name", "Phone", "Date of birth", "Registrant type", "Image"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        CommandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        importExcelButton.setText("IMPORT EXCEL");
        importExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CommandPanelLayout = new javax.swing.GroupLayout(CommandPanel);
        CommandPanel.setLayout(CommandPanelLayout);
        CommandPanelLayout.setHorizontalGroup(
            CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(importExcelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap())
        );
        CommandPanelLayout.setVerticalGroup(
            CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommandPanelLayout.createSequentialGroup()
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(importExcelButton))
        );

        dataPreviewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Preview"));

        SearchLabel.setText("Search");

        jLabel1.setText("Filter By Type");

        jButton1.setText("EXPORT EXCEL");

        jButton2.setText("EXPORT PDF");

        javax.swing.GroupLayout dataPreviewPanelLayout = new javax.swing.GroupLayout(dataPreviewPanel);
        dataPreviewPanel.setLayout(dataPreviewPanelLayout);
        dataPreviewPanelLayout.setHorizontalGroup(
            dataPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPreviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPreviewPanelLayout.createSequentialGroup()
                        .addGroup(dataPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchLabel)
                            .addComponent(searchTextField)
                            .addComponent(jLabel1)
                            .addComponent(filterByTypeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dataPreviewPanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        dataPreviewPanelLayout.setVerticalGroup(
            dataPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPreviewPanelLayout.createSequentialGroup()
                .addComponent(SearchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterByTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dataPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CommandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addComponent(TitleLabel)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CommandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Variables to be used when dealing with selection of the image.
    String thePathOfTheImage;
    File theimage, selectedImage;    
    
    //What happens when we click on browse image.
    private void BrowseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseImageButtonActionPerformed
        JFileChooser imageChooser = new JFileChooser();
        imageChooser.showOpenDialog(null);
        selectedImage = imageChooser.getSelectedFile();
        thePathOfTheImage = selectedImage.getAbsolutePath();
        imagePathTextField.setText(thePathOfTheImage);
        theimage = new File(thePathOfTheImage);
        
        displayImage();
    }//GEN-LAST:event_BrowseImageButtonActionPerformed
    
    //Method to display images.
    public void displayImage(){
        /*
        ImageIcon image = new ImageIcon(photo);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        imageLabel.setIcon(newImage);
        */  
    }
    
    //What happens when we click on the save button.
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        //Step 1: Recieving Details from fields
        String firstName = fnameTxtField.getText();
        String lastName = lastNameTextField.getText();
        String phoneNumber = PhoneNumberTextField.getText();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String theDate = dateFormat.format(dateOfBirthDateChooser.getDate());
        
        String registrantType = null;
        if(RegistrantTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("Student"))
            registrantType = RegistrantType.Student.toString();
        if(RegistrantTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("Staff"))
            registrantType = RegistrantType.Staff.toString();
        if(RegistrantTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("Stakeholder"))
            registrantType = RegistrantType.Stakeholder.toString();    
        
        //Note that we are not recieving data of the image
        //This is because we have already recieved it using the Image Browser Button.
        
        //Step 2: Saving these user details in the POJO or Model Class.
        Users users = new Users(firstName, lastName, phoneNumber, theDate, registrantType, theimage);
        
        UserDao userDao = new UserDao();
        userDao.save(users);
        
        displayInTable();
        
        JOptionPane.showMessageDialog(this, "Bingo Saved Successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
        
        resetFields();
    }//GEN-LAST:event_saveButtonActionPerformed

    //What happens when we click on the update button.
    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       
        
        resetFields();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    //When we choose reset button.
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        resetFields();//We call the resetField method created above.
    }//GEN-LAST:event_ResetButtonActionPerformed

    //When we click on delete button.
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        
        resetFields();
    }//GEN-LAST:event_deleteButtonActionPerformed

    //When we click on Import excel button.
    private void importExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importExcelButtonActionPerformed
        
    }//GEN-LAST:event_importExcelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseImageButton;
    private javax.swing.JPanel CommandPanel;
    private javax.swing.JPanel ImageContentPanel;
    private javax.swing.JTextField PhoneNumberTextField;
    private javax.swing.JComboBox<String> RegistrantTypeComboBox;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JPanel dataPreviewPanel;
    private com.toedter.calendar.JDateChooser dateOfBirthDateChooser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField filterByTypeTextField;
    private javax.swing.JTextField fnameTxtField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTextField imagePathTextField;
    private javax.swing.JButton importExcelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
