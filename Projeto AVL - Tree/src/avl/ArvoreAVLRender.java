package avl;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

@SuppressWarnings("serial")

public class ArvoreAVLRender extends JFrame{
	
	static public int CANVAS_WIDTH = 500;
	static public int CANVAS_HEIGHT = 500;
	
	private int rootY = 10;
	private int NODE_SIZE = 25;
	private int ROW_HEIGHT = 50;
	mxGraph graph = new mxGraph();
	Object parente = graph.getDefaultParent();
	
	public Object desenharArvore(NoAVL raiz, int profundidade, int index) {
		if(raiz == null) return null;
		
		int meuX = (int) ((CANVAS_WIDTH * (index)) / (Math.pow(2, profundidade -1) +1));
		
		Object verticeRaiz = graph.insertVertex(parente, null, raiz.getChave(),
				meuX, profundidade * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE);
		
		Object verticeCriancaDireita = desenharArvore(raiz.getDireita(), profundidade +1,index*2);
		if(verticeCriancaDireita != null) {
			graph.insertEdge(parente, null, null, verticeRaiz, verticeCriancaDireita);
		}
		
		Object verticeCriancaEsquerda = desenharArvore(raiz.getEsquerda(), profundidade +1,index*2-1);
		if(verticeCriancaEsquerda != null) {
			graph.insertEdge(parente, null, null, verticeRaiz, verticeCriancaEsquerda);
		}
		
		return verticeRaiz;
	}
	
	public void update(NoAVL raiz) {
        graph.getModel().beginUpdate();
        try {

            Object[] cells = graph.getChildCells(parente, true, false);
            graph.removeCells(cells, true);
            desenharArvore(raiz, 1, 1);

        } finally {
            graph.getModel().endUpdate();
        }
    }

    public ArvoreAVLRender(NoAVL raiz) {
        this.update(raiz);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

}
