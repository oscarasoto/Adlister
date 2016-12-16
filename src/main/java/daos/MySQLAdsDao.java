package daos;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oscarsoto on 12/15/16.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class MySQLAdsDao implements Ads {

    private Connection connection;

    MySQLAdsDao (Config config){

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(), config.user, config.password );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ad> all() throws SQLException {

        List<Ad> allAds = new ArrayList<>();


        String selectQuery = "SELECT * FROM ads";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);

        while (rs.next()) {
            Ad ad = new Ad(rs.getLong("id"), rs.getLong("user_id"),
                    rs.getString("title"), rs.getString("description"));
            allAds.add(ad);
        }
        return allAds;

    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
