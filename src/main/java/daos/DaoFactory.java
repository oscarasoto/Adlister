package daos;

public class DaoFactory {
    private static Ads adsDao;

    static private Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;

    }

    public static Users userDao() {
        return new ArrayListUsers();
    }

}


