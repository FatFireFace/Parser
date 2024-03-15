import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    protected Type defineType(String[] array){

        final String TYPE_REGEX  = "<\\d+><(0x[0-9a-fA-F]+)>\\s+DW_TAG_base_type";
        final String BYTE_SIZE   = "DW_AT_byte_size";
        final String ENCODING    = "DW_AT_encoding";
        final String NAME        = "DW_AT_name";

        Type type = new Type();
        Pattern pattern = Pattern.compile(TYPE_REGEX);
        Matcher matcher = pattern.matcher(array[0]);
        String address = matcher.group(1);
        type.setAddress(address);

        type.setBite_size(Integer.parseInt(array[1].replace(BYTE_SIZE, "").trim()));

        type.setEncoding(array[2].replace(ENCODING, "").trim());

        type.setName(array[3].replace(NAME, "").trim());


    return type;
    }

    protected Variable parseVariable(){

    return null;
    }


    public List<Variable> parseElf(File elfFile){
        String filePath = elfFile.getPath();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                bufferedReader.mark(256);
                String line;
                line = bufferedReader.readLine();
                List<Type> listOfTypes = new ArrayList<>();

                    while(line != null){
                        if (line.contains("DW_TAG_base_type")){
                            String[] array = new String[4];
                            for (int i = 0; i<4; i++){
                               array[i] = line;
                               line = bufferedReader.readLine();
                            }
                        listOfTypes.add(defineType(array));
                        }
                    }



            }
            catch (IOException e){
                e.printStackTrace();
            }
    return null;
    }
}
