public class Main {
    public static void main(String[] args) throws MapFullException{
        MyHashMap map  = new MyHashMap(5);
        System.out.print(map);
        map.put('1',58);
        map.get('1');
        map.get('6');
        System.out.println(map);
        System.out.println("\n\n");
        map.remove('1');
        System.out.print(map);
    }
}
