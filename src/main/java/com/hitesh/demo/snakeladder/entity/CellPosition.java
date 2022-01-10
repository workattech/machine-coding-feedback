package com.hitesh.demo.snakeladder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CellPosition {
    private int id;

    @Override
    public boolean equals(Object obj) {

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        final CellPosition other = (CellPosition) obj;

        return this.id == other.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
