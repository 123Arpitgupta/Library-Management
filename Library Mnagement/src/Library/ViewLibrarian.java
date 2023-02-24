
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JFrame {
    String x[]={"Id","Name","password","Email","contact","Address","City"};
     JButton bt;
     String y[][]=new String[20][7];
      int i=0,j=0;
      JTable t;
      Font f,f1;
      

      
      ViewLibrarian()
      {
        super("Librarian Information");
        setLocation(1,1);
        setSize(1000,400);
         f=new Font("Arial",Font.BOLD,25);
         try{
             ConnectionClass obj=new ConnectionClass();
              String q="select * from librarian";
              ResultSet rest=obj.stn.executeQuery(q);
              while(rest.next())
              {
                y[i][j++]=rest.getString("lid");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("password");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("contact");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("City");
                i++;
                j=0;
              
              }
              
              t = new JTable(y,x);
              t.setFont(f);
              
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
         JScrollPane sp= new JScrollPane(t);
         add(sp);
        
      }
      public static void main(String[] args)
      {
          new ViewLibrarian().setVisible(true);
      }
}



