package TreeBST;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        // Inserindo nó raiz
        No root = new No(10);
        root.next_left = new No();
        root.next_right = new No();
        tree.array_tree.add(root);

        // Inserindo novos nós
        tree.insert(root, 15);
        tree.insert(root, 16);
        tree.insert(root, 7);
        tree.insert(root, 8);
        tree.insert(root, 5);
        tree.insert(root, 1);

        // Convertendo uma árvore para um array
        System.out.println(Arrays.toString(tree.convert_array(root)));

        // Removendo o maior valor à direita de uma dada árvore
        tree.find(root,7);
        tree.down_tree(tree.find_one);
        System.out.println(tree.remove());

        for (int i = 0; i < tree.array_tree.size(); i++) {
            System.out.println("Esse foi o " +(i+1)+ "° nó a ser inserido \n"+ tree.array_tree.get(i) + "\n");
        }

    }
}
/*TODO:
   1 - Escrever uma função que recebe uma árvore e verifica se essa árvore é uma árvore binária de busca
   2 - Escrever uma função que transforme uma árvore binária de busca em um vetor crescente - OK
   3 - Escrever uma função para inserção de uma árvore de busca de forma recursiva - OK
   4 - Escrever uma função para remoção de uma árvore de busca de forma recursiva - OK
*/