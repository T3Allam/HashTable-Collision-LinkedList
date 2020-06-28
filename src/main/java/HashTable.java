public class HashTable<E> {

    private LinkedList<E>[] arr;

    public HashTable( ) {
        this.arr = new LinkedList[5];
        createLinkedLists();
    }

    public void createLinkedLists() {
        for (int i=0; i<arr.length; i++)
            arr[i] = new LinkedList<>();
    }


    public int hash(E title) {
        String t = (String) title;
        int asciFirstLetter =  (int) t.charAt(0);  //hash code
        int index = getIndex(asciFirstLetter); //converting hash code to index
        return index;
    }

    public Integer getIndex(int asciFirstLetter) {
        if (97<=asciFirstLetter &&  asciFirstLetter<=102 || 65<=asciFirstLetter && asciFirstLetter<=70) {
            return 0;
        } else if (103<=asciFirstLetter && asciFirstLetter<=108 || 71<=asciFirstLetter && asciFirstLetter<=76) {
            return 1;
        } else if (109<=asciFirstLetter && asciFirstLetter<=114 || 77<=asciFirstLetter && asciFirstLetter<=82) {
            return 2;
        } else if (115<=asciFirstLetter && asciFirstLetter<=119 || 83<=asciFirstLetter && asciFirstLetter<=87) {
            return 3;
        } else if (120<=asciFirstLetter && asciFirstLetter<=122 || 88<=asciFirstLetter && asciFirstLetter<=90) {
            return 4;
        }
        return null;
    }


    public boolean put(E title) {
        int index = hash(title);
        if (arr[index].get(title) == null){
            System.out.println("index is " + index );
            arr[index].append(title);
            return true;
        }
        System.out.println(title + " already exists.");
        return false;
    }
}