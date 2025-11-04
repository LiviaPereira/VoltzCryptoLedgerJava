package br.com.voltz.model;

import java.util.Objects;


public abstract class EntidadeBase implements Imprimivel {
    protected int id;

    public EntidadeBase(int id) { this.id = id; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadeBase that = (EntidadeBase) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
