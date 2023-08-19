package by.komikow.controller;

import by.komikow.entity.Unit;
import by.komikow.service.serviceImplementation.UnitServiceImpl;
import by.komikow.service.serviceInterface.UnitService;

import java.util.List;

public class UnitController {
    private UnitService unitService = new UnitServiceImpl();

    public void createUnit(String unitName) {
        unitService.createUnit(unitName);
    }

    public List<Unit> readUnit() {
        return unitService.readUnit();
    }

    public void updateUnitName(int id, String newName) {
        unitService.updateUnitName(id, newName);
    }

    public void deleteUnitById(int id) {
        unitService.deleteUnitById(id);
    }
}
