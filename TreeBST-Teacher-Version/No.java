package ABB;

public class No<T> {
    protected T info;
    protected No<T> esq, dir;

    public No(){
        this.info = null;
        this.esq = this.dir = null;
    }

    public No(T novoValor){
        this.esq = new No<>();
        this.dir = new No<>();
        this.info = novoValor;
    }
}
