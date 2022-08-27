import java.awt.Color;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;




public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        
        Student_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent e) {
                int i = Student_table.getSelectedRow();
                if (i >= 0) {
                    tf_name.setText((String) Student_table.getModel().getValueAt(i, 0));
                    tf_nachname.setText((String) Student_table.getModel().getValueAt(i, 1));
                    tf_matrikelnummer.setText((String) Student_table.getModel().getValueAt(i, 2));
                }            
           }

          
        });
        
        
        Dozent_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent e) {
                int i = Dozent_table.getSelectedRow();
                if (i >= 0) {
                    tf_name1.setText((String) Dozent_table.getModel().getValueAt(i, 0));
                    tf_nachname1.setText((String) Dozent_table.getModel().getValueAt(i, 1));
                    tf_ausweisnummer.setText((String) Dozent_table.getModel().getValueAt(i, 2));
                }            
           }

          
        });
        
        
        Lva_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent e) {
                int i = Lva_table.getSelectedRow();
                if (i >= 0) {
                    tf_lva.setText((String) Lva_table.getModel().getValueAt(i, 0));
                    tf_lvacode.setText((String) Lva_table.getModel().getValueAt(i, 1));
                    
                }            
           }

          
        });
        
        Student_othertable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent e) {
                int i = Student_othertable.getSelectedRow();
                if (i >= 0) {
                    
                    DefaultTableModel mydtm = (DefaultTableModel) Student_alllesson.getModel();
                    int rowCount = mydtm.getRowCount();
                    
                    for(int a = rowCount - 1; a>= 0; a--){
                        mydtm.removeRow(a);
                    }
                 
                  
                    String[] strarr;
                    strarr = new String[2];
                  
                    
                    
                    for(int a=0;a<uni.getStudenten().get(i).getLVA().size();a++){
                        
                     
                        strarr[0] = uni.getStudenten().get(i).getLVA().get(a).getLname();
                        strarr[1] = uni.getStudenten().get(i).getLVA().get(a).getLescode();
                        
                        mydtm.addRow(strarr);
                    }
                    
               
                }            
           }

          
        });
        
        
        
            Dozent_othertable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent e) {
                int i = Dozent_othertable.getSelectedRow();
                if (i >= 0) {
                    
                    DefaultTableModel mydtm = (DefaultTableModel) Dozent_alllesson.getModel();
                    int rowCount = mydtm.getRowCount();
                    
                    for(int a = rowCount - 1; a>= 0; a--){
                        mydtm.removeRow(a);
                    }
                 
                  
                    String[] strarr;
                    strarr = new String[2];
                  
                    
                    
                    for(int a=0;a<uni.getDozent().get(i).getLVA().size();a++){
                        
                     
                        strarr[0] = uni.getDozent().get(i).getLVA().get(a).getLname();
                        strarr[1] = uni.getDozent().get(i).getLVA().get(a).getLescode();
                        
                        mydtm.addRow(strarr);
                    }
                    
               
                }            
           }

          
        });
            
            
            lva_tableother.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent e) {
               if(uni.getLVA().size()>0){
                   int i = lva_tableother.getSelectedRow();
                if (i >= 0) {
                    
                    DefaultTableModel mydtm = (DefaultTableModel) allstudentforlva.getModel();
                    DefaultTableModel mydtm1 = (DefaultTableModel) alldozforlva.getModel();
                    
                    int rowCount = mydtm.getRowCount();
                    int rowCount2 = mydtm1.getRowCount();
                    
                    for(int a = rowCount - 1; a>= 0; a--){
                        mydtm.removeRow(a);
                    }
                    
                    for(int b = rowCount2 - 1; b>= 0; b--){
                        mydtm1.removeRow(b);
                    }
                 
                  
                    String[] strarr;
                    strarr = new String[3];
                    
                    String[] strarr2;
                    strarr2 = new String[3];
                  
                    
                    
                    for(int a=0;a<uni.getLVA().get(i).getAlleStundenten().size();a++){
                        
                     
                        strarr[0] = uni.getLVA().get(i).getAlleStundenten().get(a).getVorname();
                        strarr[1] = uni.getLVA().get(i).getAlleStundenten().get(a).getNachname();
                        strarr[2] = uni.getLVA().get(i).getAlleStundenten().get(a).getMatrikelNum();
                        
                        mydtm.addRow(strarr);
                    }
                    
                    for(int b=0;b<uni.getLVA().get(i).getAlleDozent().size();b++){
                        
                     
                        strarr2[0] = uni.getLVA().get(i).getAlleDozent().get(b).getVorname();
                        strarr2[1] = uni.getLVA().get(i).getAlleDozent().get(b).getNachname();
                        strarr2[2] = uni.getLVA().get(i).getAlleDozent().get(b).getAusweis();
                        
                        mydtm1.addRow(strarr2);
                    }
                    
               
                } 
               }
                    else{
                   JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA IM SYSTEM", "WARNUNG", JOptionPane.INFORMATION_MESSAGE);
               }
               
                           
           }

          
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        STDBUTTON = new javax.swing.JButton();
        DOZBUTTON = new javax.swing.JButton();
        LVABUTTON = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        stdPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tf_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_nachname = new javax.swing.JTextField();
        tf_matrikelnummer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addStd = new javax.swing.JButton();
        modifyStd = new javax.swing.JButton();
        rmvStd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Student_table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Searchsmt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lva_tablestd = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        Student_othertable = new javax.swing.JTable();
        removelvatostd = new javax.swing.JButton();
        addLVAtoStd = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        Student_alllesson = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dozPanel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        tf_name1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_nachname1 = new javax.swing.JTextField();
        tf_ausweisnummer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        adddoz = new javax.swing.JButton();
        modifydoz = new javax.swing.JButton();
        rmvdoz = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Dozent_table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lva_tabledoz = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Dozent_othertable = new javax.swing.JTable();
        removelvatodoz = new javax.swing.JButton();
        addlvatodoz = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        Dozent_alllesson = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lvaPanel = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        tf_lva = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_lvacode = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        addlva = new javax.swing.JButton();
        modifylva = new javax.swing.JButton();
        rmvlva = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        Lva_table = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        lva_tableother = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        allstudentforlva = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        alldozforlva = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROJECT");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        STDBUTTON.setText("Student");
        STDBUTTON.setBorder(null);
        STDBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STDBUTTONActionPerformed(evt);
            }
        });

        DOZBUTTON.setText("Dozent");
        DOZBUTTON.setBorder(null);
        DOZBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOZBUTTONActionPerformed(evt);
            }
        });

        LVABUTTON.setText("LVA");
        LVABUTTON.setBorder(null);
        LVABUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LVABUTTONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(STDBUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DOZBUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(LVABUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(STDBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(DOZBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(LVABUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 680));

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true));

        tf_name.setToolTipText("");
        tf_name.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tf_name.setName(""); // NOI18N
        tf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name :");

        jLabel2.setText("Nachname :");

        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Matrikelnummer (*) : ");

        tf_nachname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nachnameActionPerformed(evt);
            }
        });

        tf_matrikelnummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_matrikelnummerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("STUDENT HINZUFUEGEN/LOESCHEN/BEARBEITEN");

        addStd.setText("HINZUFUEGEN");
        addStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStdActionPerformed(evt);
            }
        });

        modifyStd.setText(" BEARBEITEN");
        modifyStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyStdActionPerformed(evt);
            }
        });

        rmvStd.setText("LOESCHEN");
        rmvStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvStdActionPerformed(evt);
            }
        });

        Student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nachname", "Matrikelnummer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Student_table);

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("(*) : OBLIGATORISCH");

        jLabel24.setText("Suchen:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rmvStd)
                        .addGap(18, 18, 18)
                        .addComponent(modifyStd)
                        .addGap(18, 18, 18)
                        .addComponent(addStd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tf_matrikelnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                            .addComponent(tf_nachname))))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addGap(26, 26, 26)
                                .addComponent(Searchsmt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searchsmt)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nachname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_matrikelnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyStd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmvStd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("STUDENT HINZUFUEGEN/LOESCHEN/BEARBEITEN", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        lva_tablestd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LVA", "LVA-Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(lva_tablestd);

        Student_othertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nachname", "Matrikelnummer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Student_othertable);

        removelvatostd.setText("LVA ABMELDEN");
        removelvatostd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removelvatostdActionPerformed(evt);
            }
        });

        addLVAtoStd.setText("LVA ANMELDEN");
        addLVAtoStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLVAtoStdActionPerformed(evt);
            }
        });

        Student_alllesson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LVA", "LVA-Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(Student_alllesson);

        jLabel11.setText("LVAS DES STUDENTS");

        jLabel12.setText("STUDENTEN");

        jLabel13.setText("ALLE LVAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(removelvatostd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addLVAtoStd)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removelvatostd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addLVAtoStd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addGap(105, 105, 105))
        );

        jTabbedPane2.addTab("ZUR LVA AN-/ABMELDEN", jPanel2);

        javax.swing.GroupLayout stdPanelLayout = new javax.swing.GroupLayout(stdPanel);
        stdPanel.setLayout(stdPanelLayout);
        stdPanelLayout.setHorizontalGroup(
            stdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        stdPanelLayout.setVerticalGroup(
            stdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("STUDENT", stdPanel);

        tf_name1.setToolTipText("");
        tf_name1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tf_name1.setName(""); // NOI18N
        tf_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_name1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Name :");

        jLabel7.setText("Nachname :");

        jLabel8.setForeground(new java.awt.Color(204, 0, 51));
        jLabel8.setText("Ausweisnummer (*) : ");

        tf_nachname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nachname1ActionPerformed(evt);
            }
        });

        tf_ausweisnummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ausweisnummerActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("DOZENT HINZUFUEGEN/LOESCHEN/BEARBEITEN");

        adddoz.setText("HINZUFUEGEN");
        adddoz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddozActionPerformed(evt);
            }
        });

        modifydoz.setText("BEARBEITEN");
        modifydoz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifydozActionPerformed(evt);
            }
        });

        rmvdoz.setText("LOESCHEN");
        rmvdoz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvdozActionPerformed(evt);
            }
        });

        Dozent_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nachname", "Ausweisnummer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Dozent_table);

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("(*) : OBLIGATORISCH");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 78, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_ausweisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(rmvdoz, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifydoz, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adddoz, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_nachname1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(tf_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nachname1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ausweisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adddoz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifydoz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmvdoz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 822, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("DOZENT HINZUFUEGEN/LOESCHEN/BEARBEITEN", jPanel4);

        lva_tabledoz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LVA", "LVA-Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(lva_tabledoz);

        Dozent_othertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nachname", "Matrikelnummer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(Dozent_othertable);

        removelvatodoz.setText("LVA LOESCHEN");
        removelvatodoz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removelvatodozActionPerformed(evt);
            }
        });

        addlvatodoz.setText("LVA HINZUFUEGEN");
        addlvatodoz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlvatodozActionPerformed(evt);
            }
        });

        Dozent_alllesson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LVA", "LVA-Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(Dozent_alllesson);

        jLabel14.setText("ZUGEWIESENE LVAS");

        jLabel15.setText("ALLE DOZENTEN");

        jLabel16.setText("ALLE LVAS");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(removelvatodoz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(56, 56, 56)
                                .addComponent(addlvatodoz)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removelvatodoz, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addlvatodoz, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("LVA ZUWEISEN/ABLASSEN", jPanel5);

        javax.swing.GroupLayout dozPanelLayout = new javax.swing.GroupLayout(dozPanel);
        dozPanel.setLayout(dozPanelLayout);
        dozPanelLayout.setHorizontalGroup(
            dozPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        dozPanelLayout.setVerticalGroup(
            dozPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("DOZENT", dozPanel);

        tf_lva.setToolTipText("");
        tf_lva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tf_lva.setName(""); // NOI18N
        tf_lva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_lvaActionPerformed(evt);
            }
        });

        jLabel17.setText("LVA :");

        jLabel19.setForeground(new java.awt.Color(204, 0, 51));
        jLabel19.setText("LVA-Code (*) : ");

        tf_lvacode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_lvacodeActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("LVA HINZUFUEGEN/LOESCHEN/BEARBEITEN");

        addlva.setText("HINZUFUEGEN");
        addlva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlvaActionPerformed(evt);
            }
        });

        modifylva.setText("BEARBEITEN");
        modifylva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifylvaActionPerformed(evt);
            }
        });

        rmvlva.setText("LOESCHEN");
        rmvlva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvlvaActionPerformed(evt);
            }
        });

        Lva_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LVA", "LVA-Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(Lva_table);

        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("(*) : OBLİGATORISCH");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel20))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_lva))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(rmvlva, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifylva, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addlva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_lvacode, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_lva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_lvacode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rmvlva, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifylva, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addlva, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("LVA HINZUFUEGEN/LOESCHEN/BEARBEITEN", jPanel6);

        lva_tableother.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LVA", "LVA-Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(lva_tableother);

        allstudentforlva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nachname", "Matrikelnummer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(allstudentforlva);

        jLabel22.setText("STUDENTEN DER LVA");

        jLabel23.setText("LVAS");

        alldozforlva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nachname", "Ausweisnummer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(alldozforlva);

        jLabel18.setText("ZUGEWIESENE DOZENTEN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("DOZENTEN/STUDENTEN DER LVA ZUWEISEN", jPanel7);

        javax.swing.GroupLayout lvaPanelLayout = new javax.swing.GroupLayout(lvaPanel);
        lvaPanel.setLayout(lvaPanelLayout);
        lvaPanelLayout.setHorizontalGroup(
            lvaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        lvaPanelLayout.setVerticalGroup(
            lvaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("LVA", lvaPanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 840, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void STDBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STDBUTTONActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_STDBUTTONActionPerformed

    private void DOZBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOZBUTTONActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_DOZBUTTONActionPerformed

    private void LVABUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LVABUTTONActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_LVABUTTONActionPerformed

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameActionPerformed

    private void tf_nachnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nachnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nachnameActionPerformed

    private void tf_matrikelnummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_matrikelnummerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_matrikelnummerActionPerformed

    private void addStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStdActionPerformed
        String name = tf_name.getText();
        String nachname = tf_nachname.getText();
        String matrikelnummer = tf_matrikelnummer.getText();
        
        if(matrikelnummer.length()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "MATRIKELNUMMER MUSS EINGEGEBEN WERDEN!", "WARNUNG", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(Student.numsuitable(matrikelnummer)){
            
            Student newstd = new Student(name,nachname,matrikelnummer);
            
            if(uni.getStudenten().contains(newstd)==false){
             
            
                uni.addStudent(newstd);
       
                String[] strarr;
                strarr = new String[3];
                strarr[0] = name;
                strarr[1] = nachname;
                strarr[2] = matrikelnummer;
        
                DefaultTableModel mydtm = (DefaultTableModel) Student_table.getModel();
                mydtm.addRow(strarr);
                
                DefaultTableModel mydtm2 = (DefaultTableModel) Student_othertable.getModel();
                mydtm2.addRow(strarr);
                
                
        
                tf_name.setText("");
                tf_nachname.setText("");
                tf_matrikelnummer.setText("");
        
                //uni.alleStudenten();
            }
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "MATRIKELNUMMER IST BEREITS REGISTRIERT!", "FEHLER", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "DIESE MATRIKELNUMMER IST UNGUELTIG. -MUSS AUS 7 ZIFFERN BESTEHEN -KEINE 0 AM ANFANG -KEINE BUCHSTABEN", "FEHLER", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_addStdActionPerformed

    private void rmvStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvStdActionPerformed
        
        if(uni.getStudenten().size()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT IM SYSTEM", "WARNUNG", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        else if(Student_table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT WURDE AUSGEWAEHLT", "WARNUNG", JOptionPane.INFORMATION_MESSAGE);
             
        }
        
        
         
        int index = Student_table.getSelectedRow();
        if(index>=0){
            uni.getStudenten().remove(index);
            DefaultTableModel mydtm = (DefaultTableModel) Student_table.getModel();
            mydtm.removeRow(index);
            
            DefaultTableModel mydtm2 = (DefaultTableModel) Student_othertable.getModel();
            mydtm2.removeRow(index);
            
            tf_name.setText("");
            tf_nachname.setText("");
            tf_matrikelnummer.setText("");
        }
            
    }//GEN-LAST:event_rmvStdActionPerformed

    private void modifyStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyStdActionPerformed
        
        if(uni.getStudenten().size()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT IM SYSTEM", "WARNUNG", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        else if(Student_table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT WURDE AUSGEWAEHLT", "WARNUNG", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        
        int index = Student_table.getSelectedRow();
        if(index>=0){
             Student temp = uni.getStudenten().get(index); 
        
             String matrikelnummer = tf_matrikelnummer.getText();
            
             
             if(Student.numsuitable(matrikelnummer)){
                temp.setVorname(tf_name.getText());
                temp.setNachname(tf_nachname.getText());
                temp.setlernNum(tf_matrikelnummer.getText());
             
             
                Student_table.getModel().setValueAt(temp.getVorname(), index, 0); 
                Student_table.getModel().setValueAt(temp.getNachname(), index, 1); 
                Student_table.getModel().setValueAt(temp.getMatrikelNum(), index, 2); 
                
                Student_othertable.getModel().setValueAt(temp.getVorname(), index, 0); 
                Student_othertable.getModel().setValueAt(temp.getNachname(), index, 1); 
                Student_othertable.getModel().setValueAt(temp.getMatrikelNum(), index, 2); 
             }
             else{
                 JOptionPane.showMessageDialog(jTabbedPane2, "DIESE MATRIKELNUMMER IST UNGUELTIG. -MUSS AUS 7 ZIFFERN BESTEHEN -KEINE 0 AM ANFANG -KEINE BUCHSTABEN", "FEHLER", JOptionPane.ERROR_MESSAGE);
             }
             
             
             
        }
    }//GEN-LAST:event_modifyStdActionPerformed

    private void rmvdozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvdozActionPerformed
        if(uni.getDozent().size()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        else if(Dozent_table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT WURDE AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
             
        }
        
        
         
        int index = Dozent_table.getSelectedRow();
        if(index>=0){
            uni.getDozent().remove(index);
            DefaultTableModel mydtm = (DefaultTableModel) Dozent_table.getModel();
            mydtm.removeRow(index);
            
            DefaultTableModel mydtm2 = (DefaultTableModel) Dozent_othertable.getModel();
            mydtm2.removeRow(index);
            
            tf_name1.setText("");
            tf_nachname1.setText("");
            tf_ausweisnummer.setText("");
        }
    }//GEN-LAST:event_rmvdozActionPerformed

    private void modifydozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifydozActionPerformed
        if(uni.getDozent().size()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        else if(Dozent_table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT WURDE AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        
        int index = Dozent_table.getSelectedRow();
        if(index>=0){
             Dozent temp = uni.getDozent().get(index); 
        
             String ausweisnummer = tf_ausweisnummer.getText();
            
             
             if(Dozent.Dozsuitable(ausweisnummer)){
                temp.setVorname(tf_name1.getText());
                temp.setNachname(tf_nachname1.getText());
                temp.setAusweis(tf_ausweisnummer.getText());
             
             
                Dozent_table.getModel().setValueAt(temp.getVorname(), index, 0); 
                Dozent_table.getModel().setValueAt(temp.getNachname(), index, 1); 
                Dozent_table.getModel().setValueAt(temp.getAusweis(), index, 2); 
                
                Dozent_othertable.getModel().setValueAt(temp.getVorname(), index, 0); 
                Dozent_othertable.getModel().setValueAt(temp.getNachname(), index, 1); 
                Dozent_othertable.getModel().setValueAt(temp.getAusweis(), index, 2);
             }
             else{
                 JOptionPane.showMessageDialog(jTabbedPane2, "DIE AUSWEISNUMMER IST UNGUELTIG. MUSS AUS 11 ZIFFERN BESTEHEN - KEINE BUCHSTABEN", "FEHLER", JOptionPane.ERROR_MESSAGE);
             }
             
             
             
        }
    }//GEN-LAST:event_modifydozActionPerformed

    private void adddozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddozActionPerformed
        String name = tf_name1.getText();
        String nachname = tf_nachname1.getText();
        String ausweis = tf_ausweisnummer.getText();
        
        if(ausweis.length()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "AUSWEISNUMMER MUSS EINGEGEBEN WERDEN", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(Dozent.Dozsuitable(ausweis)){
            
            Dozent newdoz = new Dozent(name,nachname,ausweis);
            
            if(uni.getDozent().contains(newdoz)==false){
             
            
                uni.addDozent(newdoz);
       
                String[] strarr;
                strarr = new String[3];
                strarr[0] = name;
                strarr[1] = nachname;
                strarr[2] = ausweis;
        
                DefaultTableModel mydtm = (DefaultTableModel) Dozent_table.getModel();
                mydtm.addRow(strarr);
                
                DefaultTableModel mydtm2 = (DefaultTableModel) Dozent_othertable.getModel();
                mydtm2.addRow(strarr);
        
                tf_name1.setText("");
                tf_nachname1.setText("");
                tf_ausweisnummer.setText("");
        
                //uni.alleDozen();
            }
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "AUSWEISNUMMER BEREITS REGISTRIERT", "FEHLER", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "DIE AUSWEISNUMMER IST UNGUELTIG. MUSS AUS 11 ZIFFERN BESTEHEN - KEINE BUCHSTABEN", "FEHLER", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_adddozActionPerformed

    private void tf_ausweisnummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ausweisnummerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ausweisnummerActionPerformed

    private void tf_nachname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nachname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nachname1ActionPerformed

    private void tf_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_name1ActionPerformed

    private void tf_lvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_lvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_lvaActionPerformed

    private void tf_lvacodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_lvacodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_lvacodeActionPerformed

    private void addlvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlvaActionPerformed
        String lva = tf_lva.getText();
        String lvacode = tf_lvacode.getText();
        
        
        if(lvacode.length()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "LVA-CODE MUSS EINGEGEBEN WERDEN", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(LVA.LVAsuitable(lvacode)){
            
            LVA newlva = new LVA(lva,lvacode);
            
            if(uni.getLVA().contains(newlva)==false){
             
            
                uni.addLVA(newlva);
       
                String[] strarr;
                strarr = new String[2];
                strarr[0] = lva;
                strarr[1] = lvacode;
              
        
                DefaultTableModel mydtm = (DefaultTableModel) Lva_table.getModel();
                mydtm.addRow(strarr);
                
                DefaultTableModel mydtm2 = (DefaultTableModel) lva_tablestd.getModel();
                mydtm2.addRow(strarr);
                
                DefaultTableModel mydtm3 = (DefaultTableModel) lva_tabledoz.getModel();
                mydtm3.addRow(strarr);
                
                DefaultTableModel mydtm4 = (DefaultTableModel) lva_tableother.getModel();
                mydtm4.addRow(strarr);
        
                tf_lva.setText("");
                tf_lvacode.setText("");
              
        
                //uni.alleLVA();
            }
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "LVA-CODE BEREITS REGISTRIERT", "FEHLER", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "LVA-CODE UNGUELTIG. DARF NUR 6 STELLEN HABEN DIEERSTEN 3 GROSSE BUCHSTABEN DIE LETZTEN 3 ZIFFERN", "FEHLER", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addlvaActionPerformed

    private void modifylvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifylvaActionPerformed
        if(uni.getLVA().size()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA IM SYSTEM.", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        else if(Lva_table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        
        int index = Lva_table.getSelectedRow();
        if(index>=0){
             LVA temp = uni.getLVA().get(index); 
        
             String lvacode = tf_lvacode.getText();
            
             
             if(LVA.LVAsuitable(lvacode)){
                temp.setLname(tf_lva.getText());
                temp.setLescode(tf_lvacode.getText());
            
              
                Lva_table.getModel().setValueAt(temp.getLname(), index, 0); 
                Lva_table.getModel().setValueAt(temp.getLescode(), index, 1); 
                
                lva_tablestd.getModel().setValueAt(temp.getLname(), index, 0); 
                lva_tablestd.getModel().setValueAt(temp.getLescode(), index, 1); 
                
                lva_tabledoz.getModel().setValueAt(temp.getLname(), index, 0); 
                lva_tabledoz.getModel().setValueAt(temp.getLescode(), index, 1); 
                
                lva_tableother.getModel().setValueAt(temp.getLname(), index, 0); 
                lva_tableother.getModel().setValueAt(temp.getLescode(), index, 1); 
                
                
              
             }
             else{
                 JOptionPane.showMessageDialog(jTabbedPane2, "LVA-CODE UNGUELTIG. DARF NUR 6 STELLEN HABEN DIEERSTEN 3 GROSSE BUCHSTABEN DIE LETZTEN 3 ZIFFERN", "FEHLER", JOptionPane.ERROR_MESSAGE);
             }
             
             
             
        }
    }//GEN-LAST:event_modifylvaActionPerformed

    private void rmvlvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvlvaActionPerformed
        if(uni.getLVA().size()<=0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA IM SYSTEM.", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        else if(Lva_table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
             
        }
        
        
         
        int index = Lva_table.getSelectedRow();
        if(index>=0){
            uni.getLVA().remove(index);
            DefaultTableModel mydtm = (DefaultTableModel) Lva_table.getModel();
            mydtm.removeRow(index);
            
            DefaultTableModel mydtm1 = (DefaultTableModel) lva_tablestd.getModel();
            mydtm1.removeRow(index);
            
            DefaultTableModel mydtm2 = (DefaultTableModel) lva_tabledoz.getModel();
            mydtm2.removeRow(index);
            
            DefaultTableModel mydtm3 = (DefaultTableModel) lva_tableother.getModel();
            mydtm3.removeRow(index);
            
            tf_lva.setText("");
            tf_lvacode.setText("");
            
        }
    }//GEN-LAST:event_rmvlvaActionPerformed

    private void addLVAtoStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLVAtoStdActionPerformed
        if(uni.getStudenten().size()>0){
            
            int indexstd = Student_othertable.getSelectedRow();
            int indexlva = lva_tablestd.getSelectedRow();
            int flag =0;
            
            
            if(indexstd>=0){
                
                if(uni.getLVA().size()>0){
                    
                    if(indexlva>=0){
                        
                        
                        
                    
                        for(int a=0;a<uni.getStudenten().get(indexstd).getstdLVAsize();a++){
                           
                            if(uni.getLVA().get(indexlva).equals(uni.getStudenten().get(indexstd).getLVA().get(a))){
                                flag = 1;
                            }
                        }
                        
                        
                        if(flag ==0){
                            
                            uni.getStudenten().get(indexstd).addLVA(uni.getLVA().get(indexlva));
                        uni.searchLVAforStd(uni.getLVA().get(indexlva).getLescode()).addStudent(uni.getStudenten().get(indexstd));
                       
                         String[] strarr;
                         strarr = new String[2];
                         strarr[0] = uni.getLVA().get(indexlva).getLname();
                         strarr[1] = uni.getLVA().get(indexlva).getLescode();
              
        
                        DefaultTableModel mydtm = (DefaultTableModel) Student_alllesson.getModel();
                        mydtm.addRow(strarr);
                        
                        JOptionPane.showMessageDialog(jTabbedPane2, "LVA HINZUGEFUEGT", "FERTIG", JOptionPane.INFORMATION_MESSAGE); 
                        
                        }
                        
                        else{
                          JOptionPane.showMessageDialog(jTabbedPane2, "LVA BEREITS REGISTRIERT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);   
                        }
                      
                         
                        
                           
                        
                        
                           
                       
                         
                 
                    }
                    else{
                       JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addLVAtoStdActionPerformed

    private void removelvatostdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removelvatostdActionPerformed
        if(uni.getStudenten().size()>0){
            
            int indexstd = Student_othertable.getSelectedRow();
            int indexlva = Student_alllesson.getSelectedRow();
            
                 
            if(indexstd>=0){
                
                if(uni.getStudenten().get(indexstd).getLVA().size()>0){
                    
                    if(indexlva>=0){
                        
              
                        uni.searchLVAforStd(uni.getStudenten().get(indexstd).getLVA().get(indexlva).getLescode()).removeStudent(uni.getStudenten().get(indexstd));
                        uni.getStudenten().get(indexstd).deleteLVA(uni.searchLVAforStd(uni.getStudenten().get(indexstd).getLVA().get(indexlva).getLescode()));
                        
                        
                        
                      
               
                        
                       // uni.searchLVAforStd(uni.getLVA().get(indexlva).getLescode()).removeStudent(uni.getStudenten().get(indexstd));
                      
             
                        DefaultTableModel mydtm = (DefaultTableModel) Student_alllesson.getModel();
                        mydtm.removeRow(indexlva);
                        
                        JOptionPane.showMessageDialog(jTabbedPane2, "LVA GELOESCHT", "FERTIG", JOptionPane.INFORMATION_MESSAGE); 
                        
                       
                         
                 
                    }
                    else{
                       JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(jTabbedPane2, "STUDENT IST KEINER LVA ANGEMELDET", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN STUDENT IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_removelvatostdActionPerformed

    private void removelvatodozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removelvatodozActionPerformed
        if(uni.getDozent().size()>0){
            
            int indexstd = Dozent_othertable.getSelectedRow();
            int indexlva = Dozent_alllesson.getSelectedRow();
            
            
            if(indexstd>=0){
                
                if(uni.getDozent().get(indexstd).getLVA().size()>0){
                    
                    if(indexlva>=0){
                        
                        
                
                        
                 
                        uni.searchLVAforDoz(uni.getDozent().get(indexstd).getLVA().get(indexlva).getLescode()).removeDozent(uni.getDozent().get(indexstd));
                        uni.getDozent().get(indexstd).removeLVA(uni.searchLVAforDoz(uni.getDozent().get(indexstd).getLVA().get(indexlva).getLescode()));
                    
                
                        DefaultTableModel mydtm = (DefaultTableModel) Dozent_alllesson.getModel();
                        mydtm.removeRow(indexlva);
                        
                        JOptionPane.showMessageDialog(jTabbedPane2, "LVA GELOESCHT", "FERTIG", JOptionPane.INFORMATION_MESSAGE); 
                           
                       
                         
                 
                    }
                    else{
                       JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(jTabbedPane2, "DOZENT IST KEINER LVA ZUGEWIESEN", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_removelvatodozActionPerformed

    private void addlvatodozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlvatodozActionPerformed
        if(uni.getDozent().size()>0){
            
            int indexstd = Dozent_othertable.getSelectedRow();
            int indexlva = lva_tabledoz.getSelectedRow();
            int flag = 0;
            
            
            if(indexstd>=0){
                
                if(uni.getLVA().size()>0){
                    
                    if(indexlva>=0){
                        
                        for(int a=0;a<uni.getDozent().get(indexstd).getDozLVAsize();a++){
                           
                            if(uni.getLVA().get(indexlva).equals(uni.getDozent().get(indexstd).getLVA().get(a))){
                                flag = 1;
                            }
                        }
                        
                        
                        if(flag ==0){
                            
                         uni.getDozent().get(indexstd).addLVA(uni.getLVA().get(indexlva));
                        uni.searchLVAforDoz(uni.getLVA().get(indexlva).getLescode()).addDozent(uni.getDozent().get(indexstd));
                        uni.getLVA().get(indexlva).printdoz();
                       
                         String[] strarr;
                         strarr = new String[2];
                         strarr[0] = uni.getLVA().get(indexlva).getLname();
                         strarr[1] = uni.getLVA().get(indexlva).getLescode();
              
        
                        DefaultTableModel mydtm = (DefaultTableModel) Dozent_alllesson.getModel();
                        mydtm.addRow(strarr);
                        
                        JOptionPane.showMessageDialog(jTabbedPane2, "DOZENT IST DER LVA ZUGEWIESEN", "FERTIG", JOptionPane.INFORMATION_MESSAGE); 
                        
                        }
                        
                        else{
                          JOptionPane.showMessageDialog(jTabbedPane2, "DOZENT BEREITS ZUGEWIESEN", "FEHLER", JOptionPane.INFORMATION_MESSAGE);   
                        }
                        
                           
                        
                        
                           
                       
                         
                 
                    }
                    else{
                       JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(jTabbedPane2, "KEINE LVA IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT AUSGEWAEHLT", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(jTabbedPane2, "KEIN DOZENT IM SYSTEM", "FEHLER", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addlvatodozActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DOZBUTTON;
    private javax.swing.JTable Dozent_alllesson;
    private javax.swing.JTable Dozent_othertable;
    private javax.swing.JTable Dozent_table;
    private javax.swing.JButton LVABUTTON;
    private javax.swing.JTable Lva_table;
    private javax.swing.JButton STDBUTTON;
    public static javax.swing.JTextField Searchsmt;
    private javax.swing.JTable Student_alllesson;
    private javax.swing.JTable Student_othertable;
    public static javax.swing.JTable Student_table;
    private javax.swing.JButton addLVAtoStd;
    private javax.swing.JButton addStd;
    private javax.swing.JButton adddoz;
    private javax.swing.JButton addlva;
    private javax.swing.JButton addlvatodoz;
    private javax.swing.JTable alldozforlva;
    private javax.swing.JTable allstudentforlva;
    private javax.swing.JPanel dozPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel lvaPanel;
    private javax.swing.JTable lva_tabledoz;
    private javax.swing.JTable lva_tableother;
    private javax.swing.JTable lva_tablestd;
    private javax.swing.JButton modifyStd;
    private javax.swing.JButton modifydoz;
    private javax.swing.JButton modifylva;
    private javax.swing.JButton removelvatodoz;
    private javax.swing.JButton removelvatostd;
    private javax.swing.JButton rmvStd;
    private javax.swing.JButton rmvdoz;
    private javax.swing.JButton rmvlva;
    private javax.swing.JPanel stdPanel;
    private javax.swing.JTextField tf_ausweisnummer;
    private javax.swing.JTextField tf_lva;
    private javax.swing.JTextField tf_lvacode;
    private javax.swing.JTextField tf_matrikelnummer;
    private javax.swing.JTextField tf_nachname;
    private javax.swing.JTextField tf_nachname1;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_name1;
    // End of variables declaration//GEN-END:variables


    static Main mainmenu = new Main();
    Universitaet uni = new Universitaet("TAU","Istanbul",false);


public static void main(String[] args) {
    
        mainmenu.setVisible(true);
        search();

    }


public static void search(){
    
    TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(Student_table.getModel());
     
     Student_table.setRowSorter(rowSorter);
     
     int i = Student_table.getSelectedRow();
    if(i>0){   
     Student_table.convertRowIndexToView(i);
    }
    
    Searchsmt.getDocument().addDocumentListener(new DocumentListener(){
        
            
            int i= Student_table.getSelectedRow();
            

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = Searchsmt.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = Searchsmt.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    
     
    }

}