package lab3;

public class SimpleParser extends ComLineParserBase {

    public SimpleParser(){
        super(new String[] {"?", "r", "w"});
    }

    private String inFile, outFile;

    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    @Override
    protected void OnUsage(String errorKey) {
        if (errorKey != null) System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] " +
                "[-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    protected SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;

        switch (key){
            case "?":
                status = SwitchStatus.ShowUsage;
                break;
            case "r":
                if (keyValue.length() >= 1){
                    inFile = keyValue;
                } else {
                    System.out.println("Error: keyValue length < 1");
                    status = SwitchStatus.Error;
                }
                break;
            case "w":
                if (keyValue. length() >= 1){
                    outFile = keyValue;
                } else {
                    System.out.println("Error: keyValue length < 1");
                    status = SwitchStatus.Error;
                }
                break;
        }
        return status;
    }
}
