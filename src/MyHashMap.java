public class MyHashMap {
    private int mod;
    private int[] keys;
    private int[] vals;
    private int emptyColumn;
    
    public MyHashMap(int mod){
        System.out.println( "new MyHashMap(size:"+ mod+");");
        this.mod = mod+1;
        this.emptyColumn = mod+1;
        this.keys = new int[mod+1];
        this.vals = new int [mod+1];
        this.initMap();
    }

    public void put(int key, int value) throws MapFullException{
        System.out.println( "put  (key:"+(char)key+", val:"+value+");" );
        if (this.emptyColumn == 1)
            throw new MapFullException("The HashMap Is Full, You can't put more elements !");
        else{
            this.emptyColumn = this.emptyColumn - 1 ;
            int index = hash(key);
            while(keys[index] != -1)
                index = hash(index+1);
            keys[index] = key;
            vals[index] = value;
        }

    }

    public int get(int key){
        int index = this.hash(key);
        int toReturn = -1;
        while(this.keys[index] != key && this.keys[index] != -1)
            index = hash(index+1);
        if(keys[index] == key)
            toReturn = this.vals[index];
        String echo = (toReturn == -1)?"get(key:"+(char)key+") = null" : "get(key:"+(char)key+") = "+toReturn;
        System.out.println(echo);
    return toReturn;
    }


    public void remove(int key)throws MapFullException{
        System.out.println("remove( key:"+(char)key+");");
        int index = hash(key);
        while(keys[index] !=key && keys[index] !=  -1)
            index = hash(index+1);
        keys[index] = -1;vals[index] = -1;
        index = hash(index+1);
        while(keys[index] !=  -1){
            this.emptyColumn = this.emptyColumn -1 ;
            int savedKey = keys[index], savedValue = vals[index];
            keys[index] =  vals[index] = -1;
            put(savedKey,savedValue);
            index = hash(index + 1);
        }
    }




    private int hash(int key){
        return key % mod ;
    }


    private void initMap(){
        for(int i =0;i<this.keys.length ; i++){
            this.keys[i]=-1;
            this.vals[i]=-1;
        }
    }


    @Override
    public String toString(){
        String toReturn = "\n[hash(key)]     [key]      [value]\n";
        for(int i = 0 ; i< mod ; i++){
            toReturn +="    [" + i + "]    " + "     [" + (char)this.keys[i] + "]    " + "    [" + this.vals[i] + "]\n";
        }
        return toReturn;
    }
}