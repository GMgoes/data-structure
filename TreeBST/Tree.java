package TreeBST;
import java.util.ArrayList;
public class Tree {
    ArrayList<No> array_tree = new ArrayList<No>();
    ArrayList<Integer> vet = new ArrayList<Integer>();
    No find_one = null;
    No find_to_remove = null;
    // TODO: Implementar uma forma para ele fazer essa logística automaticamente (Dividir em função insere e função desce)
    public void insert(No father, int value) {
        if (father.value == Integer.MIN_VALUE + 1) {
            father.value = value;
            father.next_left = new No();
            father.next_right = new No();
            array_tree.add(father);
        } else {
            if (value > father.value) {
                // Insere para a direita
                insert(father.next_right, value);
            }
            if (value < father.value) {
                // Insere para a esquerda
                insert(father.next_left, value);
            }
        }
    }
    public int [] convert_array(No root){
        in_order(root);
        int [] convert_vet = new int[vet.size()];

        for (int i = 0; i < convert_vet.length; i++) {
            convert_vet[i] = (Integer) vet.get(i);
        }
        return convert_vet;
    }
    public void in_order(No actual_node) {
        if (actual_node.value != Integer.MIN_VALUE + 1) {
            in_order(actual_node.next_left);
            vet.add(actual_node.value);
            in_order(actual_node.next_right);
        }
    }
    public void find(No father, int value_to_remove){
        if(father.value == value_to_remove){
            find_one = father;
        }
        // Anda pra direita
        if(father.value < value_to_remove){
            find(father.next_right, value_to_remove);
        }
        // Anda pra esquerda
        if(father.value > value_to_remove){
            find(father.next_left, value_to_remove);
        }
    }
    public void down_tree(No find_one){
        No actual_no = find_one;
        if(actual_no.next_right.value == Integer.MIN_VALUE + 1 ){
            find_to_remove = actual_no;
        }else {
            down_tree(actual_no.next_right);
        }
    }
    public int remove(){
        int retired = 0;
        int index_retired = -1;
        if(find_to_remove.next_left.value == Integer.MIN_VALUE + 1){
            retired = find_to_remove.value;
            find_to_remove.value = Integer.MIN_VALUE + 1;
        } else {
            retired = find_to_remove.value;
            find_to_remove.value = find_to_remove.next_left.value;
            find_to_remove.next_left = find_to_remove.next_left.next_right;
        }
        for (int i = 0; i < array_tree.size(); i++) {
            if(array_tree.get(i).value == Integer.MIN_VALUE + 1){
                index_retired = i;
            }
        }
        if(index_retired != -1){
            array_tree.remove(index_retired);
            System.out.println("OK");
        }
        return retired;
    }
}
