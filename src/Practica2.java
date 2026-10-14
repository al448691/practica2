import java.util.*;

public class Practica2 {
    public static boolean equivalentes(List<String> l1, List<String> l2) {
        if(l1 == null || l2 == null || l1.size() != l2.size()){
            return false;
        }

        Iterator<String> it1 = l1.iterator();
        while(it1.hasNext()){
            String elementoActual = it1.next();
            int cantidadL1 = contarApariciones(l1, elementoActual);
            int cantidadL2 = contarApariciones(l2, elementoActual);

            if(cantidadL1 != cantidadL2){
                return false;
            }
        }
        return true;
    }
    private static int contarApariciones(List<String> lista, String buscado){
        int contador = 0;
        Iterator<String> it = lista.iterator();

        while(it.hasNext()){
            String elemento = it.next();
            if(elemento.equals(buscado)){
                contador++;
            }
        }
        return contador;
    }

    public static void invierte(ListIterator<String> iter) {
        if(iter == null){
            return;
        }
        while(iter.hasPrevious()){
            iter.previous();
        }
        List<String> temporal = new ArrayList<>();
        while (iter.hasNext()){
            temporal.add(iter.next());
        }
        int i=0;
        while (iter.hasPrevious()){
            iter.previous();
            iter.set(temporal.get(i));
            i++;
        }
    }

    public static  List<Integer> ordenar(List<Integer> l1) {
        List<Integer> resultado = new ArrayList<>();

        if (l1 == null) {
            return resultado;
        }
        for (Integer numero : l1) {
            resultado.add(numero);
        }

        for (int i = 0; i < resultado.size() - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < resultado.size(); j++) {
                if (resultado.get(j) < resultado.get(indiceMenor)) {
                    indiceMenor = j;
                }
            }

            int temp = resultado.get(indiceMenor);
            resultado.set(indiceMenor, resultado.get(i));
            resultado.set(i, temp);
        }
        return resultado;
    }

    public static<T> List<T> detectarAlternancia (ListIterator<T> iter) {
        List<T> resultado = new ArrayList<>();

        if(iter == null){
            return resultado;
        }

        while(iter.hasPrevious()){
            iter.previous();
        }
        if(!iter.hasNext()){
            return resultado;
        }
        T e1 = iter.next();
        if(!iter.hasNext()){
            return resultado;
        }
        T e2 = iter.next();

        while (iter.hasNext()){
            T e3 = iter.next();

            if(Objects.equals(e1, e3) && !Objects.equals(e1, e2)){
                resultado.add(e1);
            }
            e1 = e2;
            e2 = e3;
        }
        return resultado;
    }
}
