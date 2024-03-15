public class Variable {
    /*
    в теге Variable при наилучшем раскладе (переменная глобальная и хранится не внутри функции) ее описание
    включает в себя DW_AT_location - где указаны len 0x00. (длина переменной в памяти)
    и :0x0300000000 (судя по моим данным, эта штука указывает на формат кодирования адреса (первая штука 0x030 - длина адреса)),
    а прямо за ними DW_AT_addr - непосредственно адрес в памяти. То есть мы находим начальный адрес _addr и длину len, по ним считываем последовательно
    значение переменной.

    в теге Variable, следующим за маркером < 2>, указываются локальные переменные. Возможно конкретно маркер это не значит,
    но оно вполне однозначно определяется тем, что в dwarfнике идет сразу за определением подпрограммы и вместо тега _addr имеет тег
    DW_OP_fbreg (frame base register), который указывает не непосредственный адрес в памяти, а смещение относительного базового кадра фрейма,
    который задается для каждого вызова функции. Чисто теоретически найти позицию функции в стеке найти возможно, если опросить адреса стека,
    но для этого надо знать, что искать, а потом в функции найти переменные. стоит ли игра свеч?


    < 1><0x000002d5>    DW_TAG_variable
                      DW_AT_name                  cTextBuf
                      DW_AT_decl_file             0x00000001
                      DW_AT_decl_line             0x00000029
                      DW_AT_decl_column           0x00000006
                      DW_AT_type                  <0x000002c5>
                      DW_AT_external              yes(1)
                      DW_AT_location              len 0x0005: 0x0300000000:
                          DW_OP_addr 0x00000000

     */

    private String name;
    private String typeAddress;
    private String type;
    private String length;
    private String address;
    private String value;

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }


    public void setTypeAddress(String typeAddress) {
        this.typeAddress = typeAddress;
    }
    public String getTypeAddress() {
        return typeAddress;
    }


    public void setLength(String length) {
        this.length = length;
    }
    public String getLength() {
        return length;
    }


    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
