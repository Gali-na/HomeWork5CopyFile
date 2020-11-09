import java.io.File;
import java.io.FileFilter;
import java.util.logging.Filter;

public class FilterForFile implements FileFilter{
    private String name;

    public FilterForFile(String name) {
        this.name = name;
    }

    public FilterForFile() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean chek (String ext) {
        if(name.equals(ext)) {
            return true;
        }
        return  false;
    }

    public boolean accept(File pathname) {
        int poinerIndex = pathname.getName().lastIndexOf(".");
        if(poinerIndex ==-1){
            return false;
        }
        String ext = pathname.getName().substring(poinerIndex +1);
        return chek(ext);
    }
}

