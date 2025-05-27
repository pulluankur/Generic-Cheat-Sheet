import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamQuestion {

    public static void main(String[] args) {

        Map<Integer, Integer> map= new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        for(Integer val : map.values()){
            
        }

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            System.out.println("anonymous thread");
        });

//        PriorityQueue<Integer> pq= new PriorityQueue<>( Comparator.reverseOrder());
//        pq.add(5);
//        pq.add(6);
//        pq.add(1);
//        pq.add(3);
//        pq.add(8);
//        System.out.println(pq);
//        ArrayList<Integer> list =  new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        ArrayList<Integer> list1 = new ArrayList<>(list);
//        list1.add(0, 3);
//        ArrayList<Integer> list2 = new ArrayList<>(list);
//        list2.add(1, 3);
//        ArrayList<Integer> list3 = new ArrayList<>(list);
//        list3.add(2, 3);
//        System.out.println(list1+ " "+ list2+ " "+ list3);

    }


}
