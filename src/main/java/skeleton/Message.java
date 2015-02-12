package skeleton;

public class Message {
    private final String key;
    private final String value;

    public Message(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        Message message = (Message) o;
        return key.equals(message.key) && value.equals(message.value);

    }

    @Override
    public int hashCode() {
        return 31 * key.hashCode() + value.hashCode();
    }
}
