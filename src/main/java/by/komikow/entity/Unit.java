package by.komikow.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "units")
@Data
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private int unitId;

    @Column(name = "unit_name")
    private String unitName;

    public Unit() {
    }

    public Unit(int unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }
}
