# PreparedStatement小结



一般认知里，使用PrepareStatement 是可以防止sql注入的

![image-20200524164724337](/Users/dn/Library/Application Support/typora-user-images/image-20200524164724337.png)

```
import java.sql.*;

public class t1 {

    static Connection conn = null;
    static Statement stmt = null;
    public static void main(String[] args) {

        try {
            getconnection();
            selectAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }


    public static void  getconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC",
                "root","12341234");
    }

    public static void selectAll() throws SQLException {

        stmt = conn.createStatement();

        String sql= "select * from user";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt("id");
            String accountId = rs.getString("name");
            String shopId =rs.getString("sex");

            System.out.println(id+" "+accountId+" "+shopId);

        }
    }

}

```



```java
   public static void selectByAge(int age) throws SQLException {

        stmt = conn.createStatement();

        String sql= "select * from user where age="+age +" and cansee =1 ";
				  System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt("id");
            String accountId = rs.getString("name");
            String shopId =rs.getString("sex");

            System.out.println(id+" "+accountId+" "+shopId);

        }
    }

```

```java
selectBySex("男");
selectBySex("男' -- ");
```

![image-20200524164638718](/Users/dn/Library/Application Support/typora-user-images/image-20200524164638718.png)





```java
public static void selectBySexUsePrepareStatement(String sex) throws SQLException {

        String sql = "select * from user where sex = ? and cansee = 1";  // 含有参数

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,sex);
        System.out.println(pst);

        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            int id = rs.getInt("id");
            String accountId = rs.getString("name");
            String shopId =rs.getString("sex");
            boolean cansee = rs.getBoolean("cansee");
            int cansee1 = rs.getInt("cansee");

            System.out.println(id+" "+accountId+" "+shopId+" "+cansee+" "+cansee1);

        }
    }
```

```java
selectBySexUsePrepareStatement("男");
selectBySexUsePrepareStatement("男"+" -- ");
```



![image-20200524171358019](/Users/dn/Library/Application Support/typora-user-images/image-20200524171358019.png)