package by.komikow.repositorie;

import by.komikow.entity.Unit;
import by.komikow.util.HibernateUtil;
import by.komikow.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitRepository {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void createUnit(String unitName) {
        String query = "insert into units (unit_name) " +
                "values ('" + unitName + "')";
        Utils.executeRequest(query);
        System.out.println("Единица измерения " + unitName + " успешно добавлен");
    }

    public List<Unit> readUnit() {
        List<Unit> unitList = new ArrayList<>();
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery("select * from units");
            while (resultSet.next()) {
                int unitId = resultSet.getInt("unit_id");
                String unitName = resultSet.getString("unit_name");
                Unit unit = new Unit(unitId, unitName);
                unitList.add(unit);
            }
            return unitList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUnitName(int id, String newName) {
        String query = "update units set unit_name='" + newName + "' where unit_id = " + id;
        Utils.executeRequest(query);
        System.out.println("Наименование единицы измерения изменено на " + newName);
    }

    public void deleteUnitById(int id) {
        String query = "delete from units where unit_id=" + id;
        Utils.executeRequest(query);
        System.out.println("Единица измерения с id = " + id + " удалёна.");
    }
}
