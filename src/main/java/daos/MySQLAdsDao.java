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

    MySQLAdsDao (Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(), config.user, config.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {

        List<Ad> allAds = new ArrayList<>();

        String selectQuery = "SELECT * FROM ads";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                Ad ad = new Ad(rs.getLong("id"), rs.getLong("user_id"),
                        rs.getString("title"), rs.getString("description"));
                allAds.add(ad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allAds;
    }

    @Override
    public Long insert(Ad ad) {

        Long newRecord = null;

        String insert = "INSERT INTO ads (user_id, title, description) VALUES (" + ad.getUserId() + ",'" +
                ad.getTitle() + "','" + ad.getDescription() + "')";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                newRecord = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newRecord;
    }
}
