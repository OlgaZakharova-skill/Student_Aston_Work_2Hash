public class Main {
    public static void main(String[] args){
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(6);
        System.out.println(hashSet.contains(6));
        hashSet.remove(6);
        System.out.println(hashSet.contains(6));
        System.out.println(hashSet.contains(4));
        System.out.println();

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList.toString());
        arrayList.add(6);
        System.out.println(arrayList.toString());
        arrayList.remove(3);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.get(3));
        arrayList.addAll(new int[]{7, 8, 9});
        System.out.println(arrayList.toString());
    }
}
