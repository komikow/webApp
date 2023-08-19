package by.komikow.service.serviceImplementation;

import by.komikow.entity.Unit;
import by.komikow.repositorie.UnitRepository;
import by.komikow.service.serviceInterface.UnitService;

import java.util.List;

public class UnitServiceImpl implements UnitService {
    private UnitRepository unitRepository = new UnitRepository();

    @Override
    public void createUnit(String unitName) {
        unitRepository.createUnit(unitName);
    }

    @Override
    public List<Unit> readUnit() {
        return unitRepository.readUnit();
    }

    @Override
    public void updateUnitName(int id, String newName) {
        unitRepository.updateUnitName(id, newName);
    }

    @Override
    public void deleteUnitById(int id) {
        unitRepository.deleteUnitById(id);
    }
}
