package ABB;

/**
 * Classe Árvore de Busca Binária que recebe um tipo genérico
 * que obrigatoriamente deve implementar o método compareTo()
 *
 * @param <T>
 */
public class Abb<T extends Comparable<T>> {
    /**
     * O atributo raiz é o que guarda o início da árvore.
     */
    protected No<T> raiz;

    /**
     * Método construtor da Classe ABB que inicializa o atributo raiz com
     * um objeto da classe No, cujas informações são todas nulas.
     */
    public Abb() {
        this.raiz = new No<>();
    }

    /**
     * Método que recebe o novo valor a ser inserido na ABB e retorna
     * true ou false se a inserção for bem sucedida.
     *
     * @param novoValor
     * @return
     */
    public boolean adicionar(T novoValor) {
        return adicionar(this.raiz, novoValor);
    }

    /**
     * Método recursivo que recebe a raiz da árvore no atributo ptr,
     * que aqui é utilizado como um ponteiro auxiliar que visita os Nós da ABB.
     * Essa função adiciona um novo Nó na árvore ABB.
     */
    private boolean adicionar(No<T> ptr, T novoValor) {
        //Se o ptr.info for nulo é neste Nó que faremos a inserção do novoValor
        if (ptr.info == null) {
            ptr.info = novoValor;
            ptr.esq = new No<>();
            ptr.dir = new No<>();
            return true;
        }
        //Se o novo valor já existir na árvore
        if (novoValor.compareTo(ptr.info) == 0) {
            return false;
        }
        if (novoValor.compareTo(ptr.info) > 0) {
            return adicionar(ptr.dir, novoValor);
        }
        return adicionar(ptr.esq, novoValor);
    }

    public T remover(){
        No<T> start = this.raiz.esq;
        return remover(start);
    }
    private T remover(No<T> prt) {
        No<T> noPai = prt;
        T valorRemoval = null;
        if (noPai.dir.info != null) {
            return remover(noPai.dir);
        }
        if (noPai.esq.info != null) {
            if (noPai.esq.esq.info != null && noPai.esq.dir.info != null) {
                // Tem dois filhos
                noPai.dir = noPai.esq.dir;
                noPai.info = noPai.esq.info;
                noPai.esq = noPai.esq.esq;
            } else if (noPai.esq.esq.info != null) {
                // Tem só um filho esquerdo
                noPai.info = noPai.esq.info;
                noPai.esq = noPai.esq.esq;

            } else if (noPai.esq.dir.info != null) {
                // Tem só um filho direito
                noPai.info = noPai.dir.info;
                noPai.dir = noPai.esq.dir;
            }
        } else {
            valorRemoval = noPai.info;
            noPai.info = null;

        }
        return valorRemoval;
    }

    /**
     * Método retorna uma string contendo as informações dos Nós da ABB
     * EM ORDEM
     *
     * @return
     */
    @Override
    public String toString() {
        return toString(this.raiz, "");
    }

    public String toString(No<T> ptr, String abbEmOrdem) {
        if (ptr.esq.info != null) abbEmOrdem = toString(ptr.esq, abbEmOrdem);
        if (ptr.info != null) abbEmOrdem += ptr.info.toString() + " ";
        if (ptr.dir.info != null) abbEmOrdem = toString(ptr.dir, abbEmOrdem);
        return abbEmOrdem;
    }


}
