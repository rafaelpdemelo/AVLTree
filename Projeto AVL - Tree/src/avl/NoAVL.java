package avl;

import base.No;

public class NoAVL extends No {

    private int fatorBalanceamento;

    public NoAVL getNoEsquerda() {
        return this.getEsquerda();
    }

    public NoAVL getNoDireita() {
        return this.getDireita();
    }

    public void setNoEsquerda(NoAVL no) {
        this.setEsquerda(no);
    }

    public void setNoDireita(NoAVL no) {
        this.setDireita(no);
    }

    public NoAVL(int chave) {
        super(chave);
        fatorBalanceamento = 0;
    }

    public int getBalanceamento() {
        return fatorBalanceamento;
    }

    public void setBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

}
