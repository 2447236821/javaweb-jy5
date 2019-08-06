import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by username on 2019/8/5.
 */
public class testDemo {
   @Test
    public void test1() throws Exception{
        ComboPooledDataSource co=new ComboPooledDataSource();
        Connection connection=co.getConnection();
        String sql="select * from uu";
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(2));
        };
    }

}
