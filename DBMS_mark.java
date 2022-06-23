import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DBMS_mark {
    private JPanel main;
    private JTextField txtName;
    private JTextField txtPrice;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField txtid;
    private JButton searchButton;
    private JTextField txtQty;
    private JTable table1;
    private JTextField txtnumber;
    private JTextField txtemail;
    private JTextField txtd;
    private JTextField txtb;
    private JButton calculationButton;
    private JTextField txtcse;
    private JTextField txtphy;
    private JTextField txtmath;
    private JTextField txteng;
    private JTextField txtbangla;
    private JTextField txttotal;
    private JTextField txtavg;
    private JTextField txtcg;
    private JTextField txtresult;
    private JButton refresh;
    private  JScrollPane table_1;

    public static void main(String[] args) {//main
        JFrame frame = new JFrame("SADIA-04");
        frame.setContentPane(new DBMS_mark().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst;

    public DBMS_mark() {
        Connect();
        table_load();

        saveButton.addActionListener(new ActionListener() {//save
            @Override
            public void actionPerformed(ActionEvent e) {


         String Name,ID,Department,Batch,PhoneNumber,Email,PHY,MATH,ENG,BAN,CSE,Total,Avg,CGPA,Result;

         Name = txtName.getText();
         ID = txtid.getText();
         Department = txtd.getText();
         Batch = txtb.getText();
         PhoneNumber = txtnumber.getText();
         Email = txtemail.getText();
         PHY = txtphy.getText();
         MATH = txtmath.getText();
         ENG = txteng.getText();
         BAN = txtbangla.getText();
         CSE = txtcse.getText();
         Total = txttotal.getText();
         Avg = txtavg.getText();
         CGPA = txtcg.getText();
         Result = txtresult.getText();


         try{
             pst = con.prepareStatement("insert into student3(Name,ID,Department,Batch,PhoneNumber,Email,PHY,MATH,ENG,BAN,CSE,Total,Avg,CGPA,Result)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,Name);
            pst.setString(2,ID);
            pst.setString(3,Department);
            pst.setString(4,Batch);
            pst.setString(5,PhoneNumber);
            pst.setString(6,Email);
            pst.setString(7,PHY);
            pst.setString(8,MATH);
            pst.setString(9,ENG);
            pst.setString(10,BAN);
            pst.setString(11,CSE);
            pst.setString(12,Total);
            pst.setString(13,Avg);
            pst.setString(14,CGPA);
            pst.setString(15,Result);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
            txtName.setText("");
            txtid.setText("");
            txtd.setText("");
            txtb.setText("");
            txtnumber.setText("");
            txtemail.setText("");

            txtphy.setText("");
            txtmath.setText("");
            txteng.setText("");
            txtbangla.setText("");
            txtcse.setText("");
            txttotal.setText("");
            txtavg.setText("");
            txtcg.setText("");
            txtresult.setText("");





            txtName.requestFocus();



         }
         catch (SQLException e1){
             e1.printStackTrace();
         }




            }
        });
        //save b end


        //search
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{


                    String ID = txtid.getText();

                    pst = con.prepareStatement("select Name,Department,Batch,PhoneNumber,Email,PHY,MATH,ENG,BAN,CSE,Total,Avg,CGPA,Result from student3 where ID = ?");

                    pst.setString(1,ID);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true){
                        String Name = rs.getString(1);
                        String Department = rs.getString(2);
                        String Batch = rs.getString(3);
                        String PhoneNumber = rs.getString(4);
                        String Email = rs.getString(5);

                        String PHY = rs.getString(6);
                        String MATH = rs.getString(7);
                        String ENG = rs.getString(8);
                        String BAN = rs.getString(9);
                        String CSE = rs.getString(10);
                        String Total = rs.getString(11);
                        String Avg = rs.getString(12);
                        String CGPA = rs.getString(13);
                        String Result = rs.getString(14);


                        txtName.setText(Name);
                        txtd.setText(Department);
                        txtb.setText(Batch);
                        txtnumber.setText(PhoneNumber);
                        txtemail.setText(Email);

                        txtphy.setText(PHY);
                        txtmath.setText(MATH);
                        txteng.setText(ENG);
                        txtbangla.setText(BAN);
                        txtcse.setText(CSE);
                        txttotal.setText(Total);
                        txtavg.setText(Avg);
                        txtcg.setText(CGPA);
                        txtresult.setText(Result);

                    }
                    else{
                        txtName.setText("");
                        txtd.setText("");
                        txtb.setText("");
                        txtnumber.setText("");
                        txtemail.setText("");

                        txtphy.setText("");
                        txtmath.setText("");
                        txteng.setText("");
                        txtbangla.setText("");
                        txtcse.setText("");
                        txttotal.setText("");
                        txtavg.setText("");
                        txtcg.setText("");
                        txtresult.setText("");

                        JOptionPane.showMessageDialog(null,"invalid");

                    }
                }
                catch (SQLException ex){
                    ex.printStackTrace();

                }

            }
        });


        //end
        //update
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name,ID,Department,Batch,PhoneNumber,Email,PHY,MATH,ENG,BAN,CSE,Total,Avg,CGPA,Result;

                Name = txtName.getText();
                ID = txtid.getText();
                Department = txtd.getText();
                Batch = txtb.getText();
                PhoneNumber = txtnumber.getText();
                Email = txtemail.getText();
                PHY = txtphy.getText();
                MATH = txtmath.getText();
                ENG = txteng.getText();
                BAN = txtbangla.getText();
                CSE = txtcse.getText();
                Total = txttotal.getText();
                Avg = txtavg.getText();
                CGPA = txtcg.getText();
                Result = txtresult.getText();


                try {
                    pst = con.prepareStatement("update student3 set  Name=?,Department=?,Batch=?,PhoneNumber=?,Email=?,PHY =?,MATH=?,ENG=?,BAN=?,CSE=?,Total=?,Avg=?,CGPA=?,Result=? where ID = ? ");
                    //  PHY =?,MATH=?,ENG=?,BAN=?,CSE=?,Total=?,Avg=?,CGPA=?,Result=?
                    pst.setString(1,Name);
                    pst.setString(2,Department);
                    pst.setString(3,Batch);
                    pst.setString(4,PhoneNumber);
                    pst.setString(5,Email);

                    pst.setString(6,PHY);
                    pst.setString(7,MATH);
                    pst.setString(8,ENG);
                    pst.setString(9,BAN);
                    pst.setString(10,CSE);
                    pst.setString(11,Total);
                    pst.setString(12,Avg);
                    pst.setString(13,CGPA);
                    pst.setString(14,Result);

                    pst.setString(15,ID);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"update");

                    txtName.setText("");

                    txtd.setText("");
                    txtb.setText("");
                    txtnumber.setText("");
                    txtemail.setText("");
                    txtphy.setText("");
                    txtmath.setText("");
                    txteng.setText("");
                    txtbangla.setText("");
                    txtcse.setText("");
                    txttotal.setText("");
                    txtavg.setText("");
                    txtcg.setText("");
                    txtresult.setText("");

                    txtName.requestFocus();
                    txtid.setText("");
                }
                catch (SQLException e1){
                    e1.printStackTrace();
                }

            }
        });
        //end

        //delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String bid;
               bid = txtid.getText();
                try {
                    pst = con.prepareStatement("delete from student3 where ID = ? ");
                    pst.setString(1,bid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"delete");

                    txtName.setText("");

                    txtd.setText("");
                    txtb.setText("");
                    txtnumber.setText("");
                    txtemail.setText("");

                    txtphy.setText("");
                    txtmath.setText("");
                    txteng.setText("");
                    txtbangla.setText("");
                    txtcse.setText("");
                    txttotal.setText("");
                    txtavg.setText("");
                    txtcg.setText("");
                    txtresult.setText("");

                    txtName.requestFocus();
                    txtid.setText("");
                }
                catch (SQLException e1){
                    e1.printStackTrace();
                }

            }
        });



    }

void table_load(){

        try {
            pst = con.prepareStatement("select * from student3");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            table1.setAutoResizeMode(table1.AUTO_RESIZE_OFF);

        }
        catch (SQLException e1){
            e1.printStackTrace();
        }


}


    public void Connect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/result","root","");
            System.out.println("Success");

        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        //calculator
        calculationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

///// 36-100 me
                int m1,m2,m3,m4,m5,t;//5 num input and total
                double a;//for avg


                m1 = Integer.parseInt(txtcse.getText());
                m2 = Integer.parseInt(txtphy.getText());
                m3 = Integer.parseInt(txtmath.getText());
                m4 = Integer.parseInt(txteng.getText());
                m5 = Integer.parseInt(txtbangla.getText());
                //total
                t = m1+m2+m3+m4+m5;
                txttotal.setText(String.valueOf(t));
                //avg
                a = t/5;

                txtavg.setText(String.valueOf(a));
                ////
                //gpa
                if(a>=80&&a<=100)
                {
                    txtcg.setText("A+");
                }
                else if(a>=75&&a<80)
                {
                    txtcg.setText("A");
                }
                else if(a>=70&&a<75)
                {
                    txtcg.setText("A-");
                }
                else if(a>=65&&a<70)
                {
                    txtcg.setText("B+");
                }
                else if(a>=60&&a<65)
                {
                    txtcg.setText("B");
                }
                else if(a>=55&&a<60)
                {
                    txtcg.setText("B-");
                }
                else if(a>=45&&a<50)
                {
                    txtcg.setText("C");
                }
                else if(a>=40&&a<45)
                {
                    txtcg.setText("D");
                }
                else
                {
                    txtcg.setText("F");
                }
                ////
                //result
                if(m1>=40&&m2>=40&&m3>=40&&m4>=40&&m5>=40)
                {
                    txtresult.setText("Pass");
                }
                else
                {
                    txtresult.setText("Fail");
                }

                //done ;;;;;;



            }
        });
    }
}
