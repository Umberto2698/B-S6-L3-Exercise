package lezione22.exceptions;

import java.util.UUID;

public class ItemoNotFoundException extends RuntimeException {
    public ItemoNotFoundException(UUID id) {
        super("Nessun elemento con questo id: " + id);
    }
}
