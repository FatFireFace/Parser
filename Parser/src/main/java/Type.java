public class Type {
    private String   address;
    private int      bite_size;//можно использовать тип полегче
    private String   encoding;//возможно не нужен он *****
    private String   name;

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setBite_size(int bite_size) {
        this.bite_size = bite_size;
    }

    public int getBite_size() {
        return bite_size;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
