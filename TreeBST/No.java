package TreeBST;

public class No {
    int value = Integer.MIN_VALUE + 1;
    No next_left;
    No next_right;
    public No(int value) {
        this.value = value;
    }
    public No() {
    }
    @Override
    public String toString() {
        String value_left = (this.next_left.value == Integer.MIN_VALUE + 1)? "Null": String.valueOf(this.next_left.value);
        String value_right = (this.next_right.value == Integer.MIN_VALUE + 1)? "Null": String.valueOf(this.next_right.value);
        return "O Nó atual é de valor: " + this.value + "\n" +
                "O Nó da esquerda tem o valor: " + value_left  + "\n" +
                "O Nó da direita tem o valor: " + value_right;
    }
}
