package by.komikow.service.serviceInterface;

import by.komikow.entity.Unit;

import java.util.List;

public interface UnitService {
    public void createUnit(String unitName);
    public List<Unit> readUnit();
    public void updateUnitName(int id, String newName);

    public void deleteUnitById(int id);
}
