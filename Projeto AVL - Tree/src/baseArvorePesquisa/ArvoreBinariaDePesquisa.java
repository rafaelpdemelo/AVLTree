package baseArvorePesquisa;

import base.AbstractArvoreBinariaDePesquisa;
import base.MostrarArvoreUtil;
import base.No;

public class ArvoreBinariaDePesquisa extends AbstractArvoreBinariaDePesquisa<No> {
    @Override
    public No novoNode(int key) {
        //Altera
        return new No(key);
    }

    @Override
    public No inserir(int key) {
        No n =  inserirNoHelper(raiz, key);
        //Altera
        return n;
    }

    @Override
    public No procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public void deletar(int key) {
        raiz = deletarNoHelper(raiz, key);
        //alteracao
    }

    public static void main(String[] args) {
        ArvoreBinariaDePesquisa a = new ArvoreBinariaDePesquisa();
        a.inserir(10);
        a.inserir(1);
        a.inserir(15);
        a.inserir(12);
        a.inserir(20);
        a.inserir(25);
        // a.deletar(1);
        // a.deletar(10);
        MostrarArvoreUtil<No> p = new MostrarArvoreUtil<>(a);
        p.imprimir(System.out);
    }
}