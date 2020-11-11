package controlador;

import Modelo.Country;
import conexionBD.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Tarditi
 */
public class GestorCountry {

    Conexion conn = new Conexion();
    Connection conexion = conn.establecerConexion();

    public List<Country> dameListaPaises() {
        ResultSet rs = null;
        Country country = new Country();
        List<Country> countrys = new ArrayList<Country>();

        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("SELECT DISTINCT region FROM country");
            while (rs.next()) {
                country = new Country();
                country.setRegion(rs.getString("Region"));
                countrys.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return countrys;
    }
    
    public List<Country> dameReportePais(String region, String name) {
        ResultSet rs = null;
        Country country = new Country();
        List<Country> countrys = new ArrayList<>();

        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("SELECT ciudad.name cityName, ciudad.population, pais.name countryName, pais.region FROM city ciudad INNER JOIN country pais ON ciudad.CountryCode = pais.code WHERE pais.region = '" + region + "' AND pais.name LIKE '%"+ name +"%' ORDER BY pais.name");
            while (rs.next()) {
                country = new Country();
                country.setNombreCiudad(rs.getString("cityName"));
                country.setPopulation(rs.getInt("Population"));
                country.setNombrePais(rs.getString("countryName"));
                country.setRegion(rs.getString("Region"));
                countrys.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return countrys;
    }

}
