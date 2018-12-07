package avl;

public class No{

    Integer c;
    No e, d;

    No(Integer... valores){
        insere(valores);
    }

    public No(Integer c, No e, No d){
        this.c = c;
        this.e = e;
        this.d = d;
    }

    void setNo(No no){
        this.c = no.c;
        this.e = no.e;
        this.d = no.d;
    }

    void setE(No e){
        this.e = e;
    }

    void setD(No d){
        this.d = d;
    }

    No get(){
        return new No(c, e, d);
    }

    void insere(Integer... inteiros){
        for (Integer i : inteiros)
            insere(i);
    }

    void insere(Integer i){
        if (c == null)c = i;
        else if (i < c && e == null)e = new No(i);
        else if (i < c && e != null)e.insere(i);
        else if (i > c && d == null)d = new No(i);
        else if (i > c && d != null)d.insere(i);
        else throw new Error("Arvore só permite valores diferentes");
    }

    void equilibra(){
        if (e == null && d == null)return;
        balancear();
        if (e != null)e.equilibra();
        if (d != null)d.equilibra();
    }

    private void balancear(){
        int balanco = balanco();
        if (balanco > 1 && d.balanco() >= 0)rotacaoE();// esquerda
        else if (balanco > 1 && d.balanco() < 0)rotacaoDE();// dupla esquerda
        else if (balanco < -1 && e.balanco() < 0)rotacaoD();// direita
        else if (balanco < -1 && e.balanco() >= 0)rotacaoDD();// dupla direita
    }

    private void rotacaoE(){
        No ref = get(), x = d.e;
        setNo(d);
        e = ref;
        e.setD(x);
    }

    private void rotacaoD(){
        No ref = get(), x = e.d;
        setNo(e);
        d = ref;
        d.setE(x);
    }

    private void rotacaoDE(){
        d.rotacaoD();
        rotacaoE();
    }

    private void rotacaoDD(){
        e.rotacaoE();
        rotacaoD();
    }

    int alturaD(){
        return d == null ? 0 : 1 + d.alturaD();
    }

    int alturaE(){
        return e == null ? 0 : 1 + e.alturaE();
    }

    int balanco(){
        return alturaD() - alturaE();
    }

    @Override
    public String toString(){
        return String.format("%s (%s , %s)", c == null ? "-" : c.toString(), e == null ? "-" : e, d == null ? "-" : d);
    }

    void imprime(){
        System.out.println(this);
    }
}
