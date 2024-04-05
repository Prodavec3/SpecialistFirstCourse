package lab2;

public class ComLineParser {
    private String[] keys, delimiters;
    public enum switchStatus { NoError, Error, ShowUsage }

    public ComLineParser(String[] keys, String[] delimiters) {
        this.keys = keys;
        this.delimiters = delimiters;
    }

    public ComLineParser(String[] keys) {
        this(keys, new String[]{"/", "-"});
    }

    public void onUsage(String errorKey){
        if (errorKey != null) System.out.println(errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("-?  показать Help файл");
        System.out.println("-r  задать имя входного файла");
        System.out.println("-w  выполнить вывод в указанный файл");
    }

    public switchStatus OnSwitch(String key, String keyValue){
        System.out.println("Key: " + key + " | Value: " + keyValue);
        return switchStatus.NoError;
    }

    public boolean Parse(String[] args){
        switchStatus switchStatus = ComLineParser.switchStatus.NoError;
        int argNum;
        for (argNum = 0; (switchStatus == ComLineParser.switchStatus.NoError) &&
                        (argNum < args.length); argNum++) {
            boolean isDelimiter = false;
            for (int j = 0; !isDelimiter && (j < delimiters.length); j++) {
                isDelimiter = args[argNum].regionMatches(0, delimiters[j], 0, 1);
            }

            if (isDelimiter) {
                boolean isKey = false;
                int i;
                for (i = 0; !isKey && i < keys.length; i++) {
                    isKey = args[argNum].toUpperCase().regionMatches(1,
                            keys[i].toUpperCase(), 0, keys[i].length());
                    if (isKey) break;
                }
                if (!isKey){
                    switchStatus = ComLineParser.switchStatus.Error;
                    break;
                } else {
                    switchStatus = OnSwitch(keys[i].toLowerCase(),
                            args[argNum].substring(1 + keys[i].length()));
                }
            } else {
                switchStatus = ComLineParser.switchStatus.Error;
                break;
            }
        }
        if (switchStatus == ComLineParser.switchStatus.ShowUsage) onUsage(null);
        if (switchStatus == ComLineParser.switchStatus.Error)
        {
            onUsage((argNum == args.length) ? null : args[argNum]);}

        return switchStatus == ComLineParser.switchStatus.NoError;
    }
}
