package ejercicio09;

import java.util.*;

public class Dado {

    public List<Integer> lanzar(int longitud, int min, int max) {
        List<Integer> listaNum = new ArrayList<>();
        Random rnd = new Random(System.nanoTime());

        do {
            listaNum.add(rnd.nextInt(max - min + 1) + min);
        } while (listaNum.size() < longitud);

        return listaNum;
    }

    public int contarNumero(List<Integer> listaNum, int numero){
        int[] cont = {0};
        listaNum.forEach(i->{
            if (i == numero){
                cont[0]++;
            }
        });
        return cont[0];
    }

    public int obtenerSuma(List<Integer> tiradas){
        int[] cont = {0};
        tiradas.forEach(i->{
            cont[0]+=i;
        });
        return cont[0];
    }

    public Integer obtenerMasAlto(List<Integer> listaNum, int min){
        return listaNum.stream().max(Integer::compareTo).get();
    }

    public Integer obtenerMasBajo (List<Integer> listaNum, int max){
        return listaNum.stream().min(Integer::compareTo).get();
    }

    public Map<Integer,Integer> clasificarMap(List<Integer> listaNum){
        Map<Integer, Integer> numDict = new HashMap<>();

        for(int num: listaNum){
            int value;
            if(numDict.containsKey(num)){
                value = numDict.get(num);
                numDict.put(num, value +1);
            }else {
                numDict.put(num,1);
            }
        }
        return numDict;
    }

    public List<Integer> buscarMasRepetido(List<Integer> listaNum, int min) {
        Map<Integer, Integer> numDict = clasificarMap(listaNum);
        int mayorQt = obtenerMasAlto(new ArrayList<>(numDict.values()), min);
        return deOrder(numDict, mayorQt);
    }

    public List<Integer> deOrder(Map<Integer, Integer> numDict, int mayorQt){
        List<Integer> finallist= new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numDict.entrySet()){
            if(entry.getValue()== mayorQt){
                finallist.add(entry.getKey());
            }
        }
        return finallist;
    }

}
