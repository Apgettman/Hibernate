import java.util.List;

public interface CityDAO {

    void createCity (City city);

    City getByIdCity ( int id);

    List<City> getAllCity ();

    void updateCity (City city);

    void deleteCity (City city);
}
