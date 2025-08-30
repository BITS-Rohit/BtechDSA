package JAVA.PRACTICE.Maps;

import java.util.Arrays;

class MapsUsingHash {
    private final int DEFAULT_SIZE = 100;
    private Entity[] entities;

    MapsUsingHash() {
        entities = new Entity[DEFAULT_SIZE];
    }

    void put(String key, int value) {
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && !entities[hash].key.equals(key)) {
            // Handle collision using linear probing
            int originalHash = hash;
            do {
                hash = (hash + 1) % entities.length;
                if (hash == originalHash) {
                    throw new RuntimeException("Hashmap is full");
                }
            } while (entities[hash] != null && !entities[hash].key.equals(key));
        }
        entities[hash] = new Entity(key, value);
    }

    Integer get(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);
        int originalHash = hash;
        while (entities[hash] != null) {
            if (entities[hash].key.equals(key)) {
                return entities[hash].value;
            }
            hash = (hash + 1) % entities.length;
            if (hash == originalHash) break; // Avoid infinite loop
        }
        return null;
    }

    boolean remove(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);
        int originalHash = hash;
        while (entities[hash] != null) {
            if (entities[hash].key.equals(key)) {
                entities[hash] = null;
                return true;
            }
            hash = (hash + 1) % entities.length;
            if (hash == originalHash) break; // Avoid infinite loop
        }
        return false;
    }

    int getOrDefault(String key, int defaultValue) {
        Integer value = get(key);
        return value != null ? value : defaultValue;
    }

    void keySet() {
        System.out.print("[ ");
        for (Entity entity : entities) {
            if (entity != null) {
                System.out.print(entity.key + " ");
            }
        }
        System.out.println("]");
        System.out.println();
    }

    void valueSet() {
        System.out.print("[ ");
        for (Entity entity : entities) {
            if (entity != null) {
                System.out.print(entity.value + " ");
            }
        }
        System.out.println("]");
        System.out.println();
    }

    void entrySet() {
        System.out.print("[ ");
        for (Entity entity : entities) {
            if (entity != null) {
                System.out.print(entity.key + " = " + entity.value + " , ");
            }
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "MapsUsingHash{" +
                "DEFAULT_SIZE=" + DEFAULT_SIZE +
                ", entities=" + Arrays.toString(entities) +
                '}';
    }

    void clear() {
        entities = new Entity[DEFAULT_SIZE];
        System.gc();
    }

    boolean containsKey(String key) {
        return get(key) != null;
    }

}

class Entity {
    String key;
    int value;

    Entity(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
